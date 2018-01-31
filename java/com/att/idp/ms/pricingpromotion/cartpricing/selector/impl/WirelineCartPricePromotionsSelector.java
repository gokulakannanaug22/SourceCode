package com.att.idp.ms.pricingpromotion.cartpricing.selector.impl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.foundation.error.ApplicationError;
import com.att.idp.foundation.error.ExceptionErrorMessage;
import com.att.idp.ms.pricingpromotion.cartpricing.selector.CartPricePromotionsSelector;
import com.att.idp.ms.pricingpromotion.common.Database;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.Promotion;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
import com.att.idp.ms.pricingpromotion.common.query.builder.PromotionQueryBuilder;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class WirelineCartPricePromotionsSelector is to query the database to
 * fetch results for Promotion.
 */
@SuppressWarnings("PMD")
// @SuppressWarnings("PMD.ExcessiveImports")
@Component
public class WirelineCartPricePromotionsSelector implements CartPricePromotionsSelector {

	/** EELFLogger instance. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(WirelineCartPricePromotionsSelector.class);

	/** Autowired PromotionQueryBuilder */
	/*
	 * @Autowired PromotionQueryBuilder promotionQueryBuilder;
	 */
	/**
	 * dbObj
	 */
	public Database dbObj;

	/**
	 *
	 * @param pricingItems
	 *            the Pricing items
	 * @param requestContext
	 *            the request context
	 * @return the map Get the items Promotions from DB and apply the rules to
	 *         filter the promotions and set in skuPromotionsMap. Construct a
	 *         Map with skuid/productId, List of Promotion from DB. iterate each
	 *         sku with their promotions and call Get the items price from DB,
	 *         Apply filters (Geo etc.,) and return the itemsPriceMap.
	 * @see com.att.idp.ms.pricingpromotion.cartpricing.selector.CartPricePromotionsSelector#retrieveItemPromotions(java.util.List,
	 *      com.att.idp.ms.pricingpromotion.common.bean.RequestContext)
	 */
	@Override
	public Map<String, List<Promotion>> retrieveItemPromotions(final List<PricingItem> pricingItems,
			final RequestContext requestContext) {

		//		final Map<String, List<Promotion>> skuPromotionsMap = new ConcurrentHashMap<String, List<Promotion>>();
		Map<String, List<Promotion>> skuBasicPromotionsMap = new ConcurrentHashMap<String, List<Promotion>>();
		final Map<String, List<Promotion>> skuAdditionalPromotionsMap = new ConcurrentHashMap<String, List<Promotion>>();
		final Map<String, List<Promotion>> skuSuplementPromotionsMap = new ConcurrentHashMap<String, List<Promotion>>();

		Map<String, List<Promotion>> finalSkuPromotionsMap = new ConcurrentHashMap<String, List<Promotion>>();
		dbObj = new Database();
		dbObj.getcouchDbConnection();
		PromotionQueryBuilder promotionQueryBuilder = new PromotionQueryBuilder();

		try {
			if (Optional.ofNullable(requestContext).isPresent() && Optional.ofNullable(pricingItems).isPresent()) {
				Field[] fields = requestContext.getServiceAddress().getClass().getDeclaredFields();
				String promotionQuery = promotionQueryBuilder.buildPromotionQuery(requestContext, pricingItems, fields);
				final Iterator<N1qlQueryRow> iter = dbObj.excuteQuery(promotionQuery);
				ObjectMapper mapper = new ObjectMapper();
				Promotion promotion = new Promotion();
				boolean basicAvailable = false;
				List<Promotion> promotionList = new ArrayList<Promotion>();
					while (iter.hasNext()) {
						final N1qlQueryRow row = iter.next();
						promotion = new Promotion();
						promotion = mapper.readValue(row.value().toString(), Promotion.class);
						if(promotion.getPromoType().equalsIgnoreCase("percentoff")){
							promotion.setPercent((int)promotion.getAmount());
							promotion.setAmount(0); // We get Amount as 15% instead of Percent, So manually setting
						}
						promotionList = new ArrayList<Promotion>();
						promotionList.add(promotion);
						String skuId = getSkuId(pricingItems, promotion.getProductId());
						if(promotion.getSaleType().equalsIgnoreCase("basic")){   // Ensure only unique SkuIds are added
							skuBasicPromotionsMap.put(skuId, promotionList);
						}
						else if(promotion.getSaleType().equalsIgnoreCase("additional")){
							skuAdditionalPromotionsMap.put(skuId, promotionList);	
						}
						else{
							skuSuplementPromotionsMap.put(skuId, promotionList);	
						}
				}
				// To add promotion by checking atleast one Basic plan is available. If yes, Additional Plan are added
				basicAvailable = basicAvailabilityCheck(skuBasicPromotionsMap);
				Optional<Entry<String, List<Promotion>>> onlyBasicPromotion = getBasicPromotion(skuBasicPromotionsMap);
						
				if(basicAvailable){
					finalSkuPromotionsMap =	getFinalPromotionMap(onlyBasicPromotion,skuBasicPromotionsMap,skuAdditionalPromotionsMap,skuSuplementPromotionsMap);
				}

			}
			return finalSkuPromotionsMap;
		} catch (JsonGenerationException Ex) {
			log.error("JsonGenerationException while getting the Promotions " + Ex.getMessage());
			throw new ApplicationError(ExceptionErrorMessage.newObject()
					.developerMessage("Exception occurred when retrieving Promotion Response.").cause(Ex));
		} catch (JsonMappingException Ex) {
			log.error("JsonMappingException while getting the Promotions " + Ex.getMessage());
			throw new ApplicationError(ExceptionErrorMessage.newObject()
					.developerMessage("Exception occurred when retrieving Promotions Response.").cause(Ex));
		} catch (IOException Ex) {
			log.error("Error while getting the Promotions " + Ex.getMessage());
			throw new ApplicationError(ExceptionErrorMessage.newObject()
					.developerMessage("Exception occurred when retrieving Promotions Response.").cause(Ex));
		}
	}

	private String getSkuId(List<PricingItem> pricingItems, String productId) {

		for (PricingItem pricingItem : pricingItems) {
			if (Optional.ofNullable(productId).isPresent() && productId.equals(pricingItem.getProductId())) {
				log.debug("Sku id: " + pricingItem.getSkuId() + "for ProductId: " + productId);
				return pricingItem.getSkuId();
			}			
		}
		return null;
	}
	
	/**
	 * @param skuBasicPromotionsMap
	 * @return
	 */
	public boolean basicAvailabilityCheck(Map<String, List<Promotion>> skuBasicPromotionsMap){
	boolean basicAvailable= skuBasicPromotionsMap.entrySet()
			.stream().filter(listPromo->listPromo.getValue().stream()
					.anyMatch(promotion -> Optional.ofNullable(promotion.getSaleType().equalsIgnoreCase("basic")).isPresent())) != null;
	return basicAvailable;
	}
	
	/**
	 * @param skuBasicPromotionsMap
	 * @return
	 */
	public Optional<Entry<String, List<Promotion>>> getBasicPromotion(Map<String, List<Promotion>> skuBasicPromotionsMap){
		Optional<Entry<String, List<Promotion>>> onlyBasicPromotion = skuBasicPromotionsMap.entrySet()
		.stream()
		.filter(listPromo -> listPromo
				.getValue()
				.stream()
				.anyMatch(
						promotion -> promotion.getSaleType().equalsIgnoreCase("basic"))).findFirst();
		return onlyBasicPromotion;
	}

	/**
	 * @param onlyBasicPromotion
	 * @param skuBasicPromotionsMap
	 * @param skuAdditionalPromotionsMap
	 * @param skuSuplementPromotionsMap
	 * @return
	 */
	public Map<String, List<Promotion>> getFinalPromotionMap(Optional<Entry<String, List<Promotion>>> onlyBasicPromotion, Map<String, List<Promotion>> skuBasicPromotionsMap,
			Map<String, List<Promotion>> skuAdditionalPromotionsMap,Map<String, List<Promotion>> skuSuplementPromotionsMap){
		final Map<String, List<Promotion>> finalSkuPromotionsMap = new ConcurrentHashMap<String, List<Promotion>>();
		skuBasicPromotionsMap = new HashMap<String, List<Promotion>>();
		skuBasicPromotionsMap.put(onlyBasicPromotion.get().getKey(), onlyBasicPromotion.get().getValue());
		finalSkuPromotionsMap.putAll(skuBasicPromotionsMap);
		finalSkuPromotionsMap.putAll(skuAdditionalPromotionsMap);
		finalSkuPromotionsMap.putAll(skuSuplementPromotionsMap);
		return finalSkuPromotionsMap;
	}
}

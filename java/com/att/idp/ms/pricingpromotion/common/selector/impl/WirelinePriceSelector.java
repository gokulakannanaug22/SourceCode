/**
 * 
 */
package com.att.idp.ms.pricingpromotion.common.selector.impl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.foundation.error.ApplicationError;
import com.att.idp.foundation.error.ExceptionErrorMessage;
import com.att.idp.ms.pricingpromotion.common.Database;
import com.att.idp.ms.pricingpromotion.common.bean.ItemPrice;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
import com.att.idp.ms.pricingpromotion.common.query.builder.PricingQueryBuilder;
import com.att.idp.ms.pricingpromotion.common.selector.PriceSelector;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class WirelinePriceSelector is used to connect to the Database to get the
 * results for Price Item.
 *
 * @author vp020k, gokulakannanv
 */
@SuppressWarnings("PMD")
// @SuppressWarnings("PMD.ExcessiveImports")
@Component
public class WirelinePriceSelector implements PriceSelector {

	/**
	 * dbObj
	 */
	public Database dbObj;

	/** EELFLogger instance. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(WirelinePriceSelector.class);

	/** Autowired PricingQueryBuilder */
	/*
	 * @Autowired private PricingQueryBuilder pricingQueryBuilder;
	 */

	/**
	 * retrieveItemsPrice to connect to the Database to get the results for
	 * Price Item.
	 * 
	 * @param pricingItems
	 *            the pricing items
	 * @param requestContext
	 *            the request context
	 * @return the map
	 * @see com.att.idp.ms.pricingpromotion.common.selector.PriceSelector#retrieveItemsPrice(java.util.List,
	 *      com.att.idp.ms.pricingpromotion.common.bean.RequestContext)
	 */
	@Override
	public Map<String, ItemPrice> retrieveItemsPrice(final List<PricingItem> pricingItems,
			final RequestContext requestContext) {

		final Map<String, ItemPrice> itemPriceMap = new ConcurrentHashMap<String, ItemPrice>();
		dbObj = new Database();
		dbObj.getcouchDbConnection();
		PricingQueryBuilder pricingQueryBuilder = new PricingQueryBuilder();
		try {
			if (Optional.ofNullable(requestContext).isPresent() && Optional.ofNullable(pricingItems).isPresent()) {
				final Field[] fields = requestContext.getServiceAddress().getClass().getDeclaredFields();
				String pricingQuery = pricingQueryBuilder.buildPricingQuery(requestContext, pricingItems, fields);
				final Iterator<N1qlQueryRow> iter = dbObj.excuteQuery(pricingQuery);
				final ObjectMapper mapper = new ObjectMapper();
				ItemPrice itemPrice = new ItemPrice();

				while (iter.hasNext()) {
					final N1qlQueryRow row = iter.next();
					String skuId = row.value().getString("skuId");
					if (!itemPriceMap.containsKey(skuId)) {
						itemPrice = mapper.readValue(row.value().toString(), ItemPrice.class);
						populateItemDetails(itemPrice, pricingItems);
						itemPriceMap.put(itemPrice.getSkuId(), itemPrice);
					}					
				}
			}
			return itemPriceMap;
		} catch (JsonGenerationException Ex) {
			log.error("JsonGenerationException while getting the itemPrice " + Ex.getMessage());
			throw new ApplicationError(ExceptionErrorMessage.newObject()
					.developerMessage("Exception occurred when retrieving Cart Price Response.").cause(Ex));
		} catch (JsonMappingException Ex) {
			log.error("JsonMappingException while getting the itemPrice " + Ex.getMessage());
			throw new ApplicationError(ExceptionErrorMessage.newObject()
					.developerMessage("Exception occurred when retrieving Cart Price Response.").cause(Ex));
		} catch (IOException Ex) {
			log.error("Error while getting the itemPrice " + Ex.getMessage());
			throw new ApplicationError(ExceptionErrorMessage.newObject()
					.developerMessage("Exception occurred when retrieving Cart Price Response.").cause(Ex));
		}
	}
	
	private void populateItemDetails(ItemPrice itemPrice, List<PricingItem> pricingItems) {
		
		for(PricingItem pricingItem : pricingItems) {
			if(itemPrice.getSkuId().equals(pricingItem.getSkuId())) {
				itemPrice.setProductId(pricingItem.getProductId());
				itemPrice.setQuantity(pricingItem.getQuantity());
				itemPrice.setType(pricingItem.getChargeType());
			}
		}
	}
}

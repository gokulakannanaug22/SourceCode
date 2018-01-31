package com.att.idp.ms.pricingpromotion.common.query.builder;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.ms.pricingpromotion.common.QueryConstants;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;

@Component
@SuppressWarnings("PMD")
public class PromotionQueryBuilder {
	
	/** EELFLogger instance. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(PromotionQueryBuilder.class);
	
	/**
	 * Enum locationTypeOrder
	 * 
	 */
	public enum locationTypeOrder {
		zip9,zip,dma,city,state,nation
	}
	
	/**
	 * locationTypes
	 */
	private List<String> locationTypes = new ArrayList<String>(locationTypeOrder.values().length);
	
	/**
	 * buildPricingQuery
	 * @param requestContext
	 * @param pricingItems
	 * @param fields
	 */
	@SuppressWarnings("CPD-SART")
	public String buildPromotionQuery(RequestContext requestContext, List<PricingItem> pricingItems, Field[] fields){
		
		StringBuilder promotionQuery = new StringBuilder();
		StringBuilder skuIds = new StringBuilder();
		StringBuilder productIds = new StringBuilder();
		String premiumTier = new String();

		if (pricingItems.size()!= 0){

			for(PricingItem sku : pricingItems){

				skuIds.append(QueryConstants.SINGLE_QUOTE+ sku.getSkuId() +QueryConstants.SINGLE_QUOTE);
				productIds.append(QueryConstants.SINGLE_QUOTE+ sku.getProductId() +QueryConstants.SINGLE_QUOTE);
				if(pricingItems.indexOf(sku)<pricingItems.size()-1){
					skuIds.append(",");
					productIds.append(",");
				}
				skuIds.append("]");
			//	productIds.append("]");				
				premiumTier = QueryConstants.SINGLE_QUOTE+ sku.getPricingTier() +QueryConstants.SINGLE_QUOTE;
			}
		}

		for(int i=0;i<6;i++)
		{
		locationTypes.add(null);
		}
		for( Field fieldName: fields )
		{

			if(fieldName.getName().equalsIgnoreCase(QueryConstants.ZIP9)){
				buildLocationTypeSequence(locationTypeOrder.valueOf(QueryConstants.ZIP9).ordinal(), fieldName.getName());
			}
			if(fieldName.getName().equalsIgnoreCase(QueryConstants.ZIP)){
				buildLocationTypeSequence(locationTypeOrder.valueOf(QueryConstants.ZIP).ordinal(), fieldName.getName());
			}
			if(fieldName.getName().equalsIgnoreCase(QueryConstants.DMA)){
				buildLocationTypeSequence(locationTypeOrder.valueOf(QueryConstants.DMA).ordinal(), fieldName.getName());
			}
			if(fieldName.getName().equalsIgnoreCase(QueryConstants.CITY)){
				buildLocationTypeSequence(locationTypeOrder.valueOf(QueryConstants.CITY).ordinal(), fieldName.getName());
			}
			if(fieldName.getName().equalsIgnoreCase(QueryConstants.STATE)){
				buildLocationTypeSequence(locationTypeOrder.valueOf(QueryConstants.STATE).ordinal(), fieldName.getName());
			}
			if(fieldName.getName().equalsIgnoreCase(QueryConstants.NATION)){
				buildLocationTypeSequence(locationTypeOrder.valueOf(QueryConstants.NATION).ordinal(), fieldName.getName());
			}
		}
		/**locationTypes.add(qualifyIndicatorsNew.toString());
		locationTypes.add(qualifyIndicatorsExisting.toString());*/


		promotionQuery.append((MessageFormat.format(QueryConstants.promotionQuery,"'promotion'",productIds.toString(),QueryConstants.SINGLE_QUOTE+requestContext.getSessionData().getCustomerType()+QueryConstants.SINGLE_QUOTE,"'Acquisition'",
				QueryConstants.SINGLE_QUOTE+requestContext.getSessionData().getFlowType()+QueryConstants.SINGLE_QUOTE,QueryConstants.SINGLE_QUOTE+requestContext.getSessionData().getCustomerType()+QueryConstants.SINGLE_QUOTE,premiumTier,"'A'","'prod1445533']",
				"['newHSIA','newVOIP']","['existingWireless','newVOIP']",locationTypes.get(0),
				QueryConstants.SINGLE_QUOTE+ requestContext.getServiceAddress().getZip9() +QueryConstants.SINGLE_QUOTE,locationTypes.get(1),QueryConstants.SINGLE_QUOTE+ requestContext.getServiceAddress().getZipCode() +QueryConstants.SINGLE_QUOTE,locationTypes.get(2),QueryConstants.SINGLE_QUOTE+ requestContext.getServiceAddress().getDma() +QueryConstants.SINGLE_QUOTE,
				locationTypes.get(3),QueryConstants.SINGLE_QUOTE+ requestContext.getServiceAddress().getCity() +QueryConstants.SINGLE_QUOTE,locationTypes.get(4),QueryConstants.SINGLE_QUOTE+ requestContext.getServiceAddress().getState() +QueryConstants.SINGLE_QUOTE,locationTypes.get(5),
				QueryConstants.SINGLE_QUOTE+ requestContext.getServiceAddress().getNation() +QueryConstants.SINGLE_QUOTE,QueryConstants.SINGLE_QUOTE+ QueryConstants.ZIP9 +QueryConstants.SINGLE_QUOTE, QueryConstants.SINGLE_QUOTE+ QueryConstants.ZIP +QueryConstants.SINGLE_QUOTE, QueryConstants.SINGLE_QUOTE+ QueryConstants.DMA +QueryConstants.SINGLE_QUOTE, QueryConstants.SINGLE_QUOTE+ QueryConstants.CITY +QueryConstants.SINGLE_QUOTE,
				QueryConstants.SINGLE_QUOTE+ QueryConstants.STATE +QueryConstants.SINGLE_QUOTE, QueryConstants.SINGLE_QUOTE+ QueryConstants.NATION +QueryConstants.SINGLE_QUOTE)));
		
		log.debug("The Promotion Query to retrieve Cart Price"+promotionQuery.toString());
        return promotionQuery.toString();
	}@SuppressWarnings("CPD-END")
	
	/**
	 * addIndexedLocType
	 * @param index
	 * @param fieldName
	 */
	private void buildLocationTypeSequence(int index, String fieldName){ 
		locationTypes.set(index,QueryConstants.SINGLE_QUOTE+ fieldName +QueryConstants.SINGLE_QUOTE);
	}

}

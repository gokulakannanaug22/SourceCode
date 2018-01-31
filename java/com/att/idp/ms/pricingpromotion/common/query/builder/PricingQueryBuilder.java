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
/**
 *  PricingPromotionQueryBuilder
 * 
 */
@Component
@SuppressWarnings("PMD")
public class PricingQueryBuilder {
	
	/** EELFLogger instance. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(PricingQueryBuilder.class);
	
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
	List<String> locationTypes = new ArrayList<String>(locationTypeOrder.values().length);
	
	/**
	 * Form pricing query.
	 *
	 * @param requestContext the request context
	 * @param pricingItems the sku items
	 * @param fields the fields
	 */
	@SuppressWarnings("CPD-START")
	public String buildPricingQuery(RequestContext requestContext, List<PricingItem> priceItems, Field[] fields){

		StringBuilder pricingQuery = new StringBuilder();
		String pricingTier = null;
		
		StringBuilder skuIds = new StringBuilder();
		if (priceItems.size()!= 0){
			for(PricingItem pItem : priceItems){
				skuIds.append(QueryConstants.SINGLE_QUOTE+ pItem.getSkuId() +QueryConstants.SINGLE_QUOTE);
				if(priceItems.indexOf(pItem)<priceItems.size()-1){
					skuIds.append(",");
				}
			//	skuIds.append("]");				
				pricingTier = QueryConstants.SINGLE_QUOTE + pItem.getPricingTier() + QueryConstants.SINGLE_QUOTE;				
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
		pricingQuery.append((MessageFormat.format(QueryConstants.priceQuery,skuIds.toString(),pricingTier,QueryConstants.SINGLE_QUOTE+requestContext.getSessionData().getCustomerType()+QueryConstants.SINGLE_QUOTE,locationTypes.get(0).toString(),
				QueryConstants.SINGLE_QUOTE+ requestContext.getServiceAddress().getZip9() +QueryConstants.SINGLE_QUOTE,locationTypes.get(1).toString(),QueryConstants.SINGLE_QUOTE+ requestContext.getServiceAddress().getZipCode() +QueryConstants.SINGLE_QUOTE,locationTypes.get(2).toString(),QueryConstants.SINGLE_QUOTE+ requestContext.getServiceAddress().getDma() +QueryConstants.SINGLE_QUOTE,
				locationTypes.get(3).toString(),QueryConstants.SINGLE_QUOTE+ requestContext.getServiceAddress().getCity() +QueryConstants.SINGLE_QUOTE,locationTypes.get(4).toString(),QueryConstants.SINGLE_QUOTE+ requestContext.getServiceAddress().getState() +QueryConstants.SINGLE_QUOTE,locationTypes.get(5).toString(),
				QueryConstants.SINGLE_QUOTE+ requestContext.getServiceAddress().getNation() +QueryConstants.SINGLE_QUOTE,QueryConstants.SINGLE_QUOTE+ QueryConstants.ZIP9 +QueryConstants.SINGLE_QUOTE, QueryConstants.SINGLE_QUOTE+ QueryConstants.ZIP +QueryConstants.SINGLE_QUOTE, QueryConstants.SINGLE_QUOTE+ QueryConstants.DMA +QueryConstants.SINGLE_QUOTE, QueryConstants.SINGLE_QUOTE+ QueryConstants.CITY +QueryConstants.SINGLE_QUOTE,
				QueryConstants.SINGLE_QUOTE+ QueryConstants.STATE +QueryConstants.SINGLE_QUOTE, QueryConstants.SINGLE_QUOTE+ QueryConstants.NATION +QueryConstants.SINGLE_QUOTE)));
	
		log.debug("The Pricing Query to retrieve Cart Price"+pricingQuery.toString());
		return pricingQuery.toString();
	} @SuppressWarnings("CPD-END")

	
	
	/**
	 * addIndexedLocType
	 * @param index
	 * @param fieldName
	 */
	private void buildLocationTypeSequence(int index, String fieldName){ 
		locationTypes.set(index,QueryConstants.SINGLE_QUOTE+ fieldName +QueryConstants.SINGLE_QUOTE);
	}
}

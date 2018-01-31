package com.att.idp.ms.pricingpromotion.itempricing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.ajsc.common.Tracable;
import com.att.idp.foundation.pipeline.Pipeline;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.itempricing.bean.ItemPriceResponse;
import com.att.idp.ms.pricingpromotion.itempricing.bean.ItemPricingContext;
import com.att.idp.ms.pricingpromotion.itempricing.model.ItemPricingRestRequest;
import com.att.idp.ms.pricingpromotion.itempricing.pipeline.ItemPricePipelineBuilder;
import com.att.idp.ms.pricingpromotion.itempricing.response.builder.ItemPriceResponseBuilder;


/**
 * The Class ItemPriceService.
 */
@Service
public class ItemPriceService {

	/** The log. 
	 * private static EELFLogger log = AjscEelfManager.getInstance().getLogger(ItemPriceService.class);*/

	/** item Price PipelineBuilder.*/
	@Autowired
	private ItemPricePipelineBuilder itemPricePipelineBuilder;
	
	/** item Price Response Builder.*/
	@Autowired
	private ItemPriceResponseBuilder itemPriceResponseBuilder;


	@Tracable(message = "invoking ItemPriceService.retrieveItemPrice")
	/**
	 * Retrieve items price.
	 * 
	 * @param itemPricingrequest
	 *            ItemPricingServiceRequest
	 * @return ItemPricingServiceResponse
	 */
	public ItemPriceResponse retrieveItemsPrice(final ItemPricingRestRequest itemPricingrequest) {

		final ItemPricingContext itemPricingContext = new ItemPricingContext();
		itemPricingContext.setItemPricingRequest(itemPricingrequest);

		final Pipeline<PricingContext> pipeline = itemPricePipelineBuilder.buildPipeline();
		pipeline.execute(itemPricingContext);
		
		//final ItemPriceResponseBuilder itemPriceResponseBuilder = new ItemPriceResponseBuilder();
		return itemPriceResponseBuilder.retrieveItemPriceRespone(itemPricingContext);
	}
}

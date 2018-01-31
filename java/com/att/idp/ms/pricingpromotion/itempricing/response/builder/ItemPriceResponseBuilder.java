package com.att.idp.ms.pricingpromotion.itempricing.response.builder;

import org.springframework.stereotype.Component;

import com.att.idp.ms.pricingpromotion.common.response.builder.ResponseBuilder;
import com.att.idp.ms.pricingpromotion.itempricing.bean.ItemPriceResponse;
import com.att.idp.ms.pricingpromotion.itempricing.bean.ItemPricingContext;


/**
 * The Class ItemPriceResponseBuilder.
 */
@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
@Component
public class ItemPriceResponseBuilder extends ResponseBuilder {

	/**
	 * Retrieve Item price respone.
	 *
	 * @param itemPricingContext
	 *            the item pricing context
	 * @return the item price response
	 */
	public ItemPriceResponse retrieveItemPriceRespone(final ItemPricingContext itemPricingContext) {

//		final ItemPriceResponse itemPriceResponse = new ItemPriceResponse();

		/*itemPriceResponse = (ItemPriceResponse) super.buildResponse(itemPricingContext, itemPriceResponse);

		itemPriceResponse.setTotalPrice(itemPricingContext.getItemPriceResponse().getTotalPrice());
*/
		return null;
	}

}

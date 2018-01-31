package com.att.idp.ms.pricingpromotion.itempricing.bean;

import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.common.model.PricingRestRequest;
import com.att.idp.ms.pricingpromotion.itempricing.model.ItemPricingRestRequest;

/**
 * The Class ItemPricingContext.
 */
public class ItemPricingContext extends PricingContext {

	/** The item price response. */
	private ItemPriceResponse itemPriceResponse;
	
	/** item Price Request. */
	private ItemPricingRestRequest itemPriceRequest;

	/**
	 * Gets the item price response.
	 *
	 * @return the item price response
	 */
	public ItemPriceResponse getItemPriceResponse() {
		return itemPriceResponse;
	}

	/**
	 * Sets the item price response.
	 *
	 * @param itemPriceResponse the new item price response
	 */
	public void setItemPriceResponse(final ItemPriceResponse itemPriceResponse) {
		this.itemPriceResponse = itemPriceResponse;
	}
	
	/**
	 * Gets the pricing request.
	 *
	 * @return the pricing request
	 */
	public PricingRestRequest getItemPricingRequest() {
		return itemPriceRequest;
	}

	/**
	 * Sets the pricing request.
	 *
	 * @param pricingRequest the new pricing request
	 */
	public void setItemPricingRequest(final ItemPricingRestRequest itemPriceRequest) {
		this.itemPriceRequest = itemPriceRequest;
	}
	
	
}

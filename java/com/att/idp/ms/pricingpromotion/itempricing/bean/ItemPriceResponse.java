package com.att.idp.ms.pricingpromotion.itempricing.bean;

import com.att.idp.ms.pricingpromotion.common.bean.PricingResponse;

/**
 * The Class ItemPriceResponse.
 */
public class ItemPriceResponse extends PricingResponse {

	/** The total price. */
	private double totalPrice;
		
	/**
	 * Gets the total price.
	 *
	 * @return the total price
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Sets the total price.
	 *
	 * @param totalPrice the new total price
	 */
	public void setTotalPrice(final double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * converts String
	 *
	 */
	@Override
	public String toString() {
		return "ItemPriceResponse [totalPrice=" + totalPrice + ", getTotalPrice()=" + getTotalPrice() + "]";
	}

}

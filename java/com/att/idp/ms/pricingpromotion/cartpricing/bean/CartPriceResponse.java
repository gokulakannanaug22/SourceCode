package com.att.idp.ms.pricingpromotion.cartpricing.bean;

import com.att.idp.ms.pricingpromotion.common.bean.PricingResponse;

/**
 * The Class CartPriceResponse.
 */
public class CartPriceResponse extends PricingResponse{

	/** The cart price. */
	private CartPrice cartPrice;	
	
	/**
	 * Gets the cart price.
	 *
	 * @return the cart price.
	 */
	public CartPrice getCartPrice() {
		return cartPrice;
	}

	/**
	 * Sets the cart price
	 *
	 * @param cartPrice the new cart price.
	 */
	public void setCartPrice(final CartPrice cartPrice) {
		this.cartPrice = cartPrice;
	}

	/**
	 * converts String
	 *
	 */
	@Override
	public String toString() {
		return "CartPriceResponse [cartPrice=" + cartPrice + ", getCartPrice()=" + getCartPrice() + "]";
	}
	
}

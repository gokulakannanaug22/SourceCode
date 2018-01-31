package com.att.idp.ms.pricingpromotion.cartpricing.bean;

import org.springframework.stereotype.Component;

import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;

/**
 * The Class CartPricingContext.
 */
public class CartPricingContext extends PricingContext {

	/** The cart price response. */
	private CartPriceResponse cartPriceResponse;

	/**
	 * Gets the cart price response.
	 *
	 * @return the cart price response
	 */
	public CartPriceResponse getCartPriceResponse() {
		if(cartPriceResponse == null) {
			return new CartPriceResponse();
		}
		return cartPriceResponse;
	}

	/**
	 * Sets the cart price response.
	 *
	 * @param cartPriceResponse the new cart price response
	 */
	public void setCartPriceResponse(final CartPriceResponse cartPriceResponse) {
		this.cartPriceResponse = cartPriceResponse;
	}


	/** (non-Javadoc)
	 * @see com.att.idp.ms.pricingpromotion.common.bean.PricingContext#toString()
	 */
	@Override
	public String toString() {
		return "CartPricingContext [CartPriceResponse=" + getCartPriceResponse() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}

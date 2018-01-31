package com.att.idp.ms.pricingpromotion.itempricing.model;

import java.util.List;

import com.att.idp.ms.pricingpromotion.common.model.PricingRestRequest;
import com.att.idp.ms.pricingpromotion.itempricing.bean.CartItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class ItemPricingServiceRequest.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPricingRestRequest extends PricingRestRequest {
	

	/** The cart. */
	private List<CartItem> cartItems;
	
	
	/**
	 * Gets the cart items.
	 *
	 * @return the cart items
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}



	/**
	 * Sets the cart items.
	 *
	 * @param cartItems the new cart items
	 */
	public void setCartItems(final List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}



	/**
	 *  (non-Javadoc).
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemPricingServiceRequest ["
//				+ "items=" + items + ", cart=" + cart + ", getItems()=" + getItems() + ", getCart()=" + getCart() 
				+ ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}

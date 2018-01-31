package com.att.idp.ms.pricingpromotion.itempricing.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ExistingCart items.
 */
@JsonInclude(Include.NON_EMPTY)
public class CartItem {
	
	/** The sku id. */
	@JsonProperty("skuId")
	private String skuId;
	
	/** The product id. */
	@JsonProperty("productId")
	private String productId;
	
	/** The quantity. */
	@JsonProperty("quantity")
	private int quantity;

	/**
	 * Gets the sku id.
	 *
	 * @return the sku id
	 */
	public String getSkuId() {
		return skuId;
	}

	/**
	 * Sets the sku id.
	 *
	 * @param skuId the new sku id
	 */
	public void setSkuId(final String skuId) {
		this.skuId = skuId;
	}
	
	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public String getProductId() {
		return productId;
	}
	
	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(final String productId) {
		this.productId = productId;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

	/**
	 * converts String
	 *
	 */
	@Override
	public String toString() {
		return "CartItem [skuId=" + skuId + ", productId=" + productId + ", quantity=" + quantity + ", getSkuId()="
				+ getSkuId() + ", getProductId()=" + getProductId() + ", getQuantity()=" + getQuantity() + "]";
	}
	
}
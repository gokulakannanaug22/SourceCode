package com.att.idp.ms.pricingpromotion.common.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Item.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_EMPTY)
public class PricingItem {

	/** The sku id. */
	@JsonProperty("skuId")
	private String skuId;
	
	/** The product id. */
	@JsonProperty("productId")
	private String productId;
	
	/** The pricing tier. */
	@JsonProperty("pricingTier")
	private String pricingTier;
	
	/** The product type. */
	@JsonProperty("productType")
	private String productType;
	
	/** The product line. */
	@JsonProperty("productLine")
	private String productLine;
	
	/** The quantity. */
	@JsonProperty("quantity")
	private int quantity;
	
	@JsonProperty("chargeType")
	private String chargeType;
	
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
	 * Gets the pricing tier.
	 *
	 * @return the pricing tier
	 */
	public String getPricingTier() {
		return pricingTier;
	}

	/**
	 * Sets the pricing tier.
	 *
	 * @param pricingTier the new pricing tier
	 */
	public void setPricingTier(final String pricingTier) {
		this.pricingTier = pricingTier;
	}

	/**
	 * Gets the product type.
	 *
	 * @return the product type
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * Sets the product type.
	 *
	 * @param productType the new product type
	 */
	public void setProductType(final String productType) {
		this.productType = productType;
	}

	/**
	 * Gets the product line.
	 *
	 * @return the product line
	 */
	public String getProductLine() {
		return productLine;
	}

	/**
	 * Sets the product line.
	 *
	 * @param productLine the new product line
	 */
	public void setProductLine(final String productLine) {
		this.productLine = productLine;
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
	
	

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	/**
	 * converts String
	 *
	 */
	@Override
	public String toString() {
		return "PricingItem [skuId=" + skuId + ", productId=" + productId + ", pricingTier=" + pricingTier
				+ ", productType=" + productType + ", productLine=" + productLine + ", quantity=" + quantity
				+ ", getSkuId()=" + getSkuId() + ", getProductId()=" + getProductId() + ", getPricingTier()="
				+ getPricingTier() + ", getProductType()=" + getProductType() + ", getProductLine()=" + getProductLine()
				+ ", getQuantity()=" + getQuantity() + ", getChargeType()=" + getChargeType() + "]";
	}
}

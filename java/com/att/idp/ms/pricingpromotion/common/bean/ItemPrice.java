package com.att.idp.ms.pricingpromotion.common.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ItemPrice.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ItemPrice {
	
	/** The sku id. */
	@JsonProperty("skuId")
	private String skuId;
		
	/** The product id. */
	@JsonProperty("productId")
	private String productId;
	
	/** The type. */
	@JsonProperty("type")
	private String type;
	
	/** The rack rate. */
	@JsonProperty("price")
	private double rackRate;
	
	/** The quantity. */
	@JsonProperty("quantity")
	private int quantity;
	
	/** The final price. */
	@JsonProperty("finalPrice")
	private double finalPrice;
		
	/** The promotion ref ids. */
	@JsonProperty("promotionRefIds")
	private List<String> promotionRefIds;
	
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
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(final String type) {
		this.type = type;
	}	
	
	/**
	 * Gets the rack rate.
	 *
	 * @return the rack rate
	 */
	public double getRackRate() {
		return rackRate;
	}
	
	/**
	 * Sets the rack rate.
	 *
	 * @param rackRate the new rack rate
	 */
	public void setRackRate(final double rackRate) {
		this.rackRate = rackRate;
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
	 * Gets the final price.
	 *
	 * @return the final price
	 */
	public double getFinalPrice() {
		return finalPrice;
	}
	
	/**
	 * Sets the final price.
	 *
	 * @param finalPrice the new final price
	 */
	public void setFinalPrice(final double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	/**
	 * Gets the promotion ref ids.
	 *
	 * @return the promotion ref ids
	 */
	public List<String> getPromotionRefIds() {
		return promotionRefIds;
	}
	
	/**
	 * Sets the promotion ref ids.
	 *
	 * @param promotionRefIds the new promotion ref ids
	 */
	public void setPromotionRefIds(final List<String> promotionRefIds) {
		this.promotionRefIds = promotionRefIds;
	}

	/**
	 * converts String
	 *
	 */
	@Override
	public String toString() {
		return "ItemPrice [skuId=" + skuId + ", productId=" + productId + ", type=" + type + ", rackRate=" + rackRate
				+ ", quantity=" + quantity + ", finalPrice=" + finalPrice + ", promotionRefIds=" + promotionRefIds
				+ ", getSkuId()=" + getSkuId() + ", getProductId()=" + getProductId() + ", getType()=" + getType()
				+ ", getRackRate()=" + getRackRate() + ", getQuantity()=" + getQuantity() + ", getFinalPrice()="
				+ getFinalPrice() + ", getPromotionRefIds()=" + getPromotionRefIds() + "]";
	}
}

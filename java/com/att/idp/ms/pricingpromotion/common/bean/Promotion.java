package com.att.idp.ms.pricingpromotion.common.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Promotion.
 */

/**
 * @author gokulakannanv
 *
 */
public class Promotion {
	/** The id. */
	@JsonProperty("identifier")
	private String identifier;
	
	/** The promotion code. */
	@JsonProperty("promotioncode")
	private String promotionCode;
	
	/** The promotion id. */
	@JsonProperty("promotionId")
	private int promotionId;
	
	/**
	 * The Enum displayLevel.
	 */
	public enum displayLevel { 
 /** The item. */
 ITEM, 
 /** The order. */
 ORDER }
	
	/** The base offer id. */
	@JsonProperty("baseOfferId")
	private String baseOfferId; 
	
	/** The promotion name. */
	@JsonProperty("promotionName")
	private String promotionName;
	
	/** The amount. */
	@JsonProperty("amount")
	private double amount;
	
	/** The percent. */
	@JsonProperty("percent")
	private int percent;
	
	/** The fixed amount. */
	@JsonProperty("fixedAmount")
	private double fixedAmount;
	
	/** The duration. */
	@JsonProperty("duration")
	private String duration;
	
	/** The promotion type. */
	@JsonProperty("promoType")
	private String promoType;
		
	/** The effective days. */
	@JsonProperty("effectiveDays")
	private int effectiveDays;
	
	/** The complex discount. */
	@JsonProperty("complexDiscount")
	private boolean complexDiscount;
	
	/** The description. */
	@JsonProperty("description")
	private String description;
	
	/** The occurance type. */
	@JsonProperty("occuranceType")
	private String occuranceType;
	
	/** The product id. */
	@JsonProperty("productId")
	private String productId;
	
	/** The saleType */
	@JsonProperty("saleType")
	private String saleType;

	/** The eligibilityId */
	@JsonProperty("eligibilityId")
	private String eligibilityId;
	
	/** The promoLevel */
	@JsonProperty("promoLevel")
	private String promoLevel;
	
	/** The locationType */
	@JsonProperty("locationType")
	private String locationType;
		
	/** The ranking */
	@JsonProperty("ranking")
	private String ranking;
	
	/**
	 * Gets the Identifier.
	 *
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * Sets the identifier.
	 *
	 * @param identifier the new identifier
	 */
	public void setIdentifier(final String identifier) {
		this.identifier = identifier;
	}
		
	/**
	 * Gets the promotion code.
	 *
	 * @return the promotion code
	 */
	public String getPromotionCode() {
		return promotionCode;
	}	

	/**
	 * Sets the promotion code.
	 *
	 * @param promotionCode the new promotion code
	 */
	public void setPromotionCode(final String promotionCode) {
		this.promotionCode = promotionCode;
	}
	
	/**
	 * Gets the promotion id.
	 *
	 * @return the promotion id
	 */
	public int getPromotionId() {
		return promotionId;
	}
	
	/**
	 * Sets the promotion id.
	 *
	 * @param promotionId the new promotion id
	 */
	public void setPromotionId(final int promotionId) {
		this.promotionId = promotionId;
	}
	
	/**
	 * Gets the base offer id.
	 *
	 * @return the base offer id
	 */
	public String getBaseOfferId() {
		return baseOfferId;
	}
	
	/**
	 * Sets the base offer id.
	 *
	 * @param baseOfferId the new base offer id
	 */
	public void setBaseOfferId(final String baseOfferId) {
		this.baseOfferId = baseOfferId;
	}
	
	/**
	 * Gets the promotion name.
	 *
	 * @return the promotion name
	 */
	public String getPromotionName() {
		return promotionName;
	}
	
	/**
	 * Sets the promotion name.
	 *
	 * @param promotionName the new promotion name
	 */
	public void setPromotionName(final String promotionName) {
		this.promotionName = promotionName;
	}
	
	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(final double amount) {
		this.amount = amount;
	}
	
	/**
	 * Gets the percent.
	 *
	 * @return the percent
	 */
	public int getPercent() {
		return percent;
	}
	
	/**
	 * Sets the percent.
	 *
	 * @param percent the new percent
	 */
	public void setPercent(final int percent) {
		this.percent = percent;
	}
	
	/**
	 * Gets the fixed amount.
	 *
	 * @return the fixed amount
	 */
	public double getFixedAmount() {
		return fixedAmount;
	}
	
	/**
	 * Sets the fixed amount.
	 *
	 * @param fixedAmount the new fixed amount
	 */
	public void setFixedAmount(final double fixedAmount) {
		this.fixedAmount = fixedAmount;
	}
	
	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}
	
	/**
	 * Sets the duration.
	 *
	 * @param duration the new duration
	 */
	public void setDuration(final String duration) {
		this.duration = duration;
	}	
		
	/**
	 * Gets the promo type.
	 *
	 * @return the promo type
	 */
	public String getPromoType() {
		return promoType;
	}

	/**
	 * Sets the promo type.
	 *
	 * @param promoType the new promo type
	 */
	public void setPromoType(String promoType) {
		this.promoType = promoType;
	}

	/**
	 * Gets the effective days.
	 *
	 * @return the effective days
	 */
	public int getEffectiveDays() {
		return effectiveDays;
	}
	
	/**
	 * Sets the effective days.
	 *
	 * @param effectiveDays the new effective days
	 */
	public void setEffectiveDays(final int effectiveDays) {
		this.effectiveDays = effectiveDays;
	}
	
	/**
	 * Checks if is complex discount.
	 *
	 * @return true, if is complex discount
	 */
	public boolean isComplexDiscount() {
		return complexDiscount;
	}
	
	/**
	 * Sets the complex discount.
	 *
	 * @param complexDiscount the new complex discount
	 */
	public void setComplexDiscount(final boolean complexDiscount) {
		this.complexDiscount = complexDiscount;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(final String description) {
		this.description = description;
	}
	
	/**
	 * Gets the occurance type.
	 *
	 * @return the occurance type
	 */
	public String getOccuranceType() {
		return occuranceType;
	}
	
	/**
	 * Sets the occurance type.
	 *
	 * @param occuranceType the new occurance type
	 */
	public void setOccuranceType(final String occuranceType) {
		this.occuranceType = occuranceType;
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
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * converts String.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Promotion [identifier=" + identifier + ", promotionCode=" + promotionCode + ", promotionId="
				+ promotionId + ", baseOfferId=" + baseOfferId + ", promotionName=" + promotionName + ", amount="
				+ amount + ", percent=" + percent + ", fixedAmount=" + fixedAmount + ", duration=" + duration
				+ ", promoType=" + promoType + ", effectiveDays=" + effectiveDays + ", complexDiscount="
				+ complexDiscount + ", description=" + description + ", occuranceType=" + occuranceType
				+ ", getIdentifier()=" + getIdentifier() + ", getPromotionCode()=" + getPromotionCode()
				+ ", getPromotionId()=" + getPromotionId() + ", getBaseOfferId()=" + getBaseOfferId()
				+ ", getPromotionName()=" + getPromotionName() + ", getAmount()=" + getAmount() + ", getPercent()="
				+ getPercent() + ", getFixedAmount()=" + getFixedAmount() + ", getDuration()=" + getDuration()
				+ ", getPromoType()=" + getPromoType() + ", getEffectiveDays()=" + getEffectiveDays()
				+ ", isComplexDiscount()=" + isComplexDiscount() + ", getDescription()=" + getDescription()
				+ ", getOccuranceType()=" + getOccuranceType() + " getProductId()=" + getProductId() +" ]";
	}
	
	
	/**
	 * getSaleType
	 * @return
	 */
	public String getSaleType() {
		return saleType;
	}

	/**
	 * setSaleType
	 * @param saleType
	 */
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	
	/**
	 * @return
	 */
	public String getEligibilityId() {
		return eligibilityId;
	}

	/**
	 * @param eligibilityId
	 */
	public void setEligibilityId(String eligibilityId) {
		this.eligibilityId = eligibilityId;
	}
	
	/**
	 * @return
	 */
	public String getPromoLevel() {
		return promoLevel;
	}

	/**
	 * @param promoLevel
	 */
	public void setPromoLevel(String promoLevel) {
		this.promoLevel = promoLevel;
	}
	
	/**
	 * @return
	 */
	public String getLocationType() {
		return locationType;
	}

	/**
	 * @param locationType
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	
	/**
	 * @return
	 */
	public String getRanking() {
		return ranking;
	}

	/**
	 * @param ranking
	 */
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

}

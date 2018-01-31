package com.att.idp.ms.pricingpromotion.common.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class CashBack.
 */
@JsonInclude(Include.NON_EMPTY)
public class CashBack {

	/** The reward id. */
	@JsonProperty("rewardId")
	private String rewardId;

	/** The short display name. */
	@JsonProperty("shortDisplayName")
	private String shortDisplayName;
	
	/** The reward category. */
	@JsonProperty("rewardCategory")
	private String rewardCategory;
	
	/** The amount. */
	@JsonProperty("amount")
	private double amount;
	
	/** The reward code. */
	@JsonProperty("rewardCode")
	private String rewardCode;
	
	/** The action type. */
	@JsonProperty("actionType")
	private String actionType;

	/** The reward type. */
	@JsonProperty("rewardType")
	private String rewardType;
	
	/** The fulfillment type. */
	@JsonProperty("fulfillmentType")
	private String fulfillmentType;
	
	/**
	 * Gets the reward id.
	 *
	 * @return the reward id
	 */
	public String getRewardId() {
		return rewardId;
	}

	/**
	 * Sets the reward id.
	 *
	 * @param rewardId the new reward id
	 */
	public void setRewardId(final String rewardId) {
		this.rewardId = rewardId;
	}

	/**
	 * Gets the reward type.
	 *
	 * @return the reward type
	 */
	public String getRewardType() {
		return rewardType;
	}

	/**
	 * Sets the reward type.
	 *
	 * @param rewardType the new reward type
	 */
	public void setRewardType(final String rewardType) {
		this.rewardType = rewardType;
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
	 * Gets the short display name.
	 *
	 * @return the short display name
	 */
	public String getShortDisplayName() {
		return shortDisplayName;
	}

	/**
	 * Sets the short display name.
	 *
	 * @param shortDisplayName the new short display name
	 */
	public void setShortDisplayName(final String shortDisplayName) {
		this.shortDisplayName = shortDisplayName;
	}

	/**
	 * Gets the reward category.
	 *
	 * @return the reward category
	 */
	public String getRewardCategory() {
		return rewardCategory;
	}

	/**
	 * Sets the reward category.
	 *
	 * @param rewardCategory the new reward category
	 */
	public void setRewardCategory(final String rewardCategory) {
		this.rewardCategory = rewardCategory;
	}

	/**
	 * Gets the reward code.
	 *
	 * @return the reward code
	 */
	public String getRewardCode() {
		return rewardCode;
	}

	/**
	 * Sets the reward code.
	 *
	 * @param rewardCode the new reward code
	 */
	public void setRewardCode(final String rewardCode) {
		this.rewardCode = rewardCode;
	}

	/**
	 * Gets the action type.
	 *
	 * @return the action type
	 */
	public String getActionType() {
		return actionType;
	}

	/**
	 * Sets the action type.
	 *
	 * @param actionType the new action type
	 */
	public void setActionType(final String actionType) {
		this.actionType = actionType;
	}

	/**
	 * Gets the fulfillment type.
	 *
	 * @return the fulfillment type
	 */
	public String getFulfillmentType() {
		return fulfillmentType;
	}

	/**
	 * Sets the fulfillment type.
	 *
	 * @param fulfillmentType the new fulfillment type
	 */
	public void setFulfillmentType(final String fulfillmentType) {
		this.fulfillmentType = fulfillmentType;
	}
	/**
	 * converts String
	 *
	 */
	@Override
	public String toString() {
		return "CashBack [rewardId=" + rewardId + ", shortDisplayName=" + shortDisplayName + ", rewardCategory="
				+ rewardCategory + ", amount=" + amount + ", rewardCode=" + rewardCode + ", actionType=" + actionType
				+ ", rewardType=" + rewardType + ", fulfillmentType=" + fulfillmentType + ", getRewardId()="
				+ getRewardId() + ", getRewardType()=" + getRewardType() + ", getAmount()=" + getAmount()
				+ ", getShortDisplayName()=" + getShortDisplayName() + ", getRewardCategory()=" + getRewardCategory()
				+ ", getRewardCode()=" + getRewardCode() + ", getActionType()=" + getActionType()
				+ ", getFulfillmentType()=" + getFulfillmentType() + "]";
	}
	
	
	
}

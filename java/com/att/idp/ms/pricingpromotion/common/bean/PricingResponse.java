package com.att.idp.ms.pricingpromotion.common.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PriceResponse. 
 */
@JsonInclude(Include.NON_EMPTY)
public class PricingResponse {

	/** The items price. */
	@JsonProperty("itemPrice")
	private List<ItemPrice> itemsPrice;
	
	/** The promotions. */
	@JsonProperty("promotions")
	private List<Promotion> promotions;
	
	/** The cash back offers. */
	@JsonProperty("cashBackOffers")
	private List<CashBack>	cashBackOffers;
	
	
	/**
	 * Gets the items price.
	 *
	 * @return the items price
	 */
	public List<ItemPrice> getItemsPrice() {
		return itemsPrice;
	}

	/**
	 * Sets the items price.
	 *
	 * @param itemsPrice the new items price
	 */
	public void setItemsPrice(final List<ItemPrice> itemsPrice) {
		this.itemsPrice = itemsPrice;
	}

	/**
	 * Gets the promotions.
	 *
	 * @return the promotions
	 */
	public List<Promotion> getPromotions() {
		return promotions;
	}

	/**
	 * Sets the promotions.
	 *
	 * @param promotions the new promotions
	 */
	public void setPromotions(final List<Promotion> promotions) {
		this.promotions = promotions;
	}

	/**
	 * Gets the cash back offers.
	 *
	 * @return the cash back offers
	 */
	public List<CashBack> getCashBackOffers() {
		return cashBackOffers;
	}

	/**
	 * Sets the cash back offers.
	 *
	 * @param cashBackOffers the new cash back offers
	 */
	public void setCashBackOffers(final List<CashBack> cashBackOffers) {
		this.cashBackOffers = cashBackOffers;
	}

	/**
	 * converts String
	 *
	 */
	@Override
	public String toString() {
		return "PricingResponse [itemsPrice=" + itemsPrice + ", promotions=" + promotions + ", cashBackOffers="
				+ cashBackOffers + ", getItemsPrice()=" + getItemsPrice() + ", getPromotions()=" + getPromotions()
				+ ", getCashBackOffers()=" + getCashBackOffers() + "]";
	}
	
	
}

package com.att.idp.ms.pricingpromotion.cartpricing.bean;

import java.util.List;

/**
 * The Class CartPrice.
 */
public class CartPrice {

	/** The amount. */
	private double amount;
	
	/** The due today. */
	private double dueToday;
	
	/** The due monthly. */
	private double dueMonthly;
	
	/** The due first bill. */
	private double dueFirstBill;
	
	/** The promotion ref Ids. */
	private List<String> promotionRefIDs;
	
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
	 * Gets the due today.
	 *
	 * @return the due today
	 */
	public double getDueToday() {
		return dueToday;
	}
	
	/**
	 * Sets the due today.
	 *
	 * @param dueToday the new due today
	 */
	public void setDueToday(final double dueToday) {
		this.dueToday = dueToday;
	}
	
	/**
	 * Gets the due monthly.
	 *
	 * @return the due monthly
	 */
	public double getDueMonthly() {
		return dueMonthly;
	}
	
	/**
	 * Sets the due monthly.
	 *
	 * @param dueMonthly the new due monthly
	 */
	public void setDueMonthly(final double dueMonthly) {
		this.dueMonthly = dueMonthly;
	}
	
	/**
	 * Gets the due first bill.
	 *
	 * @return the due first bill
	 */
	public double getDueFirstBill() {
		return dueFirstBill;
	}
	
	/**
	 * Sets the due first bill.
	 *
	 * @param dueFirstBill the new due first bill
	 */
	public void setDueFirstBill(final double dueFirstBill) {
		this.dueFirstBill = dueFirstBill;
	}
	
	/**
	 * Gets the promotion ref I ds.
	 *
	 * @return the promotion ref I ds
	 */
	public List<String> getPromotionRefIDs() {
		return promotionRefIDs;
	}
	
	/**
	 * Sets the promotion ref I ds.
	 *
	 * @param promotionRefIDs the new promotion ref I ds
	 */
	public void setPromotionRefIDs(final List<String> promotionRefIDs) {
		this.promotionRefIDs = promotionRefIDs;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CartPrice [amount=" + amount + ", dueToday=" + dueToday + ", dueMonthly=" + dueMonthly
				+ ", dueFirstBill=" + dueFirstBill + ", promotionRefIDs=" + promotionRefIDs + ", getAmount()="
				+ getAmount() + ", getDueToday()=" + getDueToday() + ", getDueMonthly()=" + getDueMonthly()
				+ ", getDueFirstBill()=" + getDueFirstBill() + ", getPromotionRefIDs()=" + getPromotionRefIDs() + "]";
	}
	
}

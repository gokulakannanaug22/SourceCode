package com.att.idp.ms.pricingpromotion.common.calculator;

import com.att.idp.ms.pricingpromotion.common.bean.Promotion;

// TODO: Auto-generated Javadoc
/**
 * The Class FlatAmountOffCalculator.
 */
public class FlatAmountOffCalculator implements DiscountTypeCalculator{

	/**
	 * Calculate promotion price.
	 *
	 * @param itemPrice
	 *            the item price
	 * @param promotion
	 *            the promotion
	 * @return the double
	 */
	public double calculateDiscountAmount(final Promotion promotion) {

		return promotion.getAmount();

	}
}

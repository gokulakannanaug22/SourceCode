package com.att.idp.ms.pricingpromotion.common.calculator;

import com.att.idp.ms.pricingpromotion.common.bean.Promotion;

/**
 * The Interface DiscountTypeCalculator.
 */
public interface DiscountTypeCalculator {
	
	/**
	 * Calculate discount amount.
	 *
	 * @param promotion the promotion
	 * @return the double
	 */
	double calculateDiscountAmount(final Promotion promotion);

}

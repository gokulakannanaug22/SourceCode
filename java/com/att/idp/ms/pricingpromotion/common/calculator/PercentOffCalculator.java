package com.att.idp.ms.pricingpromotion.common.calculator;

import com.att.idp.ms.pricingpromotion.common.bean.Promotion;



/**
 * The Class PercentOffCalculator.
 */
public class PercentOffCalculator implements DiscountTypeCalculator{

	/**
	 * Calculate promotion price.
	 *
	 * @param promotion the promotion
	 * @return the double
	 */
	public double calculateDiscountAmount(final Promotion promotion) {
		// calculate the percentage amount
		return promotion.getAmount();
	}

	/**
	 * Calculate discount amount 1.
	 *
	 * @param promotion the promotion
	 * @param selectedQtyPrice the selected qty price
	 * @return the double
	 */
	public double calculateDiscountPercent(final Promotion promotion, final double selectedQtyPrice) {
		if(promotion.getPromoType().equalsIgnoreCase("percentoff")){
		return selectedQtyPrice * ((double)promotion.getPercent() / 100);
		}else{
			return selectedQtyPrice * (promotion.getAmount() / 100);
		}
	}

}

package com.att.idp.ms.pricingpromotion.common.calculator;

import java.util.List;

import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.ms.pricingpromotion.common.bean.Promotion;


/**
 * The Class ItemDiscountCalculator.
 */
@SuppressWarnings("PMD")
//@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
public class ItemDiscountCalculator {

	/** The log. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(ItemDiscountCalculator.class);

	/**
	 * Calculate promotion amount.
	 *
	 * @param itemPromotions the item promotions
	 * @return the double
	 */

	/*@SuppressWarnings("PMD.MissingBreakInSwitch")
	public double calculateDiscountAmount(final List<Promotion> itemPromotions) {
		
		String promotionType = null;
		double discountAmount = 0.0d;
		final FlatAmountOffCalculator flatAmountOffCalculator = new FlatAmountOffCalculator();
		final PercentOffCalculator percentOffCalculator = new PercentOffCalculator();
		final FlatRateCalculator flatRateCalculator = new FlatRateCalculator();
		for (final Promotion promotion : itemPromotions) {
			promotionType = promotion.getPromoType();
			switch (promotionType) {
			case "flatamountoff":
				discountAmount += flatAmountOffCalculator.calculateDiscountAmount(promotion);
				break;
			case "percentoff":
				discountAmount += percentOffCalculator.calculateDiscountAmount(promotion);
				break;
			case "flatRate":
				discountAmount += flatRateCalculator.calculateDiscountAmount(promotion);
				break;
			default:
				log.error("Invalid Promotion type: " + promotionType);
			}
		}
		return discountAmount;
	}*/

	/**
	 * Calculate Final amount.
	 *
	 * @param itemPromotions the item promotions
	 * @PARAM selectedQtyPrice 
	 * @return the double
	 */
	@SuppressWarnings("PMD.MissingBreakInSwitch")
	public double calculateFinalPrice(final List<Promotion> itemPromotions, double selectedQtyPrice) {

		String promotionType = null;
		double discountAmount = 0.0d;
		final FlatAmountOffCalculator flatAmountOffCalculator = new FlatAmountOffCalculator();
		final PercentOffCalculator percentOffCalculator = new PercentOffCalculator();
		final FlatRateCalculator flatRateCalculator = new FlatRateCalculator();
		double flatRateAmount = 0.0d;
		double finalPrice = 0.0d;
		boolean isFlatRatePromoEligible = false;
		for (final Promotion promotion : itemPromotions) {
			promotionType = promotion.getPromoType();
			switch (promotionType) {
			case "flatamountoff":
				discountAmount += flatAmountOffCalculator.calculateDiscountAmount(promotion);
				break;
			case "percentoff":
				if (isFlatRatePromoEligible) {
					discountAmount += percentOffCalculator.calculateDiscountPercent(promotion, flatRateAmount);
				} else {
					discountAmount += percentOffCalculator.calculateDiscountPercent(promotion, selectedQtyPrice);
				}				
				break;
			case "flatRate":
				isFlatRatePromoEligible = true;
				flatRateAmount = flatRateCalculator.calculateDiscountAmount(promotion);
				break;
			default:
				log.error("Invalid Promotion type: " + promotionType);
			}
		}
		if (isFlatRatePromoEligible) {
			finalPrice = flatRateAmount - discountAmount;
		} else {
			finalPrice = selectedQtyPrice - discountAmount;
		}
		return finalPrice;
	}

}

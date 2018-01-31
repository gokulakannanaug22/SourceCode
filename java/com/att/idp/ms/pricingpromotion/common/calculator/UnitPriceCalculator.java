package com.att.idp.ms.pricingpromotion.common.calculator;

/**
 * The Class UnitPriceCalculator.
 */
public class UnitPriceCalculator {
	
	/**
	 * Calculate unit price.
	 *
	 * @param rackRatePrice the rack rate price
	 * @param quantity the quantity
	 * @return the double
	 */
	public double calculateUnitPrice(final double rackRatePrice, final int quantity) {
		
		return rackRatePrice * quantity;
	}

}

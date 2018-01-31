package com.att.idp.ms.pricingpromotion.cartpricing.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPrice;
import com.att.idp.ms.pricingpromotion.cartpricing.calculator.CartPriceCalculator;
import com.att.idp.ms.pricingpromotion.common.PricingPromotionInputData;

@SuppressWarnings("deprecation")
public class CartPriceCalculatorTest {

	CartPriceCalculator cartPriceCalc = new CartPriceCalculator();

	CartPrice cartPrice = new CartPrice();

	/*@Test
	public void calculateCartPriceMRCTest() {

		double resp = cartPriceCalc.calculateCartPrice(PricingPromotionInputData.getItemPriceMrcMap(), cartPrice);
		assertEquals(200.00, resp);
	}

	@Test
	public void calculateCartPriceNRCTest() {

		double resp = cartPriceCalc.calculateCartPrice(PricingPromotionInputData.getItemPriceNRCMap(), cartPrice);
		assertEquals(200.00, resp);
	}

	@Test
	public void calculateCartPriceMRCandNRCTest() {

		double resp = cartPriceCalc.calculateCartPrice(PricingPromotionInputData.getItemPriceMrcNrcMap(), cartPrice);
		assertEquals(200.00, resp);
	}

	@Test
	public void calculateCartPriceNrcDueTodayTest() {

		double resp = cartPriceCalc.calculateCartPrice(PricingPromotionInputData.getItemMapPriceNRC_DueToday(), cartPrice);
		assertEquals(200.00, resp);
		
	}
*/
}

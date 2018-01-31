package com.att.idp.ms.pricingpromotion.common.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.att.idp.ms.pricingpromotion.common.bean.Promotion;

/**
 * The Class FlatRateCalculatorTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class FlatRateCalculatorTest{
	
	/**
	 * flatRateCalculator
	 */
	public FlatRateCalculator flatRateCalculator;
	/**
	 * promotion
	 */
	public Promotion promotion;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		flatRateCalculator = new FlatRateCalculator();
		promotion = new Promotion();
		promotion.setAmount(10.0);
	}
	
	/**
	 * testcalculateCartPrice
	 * @throws Exception
	 */
	@Test
	public void testcalculateCartPrice() throws Exception{
		flatRateCalculator.calculateDiscountAmount(promotion);
	}
	
	/**
	 * testcalculateCartPrice
	 * @throws Exception
	 */
	@Test
	public void testcalculateCartPriceInvalid() throws Exception{
		promotion = new Promotion();
		flatRateCalculator.calculateDiscountAmount(promotion);
	}
}

package com.att.idp.ms.pricingpromotion.common.calculator;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.att.idp.ms.pricingpromotion.common.bean.Promotion;

/**
 * The Class FlatAmountOffCalculatorTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class FlatAmountOffCalculatorTest{
	
	/**
	 * flatAmountOffCalculator
	 */
	public FlatAmountOffCalculator flatAmountOffCalculator;
	
	/**
	 * promotion
	 */
	public Promotion promotion;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		flatAmountOffCalculator = new FlatAmountOffCalculator();
		promotion = new Promotion();
		promotion.setAmount(10.0);
	}
	
	/**
	 * testcalculateCartPrice
	 * @throws Exception
	 */
	@Test
	public void testcalculateCartPrice() throws Exception{
		flatAmountOffCalculator.calculateDiscountAmount(promotion);
	}
	
	/**
	 * testcalculateCartPrice
	 * @throws Exception
	 */
	@Test
	public void testcalculateCartPriceInvalid() throws Exception{
		promotion = new Promotion();
		flatAmountOffCalculator.calculateDiscountAmount(promotion);
	}
}

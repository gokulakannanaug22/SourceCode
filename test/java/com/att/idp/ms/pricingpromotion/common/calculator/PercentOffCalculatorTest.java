package com.att.idp.ms.pricingpromotion.common.calculator;

import com.att.idp.ms.pricingpromotion.common.bean.Promotion;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

// TODO: Auto-generated Javadoc
/**
 * The Class PercentOffCalculatorTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class PercentOffCalculatorTest{
	/**
	 * percentOffCalculator
	 */
	private PercentOffCalculator percentOffCalculator;

	/**
	 * promotion
	 */
	private Promotion promotion;

	@Before
	public void setUp(){
		percentOffCalculator = new PercentOffCalculator();
		promotion = new Promotion();
		promotion.setAmount(10.0);
	}

	/**
	 * testcalculateDiscountAmount
	 * @throws Exception
	 */
	@Test
	public void testcalculateDiscountAmount() throws Exception{
		percentOffCalculator.calculateDiscountAmount(promotion);
	}

	/**
	 * testcalculateDiscountAmount
	 * @throws Exception
	 */
	@Test
	public void testcalculateDiscountAmountEmptyPromo() throws Exception{
		promotion = new Promotion();
		percentOffCalculator.calculateDiscountAmount(promotion);
	}

	/**
	 * testcalculateDiscountAmount
	 * @throws Exception
	 */
	@Test(expected=NullPointerException.class)
	public void testcalculateDiscountAmountNull2() throws Exception{
		promotion = null;
		percentOffCalculator.calculateDiscountAmount(promotion);
	}
}

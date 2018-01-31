package com.att.idp.ms.pricingpromotion.common.calculator;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class UnitPriceCalculatorTest {
	/**
	 * unitPriceCalculator
	 */
	private UnitPriceCalculator unitPriceCalculator;
	
	/**
	 * rackRatePrice
	 */
	private double rackRatePrice;
	
	/**
	 * quantity
	 */
	private int quantity;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		unitPriceCalculator = new UnitPriceCalculator();
		rackRatePrice = 10.0;
		quantity = 2;	
	}
	
	/**
	 * testcalculateUnitPrice
	 * @throws Exception
	 */
	public void testcalculateUnitPrice() throws Exception {
		
		unitPriceCalculator.calculateUnitPrice(rackRatePrice, quantity);
	}
	
}



package com.att.idp.ms.pricingpromotion.cartpricing.selector.impl;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.att.idp.ms.pricingpromotion.cartpricing.processor.CartPriceCalculatorProcessor;
import com.att.idp.ms.pricingpromotion.cartpricing.selector.CartPriceCashBackSelector;
import com.att.idp.ms.pricingpromotion.common.bean.CashBack;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;

/**
 * The Class WirelessCartPriceCashBackSelectorTest.
 */

public class WirelessCartPriceCashBackSelectorTest{

	/**
	 * wirelessCartPriceCashBackSelector
	 */
	public WirelessCartPriceCashBackSelector wirelessCartPriceCashBackSelector;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		wirelessCartPriceCashBackSelector = new WirelessCartPriceCashBackSelector();
	}
	
	/**
	 * testretrieveCashBackOffers
	 * @throws Exception
	 */
	@Test
	public void testretrieveCashBackOffers() throws Exception {

	}
	
	/**
	 * testretrieveCashBackOffersNull
	 * @throws Exception
	 */
	@Test
	public void testretrieveCashBackOffersNull() throws Exception {

	}
	
	/**
	 * testretrieveCashBackOffersException
	 * @throws Exception
	 */
	@Test
	public void testretrieveCashBackOffersException() throws Exception {

	}

}

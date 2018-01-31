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

public class WirelineCartPriceCashBackSelectorTest{

	/**
	 * wirelessCartPriceCashBackSelector
	 */
	public WirelineCartPriceCashBackSelector wirelineCartPriceCashBackSelector;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		wirelineCartPriceCashBackSelector = new WirelineCartPriceCashBackSelector();
	}
	
	/**
	 * testretrieveCashBackOffers
	 * @throws Exception
	 */
	@Test
	public void testretrieveCashBackOffers() throws Exception {

	}
	
	/**
	 * testretrieveCashBackOfferspricingItemsNull
	 * @throws Exception
	 */
	@Test
	public void testretrieveCashBackOfferspricingItemsNull() throws Exception {

	}
	
	/**
	 * testretrieveCashBackOffersrequestContextNull
	 * @throws Exception
	 */
	@Test
	public void testretrieveCashBackOffersrequestContextNull() throws Exception {

	}
	
	/**
	 * testretrieveCashBackOffersBothNull
	 * @throws Exception
	 */
	@Test
	public void testretrieveCashBackOffersBothNull() throws Exception {

	}

}

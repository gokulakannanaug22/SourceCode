/**
 * 
 */
package com.att.idp.ms.pricingpromotion.common.selector.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;

// TODO: Auto-generated Javadoc
/**
 * The Class WirelessPriceSelectorTest	.
 *
 * @author vp020k
 */
@RunWith(MockitoJUnitRunner.class)
public class WirelessPriceSelectorTest  {
	
	/**
	 * wirelessPriceSelector
	 */
	public WirelessPriceSelector wirelessPriceSelector;
	/**
	 * skuItems
	 */
	private List<PricingItem> skuItems;
	
	/**
	 * requestContext
	 */
	private RequestContext requestContext;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		wirelessPriceSelector = new WirelessPriceSelector();
		skuItems = new ArrayList<PricingItem>();
		PricingItem itemDetailsFromRequest = new PricingItem();
		itemDetailsFromRequest.setSkuId("sku81003071");
		itemDetailsFromRequest.setPricingTier("NP");
		skuItems.add(itemDetailsFromRequest);
		requestContext = new RequestContext();
		requestContext.getProfileContext().setCustomerType("residential");
		requestContext.setZip9("zip9");
		requestContext.setZip("zip");
		requestContext.setDma("dma");
		requestContext.setCity("city");
		requestContext.setState("state");
		requestContext.setNation("nation");
	//	when(mCartBuilder.isValidUser(mCartServiceContext.getUuid(), mCartServiceContext.getTatsCookie())).thenReturn(true);
	
	}
	
	/**
	 * testretrieveItemsPrice
	 * @throws Exception
	 */
	@Test
	public void testretrieveItemsPrice() throws Exception{
		wirelessPriceSelector.retrieveItemsPrice(skuItems, requestContext);
	}
}

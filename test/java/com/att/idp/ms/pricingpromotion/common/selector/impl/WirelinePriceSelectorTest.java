/**
 * 
 */
package com.att.idp.ms.pricingpromotion.common.selector.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.att.idp.ms.pricingpromotion.common.PricingPromotionInputData;
import com.att.idp.ms.pricingpromotion.common.bean.ItemPrice;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;

/**
 * The Class WirelinePriceSelector.
 *
 * @author vp020k
 */
@RunWith(MockitoJUnitRunner.class)
public class WirelinePriceSelectorTest {
	/**
	 * mwirelinePriceSelector
	 */
	private WirelinePriceSelector wirelinePriceSelector;
	
	/**
	 * requestContext
	 */
	private RequestContext requestContext;
	
	
	public List<PricingItem> pricingItems;
	
		
	@Before
	public void setUp(){
		wirelinePriceSelector = new WirelinePriceSelector();
		pricingItems = PricingPromotionInputData.getCartRequestTestData().getPricingItems();
		requestContext = PricingPromotionInputData.getMockRequestContext();	
	}
	
	/**
	 * testretrieveItemsPrice
	 * @throws Exception
	 */
	@Test
	public void testretrieveItemsPrice() throws Exception{
		Map<String, ItemPrice> resp = wirelinePriceSelector.retrieveItemsPrice(pricingItems, requestContext);
		assertNotNull(resp);
		assertEquals(resp.get("sku81003071").getProductId(), "Prd45367");
		assertEquals(resp.get("sku81003071").getSkuId(), "sku81003071");
		assertEquals(resp.get("sku81003071").getType(), "mrc");
	//	assertEquals(resp.get("sku81003071").getRackRate(), 133.0); // deprecated
		assertEquals(resp.get("sku81003071").getQuantity(), 1);
	}
	
		
	// Write test cases with multiple input items.
	/**
	 * testretrieveItemsPrice
	 * @throws Exception
	 */
	@Test
	public void testretrieveItemsPricemultiPriceItems() throws Exception{
		pricingItems = PricingPromotionInputData.getCartRequestMultiTestData().getPricingItems();
		requestContext = PricingPromotionInputData.getMockRequestContext();	
		Map<String, ItemPrice> resp = wirelinePriceSelector.retrieveItemsPrice(pricingItems, requestContext);
		assertNotNull(resp);
		assertEquals(resp.get("sku81003071").getProductId(), "Prd45367");
		assertEquals(resp.get("sku81003072").getProductId(), "Prd45369");
		assertEquals(resp.get("sku81003071").getSkuId(), "sku81003071");
		assertEquals(resp.get("sku81003072").getSkuId(), "sku81003072");
		assertEquals(resp.get("sku81003071").getType(), "mrc");
		assertEquals(resp.get("sku81003072").getType(), "mrc");
	//	assertEquals(resp.get("sku81003071").getRackRate(), 133.0); // deprecated
		assertEquals(resp.get("sku81003071").getQuantity(), 1);
		assertEquals(resp.get("sku81003072").getQuantity(), 2);
	}
	
}

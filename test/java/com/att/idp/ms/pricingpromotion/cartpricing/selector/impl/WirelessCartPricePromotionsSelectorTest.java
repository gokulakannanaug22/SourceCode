/**
 * 
 */
package com.att.idp.ms.pricingpromotion.cartpricing.selector.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.att.idp.ms.pricingpromotion.cartpricing.selector.CartPricePromotionsSelector;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.Promotion;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;

// TODO: Auto-generated Javadoc
/**
 * The Class WirelessCartPricePromotionsSelector.
 *
 * @author vp020k
 */
@RunWith(MockitoJUnitRunner.class)
public class WirelessCartPricePromotionsSelectorTest  {
	
	/**
	 * wirelessCartPricePromotionsSelector
	 */
	public WirelessCartPricePromotionsSelector wirelessCartPricePromotionsSelector;
	
	/**
	 * skuItems
	 */
	private List<PricingItem> pricingItems;
	
	/**
	 * requestContext
	 */
	private RequestContext requestContext;
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		wirelessCartPricePromotionsSelector = new WirelessCartPricePromotionsSelector();
		pricingItems = new ArrayList<PricingItem>();
		PricingItem itemDetailsFromRequest = new PricingItem();
		itemDetailsFromRequest.setSkuId("sku81003071");
		itemDetailsFromRequest.setPricingTier("NP");
		pricingItems.add(itemDetailsFromRequest);
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
	 * testretrieveItemPromotions
	 * @throws Exception
	 */
	@Test
	public void testretrieveItemPromotions() throws Exception{
		wirelessCartPricePromotionsSelector.retrieveItemPromotions(pricingItems, requestContext);
	}
	
	/**
	 * testretrieveItemPromotions
	 * @throws Exception
	 */
	@Test
	public void testretrieveItemPromotionspricingItemsNull() throws Exception{
		wirelessCartPricePromotionsSelector.retrieveItemPromotions(null, requestContext);
	}
	
	/**
	 * testretrieveItemPromotions
	 * @throws Exception
	 */
	@Test
	public void testretrieveItemPromotionsrequestContextNull() throws Exception{
		wirelessCartPricePromotionsSelector.retrieveItemPromotions(pricingItems, null);
	}
	
	/**
	 * testretrieveItemPromotions
	 * @throws Exception
	 */
	@Test
	public void testretrieveItemPromotionsBothNull() throws Exception{
		wirelessCartPricePromotionsSelector.retrieveItemPromotions(null, null);
	}
}

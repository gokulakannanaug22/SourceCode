package com.att.idp.ms.pricingpromotion.cartpricing.selector.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import com.att.idp.ms.pricingpromotion.common.PricingPromotionInputData;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.Promotion;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
/**
 * The Class WirelineCartPricePromotionsSelectorTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class WirelineCartPricePromotionsSelectorTest {
	
		/**
		 * mwirelinePriceSelector
		 */
		private WirelineCartPricePromotionsSelector mwirelineCartPricePromotionsSelector;
		
		/**
		 * DefaultCouchbaseEnvironment
		 */
		/*@Mock
		private DefaultCouchbaseEnvironment DefaultCouchbaseEnvironment;
		*/
		/**
		 * skuItems
		 */
		public List<PricingItem> pricingItems;
		
		/**
		 * requestContext
		 */
		private RequestContext requestContext;
			
		@Before
		public void setUp(){
			mwirelineCartPricePromotionsSelector = new WirelineCartPricePromotionsSelector();
			/*pricingItem = new ArrayList<PricingItem>();
			PricingItem itemDetailsFromRequest = new PricingItem();
			itemDetailsFromRequest.setSkuId("sku81003071");
			itemDetailsFromRequest.setPricingTier("NP");
			pricingItem.add(itemDetailsFromRequest);
			requestContext = new RequestContext();
			requestContext.getProfileContext().setCustomerType("residential");
			requestContext.setZip9("zip9");
			requestContext.setZip("zip");
			requestContext.setDma("dma");
			requestContext.setCity("city");
			requestContext.setState("state");
			requestContext.setNation("nation");*/
			pricingItems = PricingPromotionInputData.getCartRequestTestData().getPricingItems();
			requestContext = PricingPromotionInputData.getMockRequestContext();	
		}
		
		/**
		 * testretrieveItemsPrice
		 * @throws Exception
		 */
		@Test
		public void testretrieveItemPromotions() throws Exception{
			Map<String, List<Promotion>> resp = mwirelineCartPricePromotionsSelector.retrieveItemPromotions(pricingItems, requestContext);
			assertNotNull(resp);
			assertEquals(resp.get("sku81003071").get(0).getPromotionId(), 1000004);
			assertEquals(resp.get("sku81003071").get(0).getPercent(), 15);
			assertEquals(resp.get("sku81003071").get(0).getPromoType(), "percentoff");
			assertEquals(resp.get("sku81003071").get(0).getProductId(), "Prd45367");
		}
		
		/**
		 * testretrieveItemsPrice
		 * @throws Exception
		 */
		@Test
		public void testretrieveItemPromotionsMultiPromotion() throws Exception{
			pricingItems = PricingPromotionInputData.getCartRequestMultiTestData().getPricingItems();
			requestContext = PricingPromotionInputData.getMockRequestContext();	
			Map<String, List<Promotion>> resp = mwirelineCartPricePromotionsSelector.retrieveItemPromotions(pricingItems, requestContext);
			assertNotNull(resp);
			assertEquals(resp.get("sku81003071").get(0).getPromotionId(), 1000004);
			assertEquals(resp.get("sku81003071").get(0).getPercent(), 15);
			assertEquals(resp.get("sku81003071").get(0).getPromoType(), "percentoff");
			assertEquals(resp.get("sku81003071").get(0).getProductId(), "Prd45367");
			
			assertEquals(resp.get("sku81003072").get(0).getPromotionId(), 1001001);
			assertEquals(resp.get("sku81003072").get(0).getPercent(), 5);
			assertEquals(resp.get("sku81003072").get(0).getPromoType(), "percentoff");
			assertEquals(resp.get("sku81003072").get(0).getProductId(), "Prd45369");
			
		}
		
		
		/**
		 * testretrieveItemsInvalidInput
		 * @throws Exception
		 *//*
		@Test
		public void testretrieveItemPromotionsInvalidInput() throws Exception{
			//when(dbObj.getcouchDbConnection()) --> Void
			pricingItems = new ArrayList<>();
			Map<String, List<Promotion>> resp = mwirelineCartPricePromotionsSelector.retrieveItemPromotions(pricingItems, requestContext);
			assertNotNull(resp);
		}*/
		
		/**
		 * testretrieveItemsInvalidContext
		 * @throws Exception
		 *//*
		@Test
		public void testretrieveItemPromotionsInvalidContext() throws Exception{
			//when(dbObj.getcouchDbConnection()) --> Void
			requestContext = new RequestContext();
			Map<String, List<Promotion>> resp = mwirelineCartPricePromotionsSelector.retrieveItemPromotions(pricingItems, requestContext);
			assertNotNull(resp);
		}*/
	}


package com.att.idp.ms.pricingpromotion.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPrice;
import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPriceResponse;
import com.att.idp.ms.pricingpromotion.cartpricing.model.CartPricingRestRequest;
import com.att.idp.ms.pricingpromotion.common.bean.ItemPrice;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.ProfileContext;
import com.att.idp.ms.pricingpromotion.common.bean.Promotion;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
import com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.retrievecontext.ProfileRetrieveContextByUUIDRestClient;


public class PricingPromotionInputData {

	/**
	 * Mock cart request.
	 *
	 * @return the cart pricing rest request
	 */
	public static CartPricingRestRequest getCartRequestTestData()
	{
		CartPricingRestRequest cartPricingRestRequest=new CartPricingRestRequest();
		
		List<PricingItem> pricingItems = new ArrayList<PricingItem>();
		PricingItem pricingItem = new PricingItem();
		pricingItem.setPricingTier("NP");
		pricingItem.setProductId("Prd45367");
		pricingItem.setProductLine("wireline");
		pricingItem.setProductType("fixedwirelessinternet");
		pricingItem.setQuantity(1);
		pricingItem.setSkuId("sku81003071");
		pricingItem.setChargeType("mrc");
	//	pricingItem.setSkuId(null);
		pricingItems.add(pricingItem);	
		
		cartPricingRestRequest.setPricingItems(pricingItems);
		cartPricingRestRequest.setUuId("uuid12345");
//		cartPricingRestRequest.setUuId(null);
		
		return cartPricingRestRequest;
	}
	
	/**
	 * Mock cart request.
	 *
	 * @return the cart pricing rest request
	 */
	public static CartPricingRestRequest getCartRequestMultiTestData()
	{
		CartPricingRestRequest cartPricingRestRequest=new CartPricingRestRequest();
		
		List<PricingItem> pricingItems = new ArrayList<PricingItem>();
		PricingItem pricingItem = new PricingItem();
		pricingItem.setPricingTier("NP");
		pricingItem.setProductId("Prd45367");
		pricingItem.setProductLine("wireline");
		pricingItem.setProductType("fixedwirelessinternet");
		pricingItem.setQuantity(1);
		pricingItem.setChargeType("mrc");
		pricingItem.setSkuId("sku81003071");
		
		PricingItem multiPricingItem = new PricingItem();
		multiPricingItem.setPricingTier("NP");
		multiPricingItem.setProductId("Prd45369");
		multiPricingItem.setProductLine("wireline");
		multiPricingItem.setProductType("fixedwirelessinternet");
		multiPricingItem.setQuantity(2);
		multiPricingItem.setSkuId("sku81003072");
		multiPricingItem.setChargeType("mrc");
		pricingItems.add(pricingItem);
		pricingItems.add(multiPricingItem);

		cartPricingRestRequest.setPricingItems(pricingItems);
		cartPricingRestRequest.setUuId("uuid811130712345");

		return cartPricingRestRequest;
	}
	
	public static RequestContext getMockRequestContext() {
		RequestContext requestContext = new 	RequestContext();
		
		ProfileContext profileContext = new ProfileContext();
		requestContext.setProfileContext(profileContext);
		requestContext.getProfileContext().setCustomerType("SmallBusiness");
		requestContext.setZip9("980111234");
		requestContext.setZip("98011");
		requestContext.setDma("623");
		requestContext.setCity("Bothell");
		requestContext.setState("WA");
		requestContext.setNation("US");
		requestContext.getProfileContext().setFlowType("provide");
		return requestContext;
	}

	/**
	 * Mock cart price response.
	 *
	 * @return the cart price response
	 */
	public static CartPriceResponse getMockCartPriceResponse()
	{
		CartPriceResponse cartPriceResponse = new CartPriceResponse();
		CartPrice cartPrice = new CartPrice();
		cartPrice.setAmount(132.6);
		cartPrice.setDueFirstBill(0);
		cartPrice.setDueMonthly(132.6);
		cartPrice.setDueToday(0);
		List<String> promotionRefIDs = new ArrayList<String>();
		promotionRefIDs.add("DV1273");
		cartPrice.setPromotionRefIDs(promotionRefIDs);
		cartPriceResponse.setCartPrice(cartPrice);
		List<PricingItem> pricingItems = new ArrayList<PricingItem>();

		PricingItem pricingItem = new PricingItem();
		pricingItem.setPricingTier("NP");
		pricingItem.setProductId("Prd45367");
		pricingItem.setProductLine("wireline");
		pricingItem.setProductType("fixedwirelessinternet");
		pricingItem.setQuantity(1);
		pricingItem.setSkuId("sku81003071");
		pricingItems.add(pricingItem);

		List<Promotion> promotionItems = new ArrayList<Promotion>();
		Promotion promotion = new Promotion();
		promotion.setAmount(0);
		promotion.setFixedAmount(0);
		promotion.setPercent(15);
		promotion.setPromoType("percentoff");
		promotion.setPromotionName("Internet 15 percent off");
		promotion.setPromotionCode("DV1273");
		promotion.setPromotionId(1000004);
		promotionItems.add(promotion);

		List<ItemPrice> itemsPrice=new ArrayList<ItemPrice>();
		final List<String> promotionRefIds =new ArrayList<String>();
		promotionRefIds.add("DV1273");
		ItemPrice itemPrice=new ItemPrice();
		itemPrice.setFinalPrice(132.6);
		itemPrice.setProductId("Prd45367");
		itemPrice.setPromotionRefIds(promotionRefIds);
		itemPrice.setQuantity(1);
		itemPrice.setRackRate(156);
		itemPrice.setSkuId("sku81003071");
		itemPrice.setType("mrc");

		itemsPrice.add(itemPrice);
		cartPriceResponse.setItemsPrice(itemsPrice);
		cartPriceResponse.setPromotions(promotionItems);
		return cartPriceResponse;
	}
	
	
	/**
	 * @return List<Promotion>
	 */
	public static List<Promotion> getItemPromotionFlatAmountoffList() {

		List<Promotion> promotionList = new ArrayList<Promotion>();
		Promotion promotionItem1 = new Promotion();
		Promotion promotionItem2 = new Promotion();

		promotionItem1.setAmount(100);
		promotionItem1.setBaseOfferId("offerId");
		promotionItem1.setComplexDiscount(true);
		promotionItem1.setDescription("offer description");
		promotionItem1.setDuration("10");
		promotionItem1.setEffectiveDays(2);
		promotionItem1.setFixedAmount(0);
		promotionItem1.setIdentifier("identifier");
		promotionItem1.setOccuranceType("repeated");
		promotionItem1.setPercent(0);
		promotionItem1.setPromoType("flatamountoff");
		promotionItem1.setPromotionName("flatamountoff");

		promotionItem2.setAmount(100);
		promotionItem2.setBaseOfferId("offerId");
		promotionItem2.setComplexDiscount(true);
		promotionItem2.setDescription("offer description");
		promotionItem2.setDuration("10");
		promotionItem2.setEffectiveDays(2);
		promotionItem2.setFixedAmount(0);
		promotionItem2.setIdentifier("identifier");
		promotionItem2.setOccuranceType("repeated");
		promotionItem2.setPercent(0);
		promotionItem2.setPromoType("flatamountoff");
		promotionItem2.setPromotionName("flatamountoff");

		promotionList.add(promotionItem1);
		promotionList.add(promotionItem2);

		return promotionList;
	}

	/**
	 * @return List<Promotion>
	 */
	public static List<Promotion> getItemPromotionPercentOfffList() {

		List<Promotion> promotionList = new ArrayList<Promotion>();
		Promotion promotionItem1 = new Promotion();
		Promotion promotionItem2 = new Promotion();

		promotionItem1.setAmount(1000);
		promotionItem1.setBaseOfferId("offerId");
		promotionItem1.setComplexDiscount(true);
		promotionItem1.setDescription("offer description");
		promotionItem1.setDuration("10");
		promotionItem1.setEffectiveDays(2);
		promotionItem1.setFixedAmount(0);
		promotionItem1.setIdentifier("identifier");
		promotionItem1.setOccuranceType("repeated");
		promotionItem1.setPercent(10);
		promotionItem1.setPromoType("percentOfff");
		promotionItem1.setPromotionName("percentOfff");

		promotionItem2.setAmount(100);
		promotionItem2.setBaseOfferId("offerId");
		promotionItem2.setComplexDiscount(true);
		promotionItem2.setDescription("offer description");
		promotionItem2.setDuration("10");
		promotionItem2.setEffectiveDays(2);
		promotionItem2.setFixedAmount(0);
		promotionItem2.setIdentifier("identifier");
		promotionItem2.setOccuranceType("repeated");
		promotionItem2.setPercent(5);
		promotionItem2.setPromoType("percentOfff");
		promotionItem2.setPromotionName("percentOfff");

		promotionList.add(promotionItem1);
		promotionList.add(promotionItem2);

		return promotionList;
	}

	/**
	 * @return List<Promotion>
	 */
	public static List<Promotion> getItemPromotionFlatRateList() {

		List<Promotion> promotionList = new ArrayList<Promotion>();
		Promotion promotionItem1 = new Promotion();
		Promotion promotionItem2 = new Promotion();

		promotionItem1.setAmount(100);
		promotionItem1.setBaseOfferId("offerId");
		promotionItem1.setComplexDiscount(true);
		promotionItem1.setDescription("offer description");
		promotionItem1.setDuration("10");
		promotionItem1.setEffectiveDays(2);
		promotionItem1.setFixedAmount(5);
		promotionItem1.setIdentifier("identifier");
		promotionItem1.setOccuranceType("repeated");
		promotionItem1.setPercent(0);
		promotionItem1.setPromoType("flatRate");
		promotionItem1.setPromotionName("flatRate");

		promotionItem2.setAmount(100);
		promotionItem2.setBaseOfferId("offerId");
		promotionItem2.setComplexDiscount(true);
		promotionItem2.setDescription("offer description");
		promotionItem2.setDuration("10");
		promotionItem2.setEffectiveDays(2);
		promotionItem2.setFixedAmount(0);
		promotionItem2.setIdentifier("identifier");
		promotionItem2.setOccuranceType("repeated");
		promotionItem2.setPercent(5);
		promotionItem2.setPromoType("percentOfff");
		promotionItem2.setPromotionName("percentOfff");

		promotionList.add(promotionItem1);
		promotionList.add(promotionItem2);

		return promotionList;
	}
	
	/**
	 * @return Map<String, ItemPrice>
	 */
	public static Map<String, ItemPrice> getItemPriceMrcNrcMap() {

		Map<String, ItemPrice> itemPriceMap = new HashMap<>();
		@SuppressWarnings("CPD-START")
		ItemPrice itemPrice1 = new ItemPrice();
		ItemPrice itemPrice2 = new ItemPrice();
		ItemPrice itemPrice3 = new ItemPrice();
		ItemPrice itemPrice4 = new ItemPrice();

		itemPrice1.setSkuId("sku123");
		itemPrice1.setType("mrc");
		itemPrice1.setRackRate(100);
		itemPrice1.setQuantity(20);
		itemPrice1.setProductId("product001");
		itemPrice1.setFinalPrice(230);

		itemPrice2.setSkuId("sku1234");
		itemPrice2.setType("mrc");
		itemPrice2.setRackRate(100);
		itemPrice2.setQuantity(10);
		itemPrice2.setProductId("product002");
		itemPrice2.setFinalPrice(120);

		itemPrice3.setSkuId("sku12345");
		itemPrice3.setType("mrc");
		itemPrice3.setRackRate(100);
		itemPrice3.setQuantity(20);
		itemPrice3.setProductId("product003");
		itemPrice3.setFinalPrice(230);

		itemPrice4.setSkuId("sku123456");
		itemPrice4.setType("nrc");
		itemPrice4.setRackRate(100);
		itemPrice4.setQuantity(10);
		itemPrice4.setProductId("product004");
		itemPrice4.setFinalPrice(120);

		itemPriceMap.put(itemPrice1.getSkuId(), itemPrice1);
		itemPriceMap.put(itemPrice2.getSkuId(), itemPrice2);
		itemPriceMap.put(itemPrice1.getSkuId(), itemPrice3);
		itemPriceMap.put(itemPrice2.getSkuId(), itemPrice4);

		return itemPriceMap;
	}

	/**
	 * @return Map<String, ItemPrice>
	 */
	public static Map<String, ItemPrice> getItemPriceMrcMap() {

		Map<String, ItemPrice> itemPriceMap = new HashMap<>();

		ItemPrice itemPrice1 = new ItemPrice();
		ItemPrice itemPrice2 = new ItemPrice();
		ItemPrice itemPrice3 = new ItemPrice();
		
		itemPrice1.setSkuId("sku123");
		itemPrice1.setType("mrc");
		itemPrice1.setRackRate(100);
		itemPrice1.setQuantity(20);
		itemPrice1.setProductId("product001");
		itemPrice1.setFinalPrice(230);

		itemPrice2.setSkuId("sku1234");
		itemPrice2.setType("mrc");
		itemPrice2.setRackRate(100);
		itemPrice2.setQuantity(10);
		itemPrice2.setProductId("product002");
		itemPrice2.setFinalPrice(120);

		itemPrice3.setSkuId("sku12345");
		itemPrice3.setType("mrc");
		itemPrice3.setRackRate(100);
		itemPrice3.setQuantity(20);
		itemPrice3.setProductId("product003");
		itemPrice3.setFinalPrice(230);

		itemPriceMap.put(itemPrice1.getSkuId(), itemPrice1);
		itemPriceMap.put(itemPrice2.getSkuId(), itemPrice2);
		itemPriceMap.put(itemPrice3.getSkuId(), itemPrice3);

		return itemPriceMap;
	} @SuppressWarnings("CPD-END")

	/**
	 * @return Map<String, ItemPrice>
	 */
	public static Map<String, ItemPrice> getItemPriceNRCMap() {

		Map<String, ItemPrice> itemPriceMap = new HashMap<>();

		ItemPrice itemPrice1 = new ItemPrice();
		ItemPrice itemPrice2 = new ItemPrice();
		ItemPrice itemPrice3 = new ItemPrice();

		itemPrice1.setSkuId("sku123");
		itemPrice1.setType("nrc");
		itemPrice1.setRackRate(100);
		itemPrice1.setQuantity(20);
		itemPrice1.setProductId("product001");
		itemPrice1.setFinalPrice(230);

		itemPrice2.setSkuId("sku1234");
		itemPrice2.setType("nrc");
		itemPrice2.setRackRate(100);
		itemPrice2.setQuantity(10);
		itemPrice2.setProductId("product002");
		itemPrice2.setFinalPrice(120);

		itemPrice3.setSkuId("sku12345");
		itemPrice3.setType("nrc");
		itemPrice3.setRackRate(100);
		itemPrice3.setQuantity(20);
		itemPrice3.setProductId("product003");
		itemPrice3.setFinalPrice(230);

		itemPriceMap.put(itemPrice1.getSkuId(), itemPrice1);
		itemPriceMap.put(itemPrice2.getSkuId(), itemPrice2);
		itemPriceMap.put(itemPrice3.getSkuId(), itemPrice3);

		return itemPriceMap;
	}
	
	/**
	 * @return Map<String, ItemPrice>
	 */
	public static Map<String, ItemPrice> getItemMapPriceNRC_DueToday() {

		Map<String, ItemPrice> itemPriceMap = new HashMap<>();

		ItemPrice itemPrice1 = new ItemPrice();
		ItemPrice itemPrice2 = new ItemPrice();
		ItemPrice itemPrice3 = new ItemPrice();

		itemPrice1.setSkuId("sku123");
		itemPrice1.setType("nrcduetoday");
		itemPrice1.setRackRate(100);
		itemPrice1.setQuantity(20);
		itemPrice1.setProductId("product001");
		itemPrice1.setFinalPrice(230);

		itemPrice2.setSkuId("sku1234");
		itemPrice2.setType("nrcduetoday");
		itemPrice2.setRackRate(100);
		itemPrice2.setQuantity(10);
		itemPrice2.setProductId("product002");
		itemPrice2.setFinalPrice(120);

		itemPrice3.setSkuId("sku12345");
		itemPrice3.setType("nrcduetoday");
		itemPrice3.setRackRate(100);
		itemPrice3.setQuantity(20);
		itemPrice3.setProductId("product003");
		itemPrice3.setFinalPrice(230);

		itemPriceMap.put(itemPrice1.getSkuId(), itemPrice1);
		itemPriceMap.put(itemPrice2.getSkuId(), itemPrice2);
		itemPriceMap.put(itemPrice3.getSkuId(), itemPrice3);

		return itemPriceMap;
	}
	
	/**
	 * @return Map<String, List<Promotion>>
	 */
	public static Map<String, List<Promotion>> getPromotionMap(){
		
		Map<String, List<Promotion>> promotionMap = new HashMap<>();
		
		promotionMap.put("sku123", getItemPromotionFlatAmountoffList());
		promotionMap.put("sku1234", getItemPromotionFlatRateList());
		promotionMap.put("sku12345", getItemPromotionPercentOfffList());
		
		return promotionMap;
	}
	
}

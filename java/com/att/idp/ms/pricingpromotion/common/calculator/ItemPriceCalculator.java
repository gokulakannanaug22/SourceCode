package com.att.idp.ms.pricingpromotion.common.calculator;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.att.idp.ms.pricingpromotion.common.bean.ItemPrice;
import com.att.idp.ms.pricingpromotion.common.bean.Promotion;

/**
 * The Class ItemPriceCalculator to calculate total amount for Cart Price and Item Price.
 */
@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
@Component
public class ItemPriceCalculator implements ItemPricingCalculator {

	/**
	 * pirceItems
	 * @param skuPromotionsMap the sku promotions map
	 * @param itemPriceMap the item price map
	 * @return the double
	 * @see com.att.idp.ms.pricingpromotion.common.calculator.ItemPricingCalculator#pirceItems(java.util.Map, java.util.Map)
	 */
	@Override
	public double pirceItems(final Map<String, List<Promotion>> skuPromotionsMap, final Map<String, ItemPrice> itemPriceMap) {
		
		String skuId = null;
		double totalPrice = 0d;
		for(final Map.Entry<String, ItemPrice> entry: itemPriceMap.entrySet()) {
			skuId = entry.getKey();
			totalPrice = priceItem(skuPromotionsMap.get(skuId), entry.getValue(), entry.getKey());			
		}
		return totalPrice;
	}

	

	/**
	 * priceItem
	 * @param skuPromotions the sku promotions
	 * @param itemPrice the item price
	 * @param skuId the sku id
	 * @return the double
	 * @see com.att.idp.ms.pricingpromotion.common.calculator.ItemPricingCalculator#priceItem(java.util.List, com.att.idp.ms.pricingpromotion.common.bean.ItemPrice, java.lang.String)
	 */
	@Override
	public double priceItem(final List<Promotion> skuPromotions, final ItemPrice itemPrice, final String skuId) {
		
		final UnitPriceCalculator unitPriceCalculator = new UnitPriceCalculator();
		final ItemDiscountCalculator itemDiscountCalculator = new ItemDiscountCalculator();
		final double selectedQtyPrice = unitPriceCalculator.calculateUnitPrice(itemPrice.getRackRate(), itemPrice.getQuantity());
//		final double discountAmount =itemDiscountCalculator.calculateDiscountAmount(skuPromotions);
		final double finalPrice =itemDiscountCalculator.calculateFinalPrice(skuPromotions, selectedQtyPrice);
		itemPrice.setFinalPrice(finalPrice);
		return finalPrice;
	}

}

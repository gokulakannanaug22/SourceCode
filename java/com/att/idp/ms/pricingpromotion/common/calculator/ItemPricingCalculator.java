package com.att.idp.ms.pricingpromotion.common.calculator;

import java.util.List;
import java.util.Map;

import com.att.idp.ms.pricingpromotion.common.bean.ItemPrice;
import com.att.idp.ms.pricingpromotion.common.bean.Promotion;

/**
 * The Interface ItemPricingCalculator.
 */
public interface ItemPricingCalculator {

	/**
	 * Pirce each item.
	 *
	 * @param skuPromotionsMap the sku promotions map
	 * @param itemPriceMap the item price map
	 * @return double
	 */
	double pirceItems(final Map<String, List<Promotion>> skuPromotionsMap, final Map<String, ItemPrice> itemPriceMap);
	
	/**
	 * Pirce item.
	 *
	 * @param skuPromotions the sku promotions
	 * @param itemPrice the item price
	 * @param requestContext the request context
	 * @return double
	 */
	double priceItem(final List<Promotion> skuPromotions, final ItemPrice itemPrice, String skuId);
}

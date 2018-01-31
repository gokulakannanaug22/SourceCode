/**
 * 
 */
package com.att.idp.ms.pricingpromotion.itempricing.selector.impl;

import java.util.List;
import java.util.Map;

import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.Promotion;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
import com.att.idp.ms.pricingpromotion.itempricing.bean.CartItem;
import com.att.idp.ms.pricingpromotion.itempricing.selector.ItemPricePromotionsSelector;

// TODO: Auto-generated Javadoc
/**
 * The Class WirelineItemPricePromotionsSelector.
 *
 * @author vp020k
 */
public class WirelineItemPricePromotionsSelector implements ItemPricePromotionsSelector {

	/**
	 *  (non-Javadoc).
	 *
	 * @param pricingItems the Pricing items
	 * @param cartItems the existing cart items
	 * @param requestContext the request context
	 * @return the map
	 * @see com.att.idp.ms.pricingpromotion.itempricing.selector.ItemPricePromotionsSelector#retrieveItemPromotions(java.util.List, List, com.att.idp.ms.pricingpromotion.common.bean.RequestContext)
	 */
	@Override
	public Map<String, List<Promotion>> retrieveItemPromotions(final List<PricingItem> pricingItems, final List<CartItem> cartItems,
			final RequestContext requestContext) {

		// Get the items Promotions from DB and apply the rules to filter the promotions and set in skuPromotionsMap.
		// Construct a Map with skuid/productId, List of Promotion from DB. iterate each sku with their promotions and call
		// new PromotionFilter().filterPromotions(promotionsFromDB, requestedItem, requestContext);
		
		return null;
	}

}

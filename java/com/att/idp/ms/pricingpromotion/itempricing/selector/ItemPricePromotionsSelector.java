package com.att.idp.ms.pricingpromotion.itempricing.selector;

import java.util.List;
import java.util.Map;

import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.Promotion;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
import com.att.idp.ms.pricingpromotion.itempricing.bean.CartItem;

// TODO: Auto-generated Javadoc
/**
 * The Interface ItemPricePromotionsSelector.
 */
public interface ItemPricePromotionsSelector {
	
	/**
	 * Retrieve item promotions.
	 *
	 * @param pricingItems the Pricing items
	 * @param cartItems the existing cart items
	 * @param requestContext the request context
	 * @return the map
	 */
	Map<String, List<Promotion>> retrieveItemPromotions(List<PricingItem> pricingItems, List<CartItem> cartItems,
			RequestContext requestContext);

}

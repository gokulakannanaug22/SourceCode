package com.att.idp.ms.pricingpromotion.itempricing.selector.impl;

import java.util.List;
import java.util.Map;

import com.att.idp.ms.pricingpromotion.common.bean.CashBack;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
import com.att.idp.ms.pricingpromotion.itempricing.bean.CartItem;
import com.att.idp.ms.pricingpromotion.itempricing.selector.ItemPriceCashBackSelector;

// TODO: Auto-generated Javadoc
/**
 * The Class WirelessItemPriceCashBackSelector.
 */
public class WirelessItemPriceCashBackSelector implements ItemPriceCashBackSelector{

	/**
	 *  (non-Javadoc).
	 *
	 * @param pricingItems the Pricing items
	 * @param cartItems the existing cart
	 * @param requestContext the request context
	 * @return the map
	 * @see com.att.idp.ms.pricingpromotion.itempricing.selector.ItemPriceCashBackSelector#retrieveCashBackOffers(java.util.List, List, com.att.idp.ms.pricingpromotion.common.bean.RequestContext)
	 */
	@Override
	public Map<String, List<CashBack>> retrieveCashBackOffers(final List<PricingItem> pricingItems,
			final List<CartItem> cartItems, final RequestContext requestContext) {

		
		return null;
	}

}

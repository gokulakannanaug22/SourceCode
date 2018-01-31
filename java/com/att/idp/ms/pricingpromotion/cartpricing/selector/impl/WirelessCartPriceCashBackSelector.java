package com.att.idp.ms.pricingpromotion.cartpricing.selector.impl;

import java.util.List;
import java.util.Map;

import com.att.idp.ms.pricingpromotion.cartpricing.selector.CartPriceCashBackSelector;
import com.att.idp.ms.pricingpromotion.common.bean.CashBack;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;

// TODO: Auto-generated Javadoc
/**
 * The Class WirelessCartPriceCashBackSelector.
 */

public class WirelessCartPriceCashBackSelector implements CartPriceCashBackSelector{

	/**
	 *  (non-Javadoc).
	 *
	 * @param pricingItems the sku items
	 * @param requestContext the request context
	 * @return the map
	 * @see com.att.idp.ms.pricingpromotion.cartpricing.selector.CartPriceCashBackSelector#retrieveCashBackOffers(java.util.List, com.att.idp.ms.pricingpromotion.common.bean.RequestContext)
	 */
	@Override
	public Map<String, List<CashBack>> retrieveCashBackOffers(final List<PricingItem> pricingItems,
			final RequestContext requestContext) {


		return null;

	}

}

package com.att.idp.ms.pricingpromotion.cartpricing.selector.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.att.idp.ms.pricingpromotion.cartpricing.selector.CartPriceCashBackSelector;
import com.att.idp.ms.pricingpromotion.common.bean.CashBack;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;

/**
 * The Class WirelineCartPriceCashBackSelector.
 */

@Component
public class WirelineCartPriceCashBackSelector implements CartPriceCashBackSelector{

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

//		final Map<String, List<CashBack>> cashBackOffersMap = null;

		// Get the cash back offers from DB and apply the rules to filter and set in cashBackOffersMap.
		// Construct a Map with skuid/productId, List of CashBack offers from DB. iterate each sku with their cashBack offers and filter it if required.

		return null;

	}

}

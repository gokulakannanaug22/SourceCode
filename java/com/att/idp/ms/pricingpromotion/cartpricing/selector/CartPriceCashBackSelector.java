package com.att.idp.ms.pricingpromotion.cartpricing.selector;

import java.util.List;
import java.util.Map;

import com.att.idp.ms.pricingpromotion.common.bean.CashBack;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;

// TODO: Auto-generated Javadoc
/**
 * The Interface CartPriceCashBackSelector.
 */
public interface CartPriceCashBackSelector {
	
	
	/**
	 * Retrieve item promotions.
	 *
	 * @param pricingItems the Pricing items
	 * @param requestContext the request context
	 * @return the map
	 */
	Map<String, List<CashBack>> retrieveCashBackOffers(List<PricingItem> pricingItems, RequestContext requestContext);


}

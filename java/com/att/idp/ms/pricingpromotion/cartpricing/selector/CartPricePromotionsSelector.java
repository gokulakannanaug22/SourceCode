package com.att.idp.ms.pricingpromotion.cartpricing.selector;

import java.util.List;
import java.util.Map;

import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.Promotion;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;

// TODO: Auto-generated Javadoc
/**
 * The Interface CartPricePromotionsSelector.
 */
public interface CartPricePromotionsSelector {
	
	/**
	 * Retrieve item promotions.
	 *
	 * @param pricingItems the Pricing items
	 * @param requestContext the request context
	 * @return the map
	 */
	Map<String, List<Promotion>> retrieveItemPromotions(List<PricingItem> pricingItems, RequestContext requestContext);

}

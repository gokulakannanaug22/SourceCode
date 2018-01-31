package com.att.idp.ms.pricingpromotion.common.selector;

import java.util.List;
import java.util.Map;

import com.att.idp.ms.pricingpromotion.common.bean.ItemPrice;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;

// TODO: Auto-generated Javadoc
/**
 * The Interface PriceSelector.
 */
public interface PriceSelector {
	
	/**
	 * Retrieve items price.
	 *
	 * @param pricingItems the Pricing items
	 * @param requestContext the request context
	 * @return the map
	 */
	Map<String, ItemPrice> retrieveItemsPrice(List<PricingItem> pricingItems, RequestContext requestContext);

}

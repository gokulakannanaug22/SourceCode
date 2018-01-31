package com.att.idp.ms.pricingpromotion.itempricing.processor;

import java.util.List;

import com.att.idp.foundation.error.ApplicationError;
import com.att.idp.foundation.error.ExceptionErrorMessage;
import com.att.idp.foundation.pipeline.Processor;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
import com.att.idp.ms.pricingpromotion.itempricing.selector.ItemPriceCashBackSelector;
import com.att.idp.ms.pricingpromotion.itempricing.selector.impl.WirelineItemPriceCashBackSelector;

/**
 * The Class ItemPriceCashBackSelectorProcessor.
 */
@SuppressWarnings("PMD")
//@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
public class ItemPriceCashBackSelectorProcessor implements Processor<PricingContext> {

	/**
	 * (non-Javadoc).
	 *
	 * @param pricingContext
	 *            the pricing context
	 * @see com.att.idp.foundation.pipeline.Processor#execute(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("PMD.AvoidCatchingGenericException")
	public void execute(final PricingContext pricingContext) {

		try {
			final List<PricingItem> pricingItems = pricingContext.getPricingRequest().getPricingItems();
			final RequestContext requestContext = pricingContext.getRequestContext();

//			List<CartItem> cartItems = null;
			/**
			 * Separate the skus based on line of business (lob) and call the
			 * corresponding CashBackSelector, if it has to be handled
			 * differently for wireline / wireless products.
			 *   final List<CartItem> cartItems = ((ItemPricingRestRequest) pricingContext.getPricingRequest()).getCartItems();
			 */
			final ItemPriceCashBackSelector cashBackSelector = new WirelineItemPriceCashBackSelector();
			/*pricingContext.setSkuCashBackMap(cashBackSelector.retrieveCashBackOffers(pricingItems, cartItems, requestContext));*/

		} catch (Exception e) {
			throw new ApplicationError(ExceptionErrorMessage.newObject()
					.developerMessage("Exception occurred when retrieving Promotions").cause(e));
		}

	}

}

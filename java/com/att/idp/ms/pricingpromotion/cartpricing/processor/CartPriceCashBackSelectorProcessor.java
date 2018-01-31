package com.att.idp.ms.pricingpromotion.cartpricing.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.att.idp.foundation.error.ApplicationError;
import com.att.idp.foundation.error.ExceptionErrorMessage;
import com.att.idp.foundation.pipeline.Processor;
import com.att.idp.ms.pricingpromotion.cartpricing.selector.CartPriceCashBackSelector;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;

/**
 * The Class CashBackSelectorProcessor.
 */
@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
public class CartPriceCashBackSelectorProcessor implements Processor<PricingContext> {
	
	/** The cart price cash back selector. */
	@Autowired
	private CartPriceCashBackSelector cartPriceCashBackSelector;

	/**
	 * Execute.
	 * @param pricingContext            the pricing context
	 * @see com.att.idp.foundation.pipeline.Processor#execute(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("PMD.AvoidCatchingGenericException")
	public void execute(final PricingContext pricingContext) {

		final List<PricingItem> pricingItems = new ArrayList<PricingItem>();
		RequestContext requestContext = null;
		try {
			pricingItems.addAll(pricingContext.getPricingRequest().getPricingItems());
			requestContext = pricingContext.getRequestContext();
			/**
			 * Separate the skus based on line of business (lob) and call the
			 * corresponding CashBackSelector, if it has to be handled
			 * differently for wireline / wireless products.
			 *
			 */
			 //final CartPriceCashBackSelector cashBackSelector = new WirelineCartPriceCashBackSelector();
			pricingContext.setSkuCashBackMap(cartPriceCashBackSelector.retrieveCashBackOffers(pricingItems, requestContext));

		} catch (Exception e) {
			throw new ApplicationError(ExceptionErrorMessage.newObject()
					.developerMessage("Exception occurred when retrieving Promotions").cause(e));
		}

	}

}

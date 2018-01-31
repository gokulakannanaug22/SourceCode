package com.att.idp.ms.pricingpromotion.cartpricing.processor;

import java.util.ArrayList;
import java.util.List;

import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.foundation.pipeline.Processor;
import com.att.idp.ms.pricingpromotion.cartpricing.selector.CartPricePromotionsSelector;
import com.att.idp.ms.pricingpromotion.cartpricing.selector.impl.WirelineCartPricePromotionsSelector;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;

/**
 * The Class CartPricePromotionSelectorProcessor.
 */
@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
public class CartPricePromotionSelectorProcessor implements Processor<PricingContext> {
	/** The log. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(CartPricePromotionSelectorProcessor.class);
	/**
	 *
	 * @param pricingContext
	 *            the pricing context
	 * @see com.att.idp.foundation.pipeline.Processor#execute(java.lang.Object)
	 * * Separate the skus based on line of business (lob) and call the
	 * corresponding PromotionSelector, if it has to be handled
	 * differently for wireline / wireless products.
	 */
	@Override
	@SuppressWarnings("PMD.AvoidCatchingGenericException")
	public void execute(final PricingContext pricingContext) {
		log.debug("[Executing CartPricePromotionSelectorProcessor:: Invoking Execute method]");
		final List<PricingItem> pricingItems = new ArrayList<PricingItem>();
		RequestContext requestContext = null;
			/*
			 * Separate the skus based on line of business (lob) and call the
			 * corresponding PromotionSelector, if it has to be handled
			 * differently for wireline / wireless products.
			 */
			pricingItems.addAll(pricingContext.getPricingRequest().getPricingItems());
			requestContext = pricingContext.getRequestContext();
			
			final CartPricePromotionsSelector promotionSelector = new WirelineCartPricePromotionsSelector();
			pricingContext.setSkuPromotionsMap(promotionSelector.retrieveItemPromotions(pricingItems, requestContext));

		} 
}

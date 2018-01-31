package com.att.idp.ms.pricingpromotion.itempricing.processor;

import com.att.idp.foundation.error.ApplicationError;
import com.att.idp.foundation.error.ExceptionErrorMessage;
import com.att.idp.foundation.pipeline.Processor;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.common.calculator.ItemPriceCalculator;
import com.att.idp.ms.pricingpromotion.itempricing.bean.ItemPricingContext;


// TODO: Auto-generated Javadoc
/**
 * The Class ItemPriceCalculatorSelectorProcessor.
 *
 * @author vp020k
 */
public class ItemPriceCalculatorProcessor implements Processor<PricingContext> {

	/**
	 *  (non-Javadoc).
	 *
	 * @param pricingContext the pricing context
	 * @see com.att.idp.foundation.pipeline.Processor#execute(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("PMD.AvoidCatchingGenericException")
	public void execute(final PricingContext pricingContext) {
		
		try {

			final double totalPrice = new ItemPriceCalculator().pirceItems(pricingContext.getSkuPromotionsMap(),
					pricingContext.getItemPriceMap());
			((ItemPricingContext)pricingContext).getItemPriceResponse().setTotalPrice(totalPrice);
			
		} catch (Exception e) {
			throw new ApplicationError(
					ExceptionErrorMessage.newObject().developerMessage("Exception occurred when calculating the price").cause(e));
		}
		
	}

}

/**
 * 
 */
package com.att.idp.ms.pricingpromotion.cartpricing.processor;

import org.springframework.stereotype.Component;

import com.att.idp.foundation.pipeline.Processor;
import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPrice;
import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPriceResponse;
import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPricingContext;
import com.att.idp.ms.pricingpromotion.cartpricing.calculator.CartPriceCalculator;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.common.calculator.ItemPriceCalculator;

// TODO: Auto-generated Javadoc
/**
 * The Class CartPriceCalculatorSelectorProcessor.
 *
 * @author vp020k
 */
@Component
public class CartPriceCalculatorProcessor implements Processor<PricingContext> {

	/** The item price calculator. */
//	@Autowired
//	private ItemPriceCalculator itemPriceCalculator;

	/** The cart price calculator. */
//	@Autowired
//	private CartPriceCalculator cartPriceCalculator;

	/**
	 * Execute.
	 *
	 * @param pricingContext
	 *            the pricing context
	 * @see com.att.idp.foundation.pipeline.Processor#execute(java.lang.Object)
	 */

	@Override
	@SuppressWarnings("PMD.AvoidCatchingGenericException")
	public void execute(final PricingContext pricingContext) {
		
		ItemPriceCalculator itemPriceCalculator = new ItemPriceCalculator();

		itemPriceCalculator.pirceItems(pricingContext.getSkuPromotionsMap(), pricingContext.getItemPriceMap());
		
		CartPriceCalculator cartPriceCalculator = new CartPriceCalculator();

		CartPrice cartPrice = cartPriceCalculator.calculateCartPrice(pricingContext.getItemPriceMap());
		CartPriceResponse cartPriceResponse = ((CartPricingContext) pricingContext).getCartPriceResponse();
		cartPriceResponse.setCartPrice(cartPrice);
		((CartPricingContext) pricingContext).setCartPriceResponse(cartPriceResponse);
		

	}

}

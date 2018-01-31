package com.att.idp.ms.pricingpromotion.cartpricing.response.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.foundation.error.ApplicationError;
import com.att.idp.foundation.error.ExceptionErrorMessage;
import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPriceResponse;
import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPricingContext;
import com.att.idp.ms.pricingpromotion.common.bean.ItemPrice;
import com.att.idp.ms.pricingpromotion.common.bean.Promotion;
import com.att.idp.ms.pricingpromotion.common.response.builder.ResponseBuilder;

/**
 * The Class CartPriceResponseBuilder used to set the values for itemsprice, promotion, cashback from CartPricingContext.
 */
@SuppressWarnings("PMD")
//@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
@Component
public class CartPriceResponseBuilder extends ResponseBuilder {

	/** The log. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(CartPriceResponseBuilder.class);

	/**
	 * retrieveCartPriceRespone to set the values for itemsprice, promotion, cashback from CartPricingContext
	 *
	 * @param cartPricingContext the cart pricing context
	 * @return the cart price response
	 */
	public CartPriceResponse retrieveCartPriceRespone(final CartPricingContext cartPricingContext) {

		/* CartContextData to be set 
		 * cartPriceResponse.setCartContextData(cartPricingContext.getCartPriceResponse().getCartContextData());*/
		CartPriceResponse cartPriceResponse = cartPricingContext.getCartPriceResponse();
		
		List<ItemPrice> itemsPrice = new ArrayList<ItemPrice>();
		List<Promotion> itemspromotion = new ArrayList<Promotion>();
		if(!Optional.ofNullable(cartPricingContext.getItemPriceMap()).isPresent()
				&& !Optional.ofNullable(cartPricingContext.getSkuPromotionsMap()).isPresent()){
			log.error("Exception occurred when retrieving Cart Price Response");
			throw new ApplicationError(ExceptionErrorMessage.newObject()
					.developerMessage("Exception occurred when retrieving Cart Price Response."));

		}
		itemsPrice = populateItemPrice(cartPricingContext);
		itemspromotion = populatePromotionsMap(cartPricingContext);

		cartPriceResponse.setItemsPrice(itemsPrice);
		cartPriceResponse.setPromotions(itemspromotion);
//		cartPricingContext.setCartPriceResponse(cartPriceResponse);
		return cartPriceResponse;//cartPricingContext.getCartPriceResponse();
	}

	/**
	 * populatePromotionsMap
	 * @param cartPricingContext
	 * @return
	 */
	@SuppressWarnings("PMD:LocalVariableCouldBeFinal")//itemspromotion cant be declared as final.
	private List<Promotion> populatePromotionsMap(final CartPricingContext cartPricingContext) {
		List<Promotion> itemspromotion = new ArrayList<Promotion>();
		if(Optional.ofNullable(cartPricingContext.getSkuPromotionsMap()).isPresent()){
			final Iterator<Entry<String, List<Promotion>>> iteratorPromotion = cartPricingContext.getSkuPromotionsMap().entrySet().iterator();

			while (iteratorPromotion.hasNext()) 
			{
				final Map.Entry<String, List<Promotion>> promoMapEntry = (Map.Entry<String, List<Promotion>>) iteratorPromotion.next();
				if(promoMapEntry.getValue()!=null){
					final List<Promotion> newPromo = (List<Promotion>) promoMapEntry.getValue();
					for(final Promotion promo: newPromo)
					{
						itemspromotion.add((Promotion)  promo);
					}
				}
			}
		}
		return itemspromotion;
	}


	/**
	 * populateItemPrice
	 * @param cartPricingContext
	 * @return
	 */
	private List<ItemPrice> populateItemPrice(CartPricingContext cartPricingContext) {
		List<ItemPrice> itemsPrice = new ArrayList<ItemPrice>();
		if(Optional.ofNullable(cartPricingContext.getItemPriceMap()).isPresent()){
			final Iterator<Entry<String, ItemPrice>> iteratorPrice = cartPricingContext.getItemPriceMap().entrySet().iterator();
			while (iteratorPrice.hasNext()) 
			{
				final Map.Entry<String, ItemPrice> priceMapEntry = iteratorPrice.next();
				if(priceMapEntry.getValue()!=null){
					itemsPrice.add((ItemPrice) priceMapEntry.getValue());
				}
			}
		}
		return itemsPrice;
	}

}

package com.att.idp.ms.pricingpromotion.cartpricing.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPrice;
import com.att.idp.ms.pricingpromotion.common.bean.ItemPrice;
import com.att.idp.ms.pricingpromotion.common.constants.PricingConstants;

/**
 * The Class CartPriceCalculator used to calculate the total amount with
 * differences in discount.
 */
@SuppressWarnings("PMD")
//@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
@Component
public class CartPriceCalculator {

	/** The log. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(CartPriceCalculator.class);

	/**
	 * Calculate cart context price.
	 * Get each ItemPrice, look for type(due_monthly, due_today, due_firstbill) and set the cart price
	 *
	 * @param itemPriceMap the item price map
	 * @param cartPrice the cart price
	 * @return the double
	 */
	@SuppressWarnings("PMD.MissingBreakInSwitch")
	public CartPrice calculateCartPrice (final Map<String, ItemPrice> itemPriceMap) {

		String skuId = null;
		String itemChargeType = "";
		double amount = 0d;
		ItemPrice itemPrice = new ItemPrice();
		final List<String> promotionRefIDs = new ArrayList<String>();
		CartPrice cartPrice = new CartPrice();
		if (itemPriceMap != null) {
			for (final Map.Entry<String, ItemPrice> entry : itemPriceMap.entrySet()) {

				skuId = entry.getKey();
				itemPrice = itemPriceMap.get(skuId);
				itemChargeType = itemPrice.getType();
//				promotionRefIDs.addAll(itemPrice.getPromotionRefIds());
				cartPrice.setPromotionRefIDs(promotionRefIDs);
				switch (itemChargeType) {
				case PricingConstants.PRODUCT_TYPE_MRC:
					cartPrice.setDueMonthly(cartPrice.getDueMonthly() + itemPrice.getFinalPrice());
					amount += cartPrice.getDueMonthly();
					break;
				case PricingConstants.PRODUCT_TYPE_NRC:
					cartPrice.setDueFirstBill(cartPrice.getDueFirstBill() + itemPrice.getFinalPrice());
					amount += cartPrice.getDueFirstBill();
					break;
				case PricingConstants.PRODUCT_TYPE_NRC_DUETODAY:
					cartPrice.setDueToday(cartPrice.getDueToday() + itemPrice.getFinalPrice());
					amount += cartPrice.getDueToday();
					break;
				default:
					log.error("Invalid Item Charge type: " + itemChargeType);
				}

				promotionRefIDs.clear();
			}
			cartPrice.setAmount(amount);
		}

		return cartPrice;
	}

}

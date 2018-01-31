package com.att.idp.ms.pricingpromotion.common.bean;

import java.util.List;
import java.util.Map;

import com.att.idp.foundation.error.ExceptionErrorMessage;
import com.att.idp.ms.pricingpromotion.common.model.PricingRestRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PricingContext.
 */
public class PricingContext {

	/** The pricingRequest . */
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty("pricingRequest")
	private PricingRestRequest pricingRequest;
	
	/** The sku promotions map. */
	private Map<String, List<Promotion>> skuPromotionsMap;
	
	/** The sku cash back map. */
	private Map<String, List<CashBack>> skuCashBackMap;
	
	/** The item price map. */
	private Map<String, ItemPrice> itemPriceMap;
	
	/** The errors. */
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty("errors")
	private List<ExceptionErrorMessage> errors;

	/** The context. */
	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty("context")
	private RequestContext requestContext;
	/**
	 * Gets the pricing request.
	 *
	 * @return the pricing request
	 */
	public PricingRestRequest getPricingRequest() {
		return pricingRequest;
	}

	/**
	 * Sets the pricing request.
	 *
	 * @param pricingRequest the new pricing request
	 */
	public void setPricingRequest(final PricingRestRequest pricingRequest) {
		this.pricingRequest = pricingRequest;
	}
	
	/**
	 * Gets the sku promotions map.
	 *
	 * @return the sku promotions map
	 */
	public Map<String, List<Promotion>> getSkuPromotionsMap() {
		return skuPromotionsMap;
	}	

	/**
	 * Sets the sku promotions map.
	 *
	 * @param skuPromotionsMap the sku promotions map
	 */
	public void setSkuPromotionsMap(final Map<String, List<Promotion>> skuPromotionsMap) {
		this.skuPromotionsMap = skuPromotionsMap;
	}
	
	
	/**
	 * Gets the sku cash back map.
	 *
	 * @return the sku cash back map
	 */
	public Map<String, List<CashBack>> getSkuCashBackMap() {
		return skuCashBackMap;
	}

	/**
	 * Sets the sku cash back map.
	 *
	 * @param skuCashBackMap the sku cash back map
	 */
	public void setSkuCashBackMap(final Map<String, List<CashBack>> skuCashBackMap) {
		this.skuCashBackMap = skuCashBackMap;
	}

	/**
	 * Gets the item price map.
	 *
	 * @return the item price map
	 */
	public Map<String, ItemPrice> getItemPriceMap() {
		return itemPriceMap;
	}

	/**
	 * Sets the item price map.
	 *
	 * @param itemPriceMap the item price map
	 */
	public void setItemPriceMap(final Map<String, ItemPrice> itemPriceMap) {
		this.itemPriceMap = itemPriceMap;
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public List<ExceptionErrorMessage> getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param errors the new errors
	 */
	public void setErrors(final List<ExceptionErrorMessage> errors) {
		this.errors = errors;
	}
	
	/**
	 * Gets the request context.
	 *
	 * @return the request context
	 */
	public RequestContext getRequestContext() {
		return requestContext;
	}

	/**
	 * Sets the request context.
	 *
	 * @param requestContext the new request context
	 */
	public void setRequestContext(final RequestContext requestContext) {
		this.requestContext = requestContext;
	}

	/**
	 * converts String
	 *
	 */
	@Override
	public String toString() {
		return "PricingContext [ PricingRequest=" + getPricingRequest() + ", "
				+ ", getRequestContext()=" + getRequestContext()  + ", "
				+ "getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}

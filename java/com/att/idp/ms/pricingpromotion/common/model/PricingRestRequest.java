package com.att.idp.ms.pricingpromotion.common.model;

import java.util.List;

import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonInclude;
import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The Class PricingServiceRequest.
 */
public class PricingRestRequest {

	/** The items. */
	@JsonProperty("items")
	private List<PricingItem> pricingItems;	
	
	/** The request context. */
//	@JsonProperty("context")
//	private RequestContext requestContext;
	
	/** The uu id. */
	@JsonProperty("uuId")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String uuId;	

	
	/**
	 * Gets the pricing items.
	 *
	 * @return the pricing items
	 */
	public List<PricingItem> getPricingItems() {
		return pricingItems;
	}

	/**
	 * Sets the pricing items.
	 *
	 * @param pricingItems the new pricing items
	 */
	public void setPricingItems(final List<PricingItem> pricingItems) {
		this.pricingItems = pricingItems;
	}
		
	/**
	 * Gets the uu id.
	 *
	 * @return the uu id
	 */
	public String getUuId() {
		return uuId;
	}

	/**
	 * Sets the uu id.
	 *
	 * @param uuId the new uu id
	 */
	public void setUuId(final String uuId) {
		this.uuId = uuId;
	}	
	
	/**
	 * Gets the request context.
	 *
	 * @return the request context
	 *//*
	public RequestContext getRequestContext() {
		return requestContext;
	}

	*//**
	 * Sets the request context.
	 *
	 * @param requestContext the new request context
	 *//*
	public void setRequestContext(final RequestContext requestContext) {
		this.requestContext = requestContext;
	}*/
	
	
	// validate here
	/**
	 *  (non-Javadoc).
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "PricingServiceRequest [getPricingItems()=" + getPricingItems() 
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}

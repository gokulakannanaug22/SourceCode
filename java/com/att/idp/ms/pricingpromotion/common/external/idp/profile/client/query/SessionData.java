package com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.query;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ProfileContext.
 */
//@JsonIgnoreProperties(ignoreUnknown=true)
public class SessionData {

	/** The customer type. */
	@JsonProperty("customerType")
	private String customerType;
	
	/** The flow type. */
	@JsonProperty("flowType")
	private String flowType;
	
	/** The sub flow type. */
	@JsonProperty("subFlowType")
	private String subFlowType;
	
	
	/**
	 * Gets the customer type.
	 *
	 * @return the customer type
	 */
	public String getCustomerType() {
		return customerType;
	}
	
	/**
	 * Sets the customer type.
	 *
	 * @param customerType the new customer type
	 */
	public void setCustomerType(final String customerType) {
		this.customerType = customerType;
	}
	
	/**
	 * Gets the flow type.
	 *
	 * @return the flow type
	 */
	public String getFlowType() {
		return flowType;
	}
	
	/**
	 * Sets the flow type.
	 *
	 * @param flowType the new flow type
	 */
	public void setFlowType(final String flowType) {
		this.flowType = flowType;
	}
	
	/**
	 * Gets the sub flow type.
	 *
	 * @return the sub flow type
	 */
	public String getSubFlowType() {
		return subFlowType;
	}
	
	/**
	 * Sets the sub flow type.
	 *
	 * @param subFlowType the new sub flow type
	 */
	public void setSubFlowType(final String subFlowType) {
		this.subFlowType = subFlowType;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProfileContext [customerType=" + customerType + ", flowType=" + flowType + ", subFlowType="
				+ subFlowType + "]";
	}	
}

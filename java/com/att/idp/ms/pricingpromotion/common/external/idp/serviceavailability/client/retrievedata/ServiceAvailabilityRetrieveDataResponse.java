package com.att.idp.ms.pricingpromotion.common.external.idp.serviceavailability.client.retrievedata;

import com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.query.SessionData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceAvailabilityRetrieveDataResponse {
	
private String status;
	
	@JsonProperty("data")
	private ServiceAvailabilityData serviceAvailabilityData;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(final String status) {
		this.status = status;
	}

	public ServiceAvailabilityData getServiceAvailabilityData() {
		return serviceAvailabilityData;
	}

	public void setServiceAvailabilityData(ServiceAvailabilityData serviceAvailabilityData) {
		this.serviceAvailabilityData = serviceAvailabilityData;
	}
	
	

}

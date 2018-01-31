package com.att.idp.ms.pricingpromotion.common.external.idp.serviceavailability.client.retrievedata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceAvailabilityData {
	
	@JsonProperty("addressFeatures")
	private ServiceAddress serviceAddress;

	public ServiceAddress getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(ServiceAddress serviceAddress) {
		this.serviceAddress = serviceAddress;
	}
	
	

}

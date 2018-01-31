
package com.att.idp.ms.pricingpromotion.common.external.idp.serviceavailability.client.retrievedata;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceAddress implements Serializable {

	@JsonProperty("addressId")
	private String addressId;
	@JsonProperty("addressLine1")
	private String addressLine1;
	@JsonProperty("addressLine2")
	private String addressLine2;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("zipCode")
	private String zipCode;
	@JsonProperty("zipExtension")
	private String zipExtension;
	@JsonProperty("dma")
	private String dma;
	@JsonProperty("customerType")
	private String customerType;
	
	private String zip9;
	
	private String nation = "USA";

	private final static long serialVersionUID = -6465105382327210134L;

	@JsonProperty("addressId")
	public String getAddressId() {
		return addressId;
	}

	@JsonProperty("addressId")
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public ServiceAddress withAddressId(String addressId) {
		this.addressId = addressId;
		return this;
	}

	@JsonProperty("addressLine1")
	public String getAddressLine1() {
		return addressLine1;
	}

	@JsonProperty("addressLine1")
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public ServiceAddress withAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	@JsonProperty("addressLine2")
	public String getAddressLine2() {
		return addressLine2;
	}

	@JsonProperty("addressLine2")
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public ServiceAddress withAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	public ServiceAddress withCity(String city) {
		this.city = city;
		return this;
	}

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	public ServiceAddress withState(String state) {
		this.state = state;
		return this;
	}

	@JsonProperty("zipCode")
	public String getZipCode() {
		return zipCode;
	}

	@JsonProperty("zipCode")
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public ServiceAddress withZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	@JsonProperty("zipExtension")
	public String getZipExtension() {
		return zipExtension;
	}

	@JsonProperty("zipExtension")
	public void setZipExtension(String zipExtension) {
		this.zipExtension = zipExtension;
	}

	public ServiceAddress withZipExtension(String zipExtension) {
		this.zipExtension = zipExtension;
		return this;
	}

	@JsonProperty("dma")
	public String getDma() {
		return dma;
	}

	@JsonProperty("dma")
	public void setDma(String dma) {
		this.dma = dma;
	}

	public ServiceAddress withDma(String dma) {
		this.dma = dma;
		return this;
	}

	@JsonProperty("customerType")
	public String getCustomerType() {
		return customerType;
	}

	@JsonProperty("customerType")
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public ServiceAddress withCustomerType(String customerType) {
		this.customerType = customerType;
		return this;
	}
	

	public String getZip9() {
		return zip9;
	}

	public void setZip9(String zip9) {
		this.zip9 = zip9;
	}
	
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(addressId).append(addressLine1).append(addressLine2).append(city)
				.append(state).append(zipCode).append(zipExtension).append(dma).append(customerType).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ServiceAddress) == false) {
			return false;
		}
		ServiceAddress rhs = ((ServiceAddress) other);
		return new EqualsBuilder().append(addressId, rhs.addressId).append(addressLine1, rhs.addressLine1)
				.append(addressLine2, rhs.addressLine2).append(city, rhs.city).append(state, rhs.state)
				.append(zipCode, rhs.zipCode).append(zipExtension, rhs.zipExtension).append(dma, rhs.dma)
				.append(customerType, rhs.customerType).isEquals();
	}

}

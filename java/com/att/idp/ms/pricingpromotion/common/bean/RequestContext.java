package com.att.idp.ms.pricingpromotion.common.bean;

import com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.query.SessionData;
import com.att.idp.ms.pricingpromotion.common.external.idp.serviceavailability.client.retrievedata.ServiceAddress;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class RequestContext.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestContext {

	private ServiceAddress serviceAddress;

	private SessionData sessionData;

	public ServiceAddress getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(ServiceAddress serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public SessionData getSessionData() {
		return sessionData;
	}

	public void setSessionData(SessionData sessionData) {
		this.sessionData = sessionData;
	}

	/** The zip 9. */
	/*
	 * @JsonProperty("zip9") private String zip9;
	 * 
	 *//** The zip. */
	/*
	 * @JsonProperty("zipCode") private String zip;
	 * 
	 * @JsonProperty("zipExtension") private String zipExtn;
	 * 
	 *//** The dma. */
	/*
	 * @JsonProperty("dma") private String dma;
	 * 
	 *//** The city. */
	/*
	 * @JsonProperty("city") private String city;
	 * 
	 *//** The state. */
	/*
	 * @JsonProperty("state") private String state;
	 * 
	 *//** The nation. */
	/*
	 * @JsonProperty("nation") private String nation;
	 * 
	 *//** The nation. */
	/*
	 * @JsonProperty("session") private SessionData session;
	 * 
	 *//**
		 * Gets the zipExtn.
		 *
		 * @return the zipExtn
		 */
	/*
	 * public String getZipExtn() { return zipExtn; }
	 * 
	 * 
	 *//**
		 * Sets the zipExtn.
		 *
		 * @param zip9
		 *            the new zipExtn
		 */
	/*
	 * public void setZipExtn(String zipExtn) { this.zipExtn = zipExtn; }
	 * 
	 * 
	 *//**
		 * Gets the zip 9.
		 *
		 * @return the zip 9
		 */
	/*
	 * public String getZip9() { return zip9; }
	 * 
	 *//**
		 * Sets the zip 9.
		 *
		 * @param zip9
		 *            the new zip 9
		 */
	/*
	 * public void setZip9(final String zip9) { this.zip9 = zip9; }
	 * 
	 *//**
		 * Gets the zip.
		 *
		 * @return the zip
		 */
	/*
	 * public String getZip() { return zip; }
	 * 
	 *//**
		 * Sets the zip.
		 *
		 * @param zip
		 *            the new zip
		 */
	/*
	 * public void setZip(final String zip) { this.zip = zip; }
	 * 
	 *//**
		 * Gets the dma.
		 *
		 * @return the dma
		 */
	/*
	 * public String getDma() { return dma; }
	 * 
	 *//**
		 * Sets the dma.
		 *
		 * @param dma
		 *            the new dma
		 */
	/*
	 * public void setDma(final String dma) { this.dma = dma; }
	 * 
	 *//**
		 * Gets the city.
		 *
		 * @return the city
		 */
	/*
	 * public String getCity() { return city; }
	 * 
	 *//**
		 * Sets the city.
		 *
		 * @param city
		 *            the new city
		 */
	/*
	 * public void setCity(final String city) { this.city = city; }
	 * 
	 *//**
		 * Gets the state.
		 *
		 * @return the state
		 */
	/*
	 * public String getState() { return state; }
	 * 
	 *//**
		 * Sets the state.
		 *
		 * @param state
		 *            the new state
		 */
	/*
	 * public void setState(final String state) { this.state = state; }
	 * 
	 * public SessionData getSession() { return session; }
	 * 
	 * 
	 * public void setSession(SessionData session) { this.session = session; }
	 * 
	 *//**
		 * Gets the nation.
		 *
		 * @return the nation
		 */
	/*
	 * public String getNation() { return nation; }
	 * 
	 *//**
		 * Sets the nation.
		 *
		 * @param nation
		 *            the new nation
		 */
	/*
	 * public void setNation(final String nation) { this.nation = nation; }
	 * 
	 * 
	 * 
	 *//**
		 * @see java.lang.Object#toString()
		 *//*
		 * @Override public String toString() { return "RequestContext [zip9=" +
		 * zip9 + ", zip=" + zip + ", dma=" + dma + ", city=" + city +
		 * ", state=" + state + ", nation=" + nation + ", profileContext=" +
		 * session + "]"; }
		 */

}

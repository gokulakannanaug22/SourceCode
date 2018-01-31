package com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.query;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Profile {
	
	@JsonProperty("session")
	private SessionData sessionData;

	public SessionData getSessionData() {
		return sessionData;
	}

	public void setSessionData(SessionData sessionData) {
		this.sessionData = sessionData;
	}
	

}

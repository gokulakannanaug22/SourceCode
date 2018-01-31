package com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.query;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfileQueryResponse {
	
	private String status;
	
	@JsonProperty("data")
	private Profile profile;
	

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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	
	
	/*
	
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(status).append(session).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ProfileQueryResponse) == false) {
			return false;
		}
		ProfileQueryResponse rhs = ((ProfileQueryResponse) other);
		return new EqualsBuilder().append(status, rhs.status)
				.append(session, rhs.session)
				.isEquals();
	}*/

}

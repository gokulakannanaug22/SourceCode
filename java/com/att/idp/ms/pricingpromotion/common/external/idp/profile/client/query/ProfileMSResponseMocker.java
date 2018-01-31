package com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.query;


/**
 * The Class ProfileMSResponseMocker.
 */
@SuppressWarnings("PMD")
public class ProfileMSResponseMocker {
	
	/**
	 * create Cart cartProfileResponse JSON.
	 *
	 * @param uuid the uuid
	 * @return the string
	 */
	public static String profileDataByUUIDResponseJson(String uuid){
		if(uuid.length() < 6){
			return "{\"status\": 400,\"data\": null,\"error\": [{\"code\": null,\"userMessage\": null,\"developerMessage\": \"Invalid user input.\"}]}";
		}else{
			return "{\"status\":200,\"data\":{\"session\":{ \"customerType\": \"Consumer\",\"flowType\": \"wireline\",\"subFlowType\": \"NEW_APPS\"}}}";
		}
	}

}

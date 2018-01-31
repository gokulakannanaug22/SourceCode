package com.att.idp.ms.pricingpromotion.common.external.idp.serviceavailability.client.retrievedata;


/**
 * The Class ServiceAvailabilityMSResponseMocker.
 */
@SuppressWarnings("PMD")
public class ServiceAvailabilityMSResponseMocker {
	
	
	/**
	 * create Cart serviceAvailabilityResponse JSON.
	 *
	 * @param uuid the uuid
	 * @return the string
	 */
	public static String serviceAvailabilityDataByUUIDResponseJson(String uuid){
		
			return "{\"status\": 200,\"availabilityStatus\": \"red\",\"data\": {\"userInput\": {\"addressLine1\": \"1234\",\"addressLine2\": \"abd\",\"zip\": \"98011\"},\"availableServices\": {\"isDTVAvailable\": true,\"isIPTVAvailable\": true,\"isInternetAvailable\": true,\"isHSIAAvailable\": true,\"isFBSAvailable\": false,\"isDSLAvailable\": false,\"isPotsAvailable\": false,\"isVOIPAvailable\": true,\"isGIGAFiberAvailable\": false,\"isWirelessAvailable\": true,\"wirelessHomePhoneEligible\": true},\"existingServices\": {\"LIGHTSPEEDPending\": false,\"isUverseServiceExisting\": false,\"isDSLServiceExisting\": false,\"isWirelineServiceExisting\": false,\"isDTVServiceExisting\": false,\"isWirelessServiceExisting\": false,\"isTelcoServiceExisting\": false},\"addressFeatures\": {\"addressId\": \"Sc1f76994b\",\"addressLine1\": \"1244 ALEAMO DR NE\",\"addressLine2\": \"\",\"city\": \"Bothell\",\"state\": \"WA\",\"zipCode\": \"98011\",\"zipExtension\": \"2345\",\"dma\": \"623\",\"isIPDSLAMAddress\": true,\"fccWireCenterStatus\": \"In Progress\",\"wireCenterCode\": \"MRTTGAMA\",\"customerType\": \"Consumer\",\"maxUverseHsiaSpeedAvailable\": \"45 Mbps\",\"isOutofUverseFootPrint\": false},\"mduAddresses\": {},\"closeMatchAddresses\": {},\"isCheckAvailabilityPerformed\": true}}";
	}

}

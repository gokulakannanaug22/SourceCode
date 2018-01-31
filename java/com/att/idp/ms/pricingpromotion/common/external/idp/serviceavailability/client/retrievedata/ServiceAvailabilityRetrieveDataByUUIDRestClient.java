package com.att.idp.ms.pricingpromotion.common.external.idp.serviceavailability.client.retrievedata;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.foundation.pipeline.Processor;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
import com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.query.ProfileMSResponseMocker;
import com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.query.ProfileQueryResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class RetrieveServiceAvailabilityContextProcessor is used to build the ServiceAvailability response
 */
@SuppressWarnings("PMD")
//@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
public class ServiceAvailabilityRetrieveDataByUUIDRestClient implements Processor<PricingContext> {
	
	/**
	 * The rest template.
	 *
	 * @see com.att.idp.foundation.pipeline.Processor#execute(java.lang.Object)
	 */
	/** The log. */
	private static EELFLogger log = AjscEelfManager.getInstance()
			.getLogger(ServiceAvailabilityRetrieveDataByUUIDRestClient.class);
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	@SuppressWarnings("PMD.AvoidCatchingGenericException")
	public void execute(final PricingContext pricingContext) {
	
			//final String uuid = pricingContext.getPricingRequest().getUuId();
            /*String serviceAvailURI = Constants.SERVICE_AVAILABILIY_BASE_URI + uuid;
			restTemplate.getForObject(serviceAvailURI, RequestContext.class);*/

		ObjectMapper objectMapper = new ObjectMapper();
		ServiceAvailabilityRetrieveDataResponse saRetrieveDataResponse = null;
			try {
				
				saRetrieveDataResponse =  objectMapper.readValue(ServiceAvailabilityMSResponseMocker.serviceAvailabilityDataByUUIDResponseJson(pricingContext.getPricingRequest().getUuId()),
						ServiceAvailabilityRetrieveDataResponse.class);
				
				ServiceAddress serviceAddress = saRetrieveDataResponse.getServiceAvailabilityData().getServiceAddress();
				serviceAddress.setZip9(serviceAddress.getZipCode()+serviceAddress.getZipExtension());
				
				pricingContext.getRequestContext().setServiceAddress(serviceAddress);
			
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}		
			
	}


}

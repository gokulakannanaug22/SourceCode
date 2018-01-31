package com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.query;

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
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class RetrieveProfileContextProcessor is use to build the profile service
 * response
 */
@SuppressWarnings("PMD")
//@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
public class ProfileQueryDataByUUIDRestClient implements Processor<PricingContext> {

	/**
	 * The rest template.
	 *
	 * @see com.att.idp.foundation.pipeline.Processor#execute(java.lang.Object)
	 */
	/** The log. */
	private static EELFLogger log = AjscEelfManager.getInstance()
			.getLogger(ProfileQueryDataByUUIDRestClient.class);
	@Autowired
	private RestTemplate restTemplate;

	@Override
	@SuppressWarnings("PMD.AvoidCatchingGenericException")
	public void execute(final PricingContext pricingContext) {
//		String uuid = pricingContext.getPricingRequest().getUuId();
		/*
		 * String serviceAvailURI = Constants.PROFILE_BASE_URI + uuid;
		 * RequestContext result = restTemplate.getForObject(serviceAvailURI,
		 * RequestContext.class);
		 */
		ObjectMapper objectMapper = new ObjectMapper();
		ProfileQueryResponse profileQueryResponse = null;
		try {
			profileQueryResponse = objectMapper.readValue(ProfileMSResponseMocker.profileDataByUUIDResponseJson(pricingContext.getPricingRequest().getUuId()),
					ProfileQueryResponse.class);
			pricingContext.getRequestContext().setSessionData(profileQueryResponse.getProfile().getSessionData());
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

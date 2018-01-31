package com.att.idp.ms.pricingpromotion.common.external.idp.serviceavailability.client.retrievedata;

import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.att.idp.foundation.error.ApplicationError;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
import com.att.idp.ms.pricingpromotion.common.external.idp.serviceavailability.client.retrievedata.ServiceAvailabilityRetrieveDataByUUIDRestClient;
import com.att.idp.ms.pricingpromotion.common.model.PricingRestRequest;

/**
 * The Class RetrieveServiceAvailabilityContextProcessorTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class ServiceAvailabilityRetrieveDataByUUIDRestClientTest {

	/** The retrieve service availability context processor. */
	ServiceAvailabilityRetrieveDataByUUIDRestClient retrieveServiceAvailabilityContextProcessor;
	
	/** The m pricing context. */
	@Mock
	PricingContext mPricingContext;
	
	/** The m pricing rest request. */
	@Mock
	PricingRestRequest mPricingRestRequest;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private RequestContext mRequestContext;
	
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		retrieveServiceAvailabilityContextProcessor=new ServiceAvailabilityRetrieveDataByUUIDRestClient();
	}
	
	/**
	 * Test execute.
	 */
	@Ignore
	@Test
	public void testExecute() {
		when(mPricingContext.getPricingRequest()).thenReturn(mPricingRestRequest);
		when(mPricingRestRequest.getUuId()).thenReturn("UUID");
		when(restTemplate.getForObject("http://localhost:8080/idp/service-availability/v1/availability/uuid/", RequestContext.class)).thenReturn(mRequestContext);
		retrieveServiceAvailabilityContextProcessor.execute(mPricingContext);
	}
	
	/**
	 * Test execute exception.
	 */
	@Test(expected = ApplicationError.class)
	public void testExecuteException() {
		when(mPricingContext.getPricingRequest()).thenReturn(mPricingRestRequest);
		when(mPricingRestRequest.getUuId()).thenReturn("UUID");
		retrieveServiceAvailabilityContextProcessor.execute(mPricingContext);
	}
	
	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		retrieveServiceAvailabilityContextProcessor=null;
	}

	

}

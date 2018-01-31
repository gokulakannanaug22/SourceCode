/**
 * 
 */
package com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.retrievecontext;

import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import com.att.idp.foundation.error.ApplicationError;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.retrievecontext.ProfileRetrieveContextByUUIDRestClient;
import com.att.idp.ms.pricingpromotion.common.model.PricingRestRequest;

// 
/**
 * The Class RetrieveProfileContextProcessorTest.
 *
 * @author 
 */
public class ProfileRetrieveContextByUUIDRestClientTest {

	/** The retrieve profile context processor. */
	ProfileRetrieveContextByUUIDRestClient retrieveProfileContextProcessor;
	
	/** The m pricing context. */
	@Mock
	PricingContext mPricingContext;
	
	/** The m pricing rest request. */
	@Mock
	PricingRestRequest mPricingRestRequest;
	
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		retrieveProfileContextProcessor=new ProfileRetrieveContextByUUIDRestClient ();
	}
	
	/**
	 * Test execute.
	 */
	@Ignore
	@Test
	public void testExecute() {
		when(mPricingContext.getPricingRequest()).thenReturn(mPricingRestRequest);
		when(mPricingRestRequest.getUuId()).thenReturn("UUID");
		retrieveProfileContextProcessor.execute(mPricingContext);
	}
	
	/**
	 * Test execute exception.
	 */
	@Test(expected = NullPointerException.class)
	public void testExecuteException() {
		when(mPricingContext.getPricingRequest()).thenReturn(mPricingRestRequest);
		when(mPricingRestRequest.getUuId()).thenReturn("UUID");
		retrieveProfileContextProcessor.execute(mPricingContext);
	}
	
	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		retrieveProfileContextProcessor=null;
	}

	

}

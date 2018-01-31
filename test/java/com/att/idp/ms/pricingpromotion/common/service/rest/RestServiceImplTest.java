package com.att.idp.ms.pricingpromotion.common.service.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

// TODO: Auto-generated Javadoc
//TODO: Auto-generated Javadoc
/**
 * The Class RestServiceImplTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class RestServiceImplTest {
	
	/**
	 * restServiceImpl
	 */
	public RestServiceImpl restServiceImpl;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		restServiceImpl = new RestServiceImpl();
	}
	
	/**
	 * testgetQuickHello
	 * @throws Exception
	 */
	@Test
	public void testgetQuickHello() throws Exception{
		restServiceImpl.getQuickHello("","Hello");
	}
	
}
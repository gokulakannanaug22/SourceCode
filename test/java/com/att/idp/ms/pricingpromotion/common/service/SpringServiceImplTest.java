package com.att.idp.ms.pricingpromotion.common.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
* The Class SpringServiceImpl.
*/
@RunWith(MockitoJUnitRunner.class)
public class SpringServiceImplTest {
	
	/**
	 * springServiceImpl
	 */
	public SpringServiceImpl springServiceImpl;
	
	/**
	 * setUp
	 */
	@Before
	public void setUp(){
		springServiceImpl = new SpringServiceImpl();
	}
	
	/**
	 * testgetQuickHello
	 * @throws Exception
	 */
	@Test
	public void testgetQuickHello() throws Exception{
		springServiceImpl.getQuickHello("Hello");
	}
	
	/**
	 * testgetQuickHelloNULL
	 * @throws Exception
	 */
	@Test
	public void testgetQuickHelloNULL() throws Exception{
		springServiceImpl.getQuickHello(null);
	}
	
}
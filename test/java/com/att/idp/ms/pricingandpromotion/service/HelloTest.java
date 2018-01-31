package com.att.idp.ms.pricingandpromotion.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.att.ajsc.common.utility.SystemPropertiesLoader;
import com.att.idp.ms.pricingpromotion.Application;
import com.att.idp.ms.pricingpromotion.common.model.HelloWorld;
import com.att.idp.ms.pricingpromotion.common.service.rest.RestService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:application-test.properties")
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class,
		HazelcastAutoConfiguration.class,
		CacheAutoConfiguration.class})
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = { Application.class })
public class HelloTest {

	static {
		SystemPropertiesLoader.addSystemProperties();
	}

	@Autowired
	RestService service;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQuickHello() throws Exception {
		HelloWorld helloWorld = service.getQuickHello(null, "test");
		assertEquals("Hello test!", helloWorld.getMessage());
	}
}

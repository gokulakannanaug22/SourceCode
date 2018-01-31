package com.att.idp.ms.pricingandpromotion.service;

import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.att.ajsc.common.utility.SystemPropertiesLoader;
import com.att.idp.ms.pricingpromotion.Application;
import com.att.idp.ms.pricingpromotion.common.service.rest.RestService;
import com.jayway.restassured.RestAssured;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:application-test.properties")
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class,
		HazelcastAutoConfiguration.class,
		CacheAutoConfiguration.class})
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = { Application.class })

public class ServiceTest {

	static {
		SystemPropertiesLoader.addSystemProperties();
	}

	/** The service. */
	@Autowired
	private RestService service;

	/** The port. */
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
		// TODO: Add teardown
	}

	/**
	 * Test quick hello.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testQuickHello() throws Exception {
		ResponseEntity<String> entity = restTemplate
				.getForEntity("http://localhost:" + port + "/idp/pricing-promotion/v1/hello", String.class);
		assertEquals("{\"message\":\"Hello world!\"}", entity.getBody());
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}

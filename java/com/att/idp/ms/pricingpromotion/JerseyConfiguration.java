package com.att.idp.ms.pricingpromotion;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.att.ajsc.common.messaging.DateTimeParamConverterProvider;
import com.att.ajsc.common.messaging.LogRequestFilter;
import com.att.ajsc.common.messaging.LogResponseFilter;
import com.att.ajsc.common.messaging.ObjectMapperContextResolverNonNull;
import com.att.ajsc.common.messaging.TransactionIdRequestFilter;
import com.att.ajsc.common.messaging.TransactionIdResponseFilter;
import com.att.idp.ms.pricingpromotion.cartpricing.rest.controller.CartPriceRestController;
import com.att.idp.ms.pricingpromotion.common.service.rest.RestServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class JerseyConfiguration.
 */
@Component
@ApplicationPath("/")
public class JerseyConfiguration extends ResourceConfig {
	
	/**
	 * Jersey configuration constructor.
	 *
	 * @param lrf the lrf
	 */
	@Autowired
    public JerseyConfiguration(final LogRequestFilter lrf) {
		super();
    	register(new ObjectMapperContextResolverNonNull());
        register(RestServiceImpl.class);
        register(CartPriceRestController.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
        register(TransactionIdRequestFilter.class, 6000);
        register(TransactionIdResponseFilter.class, 6003);
        register(DateTimeParamConverterProvider.class);
        register(lrf, 6001);
        register(LogResponseFilter.class, 6004);
        register(LoggingFeature.class);
    }

	/**
	 * Jersey configuration client.
	 *
	 * @return the client
	 */
	@Bean
	public Client jerseyClient() {
		return ClientBuilder.newClient(
				new ClientConfig()
				.register(TransactionIdRequestFilter.class)
				.register(TransactionIdResponseFilter.class)
				.register(DateTimeParamConverterProvider.class));
	}
}
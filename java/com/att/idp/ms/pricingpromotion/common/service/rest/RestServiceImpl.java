package com.att.idp.ms.pricingpromotion.common.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.att.ajsc.common.Tracable;
import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.ms.pricingpromotion.common.LogMessages;
import com.att.idp.ms.pricingpromotion.common.model.HelloWorld;
import com.att.idp.ms.pricingpromotion.common.service.SpringService;

//TODO: Auto-generated Javadoc
/**
 * The Class RestServiceImpl.
 */
@Controller
public class RestServiceImpl implements RestService {

	/** EELFLogger instance. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(RestServiceImpl.class);

	/** SpringService instance. */
	@Autowired
	private SpringService service;

	/**
	 * getQuickHello() method.
	 *
	 * @param name
	 *            the name
	 * @return the quick hello
	 * @see com.att.idp.ms.cart.service.rs.RestService#getQuickHello(java.lang.String)
	 */
	@Override
	@Tracable(message = "invoking quick hello")
	public HelloWorld getQuickHello(final String transactionId, final String name) {
		log.info(LogMessages.RESTSERVICE_HELLO);
		log.debug(LogMessages.RESTSERVICE_HELLO_NAME, name);
		return service.getQuickHello(name);
	}

}
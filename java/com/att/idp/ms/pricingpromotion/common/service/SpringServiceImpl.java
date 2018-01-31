package com.att.idp.ms.pricingpromotion.common.service;

import org.springframework.stereotype.Service;

import com.att.ajsc.common.Tracable;
import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.ms.pricingpromotion.common.LogMessages;
import com.att.idp.ms.pricingpromotion.common.model.HelloWorld;

//TODO: Auto-generated Javadoc
/**
* The Class SpringServiceImpl.
*/
@Service
@SuppressWarnings({"PMD.AvoidPrintStackTrace,PMD.DataflowAnomalyAnalysis"})
public class SpringServiceImpl implements SpringService {

	/** EELFLogger instance. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(SpringServiceImpl.class);

	/**
	 * getQuickHello() method.
	 *
	 * @param name
	 *            the name
	 * @return the quick hello
	 * @see com.att.idp.ms.cart.service.SpringService#getQuickHello(java.lang.String)
	 */
	@Override
	@Tracable(message = "invoking quick hello service ")
	@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
	public HelloWorld getQuickHello(final String name) {
		String retVal;

		log.info(LogMessages.SPRINSERVICE_HELLO);
		log.debug(LogMessages.SPRINSERVICE_HELLO_NAME, name);
		if (name == null || name.isEmpty()) {
			retVal = "world";
		} else {
			retVal = name;
		}
		final String message = "Hello " + retVal + "!";
		log.debug(LogMessages.SPRINSERVICE_HELLO_MESSAGE, message);
		final HelloWorld hello = new HelloWorld(message);
		log.debug(LogMessages.SPRINSERVICE_HELLO_MESSAGE_NAME, hello.toString());
		return hello;
	}
}
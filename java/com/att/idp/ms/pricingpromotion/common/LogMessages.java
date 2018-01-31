package com.att.idp.ms.pricingpromotion.common;

import com.att.eelf.i18n.EELFResolvableErrorEnum;
import com.att.eelf.i18n.EELFResourceManager;

// TODO: Auto-generated Javadoc
/**
 * The Enum LogMessages.
 */
public enum LogMessages implements EELFResolvableErrorEnum {

	/** The restservice hello. */
	RESTSERVICE_HELLO, /** The restservice hello name. */
 RESTSERVICE_HELLO_NAME, /** The sprinservice hello. */
 SPRINSERVICE_HELLO, /** The sprinservice hello name. */
 SPRINSERVICE_HELLO_NAME, /** The sprinservice hello message. */
 SPRINSERVICE_HELLO_MESSAGE, /** The sprinservice hello message name. */
 SPRINSERVICE_HELLO_MESSAGE_NAME;

	static {

		EELFResourceManager.loadMessageBundle("logmessages");

	}

}

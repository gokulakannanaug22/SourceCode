package com.att.idp.ms.pricingpromotion.common.model;

//TODO: Auto-generated Javadoc
// Test the code check-in from STS
/**
* The Class HelloWorld.
*/
public class HelloWorld {

	/** message. */
	private String message;

	/**
	 * Constructor.
	 */
	public HelloWorld() {
		// needed for deserializer
	}
	
	/**
	 * Constructor.
	 *
	 * @param message the message
	 */
	public HelloWorld(final String message) {
		this.message = message;
	}
	
	/**
	 * getMessage().
	 *
	 * @return the message
	 */

	public String getMessage() {
		return message;
	}

	/**
	 * setMessage().
	 *
	 * @param message the new message
	 */
	public void setMessage(final String message) {
		this.message = message;
	}
	
	/**
	 * toString() method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "message = "	+ getMessage();
	}
}

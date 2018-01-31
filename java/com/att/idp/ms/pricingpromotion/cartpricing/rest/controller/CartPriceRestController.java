/*******************************************************************************
 *   BSD License
 *    
 *   Copyright (c) 2017, AT&T Intellectual Property.  All other rights reserved.
 *    
 *   Redistribution and use in source and binary forms, with or without modification, are permitted
 *   provided that the following conditions are met:
 *    
 *   1. Redistributions of source code must retain the above copyright notice, this list of conditions
 *      and the following disclaimer.
 *   2. Redistributions in binary form must reproduce the above copyright notice, this list of
 *      conditions and the following disclaimer in the documentation and/or other materials provided
 *      with the distribution.
 *   3. All advertising materials mentioning features or use of this software must display the
 *      following acknowledgement:  This product includes software developed by the AT&T.
 *   4. Neither the name of AT&T nor the names of its contributors may be used to endorse or
 *      promote products derived from this software without specific prior written permission.
 *    
 *   THIS SOFTWARE IS PROVIDED BY AT&T INTELLECTUAL PROPERTY ''AS IS'' AND ANY EXPRESS OR
 *   IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 *   MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 *   SHALL AT&T INTELLECTUAL PROPERTY BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *   SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 *   PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;  LOSS OF USE, DATA, OR PROFITS;
 *   OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 *   CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 *   ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
 *   DAMAGE.
 *******************************************************************************/
package com.att.idp.ms.pricingpromotion.cartpricing.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.att.ajsc.common.Tracable;
import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.foundation.utils.rest.RestResponse;
import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPriceResponse;
import com.att.idp.ms.pricingpromotion.cartpricing.model.CartPricingRestRequest;
import com.att.idp.ms.pricingpromotion.cartpricing.service.CartPriceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class CartPriceRestController is used to get the response for CartPricing
 * by retrieving priceItem, Promotion, Discounts,Caschback etc.
 *
 * @author vp020k
 */
@RestController
@Validated
@Api
@Path("/")
@Produces({ MediaType.APPLICATION_JSON })
@SuppressWarnings("PMD")
public class CartPriceRestController {

	/** The cart price service. */
	@Autowired
	private CartPriceService cartPriceService;

	/** The log. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(CartPriceRestController.class);
	
	/*@Autowired
	private PricingRestRequestValidator pricingRestRequestValidator;*/

	
	/*public CartPriceRestController(PricingRestRequestValidator pricingRestRequestValidator) {
	    this.pricingRestRequestValidator = pricingRestRequestValidator;
	}*/
	
	/*@InitBinder("pricingRestRequest")
	public void setupBinder(WebDataBinder binder) {
	    binder.addValidators(pricingRestRequestValidator);
	}*/

	@Tracable(message = "invoking CartPriceRestController.retrieveCartPrice")
	/**
	 * Retrieve cart price.
	 *
	 * @param cartPricingRequest
	 *            the cart pricing request
	 * @return the CartPriceResponse rest response
	 */
	@POST
	@Path("/price/cart")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Renurns CartPricingServiceResponse", notes = "Calculate Price for the given items and Cart levl properties, returns CartPricingServiceResponse as a JSON object. ", response = CartPriceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Service not available"),
			@ApiResponse(code = 500, message = "Unexpected Runtime error") })
	public RestResponse retrieveCartPrice( CartPricingRestRequest cartPricingRequest) {
		
		//@Valid @RequestBody

		log.info("[CartPriceRestController Called. Invoke retrieveCartPrice]");
		
		return RestResponse.build(() -> {
			return cartPriceService.retrieveCartPrice(cartPricingRequest);
		});
	}
}

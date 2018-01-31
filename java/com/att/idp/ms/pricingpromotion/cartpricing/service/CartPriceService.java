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
package com.att.idp.ms.pricingpromotion.cartpricing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.ajsc.common.Tracable;
import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.foundation.pipeline.Pipeline;
import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPriceResponse;
import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPricingContext;
import com.att.idp.ms.pricingpromotion.cartpricing.model.CartPricingRestRequest;
import com.att.idp.ms.pricingpromotion.cartpricing.pipeline.CartPricePipelineBuilder;
import com.att.idp.ms.pricingpromotion.cartpricing.response.builder.CartPriceResponseBuilder;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;

/**
 * The Class CartPriceService will have a pipeline which will be executed upon
 * sequence to retrieve priceitems, promotions, cashback.
 *
 * @author vp020k
 */
@Service
public class CartPriceService {

	/** The cart price pipeline builder. */
/*	@Autowired
	private CartPricePipelineBuilder cartPricePipelineBuilder;*/

	/** The cart price response builder *. */
	@Autowired
	private CartPriceResponseBuilder cartPriceResponseBuilder;

	/** The log. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(CartPriceService.class);

	@Tracable(message = "invoking CartPriceService.retrieveCartPrice")
	/**
	 * retrieveCartPrice will have a pipeline which will be executed upon
	 * sequence to retrieve priceitems, promotions, cashback.
	 * 
	 * @param cartPricingrequest
	 *            CartPricingServiceRequest
	 * @return CartPriceResponse
	 */
	public CartPriceResponse retrieveCartPrice(final CartPricingRestRequest cartPricingrequest) {

		log.debug("[CartPriceService. Invoking retrieveCartPrice]");

		final CartPricingContext cartPricingContext = new CartPricingContext();
		cartPricingContext.setPricingRequest(cartPricingrequest);

		CartPricePipelineBuilder cartPricePipelineBuilder = new CartPricePipelineBuilder();
		final Pipeline<PricingContext> pipeline = cartPricePipelineBuilder.buildPipeline();
		pipeline.execute(cartPricingContext);
		
		CartPriceResponse cartPriceResponse = cartPriceResponseBuilder.retrieveCartPriceRespone(cartPricingContext);

		return cartPriceResponse;
	}

}

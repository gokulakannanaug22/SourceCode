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

package com.att.idp.ms.pricingpromotion.cartpricing.pipeline;

import org.springframework.stereotype.Component;

import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.foundation.pipeline.Pipeline;
import com.att.idp.foundation.pipeline.PipelineBuilder;
import com.att.idp.ms.pricingpromotion.cartpricing.processor.CartPriceCalculatorProcessor;
import com.att.idp.ms.pricingpromotion.cartpricing.processor.CartPricePromotionSelectorProcessor;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.query.ProfileQueryDataByUUIDRestClient;
import com.att.idp.ms.pricingpromotion.common.external.idp.serviceavailability.client.retrievedata.ServiceAvailabilityRetrieveDataByUUIDRestClient;
import com.att.idp.ms.pricingpromotion.common.processor.PriceSelectorProcessor;

/**
 * The Class CartPricePipelineBuilder runs the sequence of processors starting
 * from retrieving Address etc from Service Availability, retrieve profile from
 * API call to Profile, retrieving price item, retrieving promotions, calculate
 * the price excluding discount and then cashback.
 *
 * @author vp020k
 */
@Component
public class CartPricePipelineBuilder {

	/** The log. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(CartPricePipelineBuilder.class);

	/**
	 * It builds and returns the CartPricePipeline.
	 *
	 * @return the pipeline
	 */
	public Pipeline<PricingContext> buildPipeline() {
		
		log.debug("[CartPricePipelineBuilder. Invoking buildPipeline]");
		
		final PipelineBuilder<PricingContext> cartPricePipelineBuilder = PipelineBuilder.<PricingContext>builder();
		return cartPricePipelineBuilder.first(new ServiceAvailabilityRetrieveDataByUUIDRestClient())
				.next(new ProfileQueryDataByUUIDRestClient()).next(new PriceSelectorProcessor())
				.next(new CartPricePromotionSelectorProcessor()).next(new CartPriceCalculatorProcessor()).build();
//				.next(new CartPriceCashBackSelectorProcessor()).build();
	}

}

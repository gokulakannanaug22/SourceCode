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
package com.att.idp.ms.pricingpromotion.common.processor;

import java.util.List;

import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.foundation.pipeline.Processor;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;
import com.att.idp.ms.pricingpromotion.common.bean.RequestContext;
import com.att.idp.ms.pricingpromotion.common.selector.PriceSelector;
import com.att.idp.ms.pricingpromotion.common.selector.impl.WirelinePriceSelector;


/**
 * The Class PriceSelectorProcessor is used to get the Price Items from the
 * Database corresponding to our Inputs.
 */
@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
public class PriceSelectorProcessor implements Processor<PricingContext> {

	/** The log. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(PriceSelectorProcessor.class);

	/**
	 * Get the Price Items from the Database corresponding to our Inputs
	 * 
	 * @param pricingContext
	 *            the pricing context
	 */
	@Override
	@SuppressWarnings("PMD.AvoidCatchingGenericException")
	public void execute(final PricingContext pricingContext) {
		log.info("[PriceSelectorProcessor :: Invoking Execute method]");
		RequestContext requestContext = null;
		/**
		 * Separate the skus based on line of business (lob) and call the
		 * corresponding PriceSelector, if it has to be handled differently for
		 * wireline / wireless products.
		 */
		final List<PricingItem> pricingItems = pricingContext.getPricingRequest().getPricingItems();
		requestContext = pricingContext.getRequestContext();

		final PriceSelector priceSelector = new WirelinePriceSelector();
		pricingContext.setItemPriceMap(priceSelector.retrieveItemsPrice(pricingItems, requestContext));

	}

}
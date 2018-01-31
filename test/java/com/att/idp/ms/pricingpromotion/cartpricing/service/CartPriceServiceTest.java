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

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.att.idp.ms.pricingpromotion.cartpricing.bean.CartPriceResponse;
import com.att.idp.ms.pricingpromotion.cartpricing.model.CartPricingRestRequest;
import com.att.idp.ms.pricingpromotion.common.PricingPromotionInputData;
import com.att.idp.ms.pricingpromotion.common.bean.ItemPrice;
import com.att.idp.ms.pricingpromotion.common.bean.PricingItem;

/**
 * The Class CartPriceServiceTest.
 *
 * @author vp020k
 */
@RunWith(MockitoJUnitRunner.class)
public class CartPriceServiceTest {

	/**
	 * cartPriceService
	 */
	public CartPriceService cartPriceService;
		
	/**
	 * cartPricingrequest
	 */
	public CartPricingRestRequest cartPricingRestRequest;

	/**
	 * priceItems
	 */
	public List<PricingItem> priceItems;

	/**
	 * pricingItem
	 */
	public PricingItem pricingItem;

	/**
	 * cartPriceResponse
	 */
	public CartPriceResponse cartPriceResponse;

	/**
	 * itemPrice
	 */
	public List<ItemPrice> itemPrice;

	/**
	 * setUp
	 */
	@Before
	public void setUp() {
		cartPriceService = new CartPriceService();
		cartPricingRestRequest = new CartPricingRestRequest();
		cartPricingRestRequest.setUuId(null);
//		cartPricingRestRequest = PricingPromotionInputData.getCartRequestTestData();
	}

	/**
	 * testretrieveCartPrice
	 * 
	 * @throws Exception
	 */
	@Test
	public void testretrieveCartPriceSuccess() throws Exception {
		
		cartPriceResponse = cartPriceService.retrieveCartPrice(cartPricingRestRequest);
		assertNotNull(cartPriceResponse);
		assertNotNull(cartPriceResponse.getCartPrice().getAmount());
		assertNotNull(cartPriceResponse.getCartPrice().getDueMonthly());
		assertNotNull(cartPriceResponse.getCartPrice().getDueFirstBill());
		assertNotNull(cartPriceResponse.getCartPrice().getDueToday());
		assertNotNull((cartPriceResponse.getItemsPrice().get(0).getSkuId()));
		assertNotNull((cartPriceResponse.getItemsPrice().get(0).getRackRate()));
		assertNotNull((cartPriceResponse.getItemsPrice().get(0).getFinalPrice()));
		assertNotNull((cartPriceResponse.getPromotions().get(0).getPercent()));
		assertNotNull((cartPriceResponse.getPromotions().get(0).getPromotionId()));
		assertNotNull((cartPriceResponse.getPromotions().get(0).getPromoType()));
	}

	// Write test cases with multiple input items.

}

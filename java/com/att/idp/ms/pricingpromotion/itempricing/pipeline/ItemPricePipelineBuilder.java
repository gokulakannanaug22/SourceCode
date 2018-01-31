/**
 * 
 */
package com.att.idp.ms.pricingpromotion.itempricing.pipeline;

import org.springframework.stereotype.Service;

import com.att.idp.foundation.pipeline.Pipeline;
import com.att.idp.foundation.pipeline.PipelineBuilder;
import com.att.idp.ms.pricingpromotion.common.bean.PricingContext;
import com.att.idp.ms.pricingpromotion.common.external.idp.profile.client.query.ProfileQueryDataByUUIDRestClient;
import com.att.idp.ms.pricingpromotion.common.external.idp.serviceavailability.client.retrievedata.ServiceAvailabilityRetrieveDataByUUIDRestClient;
import com.att.idp.ms.pricingpromotion.common.processor.PriceSelectorProcessor;
import com.att.idp.ms.pricingpromotion.itempricing.processor.ItemPriceCashBackSelectorProcessor;
import com.att.idp.ms.pricingpromotion.itempricing.processor.ItemPricePromotionSelectorProcessor;

/**
 * The Class ItemPricePipelineBuilder.
 *
 * @author vp020k
 */
@Service
public class ItemPricePipelineBuilder {

	/**
	 * It builds and returns the ItemPricePipeline.
	 *
	 * @return the pipeline
	 */
	public Pipeline<PricingContext> buildPipeline() {
		
		final PipelineBuilder<PricingContext> itemPricePipelineBuilder = PipelineBuilder.<PricingContext>builder();
		return itemPricePipelineBuilder.first(new ServiceAvailabilityRetrieveDataByUUIDRestClient())
				.next(new ProfileQueryDataByUUIDRestClient())
				.next(new PriceSelectorProcessor())
				.next(new ItemPricePromotionSelectorProcessor())
//				.next(new ItemPriceCalculatorProcessor())
				.next(new ItemPriceCashBackSelectorProcessor()).build();
	}

}

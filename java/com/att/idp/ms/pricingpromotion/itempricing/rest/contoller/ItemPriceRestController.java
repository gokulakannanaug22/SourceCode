package com.att.idp.ms.pricingpromotion.itempricing.rest.contoller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.att.idp.foundation.utils.rest.RestResponse;
import com.att.idp.ms.pricingpromotion.itempricing.bean.ItemPriceResponse;
import com.att.idp.ms.pricingpromotion.itempricing.model.ItemPricingRestRequest;
import com.att.idp.ms.pricingpromotion.itempricing.service.ItemPriceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * The Class ItemPriceRestController is a controller class used to 
 * Calculate Price for the given items and returns ItemPriceResponse as a JSON object.
 */
@Controller
@Api
@Path("/")
@Produces({ MediaType.APPLICATION_JSON })
public class ItemPriceRestController {

	/** The log. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(ItemPriceRestController.class);

	/** The item price service. */
	@Autowired
	private ItemPriceService itemPriceService;

	/**
	 * Retrieve item price.
	 *
	 * @param itemPricingRequest the item pricing request
	 * @return the rest response
	 */
	@POST
	@Path("price/item")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Renurns ItemPriceResponse", 
	notes = "Calculate Price for the given items and returns ItemPriceResponse as a JSON object. ", 
	response = ItemPriceResponse.class)
	@ApiResponses(value = 
        { @ApiResponse(code = 404, message = "Service not available"),
		@ApiResponse(code = 500, message = "Unexpected Runtime error") 
        })

	public RestResponse retrieveItemPrice(@ApiParam(name = "ItemPricingRestRequest", value = "ItemPricingRequest", required = true ) 
	@PathParam("itemPricingRequest") final ItemPricingRestRequest itemPricingRequest) {
		log.info("retrieveItemPricing...");
		return RestResponse.build(() -> {
			return itemPriceService.retrieveItemsPrice(itemPricingRequest);
		});
	}
}

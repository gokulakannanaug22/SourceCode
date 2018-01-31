package com.att.idp.ms.pricingpromotion.common.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.att.idp.foundation.configuration.ApplicationConstants;
import com.att.idp.ms.pricingpromotion.common.model.HelloWorld;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// TODO: Auto-generated Javadoc
/**
 * The Interface RestService.
 */
@Api
@Path("/")
@Produces({MediaType.APPLICATION_JSON})
public interface RestService {
	
	/**
	 * getQuickHello().
	 *
	 * @param name the name
	 * @return the quick hello
	 */
	@GET
	@Path("/hello")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Respond Hello <name>!",
			notes = "Returns a JSON object with a string to say hello. "
					+ "Uses 'world' if a name is not specified",
			response = HelloWorld.class
	)
	@ApiResponses(
			value = {
					@ApiResponse(code = 404, message = "Service not available"),
					@ApiResponse(code = 500, message = "Unexpected Runtime error")
					})
	HelloWorld getQuickHello(
			@HeaderParam(ApplicationConstants.TRANSACTION_ID)
			String transactionId,
			@ApiParam( value = "Name", required = false ) 
			@QueryParam("name") 
			String name);
}
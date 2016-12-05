package com.webservice.header;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/stock")
public interface IStockService {
	
	@POST
	@Path("/getData")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({"application/xml","application/json"})
	public Object getData() throws Exception;
	
	@POST
	@Path("/getDataJson")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({"application/xml","application/json"})
	public Object getDataJson() throws Exception;
}

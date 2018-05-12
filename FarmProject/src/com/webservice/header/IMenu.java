package com.webservice.header;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/menu")
public interface IMenu {
	
	@POST
	@Path("/getMenu")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({"application/json"})
	public Object getMenu(String json) throws Exception;
}

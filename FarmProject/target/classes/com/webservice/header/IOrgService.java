package com.webservice.header;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/organization")
public interface IOrgService {

	@POST
	@Path("/search")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({"application/json"})
	public Object search(String json) throws Exception;
	
	@POST
	@Path("/insert")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({"application/json"})
	public Object insert(String json) throws Exception;
}

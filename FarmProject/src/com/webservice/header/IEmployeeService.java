package com.webservice.header;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employee")
public interface IEmployeeService {

	@POST
	@Path("/search")
	@Consumes({"application/xml","application/json",MediaType.MULTIPART_FORM_DATA})
	@Produces({"application/xml","application/json"})
	public Object search(String json) throws Exception;
	
	@POST
	@Path("/insert")
	@Consumes({"application/xml","application/json",MediaType.MULTIPART_FORM_DATA})
	@Produces({"application/xml","application/json"})
	public Object insert(String json) throws Exception;
	
	@POST
	@Path("/update")
	@Consumes({"application/xml","application/json",MediaType.MULTIPART_FORM_DATA})
	@Produces({"application/xml","application/json"})
	public Object update(String json) throws Exception;
	
	@POST
	@Path("/delete")
	@Consumes({"application/xml","application/json",MediaType.MULTIPART_FORM_DATA})
	@Produces({"application/xml","application/json"})
	public Object delete(String json) throws Exception;
}

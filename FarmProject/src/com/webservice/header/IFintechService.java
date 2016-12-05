package com.webservice.header;

import javax.ws.rs.Consumes;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

@Path("/fintech")
public interface IFintechService {
	
	@POST
	@Path("/getData")
	@Consumes({"application/xml","application/json",MediaType.MULTIPART_FORM_DATA})
	@Produces({"application/xml","application/json"})
	public Object getData() throws Exception;
	
	@POST
	@Path("/getDataJson")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({"application/xml","application/json"})
	public Object getDataJson() throws Exception;
	
	
	@OPTIONS
	@Path("/getDataOption")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN,MediaType.TEXT_HTML})
	@Produces({"application/xml","application/json"})
	public Object getDataOption() throws Exception;
}

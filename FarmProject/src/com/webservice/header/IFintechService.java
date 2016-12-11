package com.webservice.header;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fintech")
public interface IFintechService {
	
	@POST
	@Path("/getData")
	@Consumes({"application/xml","application/json",MediaType.MULTIPART_FORM_DATA})
	@Produces({"application/xml","application/json"})
	public Object getData(String json) throws Exception;
	
	@POST
	@Path("/getDataJson")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({"application/xml","application/json"})
	public Object getDataJson(String json) throws Exception;
	
	
	@POST
	@Path("/getDataMap")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.MULTIPART_FORM_DATA})
	@Produces({"application/xml","application/json"})
	public Object getDataOption(Map<String,Object>map,String json) throws Exception;
}

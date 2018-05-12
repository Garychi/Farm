package com.webservice.header;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Path("/employee")
public interface IEmployeeService {

    @POST
    @Path("/search")
    @Consumes({"application/xml", "application/json", MediaType.MULTIPART_FORM_DATA})
    @Produces({"application/xml", "application/json"})
    public Object search(String json) throws Exception;

    @POST
    @Path("/insert")
    @Consumes({"application/xml", "application/json", MediaType.MULTIPART_FORM_DATA})
    @Produces({"application/xml", "application/json"})
    public Object insert(String json) throws Exception;

    @POST
    @Path("/update")
    @Consumes({"application/xml", "application/json", MediaType.MULTIPART_FORM_DATA})
    @Produces({"application/xml", "application/json"})
    public Object update(String json) throws Exception;

    @POST
    @Path("/delete")
    @Consumes({"application/xml", "application/json", MediaType.MULTIPART_FORM_DATA})
    @Produces({"application/xml", "application/json"})
    public Object delete(String json) throws Exception;

    @POST
    @Path("/test")
    public Object test(String json) throws Exception;

    @RequestMapping(value = "/testWithConsumes", method = {RequestMethod.POST},
            consumes = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public Object testWithConsumes(String json) throws Exception;

    @RequestMapping(value = "/testWithNonConsumes", method = {RequestMethod.POST})
    public Object testWithNonConsumes(String json) throws Exception;
}

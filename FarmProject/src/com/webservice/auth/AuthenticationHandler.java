package com.webservice.auth;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharingFilter;

public class AuthenticationHandler extends CrossOriginResourceSharingFilter {

	public AuthenticationHandler() {
		super();

	}

	@Override
	public void filter(ContainerRequestContext context) {
		MultivaluedMap<String, String> headerMap = context.getHeaders();
		String authorization = context.getHeaderString("Authorization");
		System.out.println(authorization);
		super.filter(context);
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
		MultivaluedMap<String, String> headerMap = requestContext.getHeaders();
		String authorization = requestContext.getHeaderString("Authorization");
		System.out.println(authorization);
		super.filter(requestContext, responseContext);
	}

}

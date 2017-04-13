package com.webservice.header;

import javax.ws.rs.Path;

@Path("/product")
public interface IProduct extends Operation{
	public void getDescription();
}

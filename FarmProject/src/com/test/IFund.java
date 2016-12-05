package com.test;

import javax.jws.WebService;

@WebService
public interface IFund {
	public Double getPrice(String fundId);
}

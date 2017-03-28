package com.test;

import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface = "com.test.IFund")

public class FundImpl implements IFund {
    private Map<String, Double> allFunds;
 
    public Map<String, Double> getAllFunds() {
        return allFunds;
    }

    public void setAllFunds(Map<String, Double> allFunds) {
        this.allFunds = allFunds;
    }

    @Override
    public Double getPrice(String fundId) {
        return allFunds.get(fundId);
    }
}

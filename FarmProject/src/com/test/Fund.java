package com.test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Fund")
public class Fund {
    private String fundId;
    private String fundName;
    private Double price;
    
    public String getFundId() {
        return fundId;
    }
    public void setFundId(String fundId) {
        this.fundId = fundId;
    }
    public String getFundName() {
        return fundName;
    }
    public void setFundName(String fundName) {
        this.fundName = fundName;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}

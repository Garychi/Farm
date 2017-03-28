package com.test;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Company")
public class Company {
    private String compId;
    private String compName;
    private Collection<Fund> funds;
    
    public String getCompId() {
        return compId;
    }
    public void setCompId(String compId) {
        this.compId = compId;
    }
    public String getCompName() {
        return compName;
    }
    public void setCompName(String compName) {
        this.compName = compName;
    }
    public Collection<Fund> getFunds() {
        return funds;
    }
    public void setFunds(Collection<Fund> funds) {
        this.funds = funds;
    }
}

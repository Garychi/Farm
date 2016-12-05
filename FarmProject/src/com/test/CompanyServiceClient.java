package com.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//import org.apache.cxf.jaxrs.client.WebClient;


public class CompanyServiceClient {
//	public static void main(String[] args) {
//        Company newCompany = new Company();
//        newCompany.setCompId("B001");
//        newCompany.setCompName("背得來");
//        
//        Fund fundBF001 = new Fund();
//        fundBF001.setFundId("BF001");
//        fundBF001.setFundName("美國高成長股票基金");
//        fundBF001.setPrice(90.92);
//        
//        Fund fundBF002 = new Fund();
//        fundBF002.setFundId("BF002");
//        fundBF002.setFundName("美加工業股票基金");
//        fundBF002.setPrice(66.88);
//        
//        Collection<Fund> fundsList = new ArrayList<Fund>();
//        fundsList.add(fundBF001);
//        fundsList.add(fundBF002);
//        newCompany.setFunds(fundsList);
//        
//        WebClient clientAddCompany = WebClient.create("http://localhost:8080/FarmProject");
//       Company comp1= clientAddCompany.path("companyService/company").accept("application/xml").post(newCompany, Company.class);
//        
//        WebClient clientAddFunds = WebClient.create("http://localhost:8080/FarmProject");
//        Company comp2=clientAddFunds.path("companyService/company/fund").accept("application/xml").post(newCompany, Company.class);
//		
//		WebClient client = WebClient.create("http://localhost:8080/FarmProject");
//		Company company = client.path("companyService/company/A001").accept("application/xml").get(Company.class);
//		
//		System.out.println("公司代號: " + company.getCompId());
//		System.out.println("公司名稱: " + company.getCompName());
//
//		String fundString = "companyService/company/" + company.getCompId() + "/funds";
//		WebClient clientFund = WebClient.create("http://localhost:8080/FarmProject");
//		Company companyFunds = clientFund.path(fundString).accept("application/xml").get(Company.class);
//
//		Iterator<Fund> iterator = companyFunds.getFunds().iterator();
//		while (iterator.hasNext()) {
//			Fund fund = iterator.next();
//			System.out.println("基金代號: " + fund.getFundId());
//			System.out.println("基金名稱: " + fund.getFundName());
//			System.out.println("基金淨值: " + fund.getPrice());
//		}
//	}
}

package com.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class CompanyDAO {
	private static Map<String, Company> companyMap = new HashMap<String, Company>();
	private static Map<String, Collection<Fund>> fundMap = new HashMap<String, Collection<Fund>>();

	static {
		Company company1 = new Company();
		company1.setCompId("A001");
		company1.setCompName("魔根");
		companyMap.put(company1.getCompId() , company1);

		Fund fund1 = new Fund();
		fund1.setFundId("AF001");
		fund1.setFundName("新興市場債券基金");
		fund1.setPrice(35.53);

		Fund fund2 = new Fund();
		fund2.setFundId("AF002");
		fund2.setFundName("希臘高收益債券基金");
		fund2.setPrice(0.33);

		Collection<Fund> fundsList = new ArrayList<Fund>();
		fundsList.add(fund1);
		fundsList.add(fund2);

		fundMap.put(company1.getCompId() , fundsList);
	}

	public void addCompany(Company company) {
		companyMap.put(company.getCompId() , company);
	}

	public void addFund(Company company) {
		fundMap.put(company.getCompId() , company.getFunds());
	}

	public Collection<Fund> getFunds(String compId) {
		return fundMap.get(compId);
	}

	public Company getCompany(String compId) {
		Company comp = null;
		if (companyMap.get(compId) != null) {
			comp = new Company();
			comp.setCompId(companyMap.get(compId).getCompId());
			comp.setCompName(companyMap.get(compId).getCompName());
		}
		return comp;
	}

	public void deleteCompany(String compId) {
		companyMap.remove(compId);
		fundMap.remove(compId);
	}

	public void updateCompany(Company company) {
		companyMap.put(company.getCompId() , company);
	}
}

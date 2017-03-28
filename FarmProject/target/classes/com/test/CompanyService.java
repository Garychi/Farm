package com.test;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/companyService")
@Produces("application/xml")
public class CompanyService {
	private CompanyDAO companyDAO = null;

	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	@GET
	@Path("/company/{compId}")
	public Company getCompany(@PathParam("compId") String compId) {
		Company company = (Company) getCompanyDAO().getCompany(compId);
		return company;
	}

	@POST
	@Path("/company")
	@Consumes("application/xml")
	public void addCompany(Company company) {
		getCompanyDAO().addCompany(company);
	}

	@DELETE
	@Path("/company/{compId}")
	public void deleteCompany(@PathParam("compId") String compId) {
		getCompanyDAO().deleteCompany(compId);
	}

	@PUT
	@Path("/company")
	public void updateCompany(Company company) {
		getCompanyDAO().updateCompany(company);
	}

	@POST
	@Path("/company/fund")
	@Consumes("application/xml")
	public void addBooks(Company company) {
		getCompanyDAO().addFund(company);
	}

	@GET
	@Path("/company/{compId}/funds")
	@Consumes("application/xml")
	public Company getFunds(@PathParam("compId") String compId) {
		Company company = (Company) getCompanyDAO().getCompany(compId);
		company.setFunds(getCompanyDAO().getFunds(compId));
		return company;
	}
}

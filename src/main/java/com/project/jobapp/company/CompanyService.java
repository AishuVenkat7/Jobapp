package com.project.jobapp.company;

import java.util.List;

public interface CompanyService {
	
	List<Company> getAllCompanies();
	Company getCompanyById(Long id);
	boolean updateCompany(Long id, Company updatedCompany);
	void createCompany(Company company);
	boolean deleteCompanyById(Long id);
	
}

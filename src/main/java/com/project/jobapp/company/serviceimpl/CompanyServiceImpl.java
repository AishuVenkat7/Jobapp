package com.project.jobapp.company.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.jobapp.company.Company;
import com.project.jobapp.company.CompanyRepository;
import com.project.jobapp.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}
	
	@Override
	public Company getCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public boolean updateCompany(Long id, Company updatedCompany) {
		Optional<Company> companyOptional = companyRepository.findById(id);
		if (companyOptional.isPresent()) {
			Company existingCompany = companyOptional.get();
			existingCompany.setDescription(updatedCompany.getDescription());
			existingCompany.setName(updatedCompany.getName());
			existingCompany.setJobs(updatedCompany.getJobs());
			companyRepository.save(existingCompany);
			return true;
		}
		return false;
	}

	@Override
	public void createCompany(Company company) {
		companyRepository.save(company);
	}

	@Override
	public boolean deleteCompanyById(Long id) {
		if (companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
			return true;
		}
		return false;
	}

}

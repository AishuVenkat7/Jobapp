package com.project.jobapp.company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies() {
		return ResponseEntity.ok(companyService.getAllCompanies());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
		Company company = companyService.getCompanyById(id);
		if(company != null)
			return ResponseEntity.ok(company);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updatedCompany) {
		boolean updated = companyService.updateCompany(id, updatedCompany);
		if (updated)
			return ResponseEntity.ok("Updated Successfully");
		return new ResponseEntity<>("Comapny not found", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/create")
	public ResponseEntity<String> createCompany(@RequestBody Company company) {
		companyService.createCompany(company);
		return new ResponseEntity<>("Company added Successfully", HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteCompany(@PathVariable Long id) {
		boolean isDeleted = companyService.deleteCompanyById(id);
		if (isDeleted)
			return ResponseEntity.ok("Deleted Successfully");
		return new ResponseEntity<>("Comapny not found", HttpStatus.NOT_FOUND);
	}

}

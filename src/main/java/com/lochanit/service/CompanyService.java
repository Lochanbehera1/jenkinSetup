package com.lochanit.service;

import com.lochanit.Entity.Company;

import java.util.List;

public interface CompanyService {
    void createCompany(Company company);
    List<Company> getAllCompany();
    Company getIdCompany(Long id);
    boolean deleteCompanyById(Long id);
    boolean updateCompanyById(Long id,Company updateCompany);

}

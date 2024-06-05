package com.lochanit.service;

import com.lochanit.Entity.Company;
import com.lochanit.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepo companyRepo;
    @Override
    public void createCompany(Company company) {
        companyRepo.save(company);
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepo.findAll();
    }

    @Override
    public Company getIdCompany(Long id) {
        return companyRepo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try {
            companyRepo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }


    }

    @Override
    public boolean updateCompanyById(Long id, Company updateCompany) {
        Optional<Company> upCompany = companyRepo.findById(id);
        if(upCompany.isPresent()){
            Company company = upCompany.get();
            company.setDescription(updateCompany.getDescription());
            company.setName(updateCompany.getName());
            company.setJobs(updateCompany.getJobs());
            companyRepo.save(company);
            return true;
        }else {
            return false;
        }



    }
}

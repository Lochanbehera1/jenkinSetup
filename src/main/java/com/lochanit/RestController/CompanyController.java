package com.lochanit.RestController;

import com.lochanit.Entity.Company;
import com.lochanit.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("company created successful",HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
        List<Company> all = companyService.getAllCompany();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getByIdCompany(@PathVariable Long id){
        Company idCompany = companyService.getIdCompany(id);
        return new ResponseEntity<>(idCompany,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
          companyService.deleteCompanyById(id);
     return new ResponseEntity<>("delete successfully",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company updateCompany){
        companyService.updateCompanyById(id,updateCompany);
        return new ResponseEntity<>("update successful",HttpStatus.OK);

    }
}

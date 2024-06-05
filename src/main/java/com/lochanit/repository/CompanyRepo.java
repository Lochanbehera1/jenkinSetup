package com.lochanit.repository;

import com.lochanit.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Long> {
}

package com.innoventes.test.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innoventes.test.app.entity.Company;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, Long> {

    //custom jpql query to find record by code
    @Query("SELECT c FROM  Company c WHERE c.companyCode = :code")
    Optional<Company> findByCode(String code);
}
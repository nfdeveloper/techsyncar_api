package com.nfsystems.techsyncar_api.company.repositories;

import com.nfsystems.techsyncar_api.company.models.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "SELECT c FROM Company c WHERE c.companyData.cnpj = :cnpj")
    Optional<Company> findByCnpj(String cnpj);
}

package com.nfsystems.techsyncar_api.company.repositories;

import com.nfsystems.techsyncar_api.company.models.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByCnpj(String cnpj);
}

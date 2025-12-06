package com.nfsystems.techsyncar_api.automotiveservice.repositories;

import com.nfsystems.techsyncar_api.automotiveservice.models.entity.AutomotiveService;
import com.nfsystems.techsyncar_api.company.models.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutomotiveServiceRepository extends JpaRepository<AutomotiveService, Long> {

    List<AutomotiveService> findByCompany(Company company);
}

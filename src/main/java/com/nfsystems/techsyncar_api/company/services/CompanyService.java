package com.nfsystems.techsyncar_api.company.services;

import com.nfsystems.techsyncar_api.common.services.BaseService;
import com.nfsystems.techsyncar_api.company.dto.CompanyRequest;
import com.nfsystems.techsyncar_api.company.mappers.CompanyMapper;
import com.nfsystems.techsyncar_api.company.models.entity.Company;
import com.nfsystems.techsyncar_api.company.repositories.CompanyRepository;
import com.nfsystems.techsyncar_api.exceptions.TSCAREntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService extends BaseService<Company, Long, CompanyRepository> {

    private CompanyMapper companyMapper;

    protected CompanyService(CompanyRepository repository,
                             CompanyMapper companyMapper) {
        super(repository);
        this.companyMapper = companyMapper;
    }

    @Transactional
    public Long create(CompanyRequest dto){
        Company company = companyMapper.toCompany(dto);
        return save(company).getId();
    }

    public Company findByCnpj(String cnpj) {
        return repository.findByCnpj(cnpj)
                .orElseThrow(() -> new TSCAREntityNotFoundException("Entidade não encontrada."));
    }
}

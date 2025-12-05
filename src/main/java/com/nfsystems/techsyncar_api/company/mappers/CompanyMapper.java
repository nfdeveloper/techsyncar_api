package com.nfsystems.techsyncar_api.company.mappers;

import com.nfsystems.techsyncar_api.company.dto.CompanyRequest;
import com.nfsystems.techsyncar_api.company.models.entity.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper {

    public Company toCompany(CompanyRequest dto){
        return Company.builder()
                .id(dto.id())
                .companyData(dto.companyData())
                .address(dto.address())
                .contact(dto.contact())
                .build();
    }
}

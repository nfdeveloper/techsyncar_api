package com.nfsystems.techsyncar_api.company.dto;

import com.nfsystems.techsyncar_api.common.models.entity.Address;
import com.nfsystems.techsyncar_api.common.models.entity.CompanyData;
import com.nfsystems.techsyncar_api.common.models.entity.Contact;

public record CompanyRequest(
        Long id,
        CompanyData companyData,
        Address address,
        Contact contact
) { }

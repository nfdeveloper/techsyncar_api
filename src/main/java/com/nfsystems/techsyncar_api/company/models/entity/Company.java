package com.nfsystems.techsyncar_api.company.models.entity;

import com.nfsystems.techsyncar_api.common.models.entity.Address;
import com.nfsystems.techsyncar_api.common.models.entity.BaseEntity;
import com.nfsystems.techsyncar_api.common.models.entity.CompanyData;
import com.nfsystems.techsyncar_api.common.models.entity.Contact;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tscar_seq_comp")
    private Long id;

    @Embedded
    private CompanyData companyData;

    @Embedded
    private Address address;

    @Embedded
    private Contact contact;
}

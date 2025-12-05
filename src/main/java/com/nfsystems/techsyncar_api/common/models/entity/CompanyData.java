package com.nfsystems.techsyncar_api.common.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class CompanyData {

    @Column(name = "tscar_cnpj_comp", length = 20, unique = true)
    private String cnpj;

    @Column(name = "tscar_comp_socra",length = 100)
    private String socialRationale;

    @Column(name = "tscar_comp_fn",length = 100)
    private String fantasyName;

}

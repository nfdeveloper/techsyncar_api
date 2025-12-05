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
public class Contact {

    @Column(name = "tscar_cont_em", length = 80, unique = true)
    private String email;

    @Column(name = "tscar_cont_em2", length = 80, unique = true)
    private String email2;

    @Column(name = "tscar_cont_cel_ph", length = 20, unique = true)
    private String cellPhone;

    @Column(name = "tscar_cont_cel_ph2", length = 20, unique = true)
    private String cellPhone2;

    @Column(name = "tscar_cont_ph", length = 20, unique = true)
    private String phone;

    @Column(name = "tscar_cont_ph2", length = 20, unique = true)
    private String phone2;
}

package com.nfsystems.techsyncar_api.automotiveservice.models.entity;

import com.nfsystems.techsyncar_api.common.models.entity.BaseEntity;
import com.nfsystems.techsyncar_api.company.models.entity.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "tscar_autserv",
        indexes = @Index(name = "idx_autser_nm", columnList = "tscar_autser_nm")
)
public class AutomotiveService extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tscar_seq_autser")
    private Long id;

    @Column(name = "tscar_autser_nm", length = 80)
    private String name;

    @Column(name = "tscar_autser_desc", length = 200)
    private String description;

    @Column(name = "tscar_autser_vl", scale = 2, precision = 16)
    private BigDecimal totalValue;

    @Column(name = "tscar_autser_prmvl", scale = 2, precision = 16)
    private BigDecimal promotionalValue;

    @Column(name = "tscar_autser_isprmvl")
    private Boolean promotional;

    @ManyToOne
    @JoinColumn(name = "tscar_seq_comp", referencedColumnName = "tscar_seq_comp")
    private Company company;
}

package com.nfsystems.techsyncar_api.automotiveservice.dto;

import java.math.BigDecimal;

public record AutomotiveServiceRequest(
        Long id,
        String name,
        String description,
        BigDecimal totalValue,
        BigDecimal promotionalValue,
        Long companyId
) { }

package com.nfsystems.techsyncar_api.automotiveservice.dto;

import java.math.BigDecimal;

public record AutomotiveServiceResponse(
        Long id,
        String name,
        String description,
        BigDecimal totalValue,
        BigDecimal promotionalValue,
        Boolean isPromocional,
        String status
) { }

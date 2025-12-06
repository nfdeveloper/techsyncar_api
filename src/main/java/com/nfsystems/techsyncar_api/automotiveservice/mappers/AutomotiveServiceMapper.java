package com.nfsystems.techsyncar_api.automotiveservice.mappers;

import com.nfsystems.techsyncar_api.automotiveservice.dto.AutomotiveServiceRequest;
import com.nfsystems.techsyncar_api.automotiveservice.dto.AutomotiveServiceResponse;
import com.nfsystems.techsyncar_api.automotiveservice.models.entity.AutomotiveService;
import org.springframework.stereotype.Service;

@Service
public class AutomotiveServiceMapper {

    public AutomotiveService toAutomotiveService(AutomotiveServiceRequest dto){
        return AutomotiveService.builder()
                .id(dto.id())
                .name(dto.name())
                .description(dto.description())
                .totalValue(dto.totalValue())
                .promotionalValue(dto.promotionalValue())
                .build();
    }

    public AutomotiveServiceResponse toResponse(AutomotiveService obj){
        return new AutomotiveServiceResponse(
                obj.getId(),
                obj.getName(),
                obj.getDescription(),
                obj.getTotalValue(),
                obj.getPromotionalValue(),
                obj.getPromotional(),
                obj.getStatus().getValue()
        );
    }
}

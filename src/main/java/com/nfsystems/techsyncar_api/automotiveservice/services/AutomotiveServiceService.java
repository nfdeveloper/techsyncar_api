package com.nfsystems.techsyncar_api.automotiveservice.services;

import com.nfsystems.techsyncar_api.automotiveservice.dto.AutomotiveServiceRequest;
import com.nfsystems.techsyncar_api.automotiveservice.dto.AutomotiveServiceResponse;
import com.nfsystems.techsyncar_api.automotiveservice.mappers.AutomotiveServiceMapper;
import com.nfsystems.techsyncar_api.automotiveservice.models.entity.AutomotiveService;
import com.nfsystems.techsyncar_api.automotiveservice.repositories.AutomotiveServiceRepository;
import com.nfsystems.techsyncar_api.common.services.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutomotiveServiceService extends BaseService<AutomotiveService, Long, AutomotiveServiceRepository> {

    private AutomotiveServiceMapper mapper;

    protected AutomotiveServiceService(
            AutomotiveServiceRepository repository,
            AutomotiveServiceMapper mapper
            ) {
        super(repository);
        this.mapper = mapper;
    }

    public AutomotiveServiceResponse findById(Long id){
        //TODO - Company by JWT Token
        return mapper.toResponse(findByIdBase(id));
    }

    public List<AutomotiveServiceResponse> list(){
        //TODO - Company by JWT Token
        return findAll().stream().map(mapper::toResponse).toList();
    }

    @Transactional
    public Long create(AutomotiveServiceRequest dto){
        AutomotiveService obj = mapper.toAutomotiveService(dto);
        //TODO - Setar Empresa por Token

        return save(obj).getId();
    }

}

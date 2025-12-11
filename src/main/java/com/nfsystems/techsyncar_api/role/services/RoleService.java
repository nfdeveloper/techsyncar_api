package com.nfsystems.techsyncar_api.role.services;

import com.nfsystems.techsyncar_api.exceptions.TSCAREntityNotFoundException;
import com.nfsystems.techsyncar_api.role.models.Role;
import com.nfsystems.techsyncar_api.role.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository repository;

    public Role findByName(String name){
        return repository
                .findByName(name)
                .orElseThrow(() -> new TSCAREntityNotFoundException("Permissão não encontrada."));
    }
}

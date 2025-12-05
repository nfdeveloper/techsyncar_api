package com.nfsystems.techsyncar_api.company.resources;

import com.nfsystems.techsyncar_api.company.dto.CompanyRequest;
import com.nfsystems.techsyncar_api.company.models.entity.Company;
import com.nfsystems.techsyncar_api.company.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@AllArgsConstructor
public class CompanyResource {

    private final CompanyService service;

    @GetMapping
    public ResponseEntity<List<Company>> list(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findByIdBase(id));
    }

    @GetMapping("cnpj/{cnpj}")
    public ResponseEntity<Company> findByCnpj(@PathVariable String cnpj){
        return ResponseEntity.ok().body(service.findByCnpj(cnpj));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CompanyRequest request){
        Long id = service.create(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}

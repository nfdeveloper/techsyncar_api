package com.nfsystems.techsyncar_api.automotiveservice.resources;

import com.nfsystems.techsyncar_api.automotiveservice.dto.AutomotiveServiceRequest;
import com.nfsystems.techsyncar_api.automotiveservice.dto.AutomotiveServiceResponse;
import com.nfsystems.techsyncar_api.automotiveservice.services.AutomotiveServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/automotive-service")
@AllArgsConstructor
public class AutomotiveServiceResource {

    private final AutomotiveServiceService service;

    @GetMapping
    public ResponseEntity<List<AutomotiveServiceResponse>> list(){
        return ResponseEntity.ok().body(service.list());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody AutomotiveServiceRequest dto){
        Long id = service.create(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}

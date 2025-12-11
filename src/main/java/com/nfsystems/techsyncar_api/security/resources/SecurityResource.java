package com.nfsystems.techsyncar_api.security.resources;

import com.nfsystems.techsyncar_api.security.dto.SecurityRequest;
import com.nfsystems.techsyncar_api.security.dto.SecurityResponse;
import com.nfsystems.techsyncar_api.security.services.SecurityService;
import com.nfsystems.techsyncar_api.user.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/security")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SecurityResource {

    private final SecurityService service;

    @PostMapping("register")
    public ResponseEntity<Void> register(
            @RequestBody UserRequest request
    ){
        service.register(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<SecurityResponse> auth(
            @RequestBody SecurityRequest request
            ){
        return ResponseEntity.ok(service.authenticate(request));
    }
}

package com.nfsystems.techsyncar_api.security.dto;

public record SecurityRequest(
        String email,
        String password
) {
}

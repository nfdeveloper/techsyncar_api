package com.nfsystems.techsyncar_api.user.dto;

public record UserRequest(
        Long id,
        String name,
        String nickname,
        String email,
        String password,
        boolean accountLocked,
        boolean enabled,
        String role,
        Long companyId
) { }

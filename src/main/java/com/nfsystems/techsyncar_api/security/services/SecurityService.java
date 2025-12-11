package com.nfsystems.techsyncar_api.security.services;

import com.nfsystems.techsyncar_api.role.repositories.RoleRepository;
import com.nfsystems.techsyncar_api.role.services.RoleService;
import com.nfsystems.techsyncar_api.security.dto.SecurityRequest;
import com.nfsystems.techsyncar_api.security.dto.SecurityResponse;
import com.nfsystems.techsyncar_api.user.dto.UserRequest;
import com.nfsystems.techsyncar_api.user.models.entity.User;
import com.nfsystems.techsyncar_api.user.repositories.UserRepository;
import com.nfsystems.techsyncar_api.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class SecurityService {

    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Transactional
    public void register(UserRequest request){
        var user = User.builder()
                .id(request.id())
                .name(request.name())
                .email(request.email())
                .nickname(request.nickname())
                .password(passwordEncoder.encode(request.password()))
                .enabled(Boolean.TRUE)
                .accountLocked(Boolean.FALSE)
                .build();
        if(Objects.nonNull(request.role())){
            user.setRoles(List.of(roleService.findByName(request.role())));
        }

        // TODO - Send email validation
        // TODO - Find and Add Company
        userService.save(user);
    }

    public SecurityResponse authenticate(SecurityRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        var claims = new HashMap<String, Object>();
        var user = ((User) auth.getPrincipal());
        claims.put("fullName", user.getName());
        var jwtToken = jwtService.generateToken(claims, user);

        return new SecurityResponse(jwtToken);
    }
}

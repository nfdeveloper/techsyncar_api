package com.nfsystems.techsyncar_api.user.models.entity;

import com.nfsystems.techsyncar_api.company.models.entity.Company;
import com.nfsystems.techsyncar_api.role.models.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tscar_user")
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tscar_user_name", length = 100, nullable = false)
    private String name;

    @Column(name = "tscar_user_nname", length = 80, nullable = false)
    private String nickname;

    @Column(name = "tscar_user_email", length = 80, nullable = false, unique = true)
    private String email;

    @Column(name = "tscar_user_pass",nullable = false)
    private String password;

    @Column(name = "tscar_user_aclocked")
    private boolean accountLocked;

    @Column(name = "tscar_user_acenable")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @ManyToOne
    @JoinColumn(name = "tscar_comp_id")
    private Company company;

    @CreatedDate
    @Column(name = "tscar_user_created_at",nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "tscar_user_updated_at",insertable = false)
    private LocalDateTime lastModifiedDate;


    @Override
    public String getName() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

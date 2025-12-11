package com.nfsystems.techsyncar_api.user.services;

import com.nfsystems.techsyncar_api.user.models.entity.User;
import com.nfsystems.techsyncar_api.user.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void save(User user) {
        repository.save(user);
    }
}
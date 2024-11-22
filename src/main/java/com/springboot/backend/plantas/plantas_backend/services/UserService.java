package com.springboot.backend.plantas.plantas_backend.services;

import java.util.List;
import java.util.Optional;

import com.springboot.backend.plantas.plantas_backend.entities.User;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    Optional<User> findByEmail(String email);
}

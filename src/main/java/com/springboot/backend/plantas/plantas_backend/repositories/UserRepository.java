package com.springboot.backend.plantas.plantas_backend.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.plantas.plantas_backend.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {


    Optional<User> findByEmail(String email);
}

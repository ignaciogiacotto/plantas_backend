package com.springboot.backend.plantas.plantas_backend.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.backend.plantas.plantas_backend.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    Optional<User> findByEmail(String email);

}

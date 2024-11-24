package com.springboot.backend.plantas.plantas_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.plantas.plantas_backend.entities.User;
import com.springboot.backend.plantas.plantas_backend.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public User save(User user) {
        // Aquí deberías agregar la lógica para cifrar la contraseña
        // antes de guardar el usuario
        return repository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }


    // Método para actualizar la contraseña de un usuario existente
    public void updateUserPassword(String email, String rawPassword) {
        User user = repository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        user.setPassword(passwordEncoder.encode(rawPassword));
        repository.save(user);
    }
}



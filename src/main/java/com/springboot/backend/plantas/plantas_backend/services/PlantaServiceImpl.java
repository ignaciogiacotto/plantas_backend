package com.springboot.backend.plantas.plantas_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.plantas.plantas_backend.entities.Planta;
import com.springboot.backend.plantas.plantas_backend.repositories.PlantaRepository;

@Service
public class PlantaServiceImpl implements PlantaService{

    private PlantaRepository repository;

    public PlantaServiceImpl(PlantaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Planta> findAll() {
        return (List<Planta>) this.repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Planta> findById(Long id) {
        return this.repository.findById(id);
    }

    @Transactional
    @Override
    public Planta save(Planta planta) {
        return this.repository.save(planta);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

}

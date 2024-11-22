package com.springboot.backend.plantas.plantas_backend.services;

import java.util.List;
import java.util.Optional;
import com.springboot.backend.plantas.plantas_backend.entities.Planta;

public interface PlantaService {

    List<Planta> findAll();

    Optional<Planta> findById(Long id);

    Planta save(Planta planta);

    void deleteById(Long id);

}

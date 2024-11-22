package com.springboot.backend.plantas.plantas_backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springboot.backend.plantas.plantas_backend.entities.Planta;

@Repository

public interface PlantaRepository extends CrudRepository<Planta, Long>{

}

package com.springboot.backend.plantas.plantas_backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.plantas.plantas_backend.entities.Planta;
import com.springboot.backend.plantas.plantas_backend.services.PlantaService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@RequestMapping("/api/plantas")
@CrossOrigin(origins = "http://localhost:4200")
public class PlantaController {

    @Autowired
    private PlantaService service;
    
    @GetMapping
    public List<Planta> list() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Optional<Planta> plantaOptional = service.findById(id);
        if (plantaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(plantaOptional.orElseThrow());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("Error", "Planta no encontrada"));
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Planta planta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(planta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planta> update(@PathVariable Long id, @RequestBody Planta planta) {
        Optional<Planta> plantaOptional = service.findById(id);
        if (plantaOptional.isPresent()) {
            Planta plantaDb = plantaOptional.get();
            plantaDb.setName(planta.getName());
            plantaDb.setCountry(planta.getCountry());
            return ResponseEntity.ok(service.save(plantaDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Planta> plantaOptional = service.findById(id);
        if (plantaOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

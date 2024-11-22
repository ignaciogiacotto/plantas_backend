package com.springboot.backend.plantas.plantas_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plantas")
public class Planta {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    private String country;
    private String flag;
    private String name;
    private Integer readings;
    private Integer mediumAlerts;
    private Integer highAlerts;
    private Integer disabledSensors;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getReadings() {
        return readings;
    }
    public void setReadings(Integer readings) {
        this.readings = readings;
    }
    public Integer getMediumAlerts() {
        return mediumAlerts;
    }
    public void setMediumAlerts(Integer mediumAlerts) {
        this.mediumAlerts = mediumAlerts;
    }
    public Integer getHighAlerts() {
        return highAlerts;
    }
    public void setHighAlerts(Integer highAlerts) {
        this.highAlerts = highAlerts;
    }
    public Integer getDisabledSensors() {
        return disabledSensors;
    }
    public void setDisabledSensors(Integer disabledSensors) {
        this.disabledSensors = disabledSensors;
    }
    
}

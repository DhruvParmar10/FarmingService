package com.example.crops.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "crops")
public class Crops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "farm_id")
    private Long farm_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFarm_id() {
        return farm_id;
    }

    public void setFarm_id(Long farm_id) {
        this.farm_id = farm_id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getSoil_moisture() {
        return soil_moisture;
    }

    public void setSoil_moisture(float soil_moisture) {
        this.soil_moisture = soil_moisture;
    }

    public float getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(float sensor_id) {
        this.sensor_id = sensor_id;
    }

    public float getpH_Level() {
        return pH_Level;
    }

    public void setpH_Level(float pH_Level) {
        this.pH_Level = pH_Level;
    }

    public float getLight_intensity() {
        return light_intensity;
    }

    public void setLight_intensity(float light_intensity) {
        this.light_intensity = light_intensity;
    }

    public float getCO2_level() {
        return CO2_level;
    }

    public void setCO2_level(float CO2_level) {
        this.CO2_level = CO2_level;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Column(name = "temperature")
    private float temperature;

    @Column(name = "humidity")
    private float humidity;

    @Column(name = "soil_moisture")
    private float soil_moisture;

    @Column(name = "sensor_id")
    private float sensor_id;

    @Column(name = "pH_Level")
    private float pH_Level;

    @Column(name = "light_intensity")
    private float light_intensity;

    @Column(name = "CO2_level")
    private float CO2_level;

    @CreationTimestamp
    private Instant timestamp;

}

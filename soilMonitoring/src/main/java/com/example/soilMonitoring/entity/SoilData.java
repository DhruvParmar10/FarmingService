package com.example.soilMonitoring.entity;


import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@Entity



public class SoilData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public double getMoisture() {
        return moisture;
    }

    public void setMoisture(double moisture) {
        this.moisture = moisture;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    private Long farmId;
    private double moisture;

    @CurrentTimestamp
    private LocalDateTime timestamp;
}

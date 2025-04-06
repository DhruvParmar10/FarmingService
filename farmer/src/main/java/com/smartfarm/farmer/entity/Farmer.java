package com.smartfarm.farmer.entity;

import com.smartfarm.farmer.entity.Farm;
import jakarta.persistence.*;

@Entity
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id")
    private Farm farm;


    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Farm getFarm() { return farm; }
    public void setFarm(Farm farm) { this.farm = farm; }

}
package com.smartfarm.farm.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
    private Set<Farmer> farmers;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public Set<Farmer> getFarmers() { return farmers; }
    public void setFarmers(Set<Farmer> farmers) { this.farmers = farmers; }
}
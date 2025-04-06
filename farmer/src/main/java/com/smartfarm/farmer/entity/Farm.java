package com.smartfarm.farmer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String location;
    private Double sizeInAcres;

//    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Farmer> farmers = new ArrayList<>();

    // Constructors
    public Farm() {}

    public Farm(String name, String location, Double sizeInAcres) {
        this.name = name;
        this.location = location;
        this.sizeInAcres = sizeInAcres;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public Double getSizeInAcres() { return sizeInAcres; }
    public void setSizeInAcres(Double sizeInAcres) { this.sizeInAcres = sizeInAcres; }
//    public List<Farmer> getFarmers() { return farmers; }
}
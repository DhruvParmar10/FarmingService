package com.example.crops.service;

import com.example.crops.entity.Crops;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;


public interface CropService {
    public Crops createCrops(Crops crops);
    public List<Crops> getAllCrops();
    Optional<Crops> getCropsById(Long id);
    void deleteCrops(Long id);
    public List<Crops> getLatestData();
}



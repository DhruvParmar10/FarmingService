package com.example.crops.service;

import com.example.crops.entity.Crops;
import com.example.crops.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropServiceImp implements CropService {

    @Autowired
    CropRepository repository;

    @Override
    public Crops createCrops(Crops crops) {
        return repository.save(crops);
    }

    @Override
    public List<Crops> getAllCrops() {
        return repository.findAll();
    }

    @Override
    public Optional<Crops> getCropsById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteCrops(Long id) {
        Crops existingCrop = repository.findById(id).orElseThrow(() -> new RuntimeException("Crop not found"));
        repository.delete(existingCrop);
    }

    @Override
    public List<Crops> getLatestData() {
        return repository.findAll();
    }
}

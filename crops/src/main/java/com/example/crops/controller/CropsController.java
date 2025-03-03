package com.example.crops.controller;


import com.example.crops.entity.Crops;
import com.example.crops.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("crops")
public class CropsController {
    @Autowired
    CropService cropService;

    @PostMapping("/create")
    public ResponseEntity<Crops> createCrops(@RequestBody Crops crops) {
        Crops createdCrops = cropService.createCrops(crops);
        return new ResponseEntity<>(createdCrops, HttpStatus.CREATED);
    }

    // Retrieve all users
    @GetMapping("/get")
    public ResponseEntity<List<Crops>> getAllCrops() {
        List<Crops> crops = cropService.getAllCrops();
        return new ResponseEntity<>(crops, HttpStatus.OK);
    }

    // Retrieve a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Crops>> getCropsById(@PathVariable Long id) {
        // Use orElseThrow to throw an exception if the user is not found
        Optional<Crops> cropsById = cropService.getCropsById(id);

        return new ResponseEntity<>(cropsById, HttpStatus.OK);
    }

    // Retrieve all users
    @GetMapping("/getAll")
    public ResponseEntity<List<Crops>> getAllUsers() {
        List<Crops> latestData = cropService.getLatestData();
        return new ResponseEntity<>(latestData, HttpStatus.OK);
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        cropService.deleteCrops(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }








}

package com.smartfarm.farmer.controller;
import com.smartfarm.farmer.entity.Farm;
import com.smartfarm.farmer.entity.Farmer;
import com.smartfarm.farmer.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smartfarm/farmers")
public class FarmerController {

    private final FarmerService farmerService;

    @Autowired
    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping("")
    public ResponseEntity<Farmer> createFarmer(@RequestBody Farmer farmer) {
        return ResponseEntity.ok(farmerService.createFarmer(farmer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farmer> getFarmer(@PathVariable Long id) {
        return ResponseEntity.ok(farmerService.getFarmerById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Farmer>> getAllFarmers() {
        return ResponseEntity.ok(farmerService.getAllFarmers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farmer> updateFarmer(
            @PathVariable Long id,
            @RequestBody Farmer farmerDetails) {
        return ResponseEntity.ok(farmerService.updateFarmer(id, farmerDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{farmerId}/assign-farm/{farmId}")
    public ResponseEntity<Farmer> assignFarmToFarmer(
            @PathVariable Long farmerId,
            @PathVariable Long farmId) {
        return ResponseEntity.ok(farmerService.assignFarmToFarmer(farmerId, farmId));
    }
}
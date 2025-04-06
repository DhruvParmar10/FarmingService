package com.smartfarm.farmer.controller;

import com.smartfarm.farmer.entity.Farm;
import com.smartfarm.farmer.service.FarmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smartfarm/farms")
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping("")
    public ResponseEntity<Farm> createFarm(@RequestBody Farm farm) {
        return ResponseEntity.ok(farmService.createFarm(farm));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarm(@PathVariable Long id) {
        return ResponseEntity.ok(farmService.getFarmById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Farm>> getAllFarms() {
        return ResponseEntity.ok(farmService.getAllFarms());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farm> updateFarm(
            @PathVariable Long id,
            @RequestBody Farm farmDetails) {
        return ResponseEntity.ok(farmService.updateFarm(id, farmDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarm(@PathVariable Long id) {
        farmService.deleteFarm(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Farm>> getFarmsByLocation(
            @PathVariable String location) {
        return ResponseEntity.ok(farmService.getFarmsByLocation(location));
    }
}
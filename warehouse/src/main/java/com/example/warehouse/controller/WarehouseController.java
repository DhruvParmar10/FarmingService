package com.example.warehouse.controller;

import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/warehouse")

public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/ware")
    public ResponseEntity<Warehouse> createCrops(@RequestBody Warehouse warehouse) {
        Warehouse createdData = warehouseService.EntryWarehouseData(warehouse);
        return new ResponseEntity<>(createdData, HttpStatus.CREATED);
    }

    // Retrieve all users
    @GetMapping("/getAll")
    public ResponseEntity<List<Warehouse>> getAllCrops() {
        List<Warehouse> warehouse =  warehouseService.getAllStock();
        return new ResponseEntity<>(warehouse, HttpStatus.OK);
    }

    // Retrieve a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Warehouse>> getCropsById(@PathVariable Long id) {
        // Use orElseThrow to throw an exception if the user is not found
        Optional<Warehouse> currentStock =  warehouseService.getCurrentStock(id);

        return new ResponseEntity<>(currentStock, HttpStatus.OK);
    }

    // Retrieve all users
    @GetMapping("/getLatest")
    public ResponseEntity<List<Warehouse>> getLatestData() {
        List<Warehouse> latestData =  warehouseService.getLatestData();
        return new ResponseEntity<>(latestData, HttpStatus.OK);
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> ExitWarehouseData(@PathVariable Long id) {
        warehouseService.ExitWarehouseData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

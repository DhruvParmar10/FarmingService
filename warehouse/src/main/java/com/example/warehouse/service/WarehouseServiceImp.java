package com.example.warehouse.service;

import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.repository.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImp implements WarehouseService{
    @Autowired
    WarehouseRepo repo;


    @Override
    public Warehouse EntryWarehouseData(Warehouse warehouse) {
        return repo.save(warehouse);
    }

    @Override
    public List<Warehouse> getAllStock() {
        return repo.findAll();
    }

    @Override
    public Optional<Warehouse> getCurrentStock(Long id) {
        return repo.findById(id);
    }

    @Override
    public void ExitWarehouseData(Long id) {
        Warehouse existingWarehouse = repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        repo.delete(existingWarehouse);
    }

    @Override
    public List<Warehouse> getLatestData() {
        return repo.findAll();
    }
}

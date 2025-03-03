package com.example.warehouse.service;

import com.example.warehouse.entity.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {
        public Warehouse EntryWarehouseData(Warehouse warehouse); //create
        public List<Warehouse> getAllStock();
        Optional<Warehouse> getCurrentStock(Long id);
        void ExitWarehouseData(Long id);   //delete
        public List<Warehouse> getLatestData();
    }


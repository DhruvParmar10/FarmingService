package com.example.warehouse.repository;


import com.example.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse,Long> {
}

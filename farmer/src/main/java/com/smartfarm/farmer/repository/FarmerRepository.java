package com.smartfarm.farmer.repository;

import com.smartfarm.farmer.entity.Farm;
import com.smartfarm.farmer.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {
}

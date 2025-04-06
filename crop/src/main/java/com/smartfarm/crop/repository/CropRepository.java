package com.smartfarm.crop.repository;

import com.smartfarm.crop.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {
    List<Crop> findByFarmId(Long farmId);
}

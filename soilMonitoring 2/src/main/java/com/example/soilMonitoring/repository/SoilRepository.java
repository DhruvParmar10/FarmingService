package com.example.soilMonitoring.repository;

import com.example.soilMonitoring.entity.SoilData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SoilRepository extends JpaRepository<SoilData, Long> {
    static List<SoilData> findByFarmIdAndTimestampAfter(Long farmId, LocalDateTime after) {
        return null;
    }


}

package com.smartfarm.farmer.repository;

import com.smartfarm.farmer.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FarmRepository extends JpaRepository<Farm,Long> {
    // Find farms by location
    List<Farm> findByLocation(String location);

    // Custom query for large farms
    @Query("SELECT f FROM Farm f WHERE f.sizeInAcres >= :minSize")
    List<Farm> findLargeFarms(Double minSize);

    // Eagerly load farmers with farm
//    @Query("SELECT f FROM Farm f LEFT JOIN FETCH f.farmers WHERE f.id = :id")
//    Optional<Farm> findWithFarmers(Long id);
}

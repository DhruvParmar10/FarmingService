package com.smartfarm.farmer.service;

import com.smartfarm.farmer.entity.Farm;

import java.util.List;

public interface FarmService {
    Farm createFarm(Farm farm);
    Farm getFarmById(Long id);
    List<Farm> getAllFarms();
    Farm updateFarm(Long id, Farm farm);
    void deleteFarm(Long id);
    List<Farm> getFarmsByLocation(String location);
//    Farm addFarmerToFarm(Long farmId, Long farmerId);
}

package com.smartfarm.farmer.service;

import com.smartfarm.farmer.entity.Farm;
import com.smartfarm.farmer.entity.Farmer;
import java.util.List;

public interface FarmerService {
    Farmer createFarmer(Farmer farmer);
    Farmer assignFarmToFarmer(Long farmerId, Long farmId);
    Farmer getFarmerById(Long id);
    List<Farmer> getAllFarmers();
    Farmer updateFarmer(Long id, Farmer farmer);
    void deleteFarmer(Long id);
}
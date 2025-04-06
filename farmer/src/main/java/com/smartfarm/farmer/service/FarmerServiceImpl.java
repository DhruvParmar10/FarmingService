package com.smartfarm.farmer.service;

import com.smartfarm.farmer.entity.Farm;
import com.smartfarm.farmer.entity.Farmer;
import com.smartfarm.farmer.repository.FarmRepository;
import com.smartfarm.farmer.repository.FarmerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FarmerServiceImpl implements FarmerService {

    private final FarmerRepository farmerRepository;
    private final FarmRepository farmRepository;

    @Autowired
    public FarmerServiceImpl(FarmerRepository farmerRepository,FarmRepository farmRepository) {
        this.farmerRepository = farmerRepository;
        this.farmRepository = farmRepository;
    }

    @Override
    public Farmer createFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    @Override
    public Farmer getFarmerById(Long id) {
        return farmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
    }

    @Override
    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }

    @Override
    public Farmer updateFarmer(Long id, Farmer farmerDetails) {
        Farmer farmer = getFarmerById(id);
        farmer.setName(farmerDetails.getName());
        return farmerRepository.save(farmer);
    }

    @Override
    public void deleteFarmer(Long id) {
        farmerRepository.deleteById(id);
    }

    @Override
    public Farmer assignFarmToFarmer(Long farmerId, Long farmId) {
        Farmer farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        Farm farm = farmRepository.findById(farmId)
                .orElseThrow(() -> new RuntimeException("Farm not found"));

        farmer.setFarm(farm);
        return farmerRepository.save(farmer);
    }
}
package com.smartfarm.farmer.service;

import com.smartfarm.farmer.entity.Farm;
import com.smartfarm.farmer.entity.Farmer;
import com.smartfarm.farmer.repository.FarmRepository;
import com.smartfarm.farmer.repository.FarmerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final FarmerRepository farmerRepository;

    public FarmServiceImpl(FarmRepository farmRepository,
                           FarmerRepository farmerRepository) {
        this.farmRepository = farmRepository;
        this.farmerRepository = farmerRepository;
    }

    @Override
    @Transactional
    public Farm createFarm(Farm farm) {
        return farmRepository.save(farm);
    }

    @Override
    public Farm getFarmById(Long id) {
        return farmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farm not found"));
    }

    @Override
    public List<Farm> getAllFarms() {
        return farmRepository.findAll();
    }

    @Override
    @Transactional
    public Farm updateFarm(Long id, Farm farmDetails) {
        Farm farm = getFarmById(id);
        farm.setName(farmDetails.getName());
        farm.setLocation(farmDetails.getLocation());
        farm.setSizeInAcres(farmDetails.getSizeInAcres());
        return farmRepository.save(farm);
    }

    @Override
    @Transactional
    public void deleteFarm(Long id) {
        farmRepository.deleteById(id);
    }

    @Override
    public List<Farm> getFarmsByLocation(String location) {
        return farmRepository.findByLocation(location);
    }
}

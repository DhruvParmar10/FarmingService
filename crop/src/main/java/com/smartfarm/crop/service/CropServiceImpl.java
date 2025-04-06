package com.smartfarm.crop.service;

import com.smartfarm.crop.entity.Crop;
import com.smartfarm.crop.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropServiceImpl implements CropService {
    @Autowired
    private CropRepository cropRepository;

    public Crop saveCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public List<Crop> getCropsByFarmId(Long farmId) {
        return cropRepository.findByFarmId(farmId);
    }
}

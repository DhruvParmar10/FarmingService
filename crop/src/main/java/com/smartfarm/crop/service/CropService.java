package com.smartfarm.crop.service;

import com.smartfarm.crop.entity.Crop;

import java.util.List;

public interface CropService {
    Crop saveCrop(Crop crop);
    List<Crop> getCropsByFarmId(Long farmId);
}

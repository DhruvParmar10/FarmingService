package com.example.soilMonitoring.service;

import com.example.soilMonitoring.entity.SoilData;
import com.example.soilMonitoring.repository.SoilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoilService {

    @Autowired
    private SoilRepository soilRepository;

    public SoilData saveSoilData(SoilData soilData) {
        return soilRepository.save(soilData);
    }
}


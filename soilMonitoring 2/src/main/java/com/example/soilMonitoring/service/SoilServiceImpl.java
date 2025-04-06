package com.example.soilMonitoring.service;

import com.example.soilMonitoring.entity.SoilData;
import com.example.soilMonitoring.repository.SoilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SoilServiceImpl extends SoilService {

    @Autowired
    private SoilRepository soilRepository;

    @Override
    public SoilData saveSoilData(SoilData data) {
        if (data.getTimestamp() == null) {
            data.setTimestamp(LocalDateTime.now());
        }
        return soilRepository.save(data);
    }
}

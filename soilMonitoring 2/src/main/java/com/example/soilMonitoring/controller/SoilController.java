package com.example.soilMonitoring.controller;

import com.example.soilMonitoring.entity.SoilData;
import com.example.soilMonitoring.repository.SoilRepository;
import com.example.soilMonitoring.service.SoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/soil")
public class SoilController {

    @Autowired
    private SoilRepository soilRepository;

    @Autowired
    private SoilService soilService;
    
    @PostMapping
    public SoilData saveData(@RequestBody SoilData data) {
        return soilService.saveSoilData(data);
    }

    @GetMapping("/farm/getall")
    public List<SoilData> getAll() {
        return soilRepository.findAll();
    }

    @GetMapping("/farm/{farmId}")
    public List<SoilData> getData(
            @PathVariable Long farmId,
            @RequestParam(defaultValue = "7") int days) {

        return SoilRepository.findByFarmIdAndTimestampAfter(
                farmId, LocalDateTime.now().minusDays(days));


    }
}

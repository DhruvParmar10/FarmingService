package com.smartfarm.crop.controller;

import com.smartfarm.crop.entity.Crop;
import com.smartfarm.crop.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crops")
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping
    public ResponseEntity<Crop> addCrop(@RequestBody Crop crop) {
        return new ResponseEntity<>(cropService.saveCrop(crop), HttpStatus.CREATED);
    }

    @GetMapping("/farm/{farmId}")
    public ResponseEntity<List<Crop>> getCropsByFarm(@PathVariable Long farmId) {
        return new ResponseEntity<>(cropService.getCropsByFarmId(farmId), HttpStatus.OK);
    }
}

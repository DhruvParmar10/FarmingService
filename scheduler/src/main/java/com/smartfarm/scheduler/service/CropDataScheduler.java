package com.smartfarm.scheduler.service;

import com.smartfarm.scheduler.client.CropMoniteringClient;
import com.smartfarm.scheduler.client.SoilMonitoringClient;
import com.smartfarm.scheduler.entity.CropData;
import com.smartfarm.scheduler.entity.SoilData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CropDataScheduler {

    @Autowired
    private CropMoniteringClient cropMoniteringClient;

    private final Random random = new Random();

    @Scheduled(cron = "*/15 * * * * *")  // every 5 minutes
    public void generateCropData() {
        CropData data = new CropData(expectedYieldRand(), growthStageRand(), cropTypeRand(),farmIdRand());
        cropMoniteringClient.createCropData(data);
        System.out.println("Sent soil data: " + data);
    }

    private Double expectedYieldRand() {
        return 1.0 + (4.0 * random.nextDouble());
    }

    // Plant growth stage
    private String growthStageRand() {
        String[] stages = {"Germination", "Vegetative", "Budding", "Flowering", "Ripening"};
        return stages[random.nextInt(stages.length)];
    }

    // Crop type
    private String cropTypeRand() {
        String[] types = {"Wheat", "Corn", "Soybean", "Rice", "Barley"};
        return types[random.nextInt(types.length)];
    }

    // Soil pH level
    private Double soilPhRand() {
        return 5.5 + (2.0 * random.nextDouble());
    }

    // Farm ID
    private Integer farmIdRand() {
        return 1 + random.nextInt(10);
    }

    // Moisture percentage (30-70%)
}

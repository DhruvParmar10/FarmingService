package com.smartfarm.scheduler.service;

import com.smartfarm.scheduler.client.SoilMonitoringClient;
import com.smartfarm.scheduler.entity.SoilData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SoilDataScheduler {

    @Autowired
    private SoilMonitoringClient soilMonitoringClient;

    private final Random random = new Random();

    @Scheduled(cron = "*/10 * * * * *")  // every 5 minutes
    public void generateSoilData() {
        SoilData data = new SoilData(randomFarmId(), randomMoisture(), randomPH());
        soilMonitoringClient.createSoilData(data);
        System.out.println("Sent soil data: " + data);
    }

    private Long randomFarmId() {
        return (long) (1 + random.nextInt(5));
    }

    private double randomMoisture() {
        return 10 + (30 - 10) * random.nextDouble();
    }

    private double randomPH() {
        return 5.5 + (7.5 - 5.5) * random.nextDouble();
    }
}

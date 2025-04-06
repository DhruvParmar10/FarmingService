package com.smartfarm.scheduler.client;

import com.smartfarm.scheduler.entity.SoilData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "soilMonitoring", url = "http://localhost:9090") // adjust URL
public interface SoilMonitoringClient {

    @PostMapping("/soil")
    void createSoilData(@RequestBody SoilData data);
}



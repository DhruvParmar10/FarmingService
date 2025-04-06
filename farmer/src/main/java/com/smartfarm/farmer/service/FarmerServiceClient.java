package com.smartfarm.farmer.service;

import com.smartfarm.farmer.entity.Farmer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "farmer-service", url = "${farmer.service.url}")
public interface FarmerServiceClient {
    @GetMapping("/api/farmers/{id}")
    Farmer getFarmerById(@PathVariable Long id);
}
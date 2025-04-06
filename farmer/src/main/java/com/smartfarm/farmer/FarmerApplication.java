package com.smartfarm.farmer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.smartfarm.farmer.client")
public class FarmerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmerApplication.class, args);
	}

}

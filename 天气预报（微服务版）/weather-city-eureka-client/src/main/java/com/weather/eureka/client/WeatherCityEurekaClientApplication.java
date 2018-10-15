package com.weather.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeatherCityEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherCityEurekaClientApplication.class, args);
	}
}

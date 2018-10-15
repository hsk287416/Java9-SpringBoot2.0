package com.weather.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.weather.eureka.client.service.WeatherDataService;
import com.weather.eureka.client.vo.WeatherResponse;

@RestController
public class WeatherController {
    
    @Autowired
    private WeatherDataService weatherDataService;
    
    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }
}

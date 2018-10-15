package com.weather.eureka.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.eureka.client.service.CityDataService;
import com.weather.eureka.client.vo.City;

@RestController
public class CityController {
    @Autowired
    private CityDataService cityDataService;
    
    @GetMapping("/list")
    public List<City> list() throws Exception {
        return cityDataService.listCity();
    }
}

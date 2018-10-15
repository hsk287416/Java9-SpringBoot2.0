package com.weather.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.eureka.client.service.WeatherReportService;
import com.weather.eureka.client.vo.Weather;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    
    @GetMapping("/cityId/{cityId}")
    public Weather getReportByCityId(@PathVariable("cityId") String cityId) {
        
        return weatherReportService.getDataByCityId(cityId);
    }
}

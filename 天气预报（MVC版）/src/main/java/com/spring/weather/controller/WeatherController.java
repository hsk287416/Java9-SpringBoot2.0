package com.spring.weather.controller;

import com.spring.weather.service.IWeatherData;
import com.spring.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/data")
public class WeatherController {

    @Autowired
    private IWeatherData iWeatherData;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId) {
        return iWeatherData.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getDataByCityName(@PathVariable("cityName") String cityName) {
        return iWeatherData.getDataByCityName(cityName);
    }
}

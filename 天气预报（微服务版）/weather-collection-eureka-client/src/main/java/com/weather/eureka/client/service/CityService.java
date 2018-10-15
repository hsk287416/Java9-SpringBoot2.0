package com.weather.eureka.client.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.weather.eureka.client.vo.City;

@FeignClient("weather-zuul")
public interface CityService {

    @GetMapping("/city/list")
    List<City> getCityList() throws Exception;
}

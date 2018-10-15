package com.weather.eureka.client.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.weather.eureka.client.vo.City;
import com.weather.eureka.client.vo.WeatherResponse;

@FeignClient("weather-zuul")
public interface DataClient {
    @GetMapping("/city/list")
    List<City> getCityList() throws Exception;
    
    /**
     * 通过城市ID获取天气信息
     * @param cityId
     * @return
     */
    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}

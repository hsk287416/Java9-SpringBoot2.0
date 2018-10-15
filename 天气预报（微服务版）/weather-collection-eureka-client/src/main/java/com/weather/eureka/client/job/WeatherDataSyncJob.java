package com.weather.eureka.client.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.weather.eureka.client.service.CityService;
import com.weather.eureka.client.service.WeatherDataCollectionService;
import com.weather.eureka.client.vo.City;

import lombok.extern.slf4j.Slf4j;

/**
 * 定时获取天气信息
 */
@Slf4j
@Service
public class WeatherDataSyncJob {

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityService cityService;
    
    @Scheduled(initialDelay = 0, fixedDelay = 1800000)
    public void syncWeatherData() {
        log.info("Weather Data Sync Job. Start！");
        // 获取城市ID列表
        List<City> cityList = null;
        
        try {
            cityList = cityService.getCityList(); // 由城市数据API微服务提供数据
        } catch (Exception e) {
            log.error("Exception!", e);
        }
        
        // 遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            log.info("Weather Data Sync Job, cityId:" + cityId);
            
            weatherDataCollectionService.syncDateByCityId(cityId);
        }
        
        log.info("Weather Data Sync Job. End！");
    }
}

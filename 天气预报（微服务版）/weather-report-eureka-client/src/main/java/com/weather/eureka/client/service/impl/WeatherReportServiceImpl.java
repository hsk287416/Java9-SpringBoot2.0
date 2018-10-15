package com.weather.eureka.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.eureka.client.service.DataClient;
import com.weather.eureka.client.service.WeatherReportService;
import com.weather.eureka.client.vo.Weather;
import com.weather.eureka.client.vo.WeatherResponse;

@Service("weatherReportService")
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;
    
    @Override
    public Weather getDataByCityId(String cityId) {
        
        // 由天气数据API微服务来提供
        WeatherResponse resp = dataClient.getDataByCityId(cityId);
        Weather data = resp.getData();
        return data;
    }

}

package com.weather.eureka.client.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.eureka.client.service.WeatherDataService;
import com.weather.eureka.client.vo.WeatherResponse;

import lombok.extern.slf4j.Slf4j;

@Service("weatherDataService")
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return this.doGetWeahter(cityId);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
//        String uri = WEATHER_URI + "city=" + cityName;
        // TODO 通过城市名称获取城市ID
        String cityId = "";
        return this.doGetWeahter(cityId);
    }
    
    private WeatherResponse doGetWeahter(String cityId) {
        String key = "weather_data_" + cityId;
        log.info("key: {}", key);
        String strBody = null;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        ValueOperations<String, String>  ops = stringRedisTemplate.opsForValue();
        // 先查缓存，缓存有的取缓存中的数据
        if (stringRedisTemplate.hasKey(key)) {
            log.info("Redis has data");
            strBody = ops.get(key);
        } else {
            log.info("Redis don't has data");
            // 缓存没有，抛出异常
            throw new RuntimeException("Don't has data!");
        }

        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            //e.printStackTrace();
            log.error("Error!",e);
        }
        
        return resp;
    }

}

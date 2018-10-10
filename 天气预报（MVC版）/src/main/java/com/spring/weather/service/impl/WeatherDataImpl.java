package com.spring.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.weather.service.IWeatherData;
import com.spring.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Slf4j
@Service("iWeatherData")
@CacheConfig(cacheNames = "weather_cache")
public class WeatherDataImpl implements IWeatherData {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Cacheable(sync = true, key = "'weacher_data' + #cityId")
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    @Override
    @Cacheable(sync = true, key = "'weacher_data' + #cityName")
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    /**
     * 通过HTTP通信，获取远程天气信息
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeather(String uri) {
        log.info("通过HTTP请求获取天气信息...");
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        String strBody = null;

        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }

        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resp;
    }
}

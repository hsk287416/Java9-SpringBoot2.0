package com.spring.weather.service;

import com.spring.weather.vo.WeatherResponse;

public interface IWeatherData {

    /**
     * 根据城市ID查询天气数据
     * @param cityId 城市ID
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     * @param cityName 城市名称
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}

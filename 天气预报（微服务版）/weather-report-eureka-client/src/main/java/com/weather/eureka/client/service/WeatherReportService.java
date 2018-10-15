package com.weather.eureka.client.service;

import com.weather.eureka.client.vo.Weather;

public interface WeatherReportService {
    
    /**
     * 根据城市ID获取天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}

package com.weather.eureka.client.service;

import java.util.List;

import com.weather.eureka.client.vo.City;

public interface CityDataService {
    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}

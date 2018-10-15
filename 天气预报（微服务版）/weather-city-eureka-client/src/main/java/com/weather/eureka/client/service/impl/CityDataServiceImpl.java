package com.weather.eureka.client.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.weather.eureka.client.service.CityDataService;
import com.weather.eureka.client.util.XmlBuilder;
import com.weather.eureka.client.vo.City;
import com.weather.eureka.client.vo.CityList;

@Service("cityDataService")
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        // 读取XML文件
        Resource resource = new ClassPathResource("city-list.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        
        while ((line = br.readLine()) !=null) {
            buffer.append(line);
        }
        
        br.close();

        // XML转为Java对象
        CityList cityList = XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }

}

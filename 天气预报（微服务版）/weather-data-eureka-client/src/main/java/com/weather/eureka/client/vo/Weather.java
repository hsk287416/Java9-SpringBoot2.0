package com.weather.eureka.client.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Weather implements Serializable {

    private static final long serialVersionUID = 1L;

    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yeaterday yesterday;
    private List<Forecast> forecast;
}

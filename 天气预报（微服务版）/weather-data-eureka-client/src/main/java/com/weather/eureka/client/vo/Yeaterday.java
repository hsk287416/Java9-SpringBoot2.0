package com.weather.eureka.client.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Yeaterday implements Serializable {
    private static final long serialVersionUID = 1L;

    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}

package com.weatherapp.forecast.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private Integer state;
    private String text;
    private String icon;
}

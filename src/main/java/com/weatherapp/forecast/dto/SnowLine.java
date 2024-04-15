package com.weatherapp.forecast.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SnowLine {
    private Double avg;
    private Double min;
    private Double max;
    private String unit;
}

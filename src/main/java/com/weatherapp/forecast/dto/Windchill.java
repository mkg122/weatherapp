package com.weatherapp.forecast.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Windchill {
    private Double min;
    private Double max;
    private Double avg;
}

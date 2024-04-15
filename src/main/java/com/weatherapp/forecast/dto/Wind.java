package com.weatherapp.forecast.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wind {
    private String unit;
    private String direction;
    private Double avg;
    private WindGusts gusts;
    private Boolean significationWind;
}

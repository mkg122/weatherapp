package com.weatherapp.forecast.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class HourlyForecastItem {
    private Date date;
    private Integer period;
    private Double freshSnow;
    private Weather weather;
    private Precipitation prec;
    private Double sunHours;
    private Double rainHours;
    private Temperature temperature;
    private Double pressure;
    private Integer relativeHumidity;
    private Clouds clouds;
    private Wind wind;
    private Windchill windchill;
    private SnowLine snowLine;
    private Boolean isNight;
}

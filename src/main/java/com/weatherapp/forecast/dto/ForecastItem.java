package com.weatherapp.forecast.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForecastItem {
    private String date;
    private String dateWithTimezone;
    private Double freshSnow;
    private Double snowHeight;
    private Weather weather;
    private Precipitation prec;
    private Double sunHours;
    private Double rainHours;
    private Temperature temperature;
    private Wind wind;
    private Windchill windchill;
    private SnowLine snowLine;
    private Astronomy astronomy;
}

package com.weatherapp.forecast.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Forecast {

    private List<ForecastItem> items;
    private Date forecastDate;
    private Date nextUpdate;
    private String source;
    private String point;
    private String fingerprint;
}

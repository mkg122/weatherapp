package com.weatherapp.forecast.service;

public interface ForecastApi {
    public Object getForecastSummary(String city);

    public Object setForecastHourly(String city);
}

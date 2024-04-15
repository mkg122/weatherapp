package com.weatherapp.forecast.service;

public interface ForecastService {
    Object getForecastSummary(String city);

    Object getForecastHourly(String city);
}

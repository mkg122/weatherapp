package com.weatherapp.forecast.service;

import com.weatherapp.forecast.dto.ForecastSummaryDTO;
import com.weatherapp.forecast.dto.HourlyForecastDTO;

public interface ForecastApi {
    public ForecastSummaryDTO getForecastSummary(String city);

    public HourlyForecastDTO getForecastHourly(String city);
}

package com.weatherapp.forecast.service;

import com.weatherapp.forecast.dto.ForecastSummaryDTO;
import com.weatherapp.forecast.dto.HourlyForecastDTO;

public interface ForecastService {
    ForecastSummaryDTO getForecastSummary(String city);

    HourlyForecastDTO getForecastHourly(String city);
}

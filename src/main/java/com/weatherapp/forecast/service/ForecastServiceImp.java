package com.weatherapp.forecast.service;

import com.weatherapp.forecast.dto.ForecastSummaryDTO;
import com.weatherapp.forecast.dto.HourlyForecastDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForecastServiceImp implements ForecastService {
    private ForecastApi forecastApi;

    @Autowired
    public ForecastServiceImp(ForecastApi forecastApi) {
        this.forecastApi = forecastApi;
    }

    @Override
    public ForecastSummaryDTO getForecastSummary(String city){
        return forecastApi.getForecastSummary(city);
    }

    @Override
    public HourlyForecastDTO getForecastHourly(String city){
        return forecastApi.getForecastHourly(city);
    }

}

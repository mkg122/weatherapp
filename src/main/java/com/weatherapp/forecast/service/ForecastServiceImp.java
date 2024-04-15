package com.weatherapp.forecast.service;

import org.springframework.beans.factory.annotation.Autowired;

public class
ForecastServiceImp implements ForecastService {
    private ForecastApi forecastApi;

    @Autowired
    public ForecastServiceImp(ForecastApi forecastApi) {
        this.forecastApi = forecastApi;
    }

    @Override
    public Object getForecastSummary(String city){
        return null;
    }

    @Override
    public Object getForecastHourly(String city){
        return null;
    }

}

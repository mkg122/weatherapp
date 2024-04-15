package com.weatherapp.forecast.controller;

import com.weatherapp.forecast.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather/forecast/")
public class ForecastController {

    @Autowired
    private ForecastService forecastService;


    @GetMapping("summary")
    Object getForecastSummary(@RequestParam String city){
        return null;
    }

    @GetMapping("hourly")
    Object getForecastHourly(@RequestParam String city){
        return null;
    }


}

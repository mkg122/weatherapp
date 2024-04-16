package com.weatherapp.forecast.controller;

import com.weatherapp.config.exception.CustomException;
import com.weatherapp.forecast.dto.ForecastSummaryDTO;
import com.weatherapp.forecast.dto.HourlyForecastDTO;
import com.weatherapp.forecast.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<ForecastSummaryDTO> getForecastSummary(@RequestParam String city){

       ForecastSummaryDTO forecastSummaryDTO = forecastService.getForecastSummary(city);

       if(forecastSummaryDTO==null){
           throw new CustomException("forecast summary is not available for the city: "+city, HttpStatus.NOT_FOUND);
       }
       return ResponseEntity
               .status(HttpStatus.OK.value())
               .body(forecastSummaryDTO);
    }

    @GetMapping("hourly")
    ResponseEntity<HourlyForecastDTO> getForecastHourly(@RequestParam String city){

        HourlyForecastDTO hourlyForecastDTO = forecastService.getForecastHourly(city);
        if(hourlyForecastDTO==null){
           throw new CustomException("Hourly forecast is not available for the city: "+city, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(hourlyForecastDTO);

    }


}

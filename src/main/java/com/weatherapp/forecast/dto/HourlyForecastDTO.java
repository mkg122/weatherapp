package com.weatherapp.forecast.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HourlyForecastDTO {

        private Location location;
        private HourlyForecast forecast;

}

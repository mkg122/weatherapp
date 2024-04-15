package com.weatherapp.forecast.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ForecastSummaryDTO {

        private Location location;
        private Forecast forecast;

}

package com.weatherapp.forecast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Precipitation {
    private Double sum;
    private Integer probability;
    private Double sumAsRain;

    @JsonProperty("class")
    private Integer clazz;

}

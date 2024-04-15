package com.weatherapp.forecast.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private String code;
    private String name;
    private String timezone;
    private Coordinates coordinates;

}

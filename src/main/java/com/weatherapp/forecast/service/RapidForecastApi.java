package com.weatherapp.forecast.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapp.config.exception.CustomException;
import com.weatherapp.forecast.dto.ForecastSummaryDTO;
import com.weatherapp.forecast.dto.HourlyForecastDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class RapidForecastApi implements ForecastApi{

    String rapidUrl="https://forecast9.p.rapidapi.com/rapidapi/forecast/";

    String rapidAPIKey="588dbbe6e4msh3988266585d5dfep116847jsn7737beceae47";

    String rapidHost="forecast9.p.rapidapi.com";

    @Override
    public ForecastSummaryDTO getForecastSummary(String city) {

        StringBuilder sb = new StringBuilder(rapidUrl);
        sb.append(city);
        sb.append("/summary/");

        URI uri = URI.create(sb.toString());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("X-RapidAPI-Key", rapidAPIKey)
                .header("X-RapidAPI-Host", rapidHost)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            switch (response.statusCode()) {
                case 200:
                    ObjectMapper mapper =new ObjectMapper();
                    mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                    ForecastSummaryDTO dto = mapper.readValue(response.body(), ForecastSummaryDTO.class);

                    return dto;

                case 404:
                    throw new CustomException("forecast summary is not available for the city: "+city, HttpStatus.NOT_FOUND);

                default:
                    throw new CustomException("Unable to process your request.", HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }catch (Exception e) {
            throw new CustomException("Unable to process your request.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public HourlyForecastDTO getForecastHourly(String city) {

        StringBuilder sb = new StringBuilder(rapidUrl);
        sb.append(city);
        sb.append("/hourly/");

        URI uri = URI.create(sb.toString());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("X-RapidAPI-Key",rapidAPIKey )
                .header("X-RapidAPI-Host", rapidHost)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            switch (response.statusCode()) {
                case 200:
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                    HourlyForecastDTO dto = mapper.readValue(response.body(), HourlyForecastDTO.class);

                    return dto;

                case 404:
                    throw new CustomException("Hourly forecast is not available for the city: "+city, HttpStatus.NOT_FOUND);

                default:
                    throw new CustomException("Unable to process your request.", HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }catch (Exception e) {
            throw new CustomException("Unable to process your request.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

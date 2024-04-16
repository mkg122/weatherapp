package com.weatherapp.forecast.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapp.forecast.dto.ForecastSummaryDTO;
import com.weatherapp.forecast.dto.HourlyForecastDTO;
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

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            ForecastSummaryDTO dto = mapper.readValue(response.body(), ForecastSummaryDTO.class);

            return dto;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            HourlyForecastDTO dto = mapper.readValue(response.body(), HourlyForecastDTO.class);

            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}

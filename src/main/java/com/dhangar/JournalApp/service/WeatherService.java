package com.dhangar.JournalApp.service;


import com.dhangar.JournalApp.WeatherResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Getter
@Setter
public class WeatherService {
    private static final String apiKey = "e12f798cb34a1e09aa6822117db684d0";

    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&querY=CITY";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finalApi = API.replace("CITY", city).replace("API_KEY", apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;

    }
}

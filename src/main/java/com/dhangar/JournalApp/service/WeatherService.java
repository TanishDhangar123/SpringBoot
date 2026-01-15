package com.dhangar.JournalApp.service;


import com.dhangar.JournalApp.WeatherResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Getter
@Setter
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

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

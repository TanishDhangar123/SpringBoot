//package com.dhangar.JournalApp.repository;
//
//
//import com.dhangar.JournalApp.WeatherResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//public class WeatherServicePractice {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    private static final String api_key = " ";
//
//    private static final String API = " ";
//
//    public WeatherResponse getWeather(String city){
//        String finalApi = API.replace("access_key", api_key).replace("CITY", city);
//        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, " ", WeatherResponse.class);
//        WeatherResponse body = response.getBody();
//        return body;
//    }
//}

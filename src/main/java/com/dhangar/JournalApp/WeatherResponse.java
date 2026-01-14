package com.dhangar.JournalApp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class WeatherResponse {

    private Current current;

    @Getter
    @Setter
    public static class Current{

        public int temperature;

        @JsonProperty("weather_descriptions")
        public ArrayList<String> weatherDescriptions;

        public int feelslike;

    }

}

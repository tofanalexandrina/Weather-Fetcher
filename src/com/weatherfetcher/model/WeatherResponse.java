package com.weatherfetcher.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherResponse {
    public Location location;
    public Current current;
}

package com.weatherfetcher.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {
    public double temp_c;
    public Condition condition; //nested obj
}

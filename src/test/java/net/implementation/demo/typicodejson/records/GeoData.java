package net.implementation.demo.typicodejson.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GeoData(
    @JsonProperty("lat") String LAT,
    @JsonProperty("lng") String LNG
) {
}

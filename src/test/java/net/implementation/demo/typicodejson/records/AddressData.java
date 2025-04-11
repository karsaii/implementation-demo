package net.implementation.demo.typicodejson.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddressData(
    @JsonProperty("city") String CITY,
    @JsonProperty("geo") GeoData GEO,
    @JsonProperty("street") String STREET,
    @JsonProperty("suite") String SUITE,
    @JsonProperty("zipcode") String ZIPCODE
) {
}

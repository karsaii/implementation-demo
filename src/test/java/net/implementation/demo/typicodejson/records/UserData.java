package net.implementation.demo.typicodejson.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserData(
    @JsonProperty("address") AddressData ADDRESS_DATA,
    @JsonProperty("company") CompanyData COMPANY_DATA,
    @JsonProperty("email") String EMAIL,
    @JsonProperty("id") int ID,
    @JsonProperty("name") String NAME,
    @JsonProperty("phone") String PHONE,
    @JsonProperty("username") String USERNAME,
    @JsonProperty("website") String WEBSITE
) {
}

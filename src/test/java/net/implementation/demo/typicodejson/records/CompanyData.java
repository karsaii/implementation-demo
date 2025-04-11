package net.implementation.demo.typicodejson.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CompanyData(
    @JsonProperty("bs") String BS,
    @JsonProperty("catchPhrase") String CATCH_PHRASE,
    @JsonProperty("name") String NAME
) {
}

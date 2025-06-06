package net.implementation.demo.common.records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Credentials(
    @JsonProperty("username") String USERNAME,
    @JsonProperty("password") String PASSWORD,
    String DESCRIPTION
) {
}

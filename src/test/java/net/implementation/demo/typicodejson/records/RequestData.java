package net.implementation.demo.typicodejson.records;

import net.implementation.demo.typicodejson.enums.RequestType;

import java.util.Map;

public record RequestData(
    String ENDPOINT,
    String URL,
    RequestType TYPE,
    Map<String, String> HEADERS,
    int RESPONSE_CODE
) {
}

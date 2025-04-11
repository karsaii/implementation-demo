package net.implementation.demo.typicodejson.enums;

import java.util.HashMap;
import java.util.Map;

public enum RequestType {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    private static final Map<String, RequestType> VALUES = new HashMap<>();
    private final String NAME;

    static {
        for(var value : values()) {
            VALUES.putIfAbsent(value.NAME, value);
        }
    }

    RequestType(String name) {
        this.NAME = name;
    }

    public String getName() {
        return this.NAME;
    }

    public static RequestType getValueOf(String name) {
        return VALUES.getOrDefault(name, RequestType.GET);
    }
}

package net.implementation.demo.typicodejson.constants;

import java.util.Map;

public abstract class HeadersConstants {
    public static final Map<String, String> BASE_ACCEPT_JSON_HTTP_HEADER_MAP = Map.ofEntries(
        Map.entry("Accept", "application/json")
    );
}

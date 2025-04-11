package net.implementation.demo.common.namespaces;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface MapperFunctions {
    static ObjectMapper getDefaultMapper() {
        final var mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        return mapper;
    }
}

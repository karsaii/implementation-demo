package net.implementation.demo.common.constants;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.implementation.demo.common.namespaces.MapperFunctions;

public abstract class JSONConstants {
    public static final ObjectMapper MAPPER = MapperFunctions.getDefaultMapper();
}

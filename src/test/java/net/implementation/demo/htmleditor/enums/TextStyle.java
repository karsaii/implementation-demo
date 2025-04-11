package net.implementation.demo.htmleditor.enums;

import java.util.HashMap;
import java.util.Map;

public enum TextStyle {
    BOLD("BOLD"),
    UNDERLINE("UNDERLINE"),
    NONE("NONE");

    private static final Map<String, TextStyle> VALUES = new HashMap<>();
    private final String NAME;

    static {
        for(var value : values()) {
            VALUES.putIfAbsent(value.NAME, value);
        }
    }

    TextStyle(String name) {
        this.NAME = name;
    }

    public String getName() {
        return this.NAME;
    }

    public static TextStyle getValueOf(String name) {
        return VALUES.getOrDefault(name, TextStyle.NONE);
    }
}

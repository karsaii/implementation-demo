package net.implementation.demo.common.namespaces.validators;

import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;

public interface FileUtilsValidators {
    static String isValid(String value) {
        return CoreFormatter.isBlankMessageWithName(value, "File path value");
    }
}

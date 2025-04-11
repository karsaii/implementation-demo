package net.implementation.demo.common.namespaces;

import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;
import com.neathorium.thorium.java.extensions.namespaces.utilities.StringUtilities;

public interface JARUtilities {
    static boolean isInJar() {
        final var FQDName = JARUtilities.class.getName();
        final var className = FQDName.substring(FQDName.lastIndexOf(".") + 1).strip();
        final var classJar = JARUtilities.class.getResource(className + ".class");
        final var localValue = NullablePredicates.isNotNull(classJar) ? classJar.toString() : "";
        return StringUtilities.startsWithCaseInsensitive(localValue, "jar:");
    }

}

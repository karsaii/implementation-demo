package net.implementation.demo.sauceinventory.namespaces;

import com.neathorium.thorium.framework.selenium.namespaces.SeleniumExecutor;
import com.neathorium.thorium.framework.selenium.namespaces.element.Element;
import com.neathorium.thorium.framework.selenium.namespaces.extensions.boilers.DriverFunction;
import net.implementation.demo.sauceinventory.constants.HeaderConstants;

public interface HeaderFunctions {
    static DriverFunction<Boolean> isHeaderDisplayed() {
        final var nameof = HeaderConstants.FUNCTION_NAME + "isHeaderDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(HeaderConstants.HEADER_TITLE, 300, 30000)
        );
    }
}

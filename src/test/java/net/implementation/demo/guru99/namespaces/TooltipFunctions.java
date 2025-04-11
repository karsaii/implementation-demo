package net.implementation.demo.guru99.namespaces;

import com.neathorium.thorium.framework.selenium.namespaces.SeleniumExecutor;
import com.neathorium.thorium.framework.selenium.namespaces.element.Element;
import com.neathorium.thorium.framework.selenium.namespaces.extensions.boilers.DriverFunction;
import net.implementation.demo.guru99.constants.TooltipConstants;

public interface TooltipFunctions {
    static DriverFunction<Boolean> navigateTo() {
        final var nameof = TooltipConstants.FUNCTION_NAME + "navigateTo";
        return SeleniumExecutor.execute(
            nameof,
            DemoFunctions.clickSelenium(),
            DemoFunctions.clickTooltip()
        );
    }

    static DriverFunction<Boolean> isDownloadButtonDisplayed() {
        final var nameof = TooltipConstants.FUNCTION_NAME + "isDownloadButtonDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(TooltipConstants.DOWNLOAD_BUTTON, 300, 30000)
        );
    }
}

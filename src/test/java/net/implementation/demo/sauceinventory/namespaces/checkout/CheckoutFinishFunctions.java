package net.implementation.demo.sauceinventory.namespaces.checkout;

import com.neathorium.thorium.framework.selenium.namespaces.SeleniumExecutor;
import com.neathorium.thorium.framework.selenium.namespaces.element.Element;
import com.neathorium.thorium.framework.selenium.namespaces.element.ElementExpectedConditions;
import com.neathorium.thorium.framework.selenium.namespaces.extensions.boilers.DriverFunction;
import net.implementation.demo.sauceinventory.constants.checkout.CheckoutFinishConstants;
import net.implementation.demo.sauceinventory.namespaces.FooterFunctions;

public interface CheckoutFinishFunctions {
    static DriverFunction<Boolean> navigateTo() {
        final var nameof = CheckoutFinishConstants.FUNCTION_NAME + "navigateTo";
        return SeleniumExecutor.execute(
            nameof,
            CheckoutOverviewFunctions.clickFinishButton()
        );
    }

    static DriverFunction<Boolean> isContainerPresent() {
        final var nameof = CheckoutFinishConstants.FUNCTION_NAME + "isContainerPresent";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitPresent(CheckoutFinishConstants.CONTAINER, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isHeaderDisplayed() {
        final var nameof = CheckoutFinishConstants.FUNCTION_NAME + "isHeaderDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(CheckoutFinishConstants.HEADER, 300, 30000)
        );
    }

    static DriverFunction<Boolean> doNavigateTo() {
        final var nameof = CheckoutFinishConstants.FUNCTION_NAME + "navigateTo";
        return SeleniumExecutor.execute(
            nameof,
            CheckoutFinishFunctions.navigateTo(),
            CheckoutFinishFunctions.isHeaderDisplayed(),
            CheckoutFinishFunctions.isContainerPresent(),
            FooterFunctions.isFooterDisplayed()
        );
    }

    static DriverFunction<Boolean> isMessageDisplayed(String message) {
        final var nameof = CheckoutFinishConstants.FUNCTION_NAME + "isHeaderDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            CheckoutFinishFunctions.isContainerPresent(),
            ElementExpectedConditions.isTextContains(CheckoutFinishConstants.CONTAINER, message)
        );
    }


}

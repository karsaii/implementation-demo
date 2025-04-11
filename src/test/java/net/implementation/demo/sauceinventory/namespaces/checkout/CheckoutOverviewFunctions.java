package net.implementation.demo.sauceinventory.namespaces.checkout;

import com.neathorium.thorium.framework.selenium.namespaces.SeleniumExecutor;
import com.neathorium.thorium.framework.selenium.namespaces.element.Element;
import com.neathorium.thorium.framework.selenium.namespaces.extensions.boilers.DriverFunction;
import net.implementation.demo.sauceinventory.constants.checkout.CheckoutOverviewConstants;

public interface CheckoutOverviewFunctions {
    static DriverFunction<Boolean> navigateTo() {
        final var nameof = CheckoutOverviewConstants.FUNCTION_NAME + "navigateTo";
        return SeleniumExecutor.execute(
            nameof,
            CheckoutInformationFunctions.clickContinueButton()
        );
    }

    static DriverFunction<Boolean> isContainerPresent() {
        final var nameof = CheckoutOverviewConstants.FUNCTION_NAME + "isContainerPresent";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitPresent(CheckoutOverviewConstants.CONTAINER, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isTitleDisplayed() {
        final var nameof = CheckoutOverviewConstants.FUNCTION_NAME + "isTitleDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(CheckoutOverviewConstants.HEADER, 300, 30000)
        );
    }

    static DriverFunction<Boolean> clickFinishButton() {
        final var nameof = CheckoutOverviewConstants.FUNCTION_NAME + "clickFinishButton";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitClickable(CheckoutOverviewConstants.FINISH_BUTTON, 300, 30000),
            Element.clickWhenClickable(CheckoutOverviewConstants.FINISH_BUTTON)
        );
    }

    static DriverFunction<Boolean> doNavigateTo() {
        final var nameof = CheckoutOverviewConstants.FUNCTION_NAME + "doNavigateTo";
        return SeleniumExecutor.execute(
            nameof,
            CheckoutOverviewFunctions.navigateTo(),
            CheckoutOverviewFunctions.isTitleDisplayed(),
            CheckoutOverviewFunctions.isContainerPresent()
        );
    }
}

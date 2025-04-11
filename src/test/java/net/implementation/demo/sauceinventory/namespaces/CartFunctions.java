package net.implementation.demo.sauceinventory.namespaces;

import com.neathorium.thorium.framework.selenium.namespaces.SeleniumExecutor;
import com.neathorium.thorium.framework.selenium.namespaces.element.Element;
import com.neathorium.thorium.framework.selenium.namespaces.extensions.boilers.DriverFunction;
import net.implementation.demo.sauceinventory.constants.CartConstants;

public interface CartFunctions {
    static DriverFunction<Boolean> navigateTo() {
        final var nameof = CartConstants.FUNCTION_NAME + "navigateTo";
        return SeleniumExecutor.execute(
            nameof,
            ShopFunctions.clickCart()
        );
    }

    static DriverFunction<Boolean> isContainerPresent() {
        final var nameof = CartConstants.FUNCTION_NAME + "isContainerPresent";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitPresent(CartConstants.CONTAINER, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isTitleDisplayed() {
        final var nameof = CartConstants.FUNCTION_NAME + "isTitleDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(CartConstants.HEADER, 300, 30000)
        );
    }

    static DriverFunction<Boolean> clickCheckoutButton() {
        final var nameof = CartConstants.FUNCTION_NAME + "clickCheckoutButton";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitClickable(CartConstants.CHECKOUT_BUTTON, 300, 30000),
            Element.clickWhenClickable(CartConstants.CHECKOUT_BUTTON)
        );
    }

    static DriverFunction<Boolean> doNavigateTo() {
        final var nameof = CartConstants.FUNCTION_NAME + "doNavigateTo";
        return SeleniumExecutor.execute(
            nameof,
            CartFunctions.navigateTo(),
            CartFunctions.isTitleDisplayed(),
            CartFunctions.isContainerPresent()
        );
    }
}

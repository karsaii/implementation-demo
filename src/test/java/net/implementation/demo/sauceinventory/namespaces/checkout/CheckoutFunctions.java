package net.implementation.demo.sauceinventory.namespaces.checkout;

import com.neathorium.thorium.framework.selenium.namespaces.SeleniumExecutor;
import com.neathorium.thorium.framework.selenium.namespaces.extensions.boilers.DriverFunction;
import net.implementation.demo.sauceinventory.constants.checkout.CheckoutConstants;
import net.implementation.demo.sauceinventory.namespaces.CartFunctions;

public interface CheckoutFunctions {
    static DriverFunction<Boolean> completeCheckoutWithResult(String expectedMessage) {
        final var nameof = CheckoutConstants.FUNCTION_NAME + "completeCheckout";
        return SeleniumExecutor.execute(
            nameof,
            CartFunctions.doNavigateTo(),
            CheckoutInformationFunctions.doNavigateTo(),
            CheckoutInformationFunctions.fillCheckoutInfoWithNonsense(),
            CheckoutOverviewFunctions.doNavigateTo(),
            CheckoutFinishFunctions.doNavigateTo(),
            CheckoutFinishFunctions.isMessageDisplayed(expectedMessage)
        );
    }
}

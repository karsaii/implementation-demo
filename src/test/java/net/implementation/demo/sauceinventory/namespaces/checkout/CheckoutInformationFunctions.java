package net.implementation.demo.sauceinventory.namespaces.checkout;

import com.neathorium.thorium.framework.selenium.namespaces.SeleniumExecutor;
import com.neathorium.thorium.framework.selenium.namespaces.element.Element;
import com.neathorium.thorium.framework.selenium.namespaces.extensions.boilers.DriverFunction;
import net.implementation.demo.sauceinventory.constants.checkout.CheckoutInformationConstants;
import net.implementation.demo.sauceinventory.namespaces.CartFunctions;

public interface CheckoutInformationFunctions {
    static DriverFunction<Boolean> navigateTo() {
        final var nameof = CheckoutInformationConstants.FUNCTION_NAME + "navigateTo";
        return SeleniumExecutor.execute(
            nameof,
            CartFunctions.clickCheckoutButton()
        );
    }

    static DriverFunction<Boolean> isContainerPresent() {
        final var nameof = CheckoutInformationConstants.FUNCTION_NAME + "isContainerPresent";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitPresent(CheckoutInformationConstants.CONTAINER, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isTitleDisplayed() {
        final var nameof = CheckoutInformationConstants.FUNCTION_NAME + "isTitleDisplayed";
        return SeleniumExecutor.execute(
                nameof,
                Element.waitDisplayed(CheckoutInformationConstants.HEADER, 300, 30000)
        );
    }

    static DriverFunction<Boolean> clickContinueButton() {
        final var nameof = CheckoutInformationConstants.FUNCTION_NAME + "clickContinueButton";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitClickable(CheckoutInformationConstants.CONTINUE_BUTTON, 300, 30000),
            Element.clickWhenClickable(CheckoutInformationConstants.CONTINUE_BUTTON)
        );
    }

    static DriverFunction<Boolean> doNavigateTo() {
        final var nameof = CheckoutInformationConstants.FUNCTION_NAME + "doNavigateTo";
        return SeleniumExecutor.execute(
            nameof,
            CheckoutInformationFunctions.navigateTo(),
            CheckoutInformationFunctions.isTitleDisplayed(),
            CheckoutInformationFunctions.isContainerPresent()
        );
    }

    static DriverFunction<Boolean> isFirstNameDisplayed() {
        final var nameof = CheckoutInformationConstants.FUNCTION_NAME + "isFirstNameDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(CheckoutInformationConstants.FIRST_NAME, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isLastNameDisplayed() {
        final var nameof = CheckoutInformationConstants.FUNCTION_NAME + "isLastNameDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(CheckoutInformationConstants.LAST_NAME, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isZipcodeDisplayed() {
        final var nameof = CheckoutInformationConstants.FUNCTION_NAME + "isZipcodeDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(CheckoutInformationConstants.ZIPCODE, 300, 30000)
        );
    }

    static DriverFunction<Boolean> fillFirstName(String value) {
        final var nameof = CheckoutInformationConstants.FUNCTION_NAME + "fillFirstName";
        return SeleniumExecutor.execute(
            nameof,
            CheckoutInformationFunctions.isFirstNameDisplayed(),
            Element.inputWhenClickable(CheckoutInformationConstants.FIRST_NAME, value)
        );
    }

    static DriverFunction<Boolean> fillLastName(String value) {
        final var nameof = CheckoutInformationConstants.FUNCTION_NAME + "fillLastName";
        return SeleniumExecutor.execute(
            nameof,
            CheckoutInformationFunctions.isLastNameDisplayed(),
            Element.inputWhenClickable(CheckoutInformationConstants.LAST_NAME, value)
        );
    }

    static DriverFunction<Boolean> fillZipCode(String value) {
        final var nameof = CheckoutInformationConstants.FUNCTION_NAME + "fillZipCode";
        return SeleniumExecutor.execute(
            nameof,
            CheckoutInformationFunctions.isZipcodeDisplayed(),
            Element.inputWhenClickable(CheckoutInformationConstants.ZIPCODE, value)
        );
    }

    static DriverFunction<Boolean> fillCheckoutInfoWithNonsense() {
        final var nameof = CheckoutInformationConstants.FUNCTION_NAME + "fillCheckoutInfoWithNonsense";
        return SeleniumExecutor.execute(
            nameof,
            CheckoutInformationFunctions.fillFirstName("a"),
            CheckoutInformationFunctions.fillLastName("b"),
            CheckoutInformationFunctions.fillZipCode("1")
        );
    }
}

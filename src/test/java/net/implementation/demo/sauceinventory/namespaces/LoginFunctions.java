package net.implementation.demo.sauceinventory.namespaces;

import com.neathorium.thorium.framework.selenium.namespaces.DriverWaits;
import com.neathorium.thorium.framework.selenium.namespaces.SeleniumExecutor;
import com.neathorium.thorium.framework.selenium.namespaces.element.Element;
import com.neathorium.thorium.framework.selenium.namespaces.element.ElementExpectedConditions;
import com.neathorium.thorium.framework.selenium.namespaces.extensions.boilers.DriverFunction;
import net.implementation.demo.common.records.Credentials;
import net.implementation.demo.sauceinventory.constants.LoginConstants;

public interface LoginFunctions {
    static DriverFunction<Boolean> navigateTo() {
        final var nameof = LoginConstants.FUNCTION_NAME + "navigateTo";
        return SeleniumExecutor.execute(
            nameof,
            DriverWaits.navigateAndWait(LoginConstants.INVENTORY_BASE_URL, 300, 3000)
        );
    }

    static DriverFunction<Boolean> isContainerPresent() {
        final var nameof = LoginConstants.FUNCTION_NAME + "isContainerPresent";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitPresent(LoginConstants.LOGIN_CONTAINER, 300, 3000)
        );
    }

    static DriverFunction<Boolean> isLoginBoxPresent() {
        final var nameof = LoginConstants.FUNCTION_NAME + "isLoginBoxPresent";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitPresent(LoginConstants.LOGIN_BOX, 300, 3000)
        );
    }

    static DriverFunction<Boolean> isOnLoginPage() {
        final var nameof = LoginConstants.FUNCTION_NAME + "isOnLoginPage";
        return SeleniumExecutor.execute(
            nameof,
            LoginFunctions.isContainerPresent(),
            LoginFunctions.isLoginBoxPresent()
        );
    }

    static DriverFunction<Boolean> fillUsername(String username) {
        final var nameof = LoginConstants.FUNCTION_NAME + "fillUsername";
        return SeleniumExecutor.execute(
            nameof,
            Element.inputWhenClickable(LoginConstants.USERNAME_INPUT_FIELD, username)
        );
    }

    static DriverFunction<Boolean> fillPassword(String password) {
        final var nameof = LoginConstants.FUNCTION_NAME + "fillPassword";
        return SeleniumExecutor.execute(
            nameof,
            Element.inputWhenClickable(LoginConstants.PASSWORD_INPUT_FIELD, password)
        );
    }

    static DriverFunction<Boolean> clickLoginButton() {
        final var nameof = LoginConstants.FUNCTION_NAME + "clickLoginButton";
        return SeleniumExecutor.execute(
            nameof,
            Element.clickWhenClickable(LoginConstants.LOGIN_BUTTON)
        );
    }

    static DriverFunction<Boolean> fillCredentials(Credentials credentials) {
        final var nameof = LoginConstants.FUNCTION_NAME + "fillCredentials";
        return SeleniumExecutor.execute(
            nameof,
            LoginFunctions.fillUsername(credentials.USERNAME()),
            LoginFunctions.fillPassword(credentials.PASSWORD())
        );
    }

    static DriverFunction<Boolean> login(Credentials credentials) {
        final var nameof = LoginConstants.FUNCTION_NAME + "login";
        return SeleniumExecutor.execute(
            nameof,
            LoginFunctions.isOnLoginPage(),
            LoginFunctions.fillCredentials(credentials),
            LoginFunctions.clickLoginButton()
        );
    }

    static DriverFunction<Boolean> doLogin(Credentials credentials) {
        final var nameof = LoginConstants.FUNCTION_NAME + "doLogin";
        return SeleniumExecutor.execute(
            nameof,
            LoginFunctions.login(credentials),
            HeaderFunctions.isHeaderDisplayed()
        );
    }

    static DriverFunction<Boolean> isErrorContainerDisplayed() {
        final var nameof = LoginConstants.FUNCTION_NAME + "isErrorContainerDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(LoginConstants.ERROR_CONTAINER, 300, 3000)
        );
    }

    static DriverFunction<Boolean> isErrorDisplayed(String message) {
        final var nameof = LoginConstants.FUNCTION_NAME + "isErrorDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            LoginFunctions.isErrorContainerDisplayed(),
            ElementExpectedConditions.isTextContains(LoginConstants.ERROR_CONTAINER, message)
        );
    }

    static DriverFunction<Boolean> doLoginNoCredentials() {
        final var nameof = LoginConstants.FUNCTION_NAME + "doLoginNoCredentials";
        return SeleniumExecutor.execute(
            nameof,
            LoginFunctions.isOnLoginPage(),
            LoginFunctions.clickLoginButton(),
            LoginFunctions.isOnLoginPage()
        );
    }
}

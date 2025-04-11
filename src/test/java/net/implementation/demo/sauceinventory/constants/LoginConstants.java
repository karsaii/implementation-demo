package net.implementation.demo.sauceinventory.constants;

import com.neathorium.thorium.framework.core.namespaces.factory.LazyLocatorFactory;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.framework.selenium.constants.SelectorStrategyNameConstants;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import com.neathorium.thorium.framework.selenium.records.lazy.LazyElement;

public class LoginConstants {
    public static final String NAME = "Login - ";
    public static final String FUNCTION_NAME = "LoginFunctions.";
    public static final String INVENTORY_BASE_URL = "https://www.saucedemo.com/";

    public static final String LOGIN_CONTAINER_NAME = LoginConstants.NAME + "Container";
    public static final String LOGIN_BUTTON_NAME = LoginConstants.NAME + "Button";
    public static final String LOGIN_BOX_NAME = LoginConstants.NAME + "Box";
    public static final String USERNAME_INPUT_NAME = LoginConstants.NAME + "Username Field";
    public static final String PASSWORD_INPUT_NAME = LoginConstants.NAME + "Password Field";
    public static final String ERROR_CONTAINER_NAME = LoginConstants.NAME + "Error Container";

    public static final String LOGIN_CONTAINER_SELECTOR = "div[class*='login_container']";
    public static final String LOGIN_BUTTON_SELECTOR = LoginConstants.LOGIN_BOX_SELECTOR + " input[id='login-button']";
    public static final String LOGIN_BOX_SELECTOR = LoginConstants.LOGIN_CONTAINER_SELECTOR + " div[class*='login-box']";
    public static final String USERNAME_INPUT_SELECTOR = LoginConstants.LOGIN_BOX_SELECTOR + " input[id='user-name']";
    public static final String PASSWORD_INPUT_SELECTOR = LoginConstants.LOGIN_BOX_SELECTOR + " input[id='password']";
    public static final String ERROR_CONTAINER_SELECTOR = LoginConstants.LOGIN_BOX_SELECTOR + " div[class='error-message-container error']";

    public static final LazyLocator LOGIN_CONTAINER_LOCATOR = LazyLocatorFactory.get(LoginConstants.LOGIN_CONTAINER_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator LOGIN_BUTTON_LOCATOR = LazyLocatorFactory.get(LoginConstants.LOGIN_BUTTON_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator LOGIN_BOX_LOCATOR = LazyLocatorFactory.get(LoginConstants.LOGIN_BOX_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator USERNAME_INPUT_LOCATOR = LazyLocatorFactory.get(LoginConstants.USERNAME_INPUT_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator PASSWORD_INPUT_LOCATOR = LazyLocatorFactory.get(LoginConstants.PASSWORD_INPUT_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);

    public static final LazyLocator ERROR_CONTAINER_LOCATOR = LazyLocatorFactory.get(LoginConstants.ERROR_CONTAINER_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);

    public static final LazyElement LOGIN_CONTAINER = LazyElementFactory.getWithFilterParameters(LoginConstants.LOGIN_CONTAINER_NAME, LoginConstants.LOGIN_CONTAINER_LOCATOR);
    public static final LazyElement LOGIN_BUTTON = LazyElementFactory.getWithFilterParameters(LoginConstants.LOGIN_BUTTON_NAME, LoginConstants.LOGIN_BUTTON_LOCATOR);
    public static final LazyElement LOGIN_BOX = LazyElementFactory.getWithFilterParameters(LoginConstants.LOGIN_BOX_NAME, LoginConstants.LOGIN_BOX_LOCATOR);
    public static final LazyElement USERNAME_INPUT_FIELD = LazyElementFactory.getWithFilterParameters(LoginConstants.USERNAME_INPUT_NAME, LoginConstants.USERNAME_INPUT_LOCATOR);
    public static final LazyElement PASSWORD_INPUT_FIELD = LazyElementFactory.getWithFilterParameters(LoginConstants.PASSWORD_INPUT_NAME, LoginConstants.PASSWORD_INPUT_LOCATOR);
    public static final LazyElement ERROR_CONTAINER = LazyElementFactory.getWithFilterParameters(LoginConstants.ERROR_CONTAINER_NAME, LoginConstants.ERROR_CONTAINER_LOCATOR);

    public static final String LOGIN_NO_USERNAME_ERROR_EN = "Epic sadface: Username is required";

}

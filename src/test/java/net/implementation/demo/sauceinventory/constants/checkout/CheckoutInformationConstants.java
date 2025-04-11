package net.implementation.demo.sauceinventory.constants.checkout;

import com.neathorium.thorium.framework.core.namespaces.factory.LazyLocatorFactory;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.framework.selenium.constants.SelectorStrategyNameConstants;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import com.neathorium.thorium.framework.selenium.records.lazy.LazyElement;
import net.implementation.demo.sauceinventory.constants.HeaderConstants;

public abstract class CheckoutInformationConstants {
    public static final String NAME = "CheckoutInformation - ";
    public static final String FUNCTION_NAME = "CheckoutInformationFunctions.";
    public static final String TITLE_EN = "Your Cart";

    public static final String CONTAINER_NAME = CheckoutInformationConstants.NAME + "Container";
    public static final String CONTINUE_BUTTON_NAME = CheckoutInformationConstants.NAME + "Continue";
    public static final String CANCEL_BUTTON_NAME = CheckoutInformationConstants.NAME + "Cancel";
    public static final String FIRST_NAME_NAME = CheckoutInformationConstants.NAME + "First Name";
    public static final String LAST_NAME_NAME = CheckoutInformationConstants.NAME + "Last Name";
    public static final String ZIPCODE_NAME = CheckoutInformationConstants.NAME + "ZipCode Name";

    public static final String CONTAINER_SELECTOR = "div[id*='checkout_info_container']";
    public static final String CONTINUE_BUTTON_SELECTOR = CheckoutInformationConstants.CONTAINER_SELECTOR + " input[id*='continue']";
    public static final String CANCEL_BUTTON_SELECTOR = CheckoutInformationConstants.CONTAINER_SELECTOR + " button[id*='cancel']";
    public static final String FIRST_NAME_SELECTOR = CheckoutInformationConstants.CONTAINER_SELECTOR + " input[id*='first-name']";
    public static final String LAST_NAME_SELECTOR = CheckoutInformationConstants.CONTAINER_SELECTOR + " input[id*='last-name']";
    public static final String ZIPCODE_SELECTOR = CheckoutInformationConstants.CONTAINER_SELECTOR + " input[id*='postal-code']";

    public static final LazyLocator CONTAINER_LOCATOR = LazyLocatorFactory.get(CheckoutInformationConstants.CONTAINER_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator CONTINUE_BUTTON_LOCATOR = LazyLocatorFactory.get(CheckoutInformationConstants.CONTINUE_BUTTON_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator CANCEL_BUTTON_LOCATOR = LazyLocatorFactory.get(CheckoutInformationConstants.CANCEL_BUTTON_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator FIRST_NAME_LOCATOR = LazyLocatorFactory.get(CheckoutInformationConstants.FIRST_NAME_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator LAST_NAME_LOCATOR = LazyLocatorFactory.get(CheckoutInformationConstants.LAST_NAME_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator ZIPCODE_LOCATOR = LazyLocatorFactory.get(CheckoutInformationConstants.ZIPCODE_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);

    public static final LazyElement HEADER = LazyElementFactory.getWithFilterParameters(CheckoutInformationConstants.NAME + HeaderConstants.NAME, CheckoutInformationConstants.TITLE_EN, HeaderConstants.HEADER_TITLE_LOCATOR);
    public static final LazyElement CONTAINER = LazyElementFactory.getWithFilterParameters(CheckoutInformationConstants.CONTAINER_NAME, CheckoutInformationConstants.CONTAINER_LOCATOR);
    public static final LazyElement CONTINUE_BUTTON = LazyElementFactory.getWithFilterParameters(CheckoutInformationConstants.CONTINUE_BUTTON_NAME, CheckoutInformationConstants.CONTINUE_BUTTON_LOCATOR);
    public static final LazyElement CANCEL_BUTTON = LazyElementFactory.getWithFilterParameters(CheckoutInformationConstants.CANCEL_BUTTON_NAME, CheckoutInformationConstants.CANCEL_BUTTON_LOCATOR);
    public static final LazyElement FIRST_NAME = LazyElementFactory.getWithFilterParameters(CheckoutInformationConstants.FIRST_NAME_NAME, CheckoutInformationConstants.FIRST_NAME_LOCATOR);
    public static final LazyElement LAST_NAME = LazyElementFactory.getWithFilterParameters(CheckoutInformationConstants.LAST_NAME_NAME, CheckoutInformationConstants.LAST_NAME_LOCATOR);
    public static final LazyElement ZIPCODE = LazyElementFactory.getWithFilterParameters(CheckoutInformationConstants.ZIPCODE_NAME, CheckoutInformationConstants.ZIPCODE_LOCATOR);
}

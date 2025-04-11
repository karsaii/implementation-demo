package net.implementation.demo.sauceinventory.constants.checkout;

import com.neathorium.thorium.framework.core.namespaces.factory.LazyLocatorFactory;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.framework.selenium.constants.SelectorStrategyNameConstants;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import com.neathorium.thorium.framework.selenium.records.lazy.LazyElement;
import net.implementation.demo.sauceinventory.constants.HeaderConstants;

public class CheckoutFinishConstants {
    public static final String NAME = "Checkout Finish - ";
    public static final String FUNCTION_NAME = "CheckoutFinishFunctions.";
    public static final String TITLE_EN = "Checkout: Complete!";

    public static final String CONTAINER_NAME = CheckoutFinishConstants.NAME + "Container";

    public static final String CONTAINER_SELECTOR = "div[id*='checkout_complete_container']";

    public static final LazyLocator CONTAINER_LOCATOR = LazyLocatorFactory.get(CheckoutFinishConstants.CONTAINER_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);

    public static final LazyElement HEADER = LazyElementFactory.getWithFilterParameters(CheckoutFinishConstants.NAME + HeaderConstants.NAME, CheckoutFinishConstants.TITLE_EN, HeaderConstants.HEADER_TITLE_LOCATOR);
    public static final LazyElement CONTAINER = LazyElementFactory.getWithFilterParameters(CheckoutFinishConstants.CONTAINER_NAME, CheckoutFinishConstants.CONTAINER_LOCATOR);
}

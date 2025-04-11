package net.implementation.demo.sauceinventory.constants.checkout;

import com.neathorium.thorium.framework.core.namespaces.factory.LazyLocatorFactory;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.framework.selenium.constants.SelectorStrategyNameConstants;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import com.neathorium.thorium.framework.selenium.records.lazy.LazyElement;
import net.implementation.demo.sauceinventory.constants.HeaderConstants;

public abstract class CheckoutOverviewConstants {
    public static final String NAME = "Checkout Overview - ";
    public static final String FUNCTION_NAME = "CheckoutOverviewFunctions.";
    public static final String TITLE_EN = "Checkout: Overview";

    public static final String CONTAINER_NAME = CheckoutOverviewConstants.NAME + "Container";
    public static final String FINISH_BUTTON_NAME = CheckoutOverviewConstants.NAME + "Finish";
    public static final String CANCEL_BUTTON_NAME = CheckoutOverviewConstants.NAME + "Cancel";

    public static final String CONTAINER_SELECTOR = "div[id*='checkout_summary_container']";
    public static final String FINISH_BUTTON_SELECTOR = CheckoutOverviewConstants.CONTAINER_SELECTOR + " button[id*='finish']";
    public static final String CANCEL_BUTTON_SELECTOR = CheckoutOverviewConstants.CONTAINER_SELECTOR + " button[id*='cancel']";

    public static final LazyLocator CONTAINER_LOCATOR = LazyLocatorFactory.get(CheckoutOverviewConstants.CONTAINER_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator FINISH_BUTTON_LOCATOR = LazyLocatorFactory.get(CheckoutOverviewConstants.FINISH_BUTTON_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator CANCEL_BUTTON_LOCATOR = LazyLocatorFactory.get(CheckoutOverviewConstants.CANCEL_BUTTON_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);

    public static final LazyElement HEADER = LazyElementFactory.getWithFilterParameters(CheckoutOverviewConstants.NAME + HeaderConstants.NAME, CheckoutOverviewConstants.TITLE_EN, HeaderConstants.HEADER_TITLE_LOCATOR);
    public static final LazyElement CONTAINER = LazyElementFactory.getWithFilterParameters(CheckoutOverviewConstants.CONTAINER_NAME, CheckoutOverviewConstants.CONTAINER_LOCATOR);
    public static final LazyElement FINISH_BUTTON = LazyElementFactory.getWithFilterParameters(CheckoutOverviewConstants.FINISH_BUTTON_NAME, CheckoutOverviewConstants.FINISH_BUTTON_LOCATOR);
    public static final LazyElement CANCEL_BUTTON = LazyElementFactory.getWithFilterParameters(CheckoutOverviewConstants.CANCEL_BUTTON_NAME, CheckoutOverviewConstants.CANCEL_BUTTON_LOCATOR);
}

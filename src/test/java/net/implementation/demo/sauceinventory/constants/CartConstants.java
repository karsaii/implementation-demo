package net.implementation.demo.sauceinventory.constants;

import com.neathorium.thorium.framework.core.namespaces.factory.LazyLocatorFactory;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.framework.selenium.constants.SelectorStrategyNameConstants;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import com.neathorium.thorium.framework.selenium.records.lazy.LazyElement;

public abstract class CartConstants {
    public static final String NAME = "Cart - ";
    public static final String FUNCTION_NAME = "CartFunctions.";
    public static final String TITLE_EN = "Your Cart";

    public static final String CONTAINER_NAME = CartConstants.NAME + "Container";
    public static final String CHECKOUT_BUTTON_NAME = CartConstants.NAME + "Checkout Button";
    public static final String BACK_BUTTON_NAME = CartConstants.NAME + "Continue Shopping (Back) Button";

    public static final String CONTAINER_SELECTOR = "div[id*='cart_contents_container']";
    public static final String CHECKOUT_BUTTON_SELECTOR = CartConstants.CONTAINER_SELECTOR + " button[id*='checkout']";
    public static final String BACK_BUTTON_SELECTOR = CartConstants.CONTAINER_SELECTOR + " button[id*='continue-shopping']";

    public static final LazyLocator CONTAINER_LOCATOR = LazyLocatorFactory.get(CartConstants.CONTAINER_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator CHECKOUT_BUTTON_LOCATOR = LazyLocatorFactory.get(CartConstants.CHECKOUT_BUTTON_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator BACK_BUTTON_LOCATOR = LazyLocatorFactory.get(CartConstants.BACK_BUTTON_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);

    public static final LazyElement HEADER = LazyElementFactory.getWithFilterParameters(CartConstants.NAME + HeaderConstants.NAME, CartConstants.TITLE_EN, HeaderConstants.HEADER_TITLE_LOCATOR);
    public static final LazyElement CONTAINER = LazyElementFactory.getWithFilterParameters(CartConstants.CONTAINER_NAME, CartConstants.CONTAINER_LOCATOR);
    public static final LazyElement CHECKOUT_BUTTON = LazyElementFactory.getWithFilterParameters(CartConstants.CHECKOUT_BUTTON_NAME, CartConstants.CHECKOUT_BUTTON_LOCATOR);
    public static final LazyElement BACK_BUTTON = LazyElementFactory.getWithFilterParameters(CartConstants.BACK_BUTTON_NAME, CartConstants.BACK_BUTTON_LOCATOR);
}

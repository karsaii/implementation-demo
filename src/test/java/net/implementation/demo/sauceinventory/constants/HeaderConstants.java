package net.implementation.demo.sauceinventory.constants;

import com.neathorium.thorium.framework.core.namespaces.factory.LazyLocatorFactory;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.framework.selenium.constants.SelectorStrategyNameConstants;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import com.neathorium.thorium.framework.selenium.records.lazy.LazyElement;

public abstract class HeaderConstants {
    public static final String NAME = "Header - ";
    public static final String FUNCTION_NAME = "HeaderFunctions.";
    public static final String HEADER_TITLE_NAME = CartConstants.NAME + "Header Title";

    public static final String HEADER_TITLE_SELECTOR = "div[class*='header_secondary_container'] > span[class='title']";
    public static final LazyLocator HEADER_TITLE_LOCATOR = LazyLocatorFactory.get(HeaderConstants.HEADER_TITLE_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);

    public static final LazyElement HEADER_TITLE = LazyElementFactory.getWithFilterParameters(HeaderConstants.HEADER_TITLE_NAME, HeaderConstants.HEADER_TITLE_LOCATOR);
}

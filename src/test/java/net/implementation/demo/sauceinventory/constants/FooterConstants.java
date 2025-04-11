package net.implementation.demo.sauceinventory.constants;

import com.neathorium.thorium.framework.core.namespaces.factory.LazyLocatorFactory;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.framework.selenium.constants.SelectorStrategyNameConstants;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import com.neathorium.thorium.framework.selenium.records.lazy.LazyElement;

public abstract class FooterConstants {
    public static final String NAME = "Footer";
    public static final String FUNCTION_NAME = "FooterFunctions.";

    public static final String FOOTER_NAME = FooterConstants.NAME + "Footer";
    public static final String FOOTER_SELECTOR = "div[id*='root'] div[id='page_wrapper'] footer[class='footer'][data-test='footer']";
    public static final LazyLocator FOOTER_LOCATOR = LazyLocatorFactory.get(FooterConstants.FOOTER_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);

    public static final LazyElement FOOTER = LazyElementFactory.getWithFilterParameters(FOOTER_NAME, FOOTER_LOCATOR);
}

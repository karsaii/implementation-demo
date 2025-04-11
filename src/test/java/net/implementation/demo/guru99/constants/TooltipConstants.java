package net.implementation.demo.guru99.constants;

import com.neathorium.thorium.framework.core.namespaces.factory.LazyLocatorFactory;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.framework.selenium.constants.SelectorStrategyNameConstants;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import com.neathorium.thorium.framework.selenium.records.lazy.LazyElement;

public abstract class TooltipConstants {
    public static final String NAME = "Tooltip Page - ";
    public static final String FUNCTION_NAME = "TooltipFunctions.";

    public static final String DOWNLOAD_BUTTON_NAME = TooltipConstants.NAME + "Download button";
    public static final String DOWNLOAD_BUTTON_SELECTOR = "div[id*='content'] div[id*='demo_content'] a[id='download_now']";

    public static final LazyLocator DOWNLOAD_BUTTON_LOCATOR = LazyLocatorFactory.get(TooltipConstants.DOWNLOAD_BUTTON_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);

    public static final LazyElement DOWNLOAD_BUTTON = LazyElementFactory.getWithFilterParameters(TooltipConstants.DOWNLOAD_BUTTON_NAME, TooltipConstants.DOWNLOAD_BUTTON_LOCATOR);
}

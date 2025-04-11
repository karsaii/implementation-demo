package net.implementation.demo.guru99.constants;

import com.neathorium.thorium.framework.core.namespaces.factory.LazyLocatorFactory;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.framework.selenium.constants.SelectorStrategyNameConstants;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import com.neathorium.thorium.framework.selenium.records.lazy.LazyElement;

public abstract class DemoConstants {
    public static final String URL = "https://demo.guru99.com/test/guru99home";
    public static final String NAME = "Demo - ";
    public static final String FUNCTION_NAME = "DemoFunctions.";

    public static final String FILTER_TEXT = "iFrame will not show if you have adBlock extension enabled";
    public static final String ALERT_TEXT_FRAGMENT = "Successfully";

    public static final String WARNING_MESSAGE_NAME = DemoConstants.NAME + "Warning Message";
    public static final String IFRAME_NAME = DemoConstants.NAME + "iFrame";
    public static final String IFRAME_IMAGE_NAME = DemoConstants.NAME + "iFrame Image";
    public static final String IFRAME_LINK_NAME = DemoConstants.NAME + "iFrame Link(\"Button\")";
    public static final String EMAIL_FIELD_NAME = DemoConstants.NAME + "Email Field";
    public static final String EMAIL_SUBMIT_BUTTON_NAME = DemoConstants.NAME + "Email Submit Button";
    public static final String NAVBAR_NAME = DemoConstants.NAME + "Navigation Bar";
    public static final String NAVBAR_SELENIUM_NAME = DemoConstants.NAVBAR_NAME + " Selenium";
    public static final String TOOLTIP_OPTION_NAME = DemoConstants.NAVBAR_SELENIUM_NAME + " - Tooltip Option";

    public static final String ARTICLE_ITEM_SELECTOR = "div[id*='rt-page-surround'] div[id*='rt-main'] article[class*='item-page']";
    public static final String WARNING_MESSAGE_SELECTOR = DemoConstants.ARTICLE_ITEM_SELECTOR + " h3";
    public static final String IFRAME_SELECTOR = DemoConstants.ARTICLE_ITEM_SELECTOR + " iframe[src*='ads.html']";
    public static final String IFRAME_LINK_SELECTOR = "a[href='http://www.guru99.com/live-selenium-project.html']";
    public static final String IFRAME_IMAGE_SELECTOR = DemoConstants.IFRAME_LINK_SELECTOR + " img";
    public static final String EMAIL_FIELD_SELECTOR = DemoConstants.ARTICLE_ITEM_SELECTOR + " form[id*='form'] input[id='philadelphia-field-email']";
    public static final String EMAIL_SUBMIT_BUTTON_SELECTOR = DemoConstants.ARTICLE_ITEM_SELECTOR + " form[id*='form'] button[id='philadelphia-field-submit']";
    public static final String NAVBAR_SELECTOR = "div[class*='container-fluid'] nav div[id*='navbar-brand-centered'] ul[class*='nav navbar-nav']";
    public static final String NAVBAR_SELENIUM_SELECTOR = DemoConstants.NAVBAR_SELECTOR + " li[class*='dropdown'] a[class*='dropdown-toggle']";
    public static final String TOOLTIP_OPTION_SELECTOR = DemoConstants.NAVBAR_SELECTOR + " ul[class*='dropdown-menu'] li a[href*='../tooltip.html']";

    public static final LazyLocator WARNING_MESSAGE_LOCATOR = LazyLocatorFactory.get(DemoConstants.WARNING_MESSAGE_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator IFRAME_LOCATOR = LazyLocatorFactory.get(DemoConstants.IFRAME_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator IFRAME_IMAGE_LOCATOR = LazyLocatorFactory.get(DemoConstants.IFRAME_IMAGE_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator IFRAME_LINK_LOCATOR = LazyLocatorFactory.get(DemoConstants.IFRAME_LINK_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator EMAIL_FIELD_LOCATOR = LazyLocatorFactory.get(DemoConstants.EMAIL_FIELD_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator EMAIL_SUBMIT_BUTTON_LOCATOR = LazyLocatorFactory.get(DemoConstants.EMAIL_SUBMIT_BUTTON_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator NAVBAR_LOCATOR = LazyLocatorFactory.get(DemoConstants.NAVBAR_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator NAVBAR_SELENIUM_LOCATOR = LazyLocatorFactory.get(DemoConstants.NAVBAR_SELENIUM_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator TOOLTIP_OPTION_LOCATOR = LazyLocatorFactory.get(DemoConstants.TOOLTIP_OPTION_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);

    public static final LazyElement IFRAME = LazyElementFactory.getWithFilterParameters(DemoConstants.IFRAME_NAME, DemoConstants.IFRAME_LOCATOR);
    public static final LazyElement WARNING_MESSAGE = LazyElementFactory.getWithFilterParameters(DemoConstants.WARNING_MESSAGE_NAME, DemoConstants.FILTER_TEXT, DemoConstants.WARNING_MESSAGE_LOCATOR);
    public static final LazyElement IFRAME_IMAGE = LazyElementFactory.getWithFilterParameters(DemoConstants.IFRAME_IMAGE_NAME, DemoConstants.IFRAME_IMAGE_LOCATOR);
    public static final LazyElement IFRAME_LINK = LazyElementFactory.getWithFilterParameters(DemoConstants.IFRAME_LINK_NAME, DemoConstants.IFRAME_LINK_LOCATOR);
    public static final LazyElement EMAIL_FIELD = LazyElementFactory.getWithFilterParameters(DemoConstants.EMAIL_FIELD_NAME, DemoConstants.EMAIL_FIELD_LOCATOR);
    public static final LazyElement EMAIL_SUBMIT_BUTTON = LazyElementFactory.getWithFilterParameters(DemoConstants.EMAIL_SUBMIT_BUTTON_NAME, DemoConstants.EMAIL_SUBMIT_BUTTON_LOCATOR);
    public static final LazyElement NAVBAR = LazyElementFactory.getWithFilterParameters(DemoConstants.NAVBAR_NAME, DemoConstants.NAVBAR_LOCATOR);
    public static final LazyElement NAVBAR_SELENIUM = LazyElementFactory.getWithFilterParameters(DemoConstants.NAVBAR_SELENIUM_NAME, DemoConstants.NAVBAR_SELENIUM_LOCATOR);
    public static final LazyElement TOOLTIP_OPTION = LazyElementFactory.getWithFilterParameters(DemoConstants.TOOLTIP_OPTION_NAME, DemoConstants.TOOLTIP_OPTION_LOCATOR);
}

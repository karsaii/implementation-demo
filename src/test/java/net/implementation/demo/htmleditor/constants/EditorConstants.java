package net.implementation.demo.htmleditor.constants;

import com.neathorium.thorium.framework.core.namespaces.factory.LazyLocatorFactory;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.framework.selenium.constants.SelectorStrategyNameConstants;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import com.neathorium.thorium.framework.selenium.records.lazy.LazyElement;

public abstract class EditorConstants {
    public static final String NAME = "Online HTML Editor - ";
    public static final String FUNCTION_NAME = "EditorFunctions - ";
    public static final String BASE_URL = "https://onlinehtmleditor.dev/";

    public static final String CONTAINER_NAME = EditorConstants.NAME + "Container";
    public static final String INPUT_FIELD_NAME = EditorConstants.NAME + "Editor Field";
    public static final String ITEMS_TOOLBAR_NAME = EditorConstants.NAME + "Editor Toolbar";
    public static final String BOLD_BUTTON_NAME = EditorConstants.NAME + "Bold Style";
    public static final String UNDERLINE_BUTTON_NAME = EditorConstants.NAME + "Underline Style";

    public static final String CONTAINER_SELECTOR = "div[class*='container']";
    public static final String INPUT_FIELD_SELECTOR = "div[class='ck ck-editor__main'] > div[class*='ck-editor__editable']";
    public static final String ITEMS_TOOLBAR_SELECTOR = "div[class='ck ck-toolbar__items']";
    public static final String BOLD_BUTTON_SELECTOR = EditorConstants.ITEMS_TOOLBAR_SELECTOR + " button[class*='ck-button'][data-cke-tooltip-text*='Bold ']";
    public static final String UNDERLINE_BUTTON_SELECTOR = EditorConstants.ITEMS_TOOLBAR_SELECTOR + " button[class*='ck-button'][data-cke-tooltip-text*='Underline ']";
    public static final String BOLD_INPUT_TEXT_SELECTOR = EditorConstants.INPUT_FIELD_SELECTOR + " strong";
    public static final String UNDERLINE_INPUT_TEXT_SELECTOR = EditorConstants.INPUT_FIELD_SELECTOR + " u";

    public static final LazyLocator CONTAINER_LOCATOR = LazyLocatorFactory.get(EditorConstants.CONTAINER_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator INPUT_FIELD_LOCATOR = LazyLocatorFactory.get(EditorConstants.INPUT_FIELD_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator ITEMS_TOOLBAR_LOCATOR = LazyLocatorFactory.get(EditorConstants.ITEMS_TOOLBAR_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator BOLD_BUTTON_LOCATOR = LazyLocatorFactory.get(EditorConstants.BOLD_BUTTON_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator UNDERLINE_BUTTON_LOCATOR = LazyLocatorFactory.get(EditorConstants.UNDERLINE_BUTTON_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator BOLD_INPUT_TEXT_LOCATOR = LazyLocatorFactory.get(EditorConstants.BOLD_INPUT_TEXT_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator UNDERLINE_INPUT_TEXT_LOCATOR = LazyLocatorFactory.get(EditorConstants.UNDERLINE_INPUT_TEXT_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);

    public static final LazyElement CONTAINER = LazyElementFactory.getWithFilterParameters(EditorConstants.CONTAINER_NAME, EditorConstants.CONTAINER_LOCATOR);
    public static final LazyElement INPUT_FIELD = LazyElementFactory.getWithFilterParameters(EditorConstants.INPUT_FIELD_NAME, EditorConstants.INPUT_FIELD_LOCATOR);
    public static final LazyElement ITEMS_TOOLBAR = LazyElementFactory.getWithFilterParameters(EditorConstants.ITEMS_TOOLBAR_NAME, EditorConstants.ITEMS_TOOLBAR_LOCATOR);
    public static final LazyElement BOLD_BUTTON = LazyElementFactory.getWithFilterParameters(EditorConstants.BOLD_BUTTON_NAME, EditorConstants.BOLD_BUTTON_LOCATOR);
    public static final LazyElement UNDERLINE_BUTTON = LazyElementFactory.getWithFilterParameters(EditorConstants.UNDERLINE_BUTTON_NAME, EditorConstants.UNDERLINE_BUTTON_LOCATOR);

}

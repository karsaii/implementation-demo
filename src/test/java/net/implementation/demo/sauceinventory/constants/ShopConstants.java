package net.implementation.demo.sauceinventory.constants;

import com.neathorium.thorium.framework.core.namespaces.factory.LazyLocatorFactory;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.framework.selenium.constants.SelectorStrategyNameConstants;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import com.neathorium.thorium.framework.selenium.records.lazy.LazyElement;

public abstract class ShopConstants {
    public static final String NAME = "Shop - ";
    public static final String FUNCTION_NAME = "ShopFunctions.";

    public static final String INVENTORY_ITEM_NAME = ShopConstants.NAME + "Inventory Item";
    public static final String ADD_ITEM_NAME = ShopConstants.NAME + "Add Item Button";
    public static final String SHOPPING_CART_NAME = ShopConstants.NAME + "Shopping Cart";
    public static final String SHOPPING_CART_CONTAINER_NAME = ShopConstants.SHOPPING_CART_NAME + " Container";

    public static final String INVENTORY_ITEM_SELECTOR = "div[class*='inventory_item'] div[class*='inventory_item_description']";
    public static final String ADD_ITEM_SELECTOR = "button[id*='add-to-cart']";
    public static final String SHOPPING_CART_CONTAINER_SELECTOR = "div[id*='shopping_cart_container']";
    public static final String SHOPPING_CART_SELECTOR = ShopConstants.SHOPPING_CART_CONTAINER_SELECTOR + " a[data-test='shopping-cart-link']";

    public static final LazyLocator INVENTORY_ITEM_LOCATOR = LazyLocatorFactory.get(ShopConstants.INVENTORY_ITEM_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator ADD_ITEM_LOCATOR = LazyLocatorFactory.get(ShopConstants.ADD_ITEM_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator SHOPPING_CART_CONTAINER_LOCATOR = LazyLocatorFactory.get(ShopConstants.SHOPPING_CART_CONTAINER_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);
    public static final LazyLocator SHOPPING_CART_LOCATOR = LazyLocatorFactory.get(ShopConstants.SHOPPING_CART_SELECTOR, SelectorStrategyNameConstants.CSS_SELECTOR);

    public static final LazyElement SHOPPING_CART_CONTAINER = LazyElementFactory.getWithFilterParameters(ShopConstants.SHOPPING_CART_CONTAINER_NAME, ShopConstants.SHOPPING_CART_CONTAINER_LOCATOR);
    public static final LazyElement SHOPPING_CART = LazyElementFactory.getWithFilterParameters(ShopConstants.SHOPPING_CART_NAME, ShopConstants.SHOPPING_CART_LOCATOR);
}

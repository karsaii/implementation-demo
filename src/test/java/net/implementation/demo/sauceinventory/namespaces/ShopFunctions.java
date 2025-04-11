package net.implementation.demo.sauceinventory.namespaces;

import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.data.constants.CoreDataConstants;
import com.neathorium.thorium.core.data.namespaces.DataFunctions;
import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.core.data.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.framework.core.namespaces.factory.LazyLocatorFactory;
import com.neathorium.thorium.framework.selenium.constants.SelectorStrategyNameConstants;
import com.neathorium.thorium.framework.selenium.namespaces.Driver;
import com.neathorium.thorium.framework.selenium.namespaces.ExecutionCore;
import com.neathorium.thorium.framework.selenium.namespaces.SeleniumExecutor;
import com.neathorium.thorium.framework.selenium.namespaces.element.Element;
import com.neathorium.thorium.framework.selenium.namespaces.element.ElementExpectedConditions;
import com.neathorium.thorium.framework.selenium.namespaces.extensions.boilers.DriverFunction;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import net.implementation.demo.sauceinventory.constants.ShopConstants;
import net.implementation.demo.sauceinventory.records.ItemWaitData;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public interface ShopFunctions {
    private static Data<String> getItemId(WebDriver driver, String itemName) {
        final var nameof = ShopConstants.FUNCTION_NAME + "getItemAddButton";
        final var errors = CoreFormatter.isBlankMessageWithName(itemName, "Item name");
        if (StringUtils.isNotBlank(errors)) {
            return DataFactoryFunctions.getInvalidWith("", nameof, errors);
        }

        final var lazyElement = LazyElementFactory.getWithFilterParameters("Item " + itemName, itemName, ShopConstants.INVENTORY_ITEM_LOCATOR);
        final var waitData = Element.waitDisplayed(lazyElement, 300, 30000).apply(driver);
        if (DataPredicates.isInvalidOrFalse(waitData)) {
            return DataFactoryFunctions.getInvalidWith("", nameof, DataFunctions.getFormattedMessage(waitData));
        }
        final var elementData = Driver.getLazyElement(lazyElement).apply(driver);
        if (DataPredicates.isInvalidOrFalse(elementData)) {
            return DataFactoryFunctions.getInvalidWith("", nameof, DataFunctions.getFormattedMessage(elementData));
        }

        final var searchContextData = DataFactoryFunctions.replaceObject(elementData, (SearchContext)DataFunctions.getObject(elementData));
        final var buttonData = Driver.getNestedElement(ShopConstants.ADD_ITEM_LOCATOR).apply(searchContextData);
        if (DataPredicates.isInvalidOrFalse(buttonData)) {
            return DataFactoryFunctions.getInvalidWith("", nameof, DataFunctions.getFormattedMessage(buttonData));
        }

        final var button = DataFunctions.getObject(buttonData);
        return DataFactoryFunctions.getWith(button.getDomProperty("id"), true, nameof, "Attempted getting id of element" + CoreFormatterConstants.END_LINE);
    }

    static DriverFunction<String> getItemId(String itemName) {
        final var nameof = ShopConstants.FUNCTION_NAME + "getItemId";
        return ExecutionCore.ifDriver(nameof,
             driver -> ShopFunctions.getItemId(driver, itemName),
            DataFactoryFunctions.getInvalidWith("", nameof, "Driver was null")
        );
    }

    private static Data<Boolean> doClickAddItem(WebDriver driver, String name, int interval, int duration) {
        final var nameof = ShopConstants.FUNCTION_NAME + "doClickAddItem";
        final var selectorData = ShopFunctions.getItemId(driver, name);
        if (DataPredicates.isInvalidOrFalse(selectorData)) {
            return DataFactoryFunctions.getBoolean(false, nameof, DataFunctions.getFormattedMessage(selectorData), selectorData.EXCEPTION());
        }

        final var selector = DataFunctions.getObject(selectorData);
        final var locator = LazyLocatorFactory.get(ShopConstants.INVENTORY_ITEM_SELECTOR + " button[id*='" + selector + "']", SelectorStrategyNameConstants.CSS_SELECTOR);
        final var element = LazyElementFactory.getWithFilterParameters(ShopConstants.ADD_ITEM_NAME + "(\"" + name + "\")" , locator);

        final var result = SeleniumExecutor.execute(
            nameof,
            Element.waitClickable(element, interval, duration),
            Element.clickWhenClickable(element)
        ).apply(driver);

        return DataFactoryFunctions.replaceObject(result, DataFunctions.getStatus(result));
    }

    static DriverFunction<Boolean> isCartContainerPresent() {
        final var nameof = ShopConstants.FUNCTION_NAME + "clickCart";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitPresent(ShopConstants.SHOPPING_CART_CONTAINER, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isCartDisplayed() {
        final var nameof = ShopConstants.FUNCTION_NAME + "isCartDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(ShopConstants.SHOPPING_CART, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isCartContaining(int amount) {
        final var nameof = ShopConstants.FUNCTION_NAME + "isCartContaining";
        return SeleniumExecutor.execute(
            nameof,
            ShopFunctions.isCartContainerPresent(),
            ShopFunctions.isCartDisplayed(),
            ElementExpectedConditions.isTextEquals(ShopConstants.SHOPPING_CART, "" + amount)
        );
    }

    static DriverFunction<Boolean> addItems(List<ItemWaitData> itemList) {
        final var nameof = ShopConstants.FUNCTION_NAME + "addItems";
        final var stepList = new ArrayList<DriverFunction<Boolean>>();
        for (var item : itemList) {
            stepList.add(driver -> ShopFunctions.doClickAddItem(driver, item.ITEM(), item.INTERVAL(), item.DURATION()));
        }
        stepList.add(ShopFunctions.isCartContaining(itemList.size()));
        return ExecutionCore.ifDriver(
            nameof,
            SeleniumExecutor.execute(
                stepList.toArray(new DriverFunction[0])
            ),
            CoreDataConstants.NULL_BOOLEAN
        );
    }

    static DriverFunction<Boolean> clickCart() {
        final var nameof = ShopConstants.FUNCTION_NAME + "clickCart";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitClickable(ShopConstants.SHOPPING_CART, 300, 30000),
            Element.clickWhenClickable(ShopConstants.SHOPPING_CART)
        );
    }


}

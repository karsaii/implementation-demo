package net.implementation.demo.guru99.namespaces;

import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.data.constants.CoreDataConstants;
import com.neathorium.thorium.core.data.namespaces.DataFunctions;
import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.core.data.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.core.wait.exceptions.WaitTimeoutException;
import com.neathorium.thorium.exceptions.constants.ExceptionConstants;
import com.neathorium.thorium.exceptions.namespaces.ExceptionFunctions;
import com.neathorium.thorium.framework.selenium.namespaces.*;
import com.neathorium.thorium.framework.selenium.namespaces.element.Element;
import com.neathorium.thorium.framework.selenium.namespaces.extensions.boilers.DriverFunction;
import com.neathorium.thorium.framework.selenium.namespaces.factories.DriverFunctionFactory;
import com.neathorium.thorium.framework.selenium.namespaces.utilities.SeleniumUtilities;
import com.neathorium.thorium.framework.selenium.records.scripter.ScriptParametersData;
import com.neathorium.thorium.java.extensions.namespaces.predicates.AmountPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;
import com.neathorium.thorium.java.extensions.namespaces.utilities.StringUtilities;
import net.implementation.demo.guru99.constants.DemoConstants;
import org.apache.commons.lang3.StringUtils;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public interface DemoFunctions {
    static DriverFunction<Boolean> navigateTo() {
        final var nameof = DemoConstants.FUNCTION_NAME + "navigateTo";
        return SeleniumExecutor.execute(
            nameof,
            DriverWaits.navigateAndWait(DemoConstants.URL, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isWarningDisplayed() {
        final var nameof = DemoConstants.FUNCTION_NAME + "isWarningDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(DemoConstants.WARNING_MESSAGE, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isIFrameDisplayed() {
        final var nameof = DemoConstants.FUNCTION_NAME + "isIFrameDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(DemoConstants.IFRAME, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isEmailFieldDisplayed() {
        final var nameof = DemoConstants.FUNCTION_NAME + "isEmailFieldDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(DemoConstants.EMAIL_FIELD, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isEmailSubmitButtonDisplayed() {
        final var nameof = DemoConstants.FUNCTION_NAME + "isEmailSubmitButtonDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(DemoConstants.EMAIL_SUBMIT_BUTTON, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isNavBarDisplayed() {
        final var nameof = DemoConstants.FUNCTION_NAME + "isNavBarDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(DemoConstants.NAVBAR, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isSeleniumItemDisplayed() {
        final var nameof = DemoConstants.FUNCTION_NAME + "isSeleniumItemDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(DemoConstants.NAVBAR_SELENIUM, 300, 30000)
        );
    }

    static DriverFunction<Boolean> clickSelenium() {
        final var nameof = DemoConstants.FUNCTION_NAME + "clickSelenium";
        return SeleniumExecutor.execute(
            nameof,
            DemoFunctions.isSeleniumItemDisplayed(),
            Element.click(DemoConstants.NAVBAR_SELENIUM)
        );
    }

    static DriverFunction<Boolean> isTooltipDisplayed() {
        final var nameof = DemoConstants.FUNCTION_NAME + "isTooltipDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(DemoConstants.TOOLTIP_OPTION, 300, 30000)
        );
    }

    static DriverFunction<Boolean> clickTooltip() {
        final var nameof = DemoConstants.FUNCTION_NAME + "clickTooltip";
        return SeleniumExecutor.execute(
            nameof,
            DemoFunctions.isTooltipDisplayed(),
            Driver.executeSingleParameter("document.querySelectorAll(arguments[0])[0].click(); return true;", ScriptExecuteFunctions.handleParameter(new ScriptParametersData<>(DemoConstants.TOOLTIP_OPTION_SELECTOR, StringUtils::isNotBlank, SeleniumUtilities::toArray)))
        );
    }

    static DriverFunction<Boolean> doNavigateTo() {
        final var nameof = DemoConstants.FUNCTION_NAME + "doNavigateTo";
        return SeleniumExecutor.execute(
            nameof,
            DemoFunctions.navigateTo(),
            DemoFunctions.isIFrameDisplayed(),
            DemoFunctions.isWarningDisplayed(),
            DemoFunctions.isEmailFieldDisplayed(),
            DemoFunctions.isEmailSubmitButtonDisplayed(),
            DemoFunctions.isNavBarDisplayed(),
            DemoFunctions.isSeleniumItemDisplayed()
        );
    }

    static DriverFunction<Boolean> clickEmailSubmitButton() {
        final var nameof = DemoConstants.FUNCTION_NAME + "clickEmailSubmitButton";
        return SeleniumExecutor.execute(
            nameof,
            DemoFunctions.isEmailSubmitButtonDisplayed(),
            Element.clickWhenClickable(DemoConstants.EMAIL_SUBMIT_BUTTON)
        );
    }

    private static DriverFunction<Alert> isAlertDisplayed(Map<String, Alert> map) {
        final var nameof = DemoConstants.FUNCTION_NAME + "isAlertDisplayed";
        final Function<AtomicReference<Alert>, DriverFunction<Alert>> checkStep = ref -> driver -> {
            Data<Alert> result = DataFactoryFunctions.getWith(null, false, "negativeNullAlert", "negativeNullAlert");
            var exception = ExceptionConstants.EXCEPTION;
            var message = "";
            var status = false;
            try {
                result = Driver.switchToAlert().apply(driver);
                status = true;
                message = "Alert is displayed" + CoreFormatterConstants.END_LINE;
            } catch (NoAlertPresentException ex) {
                message = "Alert isn't displayed" + CoreFormatterConstants.END_LINE;
            } catch (Exception blanketException) {
                message = "Exception occurred while checking for alert displayed" + CoreFormatterConstants.END_LINE + exception.getLocalizedMessage();
                exception = blanketException;
            }

            if (DataPredicates.isValidNonFalse(result)) {
                ref.set(result.OBJECT());
            }
            return DataFactoryFunctions.getWith(result.OBJECT(), status, message, exception);
        };

        final Function<AtomicReference<Alert>, DriverFunction<Boolean>> wrappedStep = ref -> driver -> {
            final var result = checkStep.apply(ref).apply(driver);
            return DataFactoryFunctions.replaceObject(result, DataFunctions.getStatus(result));
        };

        final DriverFunction<Alert> process = driver -> {
            final AtomicReference<Alert> alert = new AtomicReference<>(null);
            var exception = ExceptionConstants.EXCEPTION;
            try {
                WaitConditions.waitWith(wrappedStep.apply(alert), WaitPredicateFunctions::isTruthyData, 1000, 10000, "Alert displayed").apply(driver);
            } catch (WaitTimeoutException ex) {
                exception = ex;
            }
            final var verifierStatus = ExceptionFunctions.isNonException(exception);
            final var returnData = DataFactoryFunctions.getWith(alert.get(), verifierStatus, nameof, "displayed. " + verifierStatus, exception);
            if (DataPredicates.isValidNonFalse(returnData)) {
                map.put("Alert", DataFunctions.getObject(returnData));
            }

            return returnData;
        };
        return SeleniumExecutor.execute(
            nameof,
            process
        );
    }

    static DriverFunction<Boolean> isNoAlertPresent(Map<String, Alert> map) {
        final var nameof = DemoConstants.FUNCTION_NAME + "isNoAlertPresent";
        final DriverFunction<Boolean> step = (WebDriver driver) -> {
            final var result = DemoFunctions.isAlertDisplayed(map).apply(driver);
            final var exception = result.EXCEPTION();
            if (ExceptionFunctions.isException(exception)) {
                return DataFactoryFunctions.getBoolean(false, nameof, "Exception during checking for no alerts" + CoreFormatterConstants.END_LINE, exception);
            }

            return DataFactoryFunctions.getBoolean(NullablePredicates.isNull(DataFunctions.getObject(result)), nameof, "No alert present.");
        };
        return SeleniumExecutor.execute(
            nameof,
            step
        );
    }

    static DriverFunction<Alert> switchToAlert(Map<String, Alert> map) {
        final var nameof = DemoConstants.FUNCTION_NAME + "switchToAlert";
        return SeleniumExecutor.execute(
            nameof,
            DemoFunctions.isAlertDisplayed(map)
        );
    }

    static DriverFunction<Boolean> alertContainsText(Map<String, Alert> map, String expectedMessage) {
        final var nameof = DemoConstants.FUNCTION_NAME + "alertContainsText";
        final DriverFunction<Boolean> step = driver -> {
            final var errors = (
                CoreFormatter.isEmptyMessage(map, "Alert Map") +
                CoreFormatter.isBlankMessageWithName(expectedMessage, "Expected Message")
            );
            if (StringUtils.isNotBlank(errors)) {
                return DataFactoryFunctions.getInvalidWith(false, nameof, errors);
            }

            final var mapKey = "Alert";
            if (!map.containsKey(mapKey)) {
                return DataFactoryFunctions.getInvalidWith(false, nameof, "Alert key wasn't found in map" + CoreFormatterConstants.END_LINE);
            }

            final var text = map.get("Alert").getText();
            final var status = StringUtilities.contains(text, expectedMessage);
            final var message = "Text(\"" + text + "\") " + (status ? "" : "didn't") + " contain the expected text(\"" + expectedMessage + "\")" + CoreFormatterConstants.END_LINE;
            return DataFactoryFunctions.getBoolean(status, nameof, message);
        };
        return SeleniumExecutor.execute(
            nameof,
            step
        );
    }

    static DriverFunction<Boolean> dismissAlert(Map<String, Alert> map) {
        final var nameof = DemoConstants.FUNCTION_NAME + "dismissAlert";
        final DriverFunction<Boolean> step = driver -> {
            final var errors = CoreFormatter.isEmptyMessage(map, "Alert Map");
            if (StringUtils.isNotBlank(errors)) {
                return DataFactoryFunctions.getInvalidWith(false, nameof, errors);
            }

            final var mapKey = "Alert";
            if (!map.containsKey(mapKey)) {
                return DataFactoryFunctions.getInvalidWith(false, nameof, "Alert key wasn't found in map" + CoreFormatterConstants.END_LINE);
            }

            final var alert = map.get(mapKey);
            var exception = ExceptionConstants.EXCEPTION;
            try {
                alert.dismiss();
            } catch (Exception ex) {
                exception = ex;
            }

            map.remove(mapKey);

            final var status = ExceptionFunctions.isNonException(exception);
            final var message = "Alert " + (status ? "" : "un") + "successfully dismissed" + CoreFormatterConstants.END_LINE;
            return DataFactoryFunctions.getWith(status, status, nameof, message, exception);
        };
        return SeleniumExecutor.execute(
            nameof,
            step,
            DemoFunctions.isNoAlertPresent(map)
        );
    }

    static DriverFunction<Boolean> doAlertValidation(Map<String, Alert> map, String expected) {
        final var nameof = DemoConstants.FUNCTION_NAME + "doAlertValidation";
        return SeleniumExecutor.execute(
            nameof,
            DemoFunctions.switchToAlert(map),
            DemoFunctions.alertContainsText(map, expected),
            DemoFunctions.dismissAlert(map)
        );
    }

    static DriverFunction<Boolean> fillEmailField(String value) {
        final var nameof = DemoConstants.FUNCTION_NAME + "fillEmailField";
        return SeleniumExecutor.execute(
            nameof,
            DemoFunctions.isEmailFieldDisplayed(),
            Element.inputWhenClickable(DemoConstants.EMAIL_FIELD, value)
        );
    }

    static DriverFunction<Boolean> isIFrameImageDisplayed() {
        final var nameof = DemoConstants.FUNCTION_NAME + "isIFrameImageDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(DemoConstants.IFRAME_IMAGE, 300, 30000),
            Element.waitPresent(DemoConstants.IFRAME_LINK, 300, 30000)
        );
    }

    static String getCurrentFrameName(WebDriver driver) {
        return String.valueOf(((JavascriptExecutor)driver).executeScript("return self.name"));
    }

    static DriverFunction<Boolean> switchToFrame() {
        final var nameof = DemoConstants.FUNCTION_NAME + "switchToFrame";
        final DriverFunction<Boolean> switcher = driver -> {
            final var frameName = getCurrentFrameName(driver);
            final var element = Driver.getLazyElement(DemoConstants.IFRAME).apply(driver);

            if (DataPredicates.isInvalidOrFalse(element)) {
                return DataFactoryFunctions.getInvalidWith(false, nameof, DataFunctions.getFormattedMessage(element));
            }

            var exception = ExceptionConstants.EXCEPTION;
            try {
                driver.switchTo().frame(DataFunctions.getObject(element));
            } catch (Exception ex) {
                exception = ex;
            }
            final var switchStatus = ExceptionFunctions.isNonException(exception);
            if (!switchStatus) {
                return DataFactoryFunctions.getWith(false, false, nameof, "Switching to frame failed" + CoreFormatterConstants.END_LINE);
            }

            final DriverFunction<Boolean> step = d -> {
                final var name = String.valueOf(DemoFunctions.getCurrentFrameName(d));
                final var status = EqualsPredicates.isNotEqual(name, frameName);
                final var message = "Switched to frame " + (status ? "" : "un") + "successfully" + CoreFormatterConstants.END_LINE;
                return DataFactoryFunctions.getWith(status, status, "DemoFunctions.switchVerifier", message);
            };

            Data<Boolean> verifierResult = CoreDataConstants.NULL_BOOLEAN;
            try {
                verifierResult = WaitConditions.waitWith(step, WaitPredicateFunctions::isTruthyData, 1000, 10000, "switch to frame").apply(driver);
            } catch (WaitTimeoutException ex) {
                exception = ex;
            }

            final var verifierStatus = ExceptionFunctions.isNonException(exception);
            return DataFactoryFunctions.getWith(verifierStatus, verifierStatus, nameof, "switched. " + verifierStatus, exception);
        };
        return SeleniumExecutor.execute(
            nameof,
            DemoFunctions.isIFrameDisplayed(),
            //Driver.switchToFrame(DemoConstants.IFRAME.get())
            switcher
        );
    }

    static DriverFunction<Boolean> clickIframeImage(Map<String, String> windowHandles) {
        final var nameof = DemoConstants.FUNCTION_NAME + "clickIframeImage";
        return SeleniumExecutor.execute(
            nameof,
            DriverFunctionFactory.getFunction(
                driver -> {
                    final var windowHandlesData = Driver.getWindowHandles().apply(driver);
                    final var list = DataFunctions.getObject(windowHandlesData).stream().toList();
                    for (var item : list) {
                        windowHandles.put(item, item);
                    }

                    final var currentHandleData = Driver.getWindowHandle().apply(driver);
                    windowHandles.put("current", DataFunctions.getObject(currentHandleData));

                    var exception = ExceptionConstants.EXCEPTION;
                    try {
                        final var result = Driver.executeSingleParameter("document.querySelectorAll(arguments[0])[0].click(); return true;", ScriptExecuteFunctions.handleParameter(new ScriptParametersData<>(DemoConstants.IFRAME_IMAGE_SELECTOR, StringUtils::isNotBlank, SeleniumUtilities::toArray))).apply(driver);
                    } catch (Exception ex) {
                        exception = ex;
                    }
                    final var status = ExceptionFunctions.isNonException(exception);
                    return DataFactoryFunctions.getBoolean(status, nameof, status ? "Clicked iFrame image" : "Didn't click iframe image");
                }
            )
        );
    }

    static DriverFunction<Boolean> closeNewTab(Map<String, String> windowHandles) {
        final var nameof = DemoConstants.FUNCTION_NAME + "closeNewTab";
        final DriverFunction<Boolean> step = driver -> {
            final var baseHandle = windowHandles.get("current");
            final var knownHandles = windowHandles.keySet().stream().toList();
            final var driverHandlesData = Driver.getWindowHandles().apply(driver);
            if (DataPredicates.isInvalidOrFalse(driverHandlesData)) {
                return DataFactoryFunctions.getWith(false, false, nameof, "Error happened during getting windowhandles" + CoreFormatterConstants.END_LINE, driverHandlesData.EXCEPTION());
            }

            final var driverHandlesList = new ArrayList<>(DataFunctions.getObject(driverHandlesData).stream().toList());
            driverHandlesList.removeAll(knownHandles);
            if (AmountPredicates.isNotSingle(driverHandlesList::size)) {
                return DataFactoryFunctions.getWith(false, false, nameof, "Too many windowHandles to properly handle" + CoreFormatterConstants.END_LINE);
            }


            final var closingHandle = driverHandlesList.getFirst();
            final var switchData = Driver.switchToWindow(closingHandle).apply(driver);
            if (DataPredicates.isInvalidOrFalse(switchData)) {
                return DataFactoryFunctions.getWith(false, false, nameof, "Error happened during switching to new(closing) windowhandle" + CoreFormatterConstants.END_LINE, driverHandlesData.EXCEPTION());
            }

            var exception = ExceptionConstants.EXCEPTION;
            try {
                driver.close();
            } catch (Exception ex) {
                exception = ex;
            }

            final var closeStatus = ExceptionFunctions.isNonException(exception);
            if (!closeStatus) {
                return DataFactoryFunctions.getWith(closeStatus, closeStatus, nameof, "Error happened during closing windowhandle" + CoreFormatterConstants.END_LINE, exception);
            }

            final var switchToBaseData = Driver.switchToWindow(baseHandle).apply(driver);
            return DataFactoryFunctions.replaceObject(switchToBaseData, switchToBaseData.STATUS());
        };
        return SeleniumExecutor.execute(
            nameof,
            step
        );
    }
}

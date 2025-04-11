package net.implementation.demo.htmleditor.namespaces;

import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.data.namespaces.DataFunctions;
import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.core.data.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.framework.selenium.namespaces.DriverWaits;
import com.neathorium.thorium.framework.selenium.namespaces.SeleniumExecutor;
import com.neathorium.thorium.framework.selenium.namespaces.element.Element;
import com.neathorium.thorium.framework.selenium.namespaces.element.ElementExpectedConditions;
import com.neathorium.thorium.framework.selenium.namespaces.extensions.boilers.DriverFunction;
import com.neathorium.thorium.framework.selenium.namespaces.factories.lazy.LazyElementFactory;
import com.neathorium.thorium.framework.selenium.records.lazy.LazyElement;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EmptiablePredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import net.implementation.demo.htmleditor.constants.EditorConstants;
import net.implementation.demo.htmleditor.enums.TextStyle;
import net.implementation.demo.htmleditor.records.TextWithStyleData;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public interface EditorFunctions {
    EnumMap<TextStyle, DriverFunction<Boolean>> STYLE_MAP = new EnumMap<>(
        Map.ofEntries(
            Map.entry(TextStyle.BOLD, EditorFunctions.clickBoldButton()),
            Map.entry(TextStyle.UNDERLINE, EditorFunctions.clickUnderlineButton()),
            Map.entry(TextStyle.NONE, driver -> DataFactoryFunctions.getBoolean(true, "noneStyleFunction", "no style applied" + CoreFormatterConstants.END_LINE))
        )
    );

    static DriverFunction<Boolean> navigateTo() {
        final var nameof = EditorConstants.FUNCTION_NAME + "navigateTo";
        return SeleniumExecutor.execute(
            nameof,
            DriverWaits.navigateAndWait(EditorConstants.BASE_URL, 500, 30000)
        );
    }

    static DriverFunction<Boolean> isContainerDisplayed() {
        final var nameof = EditorConstants.FUNCTION_NAME + "isContainerDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(EditorConstants.CONTAINER, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isToolbarDisplayed() {
        final var nameof = EditorConstants.FUNCTION_NAME + "isToolbarDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(EditorConstants.ITEMS_TOOLBAR, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isBoldButtonDisplayed() {
        final var nameof = EditorConstants.FUNCTION_NAME + "isBoldButtonDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(EditorConstants.BOLD_BUTTON, 300, 30000)
        );
    }

    static DriverFunction<Boolean> clickBoldButton() {
        final var nameof = EditorConstants.FUNCTION_NAME + "isBoldButtonDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            EditorFunctions.isBoldButtonDisplayed(),
            Element.clickWhenClickable(EditorConstants.BOLD_BUTTON)
        );
    }

    static DriverFunction<Boolean> isEditorInputFieldClickable() {
        final var nameof = EditorConstants.FUNCTION_NAME + "isEditorInputFieldDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitClickable(EditorConstants.INPUT_FIELD, 300, 30000)
        );
    }

    static DriverFunction<Boolean> clickEditorInputField() {
        final var nameof = EditorConstants.FUNCTION_NAME + "isEditorInputFieldDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            EditorFunctions.isEditorInputFieldClickable(),
            Element.clickWhenClickable(EditorConstants.INPUT_FIELD)
        );
    }

    static DriverFunction<Boolean> isUnderlineButtonDisplayed() {
        final var nameof = EditorConstants.FUNCTION_NAME + "isUnderlineButtonDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(EditorConstants.UNDERLINE_BUTTON, 300, 30000)
        );
    }

    static DriverFunction<Boolean> clickUnderlineButton() {
        final var nameof = EditorConstants.FUNCTION_NAME + "clickUnderlineButton";
        return SeleniumExecutor.execute(
            nameof,
            EditorFunctions.isUnderlineButtonDisplayed(),
            Element.clickWhenClickable(EditorConstants.UNDERLINE_BUTTON)
        );
    }

    static DriverFunction<Boolean> doNavigateTo() {
        final var nameof = EditorConstants.FUNCTION_NAME + "navigateTo";
        return SeleniumExecutor.execute(
            nameof,
            EditorFunctions.navigateTo(),
            EditorFunctions.isContainerDisplayed(),
            EditorFunctions.isToolbarDisplayed(),
            EditorFunctions.isBoldButtonDisplayed(),
            EditorFunctions.isUnderlineButtonDisplayed()
        );
    }

    private static DriverFunction<Boolean> inputStyledText(DriverFunction<Boolean> styleToggleFunction, String value) {
        return SeleniumExecutor.execute(
            EditorFunctions.clickEditorInputField(),
            Element.sendKeys(EditorConstants.INPUT_FIELD, Keys.chord(Keys.END)),
            styleToggleFunction,
            Element.inputWhenClickable(EditorConstants.INPUT_FIELD, value),
            styleToggleFunction
        );
    }

    static DriverFunction<Boolean> inputBoldText(String value) {
        final var nameof = EditorConstants.FUNCTION_NAME + "inputBoldText";
        final var toggleFunction = EditorFunctions.clickBoldButton();
        final var textValidationElement = LazyElementFactory.getWithFilterParameters(value + " Text", value, EditorConstants.BOLD_INPUT_TEXT_LOCATOR);
        return SeleniumExecutor.execute(
            nameof,
            EditorFunctions.inputStyledText(toggleFunction, value),
            ElementExpectedConditions.isTextEquals(textValidationElement, value)
        );
    }

    static DriverFunction<Boolean> inputUnderlineText(String value) {
        final var nameof = EditorConstants.FUNCTION_NAME + "inputUnderlineText";
        final var toggleFunction = EditorFunctions.clickUnderlineButton();
        final var textValidationElement = LazyElementFactory.getWithFilterParameters(value + " Text", value, EditorConstants.UNDERLINE_INPUT_TEXT_LOCATOR);
        return SeleniumExecutor.execute(
            nameof,
            EditorFunctions.inputStyledText(toggleFunction, value),
            ElementExpectedConditions.isTextEquals(textValidationElement, value)
        );
    }

    static DriverFunction<Boolean> inputText(String value) {
        final var nameof = EditorConstants.FUNCTION_NAME + "inputText";
        return SeleniumExecutor.execute(
            nameof,
            EditorFunctions.clickEditorInputField(),
            Element.sendKeys(EditorConstants.INPUT_FIELD, Keys.chord(Keys.END)),
            Element.inputWhenClickable(EditorConstants.INPUT_FIELD, value),
            ElementExpectedConditions.isTextContains(EditorConstants.INPUT_FIELD, value)
        );
    }

    static DriverFunction<Boolean> checkEditorTextContent(String value) {
        final var nameof = EditorConstants.FUNCTION_NAME + "checkEditorTextContent";
        return SeleniumExecutor.execute(
            nameof,
            EditorFunctions.isEditorInputFieldClickable(),
            ElementExpectedConditions.isTextEquals(EditorConstants.INPUT_FIELD, value)
        );
    }

    private static DriverFunction<Boolean> compareSanitizedText(LazyElement element, String expected) {
        return driver -> {
            final var textData = Element.getText(element).apply(driver);
            if (DataPredicates.isInvalidOrFalse(textData)) {
                return DataFactoryFunctions.replaceObject(textData, false);
            }
            final var regex = "[\\p{C}]";

            final var pattern = Pattern.compile(regex);
            final var matcher = pattern.matcher(DataFunctions.getObject(textData));
            final var sanitizedText = matcher.replaceAll("");
            return DataFactoryFunctions.replaceObject(textData, EqualsPredicates.isEqual(sanitizedText, expected));
        };
    }

    static DriverFunction<Boolean> inputStyledText(List<TextWithStyleData> list) {
        final var localNameof = EditorConstants.FUNCTION_NAME + "inputStyledText";
        final var inputFunctionsList = new ArrayList<DriverFunction<Boolean>>();
        final var valueList = new ArrayList<String>();
        for (var item : list) {
            final var toggles = new ArrayList<DriverFunction<Boolean>>();
            final var styleList = item.STYLE_LIST();
            if (EmptiablePredicates.isNotNullAndNonEmpty(styleList))
                for (var style : styleList) {
                    toggles.add(STYLE_MAP.get(style));
                }
            else {
                toggles.add(STYLE_MAP.get(TextStyle.NONE));
            }

            final var value = item.TEXT();
            valueList.add(value);
            final DriverFunction<Boolean> toggleStep = SeleniumExecutor.execute(toggles.toArray(new DriverFunction[0]));
            inputFunctionsList.add(EditorFunctions.inputStyledText(toggleStep, value));
        }

        final DriverFunction<Boolean> inputStep = SeleniumExecutor.execute(inputFunctionsList.toArray(new DriverFunction[0]));
        final var expected = String.join("", valueList);
        return SeleniumExecutor.execute(
            localNameof,
            inputStep,
            EditorFunctions.compareSanitizedText(EditorConstants.INPUT_FIELD, expected)
        );
    }
}

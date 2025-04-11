package net.implementation.demo.sauceinventory.namespaces;

import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.framework.selenium.namespaces.SeleniumExecutor;
import com.neathorium.thorium.framework.selenium.namespaces.element.Element;
import com.neathorium.thorium.framework.selenium.namespaces.element.ElementExpectedConditions;
import com.neathorium.thorium.framework.selenium.namespaces.extensions.boilers.DriverFunction;
import com.neathorium.thorium.framework.selenium.namespaces.scripter.Execute;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EmptiablePredicates;
import net.implementation.demo.sauceinventory.constants.FooterConstants;

import java.util.ArrayList;
import java.util.List;

public interface FooterFunctions {
    static DriverFunction<Boolean> isFooterDisplayed() {
        final var nameof = FooterConstants.FUNCTION_NAME + "isFooterDisplayed";
        return SeleniumExecutor.execute(
            nameof,
            Element.waitDisplayed(FooterConstants.FOOTER, 300, 30000)
        );
    }

    static DriverFunction<Boolean> isFooterContaining(String value) {
        final var nameof = FooterConstants.FUNCTION_NAME + "isFooterContaining";
        return SeleniumExecutor.execute(
            nameof,
            ElementExpectedConditions.isTextContains(FooterConstants.FOOTER, value)
        );
    }

    static DriverFunction<Boolean> isFooterContaining(List<String> list) {
        final var nameof = FooterConstants.FUNCTION_NAME + "isFooterContaining";
        if (EmptiablePredicates.isNullOrEmpty(list)) {
            return driver -> DataFactoryFunctions.getInvalidWith(false, nameof, "List was null or empty" + CoreFormatterConstants.END_LINE);
        }

        final var stepsList = new ArrayList<DriverFunction<Boolean>>();
        stepsList.add(FooterFunctions.isFooterDisplayed());
        for (var item : list) {
            stepsList.add(FooterFunctions.isFooterContaining(item));
        }

        return SeleniumExecutor.execute(
            nameof,
            stepsList.toArray(new DriverFunction[0])
        );
    }

    static DriverFunction<Boolean> scrollFooterIntoView() {
        final var nameof = FooterConstants.FUNCTION_NAME + "scrollFooterIntoView";
        return SeleniumExecutor.execute(
            nameof,
            FooterFunctions.isFooterDisplayed(),
            Execute.scrollIntoViewEvenDisplayed(FooterConstants.FOOTER, 300, 30000)
        );
    }
}

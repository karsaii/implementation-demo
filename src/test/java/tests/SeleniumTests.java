package tests;

import com.neathorium.thorium.core.data.namespaces.DataFunctions;
import com.neathorium.thorium.framework.selenium.namespaces.Driver;
import com.neathorium.thorium.framework.selenium.namespaces.SeleniumExecutor;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;
import common.AssertionConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.implementation.demo.common.constants.JSONConstants;
import net.implementation.demo.common.constants.PathConstants;
import net.implementation.demo.guru99.constants.DemoConstants;
import net.implementation.demo.guru99.namespaces.DemoFunctions;
import net.implementation.demo.guru99.namespaces.TooltipFunctions;
import net.implementation.demo.htmleditor.enums.TextStyle;
import net.implementation.demo.htmleditor.namespaces.EditorFunctions;
import net.implementation.demo.htmleditor.records.TextWithStyleData;
import net.implementation.demo.common.namespaces.FileUtils;
import net.implementation.demo.common.namespaces.JSONFunctions;

import net.implementation.demo.common.records.Credentials;
import net.implementation.demo.sauceinventory.constants.LoginConstants;
import net.implementation.demo.sauceinventory.namespaces.FooterFunctions;
import net.implementation.demo.sauceinventory.namespaces.LoginFunctions;
import net.implementation.demo.sauceinventory.namespaces.ShopFunctions;
import net.implementation.demo.sauceinventory.namespaces.checkout.CheckoutFunctions;
import net.implementation.demo.sauceinventory.records.ItemWaitData;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SeleniumTests {
    public static WebDriver driver = null;
    @BeforeAll
    static void beforeAll() {
        BasicConfigurator.configure();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void beforeEach() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    void afterEach() {
        if (NullablePredicates.isNotNull(driver)) {
            driver.close();
        }
    }

    @Test
    void case1_automatePurchaseProcessTest() {
        final var jsonData = FileUtils.readFile(PathConstants.CREDENTIALS_FILE_PATH);
        DataFunctions.throwIfInvalid(jsonData);
        final var credData = JSONFunctions.getCredentials(JSONConstants.MAPPER, DataFunctions.getObject(jsonData));
        DataFunctions.throwIfInvalid(credData);
        final var itemList = Arrays.asList(
            new ItemWaitData("Sauce Labs Backpack", 300, 30000),
            new ItemWaitData("Sauce Labs Fleece Jacket", 300, 30000)
        );
        final var expectedMessage = "Thank you for your order!";
        final var url = LoginConstants.INVENTORY_BASE_URL + "inventory.html";

        final var results = SeleniumExecutor.execute(
            Driver.navigate(url),
            LoginFunctions.navigateTo(),
            LoginFunctions.doLogin(DataFunctions.getObject(credData)),
            ShopFunctions.addItems(itemList),
            CheckoutFunctions.completeCheckoutWithResult(expectedMessage)

        ).apply(driver);

        AssertionConstants.ASSERT_DATA_TRUE.accept(results);
    }

    @Test
    void case2_noCredentialsThenValidateFooter() {
        final var expectedTexts = List.of("2025", "Terms of Service");
        final var credentials = new Credentials("standard_user", "secret_sauce", "Test case 2 user credentials");
        final var results = SeleniumExecutor.execute(
            LoginFunctions.navigateTo(),
            LoginFunctions.doLoginNoCredentials(),
            LoginFunctions.isErrorDisplayed(LoginConstants.LOGIN_NO_USERNAME_ERROR_EN),
            LoginFunctions.doLogin(credentials),
            FooterFunctions.scrollFooterIntoView(),
            FooterFunctions.isFooterContaining(expectedTexts)
        ).apply(driver);

        AssertionConstants.ASSERT_DATA_TRUE.accept(results);
    }

    @Test
    void case3_editorTest() {
        final var inputTextList = List.of(
            new TextWithStyleData("Automation", List.of(TextStyle.BOLD)),
            new TextWithStyleData(" ", List.of()),
            new TextWithStyleData("Test", List.of(TextStyle.UNDERLINE)),
            new TextWithStyleData(" Example", List.of())
        );

        final var results = SeleniumExecutor.execute(
            EditorFunctions.doNavigateTo(),
            EditorFunctions.inputStyledText(inputTextList)
        ).apply(driver);

        AssertionConstants.ASSERT_DATA_TRUE.accept(results);
    }

    @Test
    void case4_guru99IFrameTabTooltipTest() {
        final Map<String, Alert> map = new HashMap<>();
        final Map<String, String> windowHandles = new HashMap<>();
        final var results = SeleniumExecutor.execute(
            DemoFunctions.doNavigateTo(),
            DemoFunctions.switchToFrame(),
            DemoFunctions.clickIframeImage(windowHandles),
            DemoFunctions.closeNewTab(windowHandles),
            DemoFunctions.fillEmailField("a"),
            DemoFunctions.clickEmailSubmitButton(),
            DemoFunctions.doAlertValidation(map, DemoConstants.ALERT_TEXT_FRAGMENT),
            TooltipFunctions.navigateTo(),
            TooltipFunctions.isDownloadButtonDisplayed()
        ).apply(driver);

        AssertionConstants.ASSERT_DATA_TRUE.accept(results);
    }
}

package tests;

import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.data.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.java.extensions.namespaces.utilities.BooleanUtilities;
import com.neathorium.thorium.java.extensions.namespaces.utilities.StringUtilities;
import common.AssertionConstants;
import net.implementation.demo.typicodejson.namespaces.v1.UsersFunctions;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RestTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestTests.class);

    @BeforeAll
    static void setup() {
        BasicConfigurator.configure();
    }

    @Test
    void case5_getUsersLogDataAndVerifyFirstEmailContainsAtSymbolTest() {
        final var userListData = UsersFunctions.getUsersOkHttp();
        final var secondUserListData = UsersFunctions.getUsersApacheHttp();
        final var dataFetched = (
            DataPredicates.isValidNonFalse(userListData) &&
            DataPredicates.isValidNonFalse(secondUserListData)
        );

        if (BooleanUtilities.isFalse(dataFetched)) {
            throw new RuntimeException("There were issues during data fetching" + CoreFormatterConstants.END_LINE);
        }

        final var filteredList = UsersFunctions.getExtractedData(userListData);
        UsersFunctions.logExtractedData(RestTests.LOGGER, filteredList);
        final var firstItem = filteredList.getFirst();

        final var expectedSymbol = "@";
        final var status = StringUtilities.contains(firstItem.EMAIL(), expectedSymbol);
        final var message = "First item(" + firstItem + ") email didn't contain @" + CoreFormatterConstants.END_LINE;
        AssertionConstants.ASSERT_TRUE.accept(status, message);
    }
}

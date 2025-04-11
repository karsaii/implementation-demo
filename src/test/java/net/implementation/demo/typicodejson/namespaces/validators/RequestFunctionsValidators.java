package net.implementation.demo.typicodejson.namespaces.validators;

import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import net.implementation.demo.typicodejson.constants.RestConstants;
import net.implementation.demo.typicodejson.records.RequestData;
import okhttp3.Request;
import org.junit.platform.commons.util.StringUtils;

public class RequestFunctionsValidators {
    public static boolean isInvalid(Request.Builder builder) {
        return EqualsPredicates.isEqual(RestConstants.DEFAULT_WRONG_BUILDER, builder);
    }

    public static String isValid(Request.Builder builder, RequestData data) {
        final var nameof = "RequestFunctionsValidators.isValid";
        var errors = CoreFormatter.isNullMessageWithName(builder, "Request Builder");
        if (StringUtils.isBlank(errors) && RequestFunctionsValidators.isInvalid(builder)) {
            errors += "Builder was invalid(Matched default wrong builder)" + CoreFormatterConstants.END_LINE;
        }
        errors += CoreFormatter.isNullMessageWithName(data, "Request Data");

        return CoreFormatter.getNamedErrorMessageOrEmpty(nameof, errors);
    }
}

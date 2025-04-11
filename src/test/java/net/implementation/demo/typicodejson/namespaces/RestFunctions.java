package net.implementation.demo.typicodejson.namespaces;

import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.exceptions.constants.ExceptionConstants;
import com.neathorium.thorium.exceptions.namespaces.ExceptionFunctions;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.function.Function;

public interface RestFunctions {
    static Data<Response> doRequest(OkHttpClient client, Request request) {
        final var nameof = "RestFunctions.doRequest";
        final var errors = (
            CoreFormatter.isNullMessageWithName(client, "HTTP Client") +
            CoreFormatter.isNullMessageWithName(request, "Request")
        );
        if (StringUtils.isNotBlank(errors)) {
            return DataFactoryFunctions.getInvalidWith(null, nameof, errors);
        }

        Response response = null;
        var exception = ExceptionConstants.EXCEPTION;
        try {
            response = client.newCall(request).execute();
        } catch (IOException ex) {
            exception = ex;
        }

        final var status = ExceptionFunctions.isNonException(exception) && NullablePredicates.isNotNull(response);
        final var message = (status ? "No " : "") + "issues occurred during rest call" + CoreFormatterConstants.END_LINE;
        return DataFactoryFunctions.getWith(response, status, nameof, message, exception);
    }

    static Function<OkHttpClient, Data<Response>> doRequest(Request request) {
        return client -> RestFunctions.doRequest(client, request);
    }

    static Data<String> getBody(Response response) {
        final var nameof = "RestFunctions.getBody";
        final var errors = CoreFormatter.isNullMessageWithName(response, "Response");
        if (StringUtils.isNotBlank(errors)) {
            return DataFactoryFunctions.getInvalidWith("", nameof, errors);
        }

        var exception = ExceptionConstants.EXCEPTION;
        var body = "";
        try {
            body = response.body().string();
        } catch (IOException ex) {
            exception = ex;
        }

        final var status = ExceptionFunctions.isNonException(exception);
        final var message = (status ? "No " : "") + "issues occurred while getting body from response" + CoreFormatterConstants.EMPTY;
        return DataFactoryFunctions.getWith(body, status, nameof, message, exception);

    }
}

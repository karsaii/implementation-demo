package net.implementation.demo.typicodejson.namespaces;

import net.implementation.demo.typicodejson.constants.RestConstants;
import net.implementation.demo.typicodejson.namespaces.v1.RequestDataFunctions;
import net.implementation.demo.typicodejson.namespaces.validators.RequestFunctionsValidators;
import net.implementation.demo.typicodejson.records.RequestData;
import okhttp3.Request;
import org.junit.platform.commons.util.StringUtils;

public interface RequestFunctions {
    static Request.Builder setUrl(Request.Builder builder, RequestData data) {
        final var errors = RequestFunctionsValidators.isValid(builder, data);
        if (StringUtils.isNotBlank(errors)) {
            return RestConstants.DEFAULT_WRONG_BUILDER;
        }

        return builder.url(RequestDataFunctions.getUri(data));
    }

    static Request.Builder setMethod(Request.Builder builder, RequestData data) {
        final var errors = RequestFunctionsValidators.isValid(builder, data);
        if (StringUtils.isNotBlank(errors)) {
            return RestConstants.DEFAULT_WRONG_BUILDER;
        }

        return builder.method(data.TYPE().getName(), null);
    }

    static Request.Builder setHeaders(Request.Builder builder, RequestData data) {
        final var errors = RequestFunctionsValidators.isValid(builder, data);
        if (StringUtils.isNotBlank(errors)) {
            return RestConstants.DEFAULT_WRONG_BUILDER;
        }

        final var headers = data.HEADERS().entrySet();
        for (var headerEntry : headers) {
            builder.addHeader(headerEntry.getKey(), headerEntry.getValue());
        }

        return builder;
    }

    static Request.Builder setData(Request.Builder builder, RequestData data) {
        final var urlSet = RequestFunctions.setUrl(builder, data);
        final var methodSet = RequestFunctions.setMethod(urlSet, data);
        final var headersSet = RequestFunctions.setHeaders(methodSet, data);
        return headersSet;
    }

    static Request get(Request.Builder builder, RequestData data) {
        return RequestFunctions.setData(builder, data).build();
    }

    static Request get(RequestData data) {
        final var builder = new Request.Builder();

        return RequestFunctions.get(builder, data);
    }
}

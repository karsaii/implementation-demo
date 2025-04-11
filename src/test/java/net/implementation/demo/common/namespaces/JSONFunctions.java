package net.implementation.demo.common.namespaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.exceptions.constants.ExceptionConstants;
import com.neathorium.thorium.exceptions.namespaces.ExceptionFunctions;
import net.implementation.demo.common.constants.CredentialsConstants;
import net.implementation.demo.common.records.Credentials;
import net.implementation.demo.typicodejson.records.UserData;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public interface JSONFunctions {
    static Data<Credentials> getCredentials(ObjectMapper mapper, String json) {
        final var nameof = "JSONFunctions.getCredentials";
        var credentials = CredentialsConstants.NULL_CREDENTIALS;
        final var errors = (
            CoreFormatter.isNullMessageWithName(mapper, "ObjectMapper") +
            CoreFormatter.isNullMessageWithName(json, "JSON content")
        );
        if (StringUtils.isNotBlank(errors)) {
            return DataFactoryFunctions.getWith(credentials, false, nameof, errors);
        }

        var exception = ExceptionConstants.EXCEPTION;
        try {
            credentials = mapper.readValue(json, credentials.getClass());
        } catch (JsonProcessingException ex) {
            exception = ex;

        }

        final var status = ExceptionFunctions.isNonException(exception);
        final var message = (status ? "No " : "") + "occurred during JSON parsing" + CoreFormatterConstants.END_LINE;
        return DataFactoryFunctions.getWith(credentials, status, nameof, message, exception);
    }

    static Data<List<UserData>> getUserListData(ObjectMapper mapper, String json) {
        final var nameof = "JSONFunctions.getCredentials";
        List<UserData> userList = List.of();
        final var errors = (
            CoreFormatter.isNullMessageWithName(mapper, "ObjectMapper") +
            CoreFormatter.isNullMessageWithName(json, "JSON content")
        );
        if (StringUtils.isNotBlank(errors)) {
            return DataFactoryFunctions.getWith(userList, false, nameof, errors);
        }

        var exception = ExceptionConstants.EXCEPTION;
        try {
            var type = mapper.getTypeFactory().constructCollectionType(List.class, UserData.class);
            userList = mapper.readValue(json, type);
        } catch (JsonProcessingException ex) {
            exception = ex;

        }

        final var status = ExceptionFunctions.isNonException(exception);
        final var message = (status ? "No " : "") + "occurred during JSON parsing" + CoreFormatterConstants.END_LINE;
        return DataFactoryFunctions.getWith(userList, status, nameof, message, exception);
    }
}

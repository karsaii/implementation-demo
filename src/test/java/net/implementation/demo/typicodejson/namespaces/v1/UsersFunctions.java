package net.implementation.demo.typicodejson.namespaces.v1;

import com.neathorium.thorium.core.data.constants.CoreDataConstants;
import com.neathorium.thorium.core.data.namespaces.DataFunctions;
import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.core.data.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.exceptions.constants.ExceptionConstants;
import com.neathorium.thorium.exceptions.namespaces.ExceptionFunctions;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import net.implementation.demo.common.constants.JSONConstants;
import net.implementation.demo.common.namespaces.JSONFunctions;
import net.implementation.demo.typicodejson.constants.RestConstants;
import net.implementation.demo.typicodejson.constants.v1.RequestDataConstants;
import net.implementation.demo.typicodejson.namespaces.RequestFunctions;
import net.implementation.demo.typicodejson.namespaces.RestFunctions;
import net.implementation.demo.typicodejson.records.UsersExtractedData;
import net.implementation.demo.typicodejson.records.UserData;
import org.apache.commons.lang3.StringUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface UsersFunctions {
    static Data<List<UserData>> getUsersOkHttp() {
        final var nameof = "UsersFunctions.getUsers";
        final var requestData = RequestDataConstants.GET_USERS_DATA;
        final var request = RequestFunctions.get(requestData);
        final List<UserData> negativeList = List.of();
        final var defaultNegative = DataFactoryFunctions.getInvalidWith(negativeList, nameof, "");
        final var responseData = RestFunctions.doRequest(RestConstants.CLIENT, request);
        if (DataPredicates.isInvalidOrFalse(responseData)) {
            return DataFactoryFunctions.replaceMessage(defaultNegative, DataFunctions.getFormattedMessage(responseData));
        }

        var statusCode = 404;
        Data<String> bodyData = CoreDataConstants.NULL_STRING;
        try (final var response = DataFunctions.getObject(responseData)) {
            statusCode = response.code();
            bodyData = RestFunctions.getBody(response);
        }

        if (DataPredicates.isInvalidOrFalse(bodyData)) {
            return DataFactoryFunctions.replaceMessage(defaultNegative, DataFunctions.getFormattedMessage(bodyData));
        }

        final var body = DataFunctions.getObject(bodyData);
        final var status = EqualsPredicates.isEqual(statusCode, requestData.RESPONSE_CODE());
        return status ? JSONFunctions.getUserListData(JSONConstants.MAPPER, body) : defaultNegative;
    }

    static Data<List<UserData>> getUsersApacheHttp() {
        final var nameof = "UsersFunctions.getUsersAlt";
        final List<UserData> negativeList = List.of();
        final var defaultNegative = DataFactoryFunctions.getInvalidWith(negativeList, nameof, "");
        final var requestData = RequestDataConstants.GET_USERS_DATA;

        var exception = ExceptionConstants.EXCEPTION;
        var statusCode = 404;
        var body = "";
        try(var httpclient = HttpClients.createDefault()) {
            final var httpget = new HttpGet(RequestDataFunctions.getUri(requestData));
            final var httpResponse = httpclient.execute(httpget);
            statusCode = httpResponse.getCode();
            body = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        } catch (IOException | ParseException ex) {
            exception = ex;
        }

        if (ExceptionFunctions.isException(exception)) {
            return DataFactoryFunctions.replaceMessage(defaultNegative, "Error occurred during http request: " + exception.getLocalizedMessage());
        }

        final var status = EqualsPredicates.isEqual(statusCode, requestData.RESPONSE_CODE());
        return status ? JSONFunctions.getUserListData(JSONConstants.MAPPER, body) : defaultNegative;
    }

    static List<UsersExtractedData> getExtractedData(Data<List<UserData>> userListData) {
        var errors = CoreFormatter.isNullMessageWithName(userListData, "User List Data");
        if (StringUtils.isNotBlank(errors)) {
            return List.of();
        }

        final var userList = DataFunctions.getObject(userListData);
        errors += CoreFormatter.isNullOrEmptyListMessageWithName(userList, "User List");
        if (StringUtils.isNotBlank(errors)) {
            return List.of();
        }

        final var filteredList = new ArrayList<UsersExtractedData>();
        for (var item : userList) {
            filteredList.add(new UsersExtractedData(item.NAME(), item.EMAIL()));
        }

        return filteredList;
    }

    static void logExtractedData(Logger logger, List<UsersExtractedData> list) {
        final var errors = (
            CoreFormatter.isNullMessageWithName(logger, "Logger") +
            CoreFormatter.isNullOrEmptyListMessageWithName(list, "User Data list")
        );

        if (StringUtils.isNotBlank(errors)) {
            return;
        }

        for (var item : list) {
            logger.info("{} | {}", item.NAME(), item.EMAIL());
        }
    }
}

package net.implementation.demo.typicodejson.constants.v1;

import net.implementation.demo.common.constants.PathConstants;
import net.implementation.demo.typicodejson.constants.HeadersConstants;
import net.implementation.demo.typicodejson.constants.UsersConstants;
import net.implementation.demo.typicodejson.enums.RequestType;
import net.implementation.demo.typicodejson.records.RequestData;

public abstract class RequestDataConstants {
    public static final RequestData GET_USERS_DATA = new RequestData(
        UsersConstants.ENDPOINT_FRAGMENET,
        PathConstants.TYPICODE_BASE_URL,
        RequestType.GET,
        HeadersConstants.BASE_ACCEPT_JSON_HTTP_HEADER_MAP,
        200
    );
}

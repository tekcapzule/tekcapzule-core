package com.tekcapsule.core.utils;

import com.tekcapsule.core.domain.Origin;
import com.tekcapsule.core.domain.SourceSystem;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.MessageHeaders;

import java.util.Map;

public class HeaderUtil {

    public static final String USER_ID = "x-user-login";
    public static final String CHANNEL = "x-channel-code";

    public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    public static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";


    public static final String ALLOW_METHODS = "GET, POST, PUT, DELETE, OPTIONS";
    public static final String ALLOW_CREDENTIALS = "true";
    public static final String ALLOW_ALL_ORIGIN = "*";
    public static final String ALLOW_WHITELISTED_ORIGIN = "*";
    public static final String ALLOW_HEADERS = "Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, Authorization, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, X-User-Login, X-Channel-Code";
    public static final String EXPOSE_HEADERS = "X-User-Login, X-Channel-Code, Authorization";
    public static final String HTTP_STATUS_CODE_HEADER = "statuscode";

    public static Origin buildOriginFromHeaders(MessageHeaders headers) {
        SourceSystem sourceSystem = SourceSystem.valueOf(headers.get(CHANNEL).toString().toUpperCase());
        String userId = headers.get(USER_ID).toString();

        Origin origin = Origin.builder()
                .channel(sourceSystem)
                .userId(userId)
                .build();
        return origin;
    }

    public static Map<String, Object> populateResponseHeaders(Map<String, Object> responseHeader, Stage stage, Outcome outcome) {

        responseHeader.put(ACCESS_CONTROL_ALLOW_CREDENTIALS, ALLOW_CREDENTIALS);
        responseHeader.put(ACCESS_CONTROL_ALLOW_HEADERS, ALLOW_HEADERS);
        responseHeader.put(ACCESS_CONTROL_ALLOW_METHODS, ALLOW_METHODS);
        responseHeader.put(ACCESS_CONTROL_EXPOSE_HEADERS, EXPOSE_HEADERS);

        if (outcome == Outcome.SUCCESS) {
            responseHeader.put(HTTP_STATUS_CODE_HEADER, HttpStatus.OK.value());
        } else if (outcome == Outcome.NOT_FOUND) {
            responseHeader.put(HTTP_STATUS_CODE_HEADER, HttpStatus.NOT_FOUND.value());
        } else {
            responseHeader.put(HTTP_STATUS_CODE_HEADER, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        if (stage == Stage.PROD) {
            responseHeader.put(ACCESS_CONTROL_ALLOW_ORIGIN, ALLOW_WHITELISTED_ORIGIN);
        } else {
            responseHeader.put(ACCESS_CONTROL_ALLOW_ORIGIN, ALLOW_ALL_ORIGIN);
        }
        return responseHeader;
    }
}

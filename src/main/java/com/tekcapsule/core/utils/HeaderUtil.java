package com.tekcapsule.core.utils;

import com.tekcapsule.core.domain.Origin;
import com.tekcapsule.core.domain.SourceSystem;
import org.springframework.messaging.MessageHeaders;

import java.util.Map;

public class HeaderUtil {

    public static final String USER_ID = "x-userId";
    public static final String CHANNEL = "x-channel";

    public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";

    public static final String ALLOW_METHODS = "POST";
    public static final String ALLOW_CREDENTIALS = "true";
    public static final String ALLOW_ORIGIN = "*";
    public static final String ALLOW_HEADERS = "Content-Type";

    public static Origin buildOriginFromHeaders(MessageHeaders headers) {
        /*SourceSystem sourceSystem = SourceSystem.valueOf(headers.get(CHANNEL).toString());
        String userId = headers.get(USER_ID).toString();

        Origin origin = Origin.builder()
                .channel(sourceSystem)
                .tenantId(tenantId)
                .userId(userId)
                .build();*/

        Origin origin = Origin.builder()
                .channel(SourceSystem.WEB_CLIENT)
                .userId("tekCapsuleUser")
                .build();
        return origin;
    }

    public static Map<String, Object> populateCorsHeaders(Map<String, Object> responseHeader) {

        responseHeader.put(ACCESS_CONTROL_ALLOW_CREDENTIALS, ALLOW_CREDENTIALS);
        responseHeader.put(ACCESS_CONTROL_ALLOW_HEADERS, ALLOW_HEADERS);
        responseHeader.put(ACCESS_CONTROL_ALLOW_METHODS, ALLOW_METHODS);
        responseHeader.put(ACCESS_CONTROL_ALLOW_ORIGIN, ALLOW_ORIGIN);

        return responseHeader;
    }

}

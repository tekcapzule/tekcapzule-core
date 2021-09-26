package com.tekcapsule.core.utils;

import com.tekcapsule.core.domain.Origin;
import com.tekcapsule.core.domain.SourceSystem;
import org.springframework.messaging.MessageHeaders;

public class HeaderUtil {

    public static final String USER_ID = "x-userId";
    public static final String CHANNEL = "x-channel";

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
}

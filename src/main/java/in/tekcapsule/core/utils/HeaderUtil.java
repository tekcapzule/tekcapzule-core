package in.tekcapsule.core.utils;

import in.tekcapsule.core.domain.Origin;
import in.tekcapsule.core.domain.SourceSystem;
import org.springframework.messaging.MessageHeaders;

public class HeaderUtil {

    public static final String USER_ID = "x-userId";
    public static final String TENANT_ID = "x-tenantId";
    public static final String CHANNEL = "x-channel";

    public static Origin buildOriginFromHeaders(MessageHeaders headers) {
        /*SourceSystem sourceSystem = SourceSystem.valueOf(headers.get(CHANNEL).toString());
        String userId = headers.get(USER_ID).toString();
        String tenantId = headers.get(TENANT_ID).toString();

        Origin origin = Origin.builder()
                .channel(sourceSystem)
                .tenantId(tenantId)
                .userId(userId)
                .build();*/

        Origin origin = Origin.builder()
                .channel(SourceSystem.WEB_CLIENT)
                .tenantId("devstream")
                .userId("devstreamUser")
                .build();
        return origin;
    }
}

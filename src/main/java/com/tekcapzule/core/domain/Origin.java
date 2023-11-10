package com.tekcapzule.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Origin {
    private String tenantId;
    private String userId;
    private SourceSystem channel;
}

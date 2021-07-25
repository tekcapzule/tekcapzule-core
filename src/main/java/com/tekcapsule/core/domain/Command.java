package com.tekcapsule.core.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Command {
    private ExecBy execBy;
    private String execOn;
    private SourceSystem channel;
}

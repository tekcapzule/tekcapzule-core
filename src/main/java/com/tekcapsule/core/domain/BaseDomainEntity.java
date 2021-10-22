package com.tekcapsule.core.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public abstract class BaseDomainEntity {

    @DynamoDBAttribute(attributeName = "addedBy")
    private String addedBy;
    @DynamoDBAttribute(attributeName = "updatedBy")
    private String updatedBy;
    @DynamoDBAttribute(attributeName = "addedOn")
    private String addedOn;
    @DynamoDBAttribute(attributeName = "updatedOn")
    private String updatedOn;
}

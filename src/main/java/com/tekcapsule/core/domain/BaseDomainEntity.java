package com.tekcapsule.core.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public abstract class BaseDomainEntity {

    @DynamoDBAttribute(attributeName = "addedBy")
    @JsonIgnore
    private String addedBy;
    @DynamoDBAttribute(attributeName = "updatedBy")
    @JsonIgnore
    private String updatedBy;
    @DynamoDBAttribute(attributeName = "addedOn")
    @JsonIgnore
    private String addedOn;
    @DynamoDBAttribute(attributeName = "updatedOn")
    @JsonIgnore
    private String updatedOn;
}

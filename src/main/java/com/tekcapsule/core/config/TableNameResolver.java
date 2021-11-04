package com.tekcapsule.core.config;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import org.springframework.stereotype.Component;

@Component
public class TableNameResolver extends DynamoDBMapperConfig.DefaultTableNameResolver {

    private String applicationEnvironment;

    public TableNameResolver() {}

    public TableNameResolver(String applicationEnvironment) {
        this.applicationEnvironment=applicationEnvironment;
    }

    @Override
    public String getTableName(Class<?> clazz, DynamoDBMapperConfig config) {
        String rawTableName = super.getTableName(clazz, config);
        return applicationEnvironment.concat(rawTableName);
    }
}

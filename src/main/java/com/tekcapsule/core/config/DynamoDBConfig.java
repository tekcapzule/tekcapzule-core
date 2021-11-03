package com.tekcapsule.core.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory;
import com.amazonaws.services.s3.model.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {

    @Value("#{environment.APPLICATION_ENVIRONMENT}")
    private String applicationEnvironment;

    @Value("#{environment.CLOUD_REGION}")
    private String cloudRegion;

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(String.valueOf(Region.valueOf(cloudRegion)))
                .build();


        return new DynamoDBMapper(client, DynamoDBMapperConfig.DEFAULT);
    }
    @Bean
    public DynamoDBMapperConfig.TableNameOverride getTableNameOverride() {
        String prefix = applicationEnvironment;
        return DynamoDBMapperConfig.TableNameOverride.withTableNamePrefix(prefix);
    }

    @Bean
    public DynamoDBMapperConfig getDynamoDBMapperConfig(DynamoDBMapperConfig.TableNameOverride tableNameOverride) {
        DynamoDBMapperConfig.Builder builder = new DynamoDBMapperConfig.Builder();
        builder.setTableNameOverride(tableNameOverride);
        builder.setTypeConverterFactory(DynamoDBTypeConverterFactory.standard());
        return builder.build();
    }
}
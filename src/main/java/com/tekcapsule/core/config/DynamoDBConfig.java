package com.tekcapsule.core.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.s3.model.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DynamoDBConfig {

    @Value("#{environment.APPLICATION_ENVIRONMENT}")
    private String applicationEnvironment;

    @Value("#{environment.CLOUD_REGION}")
    private String cloudRegion;


    @Bean
    @Primary
    public DynamoDBMapper dynamoDBMapper() {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(String.valueOf(Region.valueOf(cloudRegion)))
                .build();

        DynamoDBMapper mapper = new DynamoDBMapper(client,new DynamoDBMapperConfig.Builder().withTableNameResolver(new TableNameResolver(applicationEnvironment)).build());
        return mapper;
    }
}
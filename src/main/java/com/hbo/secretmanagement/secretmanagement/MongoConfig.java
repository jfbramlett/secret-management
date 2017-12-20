package com.hbo.secretmanagement.secretmanagement;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;


@Configuration
@EnableConfigurationProperties({MongoProperties.class})
@ConditionalOnMissingBean(MongoClient.class)
public class MongoConfig extends AbstractMongoConfiguration {

    private final MongoProperties mongoProperties;

    public MongoConfig(final MongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    @Override
    protected String getDatabaseName() {
        return mongoProperties.getMongoClientDatabase();
    }

    @Override
    public Mongo mongo() throws Exception {
        return mongoProperties.createMongoClient(null, null);
    }

}
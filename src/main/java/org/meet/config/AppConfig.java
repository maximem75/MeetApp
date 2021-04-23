package org.meet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collections;
import java.util.List;

@Configuration
public class AppConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "MeetApp";
    }

    @Override
    protected List<String> getMappingBasePackages() {
        return Collections.singletonList("org.meet.repository");
    }
}
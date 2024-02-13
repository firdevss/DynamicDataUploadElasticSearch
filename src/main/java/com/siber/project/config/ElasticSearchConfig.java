package com.siber.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

import java.time.Duration;

@Configuration
public class ElasticSearchConfig extends ElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .usingSsl("d2eb97988bedebbe10e326c4218be672769fee4c7fef6c22b9362376ee0ca515") //add the generated sha-256 fingerprint
                .withBasicAuth("elastic", "3psuHEuRXcvU*fvOLpwi") //add your username and password
                .withConnectTimeout(Duration.ofMillis(3600000))
                .withSocketTimeout(Duration.ofMillis(3600000))
                .build();
    }
}

package com.denisvlem.learnrabbitmqreceiver.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.dependencies.sender")
@Data
public class SenderProperties {
    private String protocol;
    private String host;
    private int port;

    public String getUrl() {
        return String.format("%s://%s:%s", protocol, host, port);
    }
}

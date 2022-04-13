package com.denisvlem.learnrabbitmqreceiver.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
        prefix = "application.dependencies.sender"
)
@Data
public class SenderProperties {
    private String protocol = "http";
    private String host = "localhost";
    private int port = 8080;

    public String getUrl() {
        return String.format("%s://%s:%s", protocol, host, port);
    }
}

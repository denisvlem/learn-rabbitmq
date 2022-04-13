package com.denisvlem.learnrabbitmqreceiver.configuration;

import com.denisvlem.learnrabbitmqreceiver.properties.SenderProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfiguration {

    private final SenderProperties senderProperties;

    @Bean("senderServiceRestTemplate")
    public RestTemplate senderServiceRestTemplate(RestTemplateBuilder builder) {
        return builder.rootUri(senderProperties.getUrl()).build();
    }
}

package com.denisvlem.learnrabbitmqreceiver;

import com.denisvlem.learnrabbitmqreceiver.properties.SenderProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({SenderProperties.class})
public class LearnRabbitmqReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnRabbitmqReceiverApplication.class, args);
    }
}

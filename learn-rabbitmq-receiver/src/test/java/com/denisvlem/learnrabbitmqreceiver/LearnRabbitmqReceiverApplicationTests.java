package com.denisvlem.learnrabbitmqreceiver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("dev")
class LearnRabbitmqReceiverApplicationTests {

    @Autowired
    private LearnRabbitmqReceiverApplication context;

    @Test
    void contextLoads() {
        assertThat(context).isNotNull();
    }

}

package com.denisvlem.learnrabbitmqreceiver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LearnRabbitmqReceiverApplicationTests extends BaseItTest {

    @Autowired
    private LearnRabbitmqReceiverApplication context;

    @Test
    void contextLoads() {
        assertThat(context).isNotNull();
    }

}

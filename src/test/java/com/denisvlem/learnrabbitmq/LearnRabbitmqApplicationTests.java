package com.denisvlem.learnrabbitmq;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class LearnRabbitmqApplicationTests extends BaseItTest {

    @Autowired
    private LearnRabbitmqApplication context;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(context);
    }

}

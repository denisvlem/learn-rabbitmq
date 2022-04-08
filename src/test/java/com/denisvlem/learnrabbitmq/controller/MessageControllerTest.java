package com.denisvlem.learnrabbitmq.controller;

import com.denisvlem.learnrabbitmq.Api;
import com.denisvlem.learnrabbitmq.BaseItTest;
import com.denisvlem.learnrabbitmq.dto.MessageRequestDto;
import org.junit.jupiter.api.Test;

import java.util.List;

class MessageControllerTest extends BaseItTest {


    @Test
    void givenRequest_whenSendMessage_theReturnOk() {
        //given
        MessageRequestDto request = new MessageRequestDto(
                "testSubject",
                "testMessage",
                List.of("test@test.test", "user@company.com")
        );
        //when
        Api.doPostSendMessage(request)
                //then
                .then().statusCode(200);
    }
}
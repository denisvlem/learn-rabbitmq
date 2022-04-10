package com.denisvlem.learnrabbitmq.controller;

import com.denisvlem.learnrabbitmq.Api;
import com.denisvlem.learnrabbitmq.BaseItTest;
import com.denisvlem.learnrabbitmq.dto.MessageRequestDto;
import com.denisvlem.learnrabbitmq.sender.StringSender;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

class MessageControllerTest extends BaseItTest {

    @MockBean
    private StringSender sender;

    @Test
    void givenRequest_whenSendMessage_theReturnOk() {
        //given
        Mockito.doNothing().when(sender)
                .send(Mockito.anyString(), Mockito.anyString());

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
package com.denisvlem.learnrabbitmqreceiver.service;

import com.denisvlem.learnrabbitmqreceiver.BaseItTest;
import com.denisvlem.learnrabbitmqreceiver.dto.MessageRequestDto;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

class MessageServiceTest extends BaseItTest {


    @Test
    @SneakyThrows
    void whenMessageReceive_ShouldRequestSenderAndConfirm() {
        //given
        var requestDto = new MessageRequestDto();
        requestDto.setMessage("messageTest");
        requestDto.setRecipients(List.of("test@test.test", "user@company.domain"));
        requestDto.setSubject("subjectTest");

        final String senderRequestUrl = "/message/email/sent/confirm/";
        WireMock.stubFor(post(urlPathEqualTo(senderRequestUrl))
                .willReturn(aResponse().withStatus(200))
        );

        //when
        messageService.receiveMessage(objectMapper.writeValueAsString(requestDto));

        //then
        WireMock.verify(1, RequestPatternBuilder.newRequestPattern().withUrl(senderRequestUrl));
    }
}
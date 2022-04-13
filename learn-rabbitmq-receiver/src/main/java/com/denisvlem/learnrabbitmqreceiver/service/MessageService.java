package com.denisvlem.learnrabbitmqreceiver.service;

import com.denisvlem.learnrabbitmqreceiver.dto.MessageRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    @Qualifier("senderServiceRestTemplate")
    private final RestTemplate senderServiceRestTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void receiveMessage(String messageContent) {
        var request = objectMapper.readValue(messageContent, MessageRequestDto.class);
        log.info("Request received: [{}]", request);

        try {
            var response = senderServiceRestTemplate.postForObject("/message/email/sent/confirm/", null, String.class);
        } catch (RestClientException e) {
            log.warn("Error: ", e);
        }
    }
}

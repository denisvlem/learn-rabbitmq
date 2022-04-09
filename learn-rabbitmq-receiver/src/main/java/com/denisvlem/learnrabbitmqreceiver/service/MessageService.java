package com.denisvlem.learnrabbitmqreceiver.service;

import com.denisvlem.learnrabbitmqreceiver.dto.MessageRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void receiveMessage(String messageContent) {
        var request = objectMapper.readValue(messageContent, MessageRequestDto.class);
        log.info("Request received: [{}]", request);
    }
}

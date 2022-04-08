package com.denisvlem.learnrabbitmq.service;

import com.denisvlem.learnrabbitmq.dto.MessageRequestDto;
import com.denisvlem.learnrabbitmq.sender.StringSender;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final StringSender stringSender;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void send(MessageRequestDto requestDto) {
        String content = objectMapper.writeValueAsString(requestDto);
        stringSender.send(content, requestDto.subject());
    }
}

package com.denisvlem.learnrabbitmq.controller;

import com.denisvlem.learnrabbitmq.dto.MessageRequestDto;
import com.denisvlem.learnrabbitmq.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/send")
    public void doPostSendMessage(@RequestBody MessageRequestDto request) {
        messageService.send(request);
    }
}

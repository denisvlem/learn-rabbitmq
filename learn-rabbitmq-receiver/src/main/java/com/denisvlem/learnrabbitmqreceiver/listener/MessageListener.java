package com.denisvlem.learnrabbitmqreceiver.listener;

import com.denisvlem.learnrabbitmqreceiver.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class MessageListener {

    private final MessageService messageService;

    @RabbitListener(queues = "message_queue")
    public void listen(String message) {
        messageService.receiveMessage(message);
    }
}

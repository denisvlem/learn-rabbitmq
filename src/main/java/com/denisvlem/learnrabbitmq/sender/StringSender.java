package com.denisvlem.learnrabbitmq.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class StringSender {

    private final Queue queue;
    private final RabbitTemplate rabbitTemplate;

    public void send(String content, String subject) {
        log.info("Sending a message with subject: [{}]", subject);
        log.debug("Sending a message: {}", content);
        try {
            rabbitTemplate.convertAndSend(queue.getName(), content);
            log.info("Successfully sent the message with subject: [{}]", subject);
        } catch (AmqpException e) {
            log.warn("Exception thrown while sending a message with subject [{}]", subject);
            log.warn("Exception: ", e);
            throw e;
        }
    }
}

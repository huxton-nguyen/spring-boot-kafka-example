package com.example.springbootkafkaexample.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    @Value("${spring.kafka.default.topic-name}")
    private String topicName;

    private final KafkaTemplate<String, User> template;

    public void sendMessage(User user) {
        log.error(String.format("Message sent -> %s", user.toString()));

        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();

        template.send(message);
    }
}

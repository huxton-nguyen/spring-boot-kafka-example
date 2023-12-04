package com.example.springbootkafkaexample.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.default.topic-name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        log.error(String.format("Json message received -> %s ", user.toString()));
    }
}

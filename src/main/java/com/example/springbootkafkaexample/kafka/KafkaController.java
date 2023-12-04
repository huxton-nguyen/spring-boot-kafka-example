package com.example.springbootkafkaexample.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/kafka")
@RequiredArgsConstructor
public class KafkaController {

    @Value("${spring.kafka.default.topic-name}")
    private String topicName;

    private final KafkaProducer producer;

    @PostMapping(path = "publish")
    public ResponseEntity<String> publish(@RequestBody User user) {

        producer.sendMessage(user);

        return ResponseEntity.ok(String.format("Json message sent to %s", topicName));
    }
}

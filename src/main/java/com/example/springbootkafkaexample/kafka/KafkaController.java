package com.example.springbootkafkaexample.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/kafka")
@RequiredArgsConstructor
public class KafkaController {

    @Value("${spring.kafka.default.topic-name}")
    private String topicName;

    private final KafkaProducer producer;

    @PostMapping(path = "publish")
    public ResponseEntity<String> publish(@RequestBody User user) throws Exception {

        producer.sendMessage(user);

        Thread.sleep(1000);

        return ResponseEntity.ok(String.format("Json message sent to %s", topicName));
    }
}

package com.marble.kafka.consumer;

import com.marble.kafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Slf4j
@Service

public class KafkaConsumer {

    @KafkaListener(topics = "MarBl", groupId = "consumer-1")
    public void consumerMessage(User data) {

        log.info(format("Consuming the message from MarBl Topic: %s", data.toString()));
    }
}

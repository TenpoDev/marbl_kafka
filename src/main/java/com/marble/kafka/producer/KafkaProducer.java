package com.marble.kafka.producer;

import com.marble.kafka.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {

        log.info(String.format("Message sent -> %s", user.toString()));

        Message<User> message = MessageBuilder
                                    .withPayload(user)
                                    .setHeader(KafkaHeaders.TOPIC, "MarBl")
                                    .build();

        kafkaTemplate.send(message);

    }

}

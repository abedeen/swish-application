package com.swish.ride.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SwishApplicationKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(SwishApplicationKafkaConsumer.class);
    private static final String TOPIC = "topic_swishapplication";

    @KafkaListener(topics = "topic_swishapplication", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}

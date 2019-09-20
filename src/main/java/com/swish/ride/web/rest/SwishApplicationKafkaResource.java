package com.swish.ride.web.rest;

import com.swish.ride.service.SwishApplicationKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/swish-application-kafka")
public class SwishApplicationKafkaResource {

    private final Logger log = LoggerFactory.getLogger(SwishApplicationKafkaResource.class);

    private SwishApplicationKafkaProducer kafkaProducer;

    public SwishApplicationKafkaResource(SwishApplicationKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}

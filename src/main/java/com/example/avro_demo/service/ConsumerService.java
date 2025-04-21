package com.example.avro_demo.service;

import com.example.kafka_schemas.TestEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = "demo.topic", groupId = "demo-service")
    public void consume(TestEvent testEvent) {
        System.out.println(testEvent.getId()+"\n"+testEvent.getMessage());
    }

}

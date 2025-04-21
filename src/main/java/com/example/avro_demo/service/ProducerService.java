package com.example.avro_demo.service;

import com.example.kafka_schemas.TestEvent;
import com.example.kafka_schemas.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final KafkaTemplate<String, TestEvent> kafkaTemplate;
    public void produceService(Integer id, String message){
        // API 요청 DTO → Avro 객체로 변환
        TestEvent testEvent = TestEvent.newBuilder()
                .setId(id)
                .setMessage(message)
                .setUser(User.newBuilder().
                        setUserId(12345).
                        setUsername("홍길동").
                        build())
                .setTags(new ArrayList<>())
                .build();
        kafkaTemplate.send("demo.topic", "demo.key", testEvent);
    }
}

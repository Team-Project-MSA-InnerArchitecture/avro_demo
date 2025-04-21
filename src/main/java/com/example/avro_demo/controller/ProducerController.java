package com.example.avro_demo.controller;

import com.example.avro_demo.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/demo")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;
    @PostMapping
    public ResponseEntity<String> createEvent(@RequestParam Integer id, @RequestParam String message){
        this.producerService.produceService(id, message);
        return ResponseEntity.ok("Order created and event published to Kafka.");
    }
}

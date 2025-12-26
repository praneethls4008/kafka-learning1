package com.learning.kafka_learning1.consumer;

import com.learning.kafka_learning1.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@KafkaListener(topics = "my-topic-1", groupId = "myGroup")
public class KafkaConsumer {

    @KafkaHandler
    public void handleStudent(Student student) {
        log.info("Received Student object: {}", student.toString());
    }

    @KafkaHandler
    public void handleString(String message) {
        log.info("Received String message: {}", message);
    }

    @KafkaHandler(isDefault = true)
    public void handleUnknown(Object object) {
        log.info("Received unknown data type: {}", object);
    }
}
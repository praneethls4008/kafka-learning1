package com.learning.kafka_learning1.producer;

import com.learning.kafka_learning1.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String msg){
        log.info(String.format("Sending message to my-topic-1:: %s", msg));
        kafkaTemplate.send("my-topic-1", msg);
    }

    public void sendMessage(Student student){
        log.info(String.format("Sending message to my-topic-1:: %s", student));

        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "my-topic-1")
                .build();

        kafkaTemplate.send(message);
    }
}

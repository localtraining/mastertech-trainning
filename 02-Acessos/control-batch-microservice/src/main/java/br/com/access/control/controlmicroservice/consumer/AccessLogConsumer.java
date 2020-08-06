package br.com.access.control.controlmicroservice.consumer;

import br.com.access.control.controlmicroservice.producer.AccessLog;
import br.com.access.control.controlmicroservice.repository.LocalFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class AccessLogConsumer {
    @Autowired
    LocalFileRepository localFileRepository;

    @KafkaListener(topics = "control-microservice-log", groupId = "orbeck of vinheim-1")
    public void receber(@Payload AccessLog accessLog) {
        try {
            localFileRepository.saveFile(accessLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
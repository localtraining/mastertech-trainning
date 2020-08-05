package br.com.access.control.controlmicroservice.consumer;

import br.com.access.control.controlmicroservice.producer.AccessLog;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AccessLogConsumer {
    @KafkaListener(topics = "control-microservice-log", groupId = "orbeck of vinheim-1")
    public void receber(@Payload AccessLog accessLog) {
        System.out.println(String.format("%s - %s", LocalDateTime.now(), accessLog.toString()));
    }
}

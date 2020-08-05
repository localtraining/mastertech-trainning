package br.com.access.control.controlmicroservice.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccessProducer {
    @Autowired
    private KafkaTemplate<String, AccessLog> producer;

    public void sendKafkaLogMessage(AccessLog accessLog) {
        producer.send("control-microservice-log", accessLog);
    }
}

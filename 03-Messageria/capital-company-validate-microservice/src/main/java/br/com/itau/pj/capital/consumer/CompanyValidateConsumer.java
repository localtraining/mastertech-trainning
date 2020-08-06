package br.com.itau.pj.capital.consumer;

import br.com.itau.pj.capital.producer.Company;
import br.com.itau.pj.capital.repository.LocalFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CompanyValidateConsumer {
    @Autowired
    private LocalFileRepository localFileRepository;

    @KafkaListener(topics = "company-microservice-validate", groupId = "orbeck of vinheim-1")
    public void receber(@Payload Company company) {
        try {
            localFileRepository.saveFile(company);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
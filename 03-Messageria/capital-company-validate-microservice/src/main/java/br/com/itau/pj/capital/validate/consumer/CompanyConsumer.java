package br.com.itau.pj.capital.validate.consumer;

import br.com.itau.pj.capital.producer.Company;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CompanyConsumer {

    @KafkaListener(topics = "company-microservice-create", groupId = "orbeck of vinheim-1")
    public void receber(@Payload Company company) {
        System.out.println(" *** " + company.getCnpj());
    }
}
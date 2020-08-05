package br.com.itau.pj.capital.consumer;

import br.com.itau.pj.capital.model.dto.CompanyResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CompanyConsumer {

    @KafkaListener(topics = "company-microservice-create", groupId = "orbeck of vinheim-1")
    public void receber(@Payload CompanyResponse companyCustomsResponse) {
        System.out.println(" *** " + companyCustomsResponse.getCnpj());
    }
}
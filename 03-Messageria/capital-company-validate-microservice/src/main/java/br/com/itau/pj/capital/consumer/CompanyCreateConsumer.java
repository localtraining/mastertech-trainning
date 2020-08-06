package br.com.itau.pj.capital.consumer;

import br.com.itau.pj.capital.producer.Company;
import br.com.itau.pj.capital.producer.CompanyValidateProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CompanyCreateConsumer {

    @Autowired
    private CompanyValidateProducer companyProducer;

    @KafkaListener(topics = "company-microservice-create", groupId = "orbeck of vinheim-1")
    public void receber(@Payload Company company) {
        System.out.println(" *** " + company.getCnpj());

        companyProducer.sendKafkaValidateCompanyMessage(company);
    }
}
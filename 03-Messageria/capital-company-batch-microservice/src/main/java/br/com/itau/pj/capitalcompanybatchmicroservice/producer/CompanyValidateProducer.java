package br.com.itau.pj.capital.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CompanyValidateProducer {
    @Autowired
    private KafkaTemplate<String, Company> producer;

    public void sendKafkaValidateCompanyMessage(Company company) {
        System.out.println("  --- Capital Social: " + company.getNominalCapital().toString());

        if(company.isValidNominalCapital()) {
            producer.send("company-microservice-validate", company);
        }
    }
}

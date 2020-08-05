package br.com.itau.pj.capital.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CompanyProducer {
    @Autowired
    private KafkaTemplate<String, Company> producer;

    public void sendKafkaCreateCompanyMessage(Company company) {
        producer.send("company-microservice-create", company);
    }
}
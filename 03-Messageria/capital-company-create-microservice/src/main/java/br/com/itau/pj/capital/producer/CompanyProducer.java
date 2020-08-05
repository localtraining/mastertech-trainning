package br.com.itau.pj.capital.producer;

import br.com.itau.pj.capital.model.dto.CompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CompanyProducer {
    @Autowired
    private KafkaTemplate<String, CompanyRequest> producer;

    public void sendKafkaCreateCompanyMessage(CompanyRequest company) {
        producer.send("company-microservice-create", company);
    }
}
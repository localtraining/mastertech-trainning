package br.com.itau.pj.capital.create.service;

import br.com.itau.pj.capital.validate.client.CompanyClient;
import br.com.itau.pj.capital.validate.producer.CompanyProducer;
import br.com.itau.pj.capital.validate.exception.CompanyNotFoundException;
import br.com.itau.pj.capital.validate.producer.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyClient companyClient;

    @Autowired
    private CompanyProducer companyProducer;

    public Company findCompany(String cnpj) {
        return companyClient.getCompany(cnpj).orElseThrow(CompanyNotFoundException::new);
    }

    public Company createCompany(Company company) {
        companyProducer.sendKafkaCreateCompanyMessage(company);

        return company;
    }
}
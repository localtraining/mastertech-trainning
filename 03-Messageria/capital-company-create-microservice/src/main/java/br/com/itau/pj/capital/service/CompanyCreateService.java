package br.com.itau.pj.capital.service;

import br.com.itau.pj.capital.client.CompanyClient;
import br.com.itau.pj.capital.exception.CompanyNotFoundException;
import br.com.itau.pj.capital.producer.Company;
import br.com.itau.pj.capital.producer.CompanyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyCreateService {
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
package br.com.itau.pj.capital.service;

import br.com.itau.pj.capital.client.CompanyClient;
import br.com.itau.pj.capital.exception.CompanyNotFoundException;
import br.com.itau.pj.capital.model.CompanyMapper;
import br.com.itau.pj.capital.model.dto.CompanyRequest;
import br.com.itau.pj.capital.model.dto.CompanyResponse;
import br.com.itau.pj.capital.producer.CompanyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyClient companyClient;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyProducer companyProducer;

    public CompanyResponse findCompany(String cnpj) {
        return companyClient.getCompany(cnpj).orElseThrow(CompanyNotFoundException::new);
    }

    public CompanyResponse createCompany(CompanyRequest companyRequest) {
        companyProducer.sendKafkaCreateCompanyMessage(companyRequest);

        return companyMapper.fromCompanyRequest(companyRequest);
    }
}
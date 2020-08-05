package br.com.itau.pj.capital.service;

import br.com.itau.pj.capital.client.CompanyClient;
import br.com.itau.pj.capital.exception.CompanyNotFoundException;
import br.com.itau.pj.capital.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyClient companyClient;

    public Company findCompany(String cnpj) {
        return companyClient.getCompany(cnpj).orElseThrow(CompanyNotFoundException::new);
    }
}

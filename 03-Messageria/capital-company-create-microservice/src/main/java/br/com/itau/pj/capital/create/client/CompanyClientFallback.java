package br.com.itau.pj.capital.create.client;

import br.com.itau.pj.capital.validate.exception.CompanyServiceOfflineException;
import br.com.itau.pj.capital.validate.producer.Company;

import java.util.Optional;

public class CompanyClientFallback implements CompanyClient {
    @Override
    public Optional<Company> getCompany(String cnpj) {
        throw new CompanyServiceOfflineException();
    }
}
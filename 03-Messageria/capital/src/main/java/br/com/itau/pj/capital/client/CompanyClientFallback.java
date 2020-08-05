package br.com.itau.pj.capital.client;

import br.com.itau.pj.capital.exception.CompanyServiceOfflineException;
import br.com.itau.pj.capital.model.Company;

import java.util.Optional;

public class CompanyClientFallback implements CompanyClient {
    @Override
    public Optional<Company> getCompany(String cnpj) {
        throw new CompanyServiceOfflineException();
    }
}
package br.com.itau.pj.capital.client;

import br.com.itau.pj.capital.exception.CompanyServiceOfflineException;
import br.com.itau.pj.capital.model.dto.CompanyResponse;

import java.util.Optional;

public class CompanyClientFallback implements CompanyClient {
    @Override
    public Optional<CompanyResponse> getCompany(String cnpj) {
        throw new CompanyServiceOfflineException();
    }
}
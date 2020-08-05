package br.com.itau.pj.capital.model;

import br.com.itau.pj.capital.model.dto.CompanyRequest;
import br.com.itau.pj.capital.model.dto.CompanyResponse;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public CompanyResponse fromCompanyRequest(CompanyRequest companyRequest) {
        CompanyResponse companyResponse = new CompanyResponse();

        companyResponse.setCnpj(companyRequest.getCnpj());
        companyResponse.setName(companyRequest.getName());
        companyResponse.setNominalCapital(companyRequest.getNominalCapital());

        return companyResponse;
    }
}

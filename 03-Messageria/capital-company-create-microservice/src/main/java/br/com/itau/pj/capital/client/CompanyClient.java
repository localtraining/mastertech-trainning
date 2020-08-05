package br.com.itau.pj.capital.client;

import br.com.itau.pj.capital.model.dto.CompanyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="capital-microservice", configuration = CompanyClientConfiguration.class, url = "https://www.receitaws.com.br/")
public interface CompanyClient {
    @GetMapping("/v1/cnpj/{cnpj}")
    Optional<CompanyResponse> getCompany(@PathVariable String cnpj);
}
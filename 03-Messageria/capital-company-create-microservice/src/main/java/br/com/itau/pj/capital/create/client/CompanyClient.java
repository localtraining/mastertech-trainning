package br.com.itau.pj.capital.create.client;

import br.com.itau.pj.capital.validate.producer.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="capital-microservice", configuration = CompanyClientConfiguration.class, url = "https://www.receitaws.com.br/")
public interface CompanyClient {
    @GetMapping("/v1/cnpj/{cnpj}")
    Optional<Company> getCompany(@PathVariable String cnpj);
}
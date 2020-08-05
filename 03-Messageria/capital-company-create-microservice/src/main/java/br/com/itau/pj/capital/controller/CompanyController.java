package br.com.itau.pj.capital.controller;

import br.com.itau.pj.capital.model.dto.CompanyRequest;
import br.com.itau.pj.capital.model.dto.CompanyResponse;
import br.com.itau.pj.capital.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/capital/{cnpj}")
    public CompanyResponse findCompany(@PathVariable String cnpj) {
        return companyService.findCompany(cnpj);
    }

    @PostMapping("/empresa/criar")
    public void createCompany(@Valid @RequestBody CompanyRequest companyRequest) {
        companyService.createCompany(companyRequest);
    }
}
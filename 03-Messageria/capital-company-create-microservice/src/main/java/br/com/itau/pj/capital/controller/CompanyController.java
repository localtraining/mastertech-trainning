package br.com.itau.pj.capital.controller;

import br.com.itau.pj.capital.producer.Company;
import br.com.itau.pj.capital.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/capital/{cnpj}")
    public Company findCompany(@PathVariable String cnpj) {
        return companyService.findCompany(cnpj);
    }

    @PostMapping("/empresa/criar")
    public void createCompany(@Valid @RequestBody Company company) {
        companyService.createCompany(company);
    }
}
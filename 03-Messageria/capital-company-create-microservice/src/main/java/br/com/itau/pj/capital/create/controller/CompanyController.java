package br.com.itau.pj.capital.create.controller;

import br.com.itau.pj.capital.validate.service.CompanyService;
import br.com.itau.pj.capital.validate.producer.Company;
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
package br.com.itau.pj.capital.controller;

import br.com.itau.pj.capital.producer.Company;
import br.com.itau.pj.capital.service.CompanyCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CompanyController {
    @Autowired
    private CompanyCreateService companyCreateService;

    @GetMapping("/capital/{cnpj}")
    public Company findCompany(@PathVariable String cnpj) {
        return companyCreateService.findCompany(cnpj);
    }

    @PostMapping("/empresa/criar")
    public void createCompany(@Valid @RequestBody Company company) {
        companyCreateService.createCompany(company);
    }
}
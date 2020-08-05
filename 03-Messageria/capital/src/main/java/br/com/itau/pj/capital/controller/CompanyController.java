package br.com.itau.pj.capital.controller;

import br.com.itau.pj.capital.model.Company;
import br.com.itau.pj.capital.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    public Company findCompany(@PathVariable String cnpj) {
        return companyService.findCompany(cnpj);
    }
}

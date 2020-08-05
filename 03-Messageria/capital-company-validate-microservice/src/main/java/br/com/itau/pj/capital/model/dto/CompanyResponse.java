package br.com.itau.pj.capital.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyResponse {
    private String cnpj;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("capital_social")
    private String nominalCapital;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNominalCapital() {
        return nominalCapital;
    }

    public void setNominalCapital(String nominalCapital) {
        this.nominalCapital = nominalCapital;
    }
}
package br.com.itau.pj.capital.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CompanyRequest {
    private String cnpj;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("capital_social")
    private BigDecimal nominalCapital;

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

    public BigDecimal getNominalCapital() {
        return nominalCapital;
    }

    public void setNominalCapital(BigDecimal nominalCapital) {
        this.nominalCapital = nominalCapital;
    }
}
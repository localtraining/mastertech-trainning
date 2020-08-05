package br.com.itau.pj.capital.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Company {
    private String cpnj;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("capital_social")
    private BigDecimal socialCapital;

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSocialCapital() {
        return socialCapital;
    }

    public void setSocialCapital(BigDecimal socialCapital) {
        this.socialCapital = socialCapital;
    }
}
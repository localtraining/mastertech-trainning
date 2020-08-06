package br.com.itau.pj.capital.producer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Company {
    public static BigDecimal ONE_MILLION_NOMINAL_CAPITAL_COMPANY = new BigDecimal(1000000L);

    private String cnpj;

    @JsonProperty("nome")
    private String name;

    @JsonProperty("capital_social")
    private BigDecimal nominalCapital = BigDecimal.ZERO;

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

    @JsonIgnore
    public boolean isValidNominalCapital() {
        return getNominalCapital().compareTo(ONE_MILLION_NOMINAL_CAPITAL_COMPANY) > 0;
    }
}
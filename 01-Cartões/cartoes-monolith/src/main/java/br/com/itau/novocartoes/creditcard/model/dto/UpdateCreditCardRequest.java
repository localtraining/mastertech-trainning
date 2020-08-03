package br.com.itau.novocartoes.creditcard.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class UpdateCreditCardRequest {

    private String number;

    @NotNull
    @JsonProperty("ativo")
    private Boolean active;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

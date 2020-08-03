package br.com.itau.creditcard.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateCreditCardRequest {
    @NotBlank
    @Size(min = 10)
    @JsonProperty("numero")
    private String number;

    @NotNull
    @JsonProperty("clienteId")
    private Long customerId;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
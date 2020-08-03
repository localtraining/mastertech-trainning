package br.com.access.customer.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerRequest {
    @JsonProperty("nome")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
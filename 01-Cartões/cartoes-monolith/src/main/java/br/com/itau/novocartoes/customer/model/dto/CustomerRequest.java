package br.com.itau.novocartoes.customer.model.dto;

import javax.persistence.Entity;

public class CustomerRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
package br.com.access.control.controlmicroservice.model;

import javax.persistence.*;

public class Customer {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
package br.com.access.control.controlmicroservice.model;

import javax.persistence.*;

public class Door {
    private Long id;
    private String floor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
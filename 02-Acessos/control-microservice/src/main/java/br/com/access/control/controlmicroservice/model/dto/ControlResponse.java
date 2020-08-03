package br.com.access.control.controlmicroservice.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ControlResponse {
    @JsonProperty("porta_id")
    private Long doorId;

    @JsonProperty("cliente_id")
    private Long customerId;

    public Long getDoorId() {
        return doorId;
    }

    public void setDoorId(Long doorId) {
        this.doorId = doorId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}

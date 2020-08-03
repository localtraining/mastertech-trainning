package br.com.access.control.controlmicroservice.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class ControlRequest {
    @NotNull
    @JsonProperty("porta_id")
    private Long doorId;

    @NotNull
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

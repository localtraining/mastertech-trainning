package br.com.itau.payment.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PaymentRequest {
    @NotNull
    @JsonProperty("cartao_id")
    private Long creditCardId;

    @NotNull
    @JsonProperty("descricao")
    private String description;

    @NotNull
    @JsonProperty("valor")
    private BigDecimal value;

    public Long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

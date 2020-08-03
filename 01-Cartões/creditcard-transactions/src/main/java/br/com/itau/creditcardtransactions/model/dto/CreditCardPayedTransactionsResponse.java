package br.com.itau.creditcardtransactions.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditCardPayedTransactionsResponse {
    private Long id;

    @JsonProperty("valorPago")
    private BigDecimal value;

    @JsonProperty("pagoEm")
    private LocalDate payedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDate getPayedDate() {
        return payedDate;
    }

    public void setPayedDate(LocalDate payedDate) {
        this.payedDate = payedDate;
    }
}
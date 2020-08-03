package br.com.itau.creditcardtransactions.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CreditCardCustomerClientConfiguration {
    @Bean
    public ErrorDecoder getErrorDecoder() {
        return new CreditCardCustomerClientDecoder();
    }
}
package br.com.itau.creditcardtransactions.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class PaymentsClientConfiguration {
    @Bean
    public ErrorDecoder getErrorDecoder() {
        return new PaymentsClientDecoder();
    }
}
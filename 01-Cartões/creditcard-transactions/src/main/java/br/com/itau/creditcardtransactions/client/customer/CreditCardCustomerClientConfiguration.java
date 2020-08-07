package br.com.itau.creditcardtransactions.client.customer;

import br.com.itau.creditcardtransactions.client.OAuth2FeignConfiguration;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CreditCardCustomerClientConfiguration extends OAuth2FeignConfiguration {
    @Bean
    public ErrorDecoder getErrorDecoder() {
        return new CreditCardCustomerClientDecoder();
    }
}
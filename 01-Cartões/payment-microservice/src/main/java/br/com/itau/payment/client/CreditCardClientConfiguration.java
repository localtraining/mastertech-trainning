package br.com.itau.payment.client;

import br.com.itau.payment.exception.CreditCardServiceOfflineException;
import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class CreditCardClientConfiguration extends OAuth2FeignConfiguration {
    @Bean
    public ErrorDecoder getErrorDecoder() {
        return new CreditCardClientDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators feignDecorators = FeignDecorators.builder()
                .withFallback(new CreditCardServiceOfflineException(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(feignDecorators);
    }
}
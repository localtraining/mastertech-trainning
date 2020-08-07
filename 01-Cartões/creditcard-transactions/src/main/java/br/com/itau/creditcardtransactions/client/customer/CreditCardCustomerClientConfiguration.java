package br.com.itau.creditcardtransactions.client.customer;

import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

public class CreditCardCustomerClientConfiguration {
    @Bean
    public ErrorDecoder getErrorDecoder() {
        return new CreditCardCustomerClientDecoder();
    }

    @Autowired
    private OAuth2ClientContext oAuth2ClientContext;

    @Autowired
    private ClientCredentialsResourceDetails clientCredentialsResourceDetails;

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new OAuth2FeignRequestInterceptor(oAuth2ClientContext, clientCredentialsResourceDetails);
    }
}
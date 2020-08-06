package br.com.itau.contacts.security;

import br.com.itau.contacts.model.Contact;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import java.util.Map;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public PrincipalExtractor getPrincipalExtractor() {
        return new PrincipalExtractor() {
            @Override
            public Object extractPrincipal(Map<String, Object> map) {
                Contact contact = new Contact();

                contact.setName(map.get("name").toString());
                contact.setOwner((Long) map.get("id"));

                return contact;
            }
        };
    }

}

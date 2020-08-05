package br.com.itau.pj.capital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CapitalCompanyValidateApplication {
	public static void main(String[] args) {
		SpringApplication.run(CapitalCompanyValidateApplication.class, args);
	}
}

package br.com.itau.pj.capital.create;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CapitalCompanyCreateApplication {
	public static void main(String[] args) {
		SpringApplication.run(CapitalCompanyCreateApplication.class, args);
	}
}

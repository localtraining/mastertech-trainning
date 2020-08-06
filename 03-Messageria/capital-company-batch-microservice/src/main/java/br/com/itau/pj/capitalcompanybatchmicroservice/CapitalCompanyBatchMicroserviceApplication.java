package br.com.itau.pj.capitalcompanybatchmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class CapitalCompanyBatchMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapitalCompanyBatchMicroserviceApplication.class, args);
	}

}

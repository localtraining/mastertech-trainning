package br.com.itau.creditcardtransactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class CreditcardTransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditcardTransactionsApplication.class, args);
	}

}

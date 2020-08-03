package br.com.access.doors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DoorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoorsApplication.class, args);
	}

}

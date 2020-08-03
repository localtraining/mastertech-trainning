package br.com.access.control.controlmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ControlMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlMicroserviceApplication.class, args);
	}

}

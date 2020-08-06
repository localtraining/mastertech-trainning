package br.com.access.control.controlmicroservice;

import br.com.access.control.controlmicroservice.config.ProjectConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ProjectConfig.class})
public class ControlBatchMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ControlBatchMicroserviceApplication.class, args);
	}
}
package br.com.access.control.controlmicroservice.client;

import br.com.access.control.controlmicroservice.model.Control;
import br.com.access.control.controlmicroservice.model.Door;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="doors-access-microservice", configuration = DoorClientConfiguration.class)
public interface DoorClient {
    @GetMapping("/porta/{id}")
    Optional<Door> find(@PathVariable Long id);
}
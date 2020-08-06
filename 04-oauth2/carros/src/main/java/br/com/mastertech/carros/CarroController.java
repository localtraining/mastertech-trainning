package br.com.mastertech.carros;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class CarroController {

    @GetMapping("/{modelo}")
    public Carro getCarro(@PathVariable String modelo, Principal principal) {
        Carro carro = new Carro();
        carro.setModelo(modelo);
        carro.setDono(principal.getName());
        return carro;
    }

}

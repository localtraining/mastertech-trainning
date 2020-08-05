package br.com.mastertech.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

    @Autowired
    private LivroProducer livroProducer;

    @PostMapping
    public void create(@RequestBody Livro livro) {
        livroProducer.enviarAoKafka(livro);
    }

}

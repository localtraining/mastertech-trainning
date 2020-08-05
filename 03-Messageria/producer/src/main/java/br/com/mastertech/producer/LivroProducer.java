package br.com.mastertech.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LivroProducer {

    @Autowired
    private KafkaTemplate<String, Livro> producer;

    public void enviarAoKafka(Livro livro) {
        producer.send("spec3-biblioteca", livro);
    }

}

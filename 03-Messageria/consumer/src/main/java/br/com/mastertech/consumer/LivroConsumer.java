package br.com.mastertech.consumer;

import br.com.mastertech.producer.Livro;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class LivroConsumer {

    @KafkaListener(topics = "spec3-biblioteca", groupId = "orbeck of vinheim-1")
    public void receber(@Payload Livro livro) {
        System.out.println("Recebi um livro chamado " + livro.getName() + " de " + livro.getAuthor());
    }
}
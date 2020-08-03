package br.com.itau.novocartoes.creditcard;

import br.com.itau.novocartoes.creditcard.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    Optional<CreditCard> findByNumber(String creditCardNumber);
}

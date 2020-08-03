package br.com.itau.payment.repository;

import br.com.itau.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByCreditCardId(Long creditCardId);
    List<Payment> findByCreditCardIdAndPayedIsNull(Long creditCardId);
}
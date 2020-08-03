package br.com.itau.novocartoes.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value="/pagamentos/{creditCardId}")
    public List<Payment> listByCreditCardId(@PathVariable Long creditCardId) {
        return paymentService.listByCreditCardId(creditCardId);
    }

    @PostMapping(value="/pagamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Payment create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }
}
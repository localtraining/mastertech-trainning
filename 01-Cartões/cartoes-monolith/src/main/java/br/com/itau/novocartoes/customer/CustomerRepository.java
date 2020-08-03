package br.com.itau.novocartoes.customer;

import br.com.itau.novocartoes.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

package br.com.access.control.controlmicroservice.repository;

import br.com.access.control.controlmicroservice.model.Control;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlRepository extends JpaRepository<Control, Long> {
    Control findByCustomerIdAndDoorId(Long customerId, Long doorId);
}

package br.com.access.control.controlmicroservice.repository;

import br.com.access.control.controlmicroservice.model.Control;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ControlRepository extends JpaRepository<Control, Long> {
    Optional<Control> findByCustomerIdAndDoorId(Long customerId, Long doorId);
}

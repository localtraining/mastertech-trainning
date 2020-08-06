package br.com.itau.contacts.repository;

import br.com.itau.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Optional<List<Contact>> findByOwner(Integer ownerId);
}

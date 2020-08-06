package br.com.itau.contacts.service;

import br.com.itau.contacts.model.Contact;
import br.com.itau.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> listByOwnerId(Integer ownerId) {
        return contactRepository.findByOwner(ownerId);
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }
}
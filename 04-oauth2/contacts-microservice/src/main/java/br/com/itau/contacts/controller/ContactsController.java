package br.com.itau.contacts.controller;

import br.com.itau.contacts.exception.UnauthorizedException;
import br.com.itau.contacts.model.Contact;
import br.com.itau.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactsController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/contato")
    public Contact create(@RequestBody Contact newContact, @AuthenticationPrincipal Contact contact) {
        newContact.setOwner(contact.getId());

        return contactService.save(contact);
    }

    @GetMapping("/contatos")
    public List<Contact> listByOwnerId(@AuthenticationPrincipal Contact contact) {
        return contactService.listByOwnerId(contact.getOwner());
    }
}
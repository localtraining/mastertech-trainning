package br.com.itau.contacts.controller;

import br.com.itau.contacts.model.Contact;
import br.com.itau.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContactsController {
    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact create(@RequestBody Contact newContact, @AuthenticationPrincipal Contact contact) {
        newContact.setOwner(contact.getId());

        return contactService.save(contact);
    }

    @GetMapping("/{ownerId}")
    public List<Contact> listByOwnerId(@PathVariable Integer ownerId) {
        return contactService.list(ownerId);
    }
}
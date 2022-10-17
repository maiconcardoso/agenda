package br.com.maiconcardoso.agendaapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maiconcardoso.agendaapi.models.ContactModel;
import br.com.maiconcardoso.agendaapi.services.ContactService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/contacts")
public class ContactController {
    
    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactModel> saveContact(ContactModel contactModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.save(contactModel));
    }

    @GetMapping
    public ResponseEntity<List<ContactModel>> findAllContacts() {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactModel> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findById(id));
    }

    @PatchMapping("/{id}/favorito")
    public ResponseEntity<ContactModel> favorite(@PathVariable Integer id, @RequestBody Boolean favorite) {
        contactService.favorite(id, favorite);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Integer id) {
        contactService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

package br.com.maiconcardoso.agendaapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.maiconcardoso.agendaapi.exceptions.ContactNotFoundException;
import br.com.maiconcardoso.agendaapi.models.ContactModel;
import br.com.maiconcardoso.agendaapi.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository repository;

    public ContactModel save(ContactModel contact) {
        return repository.save(contact);
    }

    public ContactModel findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(ContactNotFoundException.MESSAGE));
    }

    public void delete(Integer id) {
        ContactModel contact = findById(id);
        repository.delete(contact);
    }

    public List<ContactModel> findAll() {
        return repository.findAll();
    }

    public void favorite(Integer id, Boolean favorite) {
        Optional<ContactModel> contactModel = repository.findById(id);
        contactModel.ifPresent(c -> {
            c.setFavorite(favorite);
            repository.save(c);
        });

    }

}

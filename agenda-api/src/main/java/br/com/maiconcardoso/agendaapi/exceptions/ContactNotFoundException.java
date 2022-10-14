package br.com.maiconcardoso.agendaapi.exceptions;

public class ContactNotFoundException extends RuntimeException{

    public static final String MESSAGE = "Contact Not Found";

    public ContactNotFoundException(String message) {
        super(message);
    }
    
}

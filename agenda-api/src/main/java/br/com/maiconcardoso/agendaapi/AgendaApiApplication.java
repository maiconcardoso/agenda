package br.com.maiconcardoso.agendaapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.maiconcardoso.agendaapi.models.ContactModel;
import br.com.maiconcardoso.agendaapi.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class AgendaApiApplication {

	private final ContactRepository contatoRepository;

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			ContactModel contato = new ContactModel(null, "Maria", "maria@gmail.com", true);
			contatoRepository.save(contato);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AgendaApiApplication.class, args);
	}

}

package br.com.maiconcardoso.agendaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class AgendaApiApplication {

	// private final ContactRepository contatoRepository;

	// @Bean
	// public CommandLineRunner runner() {
	// 	return args -> {
	// 		ContactModel contato = new ContactModel(null, "Maria", "maria@gmail.com", true);
	// 		contatoRepository.save(contato);
	// 	};
	// }

	public static void main(String[] args) {
		SpringApplication.run(AgendaApiApplication.class, args);
	}

}

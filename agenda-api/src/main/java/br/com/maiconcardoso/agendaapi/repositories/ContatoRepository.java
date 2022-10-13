package br.com.maiconcardoso.agendaapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.maiconcardoso.agendaapi.models.ContatoModel;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoModel, Integer>{
    
}

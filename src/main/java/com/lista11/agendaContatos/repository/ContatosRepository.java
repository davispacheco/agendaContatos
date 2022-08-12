package com.lista11.agendaContatos.repository;

import com.lista11.agendaContatos.model.ContatosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatosRepository extends JpaRepository <ContatosModel, Long> {
}

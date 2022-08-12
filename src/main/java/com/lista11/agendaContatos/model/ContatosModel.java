package com.lista11.agendaContatos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contatos")
public class ContatosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 20, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String sobrenome;
    @Column(length = 20, nullable = false)
    private String telefone;
    @Column(length = 50, nullable = false)
    private String email;
}

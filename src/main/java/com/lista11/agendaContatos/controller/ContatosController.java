package com.lista11.agendaContatos.controller;

import com.lista11.agendaContatos.model.ContatosModel;
import com.lista11.agendaContatos.service.ContatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContatosController {
    @Autowired
    private ContatosService contatosService;

    @GetMapping(path = "/contatos")
    public List<ContatosModel> buscarTodosContatos() {
        return contatosService.buscarTodos();
    }

    @GetMapping(path = "/contatos/{codigo}")
    public Optional<ContatosModel> buscarContatoPorId(@PathVariable Long codigo) {
        return contatosService.buscarPorId(codigo);
    }

    @PostMapping(path = "/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public ContatosModel cadastrarContatos(@RequestBody ContatosModel contatosModel) {
        return contatosService.cadastrar(contatosModel);
    }

    @PutMapping(path = "/contatos/{codigo}")
    public ContatosModel alterarContatos(@PathVariable("codigo") Long codigo, @RequestBody ContatosModel contatos) {
        return contatosService.alterar(codigo, contatos);
    }

    @DeleteMapping(path = "/contatos/{codigo}")
    public void deletarContatos(@PathVariable Long codigo) {
        contatosService.deletar(codigo);
    }
}

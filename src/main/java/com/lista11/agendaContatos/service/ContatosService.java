package com.lista11.agendaContatos.service;

import com.lista11.agendaContatos.model.ContatosModel;
import com.lista11.agendaContatos.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatosService {

    @Autowired
    private ContatosRepository contatosRepository;

    public List<ContatosModel> buscarTodos() {
        return contatosRepository.findAll();
    }

    public Optional<ContatosModel> buscarPorId(Long codigo) {
        return contatosRepository.findById(codigo);
    }

    public ContatosModel cadastrar(ContatosModel contatosModel) {

        contatosModel.getCodigo();
        contatosModel.getNome();
        contatosModel.getSobrenome();
        contatosModel.getTelefone();
        contatosModel.getEmail();

        return contatosRepository.save(contatosModel);
    }

    public ContatosModel alterar(Long codigo, ContatosModel contatos) {
        ContatosModel contatosBanco = buscarPorId(codigo).get();

        contatos.getCodigo();
        contatos.getNome();
        contatos.getSobrenome();
        contatos.getTelefone();
        contatos.getEmail();

        if (contatos.getCodigo() != null) {
            contatosBanco.setCodigo(contatos.getCodigo());
        }
        if (contatos.getNome() != null) {
            contatosBanco.setNome(contatos.getNome());
        }
        if (contatos.getSobrenome() != null) {
            contatosBanco.setSobrenome(contatos.getSobrenome());
        }
        if (contatos.getTelefone() != null) {
            contatosBanco.setTelefone(contatos.getTelefone());
        }
        if (contatos.getEmail() != null) {
            contatosBanco.setEmail(contatos.getEmail());
        }

        return contatosRepository.save(contatosBanco);
    }

    public void deletar(Long codigo) {
        contatosRepository.deleteById(codigo);
    }
}

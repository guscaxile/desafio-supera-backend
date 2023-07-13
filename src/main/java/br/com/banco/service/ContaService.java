package br.com.banco.service;

import br.com.banco.exception.ContaNaoEncontradaException;
import br.com.banco.model.Conta;
import br.com.banco.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private final ContaRepository repository;

    public ContaService(ContaRepository repository){
        this.repository = repository;;
    }

    public List<Conta> getContas(){
        return repository.findAll();
    }

    public Conta getContaById(Long id){
        return repository.findById(id).orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada."));
    }
}

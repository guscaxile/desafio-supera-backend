package br.com.banco.service;

import br.com.banco.exception.TransferenciaNaoEncontradaException;
import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransferenciaService {

    private final TransferenciaRepository repository;

    public TransferenciaService(TransferenciaRepository repository){
        this.repository = repository;
    }

    public List<Transferencia> getTransferencia(){
        return repository.findAll();
    }

    public Transferencia getTransferenciaById(Long id){
        return repository.findById(id).orElseThrow(() -> new TransferenciaNaoEncontradaException("Transferência não encontrada."));
    }

    public List<Transferencia> obterTransferenciasPorData(LocalDate data) {
        return repository.findByDataTransferencia(data);
    }

    public List<Transferencia> obterTransferenciasPorOperador(String nomeOperador) {
        return repository.findByNameOperador(nomeOperador);
    }
}

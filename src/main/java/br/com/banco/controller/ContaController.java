package br.com.banco.controller;

import br.com.banco.model.Conta;
import br.com.banco.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contas")
public class ContaController {

    private final ContaService service;

    public ContaController(ContaService service){
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Conta> listarContas(){
        return service.getContas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Conta obterContaPorId(@PathVariable Long id){
        return service.getContaById(id);
    }
}

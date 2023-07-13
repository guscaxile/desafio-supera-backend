package br.com.banco.controller;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("transferencias")
public class TransferenciaController {

    private final TransferenciaService service;

    public TransferenciaController(TransferenciaService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Transferencia>> listarTransferencias() {
        return ResponseEntity.ok().body(service.getTransferencia());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Transferencia> obterTransferenciaPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getTransferenciaById(id));
    }

    @GetMapping("/data/{data}")
    public ResponseEntity<List<Transferencia>> obterExtratoPorData(@PathVariable("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return ResponseEntity.ok().body(service.obterTransferenciasPorData(data));
    }

    @GetMapping("/operador/{operador}")
    public ResponseEntity<List<Transferencia>> obterExtratoPorOperador(@PathVariable("operador") String nomeOperador) {
        return ResponseEntity.ok().body(service.obterTransferenciasPorOperador(nomeOperador));
    }
}

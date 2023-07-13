package br.com.banco.repository;

import br.com.banco.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    List<Transferencia> findByDataTransferencia(LocalDate data);
    @Query(value = "SELECT * FROM transferencia " +
            "WHERE nome_operador_transacao = :nomeOperador BETWEEN :initial AND :end",
            nativeQuery = true)
    List<Transferencia> findByNameOperador(String nomeOperador);
}

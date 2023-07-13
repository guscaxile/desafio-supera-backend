package br.com.banco.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long id;

    @NotNull
    @Column(name = "nome_responsavel")
    private String nomeResponsavel;
}

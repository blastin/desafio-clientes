package br.projeto.desafio.dominio.cliente;

import java.time.LocalDate;
import java.util.UUID;

public interface Cliente {

    @SuppressWarnings("unused")
    default UUID getId() {
        throw new IllegalCallerException("Cliente nao deveria retornar ID diretamente");
    }

    String getNome();

    LocalDate getDataNascimento();

    String getCpf();

    Endereco getEndereco();

}

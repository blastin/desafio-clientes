package br.projeto.desafio.dominio.cliente;

import java.util.UUID;

@Adaptador
public interface Endereco {

    @SuppressWarnings("unused")
    default UUID getId() {
        return UUID.randomUUID();
    }

    String getLogradouro();

    String getComplemento();

    Integer getNumero();

}

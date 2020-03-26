package br.projeto.desafio.dominio.cliente;

import java.util.UUID;

@Adaptador
public interface Endereco {

    @SuppressWarnings("unused")
    default UUID getId() {
        throw new IllegalCallerException("Endereco nao deveria retornar ID diretamente");
    }

    String getLogradouro();

    String getComplemento();

    Integer getNumero();

}

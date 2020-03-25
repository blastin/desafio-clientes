package br.projeto.desafio.spring.web;

import br.projeto.desafio.dominio.cliente.Cliente;
import br.projeto.desafio.dominio.cliente.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Value;

import java.time.LocalDate;

@Data
final class ClienteDTO implements Cliente {

    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String nome;

    private EnderecoDTO endereco;

    @Value
    private static class EnderecoDTO implements Endereco {

        String complemento;

        String logradouro;

        Integer numero;

    }
}

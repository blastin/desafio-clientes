package br.projeto.desafio.console;

import br.projeto.desafio.dominio.cliente.Cliente;
import br.projeto.desafio.dominio.cliente.ClienteException;
import br.projeto.desafio.dominio.cliente.ClientesGateway;
import br.projeto.desafio.dominio.cliente.Endereco;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class Repositorio implements ClientesGateway {

    @Override
    public Collection<? extends Cliente> clientes() {
        return List.of();
    }

    @Override
    public Cliente obterClientePorCPF(final String cpf) throws ClienteException {
        return new Cliente() {
            @Override
            public String getNome() {
                return "";
            }

            @Override
            public LocalDate getDataNascimento() {
                return LocalDate.now();
            }

            @Override
            public String getCpf() {
                return cpf;
            }

            @Override
            public Endereco getEndereco() {
                return new Endereco() {
                    @Override
                    public String getLogradouro() {
                        return "";
                    }

                    @Override
                    public String getComplemento() {
                        return "";
                    }

                    @Override
                    public Integer getNumero() {
                        return 1;
                    }
                };
            }
        };
    }

    @Override
    public Cliente novoCliente(final Cliente cliente) throws ClienteException {
        return null;
    }

    @Override
    public Cliente removerClientePorCPF(final String cpf) throws ClienteException {
        return null;
    }

    @Override
    public Cliente atualizarCliente(final String cpf, final Cliente cliente) throws ClienteException {
        return null;
    }

}

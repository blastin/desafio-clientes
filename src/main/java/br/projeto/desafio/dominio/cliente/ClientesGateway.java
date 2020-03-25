package br.projeto.desafio.dominio.cliente;

import java.util.Collection;

public interface ClientesGateway {

    Collection<? extends Cliente> clientes();

    Cliente obterClientePorCPF(final String cpf) throws ClienteException;

    default Cliente novoCliente(final Cliente cliente) throws ClienteException {
        throw new ClienteException("metodo deve ser sobrescrito");
    }

    Cliente removerClientePorCPF(final String cpf) throws ClienteException;

    default Cliente atualizarCliente(final String cpf, final Cliente cliente) throws ClienteException {
        throw new ClienteException("metodo deve ser sobrescrito");
    }

}

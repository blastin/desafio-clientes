package br.projeto.desafio.spring.web;

import br.projeto.desafio.dominio.cliente.Cliente;
import br.projeto.desafio.dominio.cliente.ClienteException;
import br.projeto.desafio.dominio.cliente.ClientesGateway;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

@Slf4j
final class ClientesLog implements ClientesGateway {

    private final ClientesGateway clientesGateway;

    ClientesLog(final ClientesGateway clientesGateway) {
        this.clientesGateway = clientesGateway;
    }

    @Override
    public Collection<? extends Cliente> clientes() {
        log.info("Consultando todos clientes");
        return clientesGateway.clientes();
    }

    @Override
    public Cliente obterClientePorCPF(final String cpf) throws ClienteException {
        log.info("Consultando cliente com cpf = {}", cpf);
        return clientesGateway.obterClientePorCPF(cpf);
    }

    @Override
    public Cliente novoCliente(final Cliente cliente) throws ClienteException {
        log.info("Cadastrando cliente = {}", cliente);
        return clientesGateway.novoCliente(cliente);
    }

    @Override
    public Cliente removerClientePorCPF(final String cpf) throws ClienteException {
        log.info("Removendo cliente por cpf = {}", cpf);
        return clientesGateway.removerClientePorCPF(cpf);
    }

    @Override
    public Cliente atualizarCliente(final String cpf, final Cliente cliente) throws ClienteException {
        log.info("Atualizando cliente = {}", cliente);
        return clientesGateway.atualizarCliente(cpf, cliente);
    }
}

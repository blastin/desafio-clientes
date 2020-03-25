package br.projeto.desafio.spring.web;

import br.projeto.desafio.dominio.cliente.Cliente;
import br.projeto.desafio.dominio.cliente.ClientesGateway;
import br.projeto.desafio.dominio.cliente.StatusCliente;

import java.util.Collection;

final class ClienteServico implements ClientesGateway {

    private final ClienteRepositorio repositorio;

    ClienteServico(final ClienteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Collection<? extends Cliente> clientes() {
        return repositorio.findAllByStatusEquals(StatusCliente.ATIVO);
    }

    @Override
    public Cliente obterClientePorCPF(final String cpf) {
        return repositorio.getClienteByCpf(cpf);
    }

    @Override
    public Cliente novoCliente(final Cliente cliente) {
        return repositorio.save(new ClienteEntidade(cliente));
    }

    @Override
    public Cliente removerClientePorCPF(final String cpf) {
        repositorio.deleteByCpf(cpf);
        return null;
    }

    @Override
    public Cliente atualizarCliente(final String cpf, final Cliente cliente) {
        return repositorio.save(new ClienteEntidade(cpf, cliente));
    }
}

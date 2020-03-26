package br.projeto.desafio.dominio.cliente;

import java.util.Collection;
import java.util.Optional;

final class ClientesProxy implements ClientesGateway {

    private final ClientesGateway clientesGateway;

    private final StatusResposta statusResposta;

    ClientesProxy(final ClientesGateway clientesGateway, final StatusResposta statusResposta) {
        this.clientesGateway = clientesGateway;
        this.statusResposta = statusResposta;
    }

    @Override
    public Collection<? extends Cliente> clientes() {
        return clientesGateway.clientes();
    }

    @Override
    public Cliente obterClientePorCPF(final String cpf) throws ClienteException {

        return Optional
                .ofNullable(clientesGateway.obterClientePorCPF(cpf))
                .orElseThrow(() -> new ClienteException(
                        statusResposta.naoEncontrado(),
                        String.format("cliente com cpf = %s nao foi encontrado", cpf)));

    }

    @Override
    public Cliente novoCliente(final Cliente cliente) throws ClienteException {

        final String cpf = cliente.getCpf();

        final Optional<Cliente> optionalClienteEntidade = Optional.ofNullable(clientesGateway.obterClientePorCPF(cpf));

        if (optionalClienteEntidade.isPresent()) {
            throw new ClienteException(
                    statusResposta.existente(),
                    String.format("nao foi possivel criar novo cliente com cpf = %s", cpf));
        }

        return clientesGateway.novoCliente(cliente);

    }

    @Override
    public Cliente removerClientePorCPF(final String cpf) throws ClienteException {

        final Optional<Cliente> optionalClienteEntidade = Optional.ofNullable(clientesGateway.obterClientePorCPF(cpf));

        if (optionalClienteEntidade.isEmpty()) {
            throw new ClienteException(
                    statusResposta.semConteudo(),
                    String.format("nao foi possivel remover cliente com cpf = %s", cpf));
        }

        final Cliente cliente = optionalClienteEntidade.get();

        clientesGateway.removerClientePorCPF(cpf);

        return cliente;

    }

    @Override
    public Cliente atualizarCliente(final String cpf, final Cliente cliente) throws ClienteException {

        final Optional<Cliente> optionalClienteEntidade = Optional.ofNullable(clientesGateway.obterClientePorCPF(cpf));

        if (optionalClienteEntidade.isEmpty()) {
            throw new ClienteException(
                    statusResposta.semConteudo(),
                    String.format("nao foi possivel atualizar cliente com cpf = %s", cpf));
        }

        final Endereco endereco = cliente.getEndereco();

        final Cliente clienteObtido = optionalClienteEntidade.get();

        final Endereco enderecoObtido = clienteObtido.getEndereco();

        final Cliente clienteParaAtualizar =
                new ClienteConstrutor()
                        .comID(clienteObtido.getId())
                        .comNome(cliente.getNome())
                        .comCpf(cpf)
                        .comDataNascimento(cliente.getDataNascimento())
                        .paraEndereco(
                                new EnderecoConstrutor()
                                        .comId(enderecoObtido.getId())
                                        .comLogradouro(endereco.getLogradouro())
                                        .comComplemento(endereco.getComplemento())
                                        .comNumero(endereco.getNumero())
                                        .construir()
                        ).construir();


        return clientesGateway.atualizarCliente(cpf, clienteParaAtualizar);

    }

}

package br.projeto.desafio.dominio.cliente;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.Profile;

import java.util.Collection;
import java.util.SplittableRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Profile("test")
public class ClientesGatewayTest {

    private final StatusResposta statusResposta = new StatusRespostaParaTeste();

    private final ClientesGateway repositorio = Mockito.mock(ClientesGateway.class);

    private final ClientesGateway clientesGateway = ClientesFabrica.construir(repositorio, statusResposta);

    private final SplittableRandom random = new SplittableRandom();

    @Test
    @DisplayName("obter todos clientes")
    public void obterClientes() {

        final Collection<? extends Cliente> clientes = construirClientes(random.nextInt(100));

        Mockito
                .when(repositorio.clientes())
                .thenAnswer(invocation -> clientes);

        final Collection<? extends Cliente> clientesObtidos = clientesGateway.clientes();

        Assertions
                .assertEquals(cpfs(clientes), cpfs(clientesObtidos), "clientes devem ser iguais");

    }

    @Test
    @DisplayName("obter cliente por cpf")
    public void obterClientePorCPF() throws ClienteException {

        final Cliente cliente = construirCliente();

        Mockito
                .when(repositorio.obterClientePorCPF(cliente.getCpf()))
                .thenReturn(cliente);

        final Cliente clienteRecebido = clientesGateway.obterClientePorCPF(cliente.getCpf());

        Assertions
                .assertEquals(cliente.getCpf(), clienteRecebido.getCpf(), "cpfs devem ser iguais");

    }

    @Test
    @DisplayName("obter cliente por cpf inexistente")
    public void obterClientePorCPFInexistente() {

        final Cliente cliente = construirCliente();

        final ClienteException clienteException = Assertions
                .assertThrows(ClienteException.class, () -> clientesGateway.obterClientePorCPF(cliente.getCpf()));


        Assertions.assertEquals(statusResposta.naoEncontrado(), clienteException.getStatusResposta());

    }

    @Test
    @DisplayName("criar novo cliente")
    public void novoCliente() throws ClienteException {

        final Cliente cliente = construirCliente();

        Mockito.when(repositorio.novoCliente(Mockito.any(Cliente.class))).thenReturn(cliente);

        final Cliente novoCliente = clientesGateway.novoCliente(cliente);

        Assertions
                .assertEquals(cliente.getCpf(), novoCliente.getCpf(), "cpf de cliente cadastrado deve ser igual");

    }

    @Test
    @DisplayName("criar novo cliente por cpf existente")
    public void novoClientePorCpfExistente() throws ClienteException {

        final Cliente cliente = construirCliente();

        Mockito
                .when(repositorio.obterClientePorCPF(cliente.getCpf()))
                .thenReturn(cliente);

        final ClienteException clienteException = Assertions
                .assertThrows(ClienteException.class, () -> clientesGateway.novoCliente(cliente));

        Assertions.assertEquals(statusResposta.existente(), clienteException.getStatusResposta());

    }

    @Test
    @DisplayName("remover cliente por cpf")
    public void removerClientePorCPF() throws ClienteException {

        final Cliente cliente = construirCliente();

        Mockito
                .when(repositorio.obterClientePorCPF(cliente.getCpf()))
                .thenReturn(cliente);

        final Cliente clienteRecebido = clientesGateway.removerClientePorCPF(cliente.getCpf());

        Assertions
                .assertEquals(cliente.getCpf(), clienteRecebido.getCpf(), "cpf de cliente removido deve ser igual");

    }

    @Test
    @DisplayName("remover cliente por cpf inexistente")
    public void removerClientePorCPFInexistente() {

        final Cliente cliente = construirCliente();

        final ClienteException clienteException = Assertions
                .assertThrows(ClienteException.class, () -> clientesGateway.removerClientePorCPF(cliente.getCpf()));

        Assertions.assertEquals(statusResposta.semConteudo(), clienteException.getStatusResposta());

    }

    @Test
    @DisplayName("atualizar cliente por cpf")
    public void atualizarClientePorCPF() throws ClienteException {

        final Cliente cliente = construirCliente();

        Mockito
                .when(repositorio.obterClientePorCPF(cliente.getCpf()))
                .thenReturn(cliente);

        Mockito
                .when(repositorio.atualizarCliente(Mockito.anyString(), Mockito.any(Cliente.class)))
                .thenReturn(cliente);

        final Cliente clienteRecebido = clientesGateway.atualizarCliente(cliente.getCpf(), cliente);

        Assertions
                .assertEquals(cliente.getCpf(), clienteRecebido.getCpf(), "cpf de cliente atualizado deve ser igual");

    }

    @Test
    @DisplayName("atualizar cliente por cpf inexistente")
    public void atualizarClientePorCPFInexistente() {

        final Cliente cliente = construirCliente();

        final ClienteException clienteException = Assertions
                .assertThrows(ClienteException.class, () -> clientesGateway.atualizarCliente(cliente.getCpf(), cliente));

        Assertions.assertEquals(statusResposta.semConteudo(), clienteException.getStatusResposta());

    }


    private Collection<String> cpfs(final Collection<? extends Cliente> clientes) {

        return clientes
                .parallelStream()
                .map(Cliente::getCpf)
                .collect(Collectors.toList());

    }

    private Collection<? extends Cliente> construirClientes(final int quantidadeVezes) {

        return IntStream
                .range(1, quantidadeVezes + 1)
                .mapToObj(i ->
                        construirCliente())
                .collect(Collectors.toUnmodifiableList());

    }

    private Cliente construirCliente() {

        final Cliente clienteParaTeste = new ClienteParaTeste(random);

        final Endereco endereco = clienteParaTeste.getEndereco();

        return new ClienteConstrutor()
                .comID(clienteParaTeste.getId())
                .comCpf(clienteParaTeste.getCpf())
                .comDataNascimento(clienteParaTeste.getDataNascimento())
                .comNome(clienteParaTeste.getNome())
                .paraEndereco(
                        new EnderecoConstrutor()
                                .comId(endereco.getId())
                                .comNumero(endereco.getNumero())
                                .comComplemento(endereco.getComplemento())
                                .comLogradouro(endereco.getLogradouro())
                                .construir()
                ).construir();
    }

}

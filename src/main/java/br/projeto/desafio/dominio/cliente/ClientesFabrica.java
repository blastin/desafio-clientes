package br.projeto.desafio.dominio.cliente;

public final class ClientesFabrica {

    private ClientesFabrica() {
    }

    public static ClientesGateway construir(final ClientesGateway clientesGateway, final StatusResposta statusResposta) {
        return new ClientesProxy(clientesGateway, statusResposta);
    }

}

package br.projeto.desafio.console;

import br.projeto.desafio.dominio.cliente.*;

public class ConsoleMain {


    public static void main(String[] args) throws ClienteException {

        final ClientesGateway repositorio = new Repositorio();

        final StatusResposta statusResposta = new StatusRespostaConsole();

        final ClientesGateway servico = ClientesFabrica.construir(repositorio, statusResposta);

        final Cliente cliente = servico.obterClientePorCPF("123456");

        System.out.println(cliente.getCpf());

    }
}

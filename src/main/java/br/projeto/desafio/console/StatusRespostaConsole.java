package br.projeto.desafio.console;

import br.projeto.desafio.dominio.cliente.StatusResposta;

public class StatusRespostaConsole implements StatusResposta {
    @Override
    public int naoEncontrado() {
        return 1;
    }

    @Override
    public int semConteudo() {
        return 2;
    }

    @Override
    public int existente() {
        return 3;
    }
}

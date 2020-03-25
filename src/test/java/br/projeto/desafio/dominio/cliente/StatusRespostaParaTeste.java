package br.projeto.desafio.dominio.cliente;

final class StatusRespostaParaTeste implements StatusResposta {

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

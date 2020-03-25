package br.projeto.desafio.spring.web;

import br.projeto.desafio.dominio.cliente.StatusResposta;
import org.springframework.http.HttpStatus;

final class StatusRespostaHttp implements StatusResposta {

    @Override
    public int naoEncontrado() {
        return HttpStatus.NOT_FOUND.value();
    }

    @Override
    public int semConteudo() {
        return HttpStatus.NO_CONTENT.value();
    }

    @Override
    public int existente() {
        return HttpStatus.CONFLICT.value();
    }

}

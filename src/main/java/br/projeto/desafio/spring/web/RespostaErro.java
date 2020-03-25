package br.projeto.desafio.spring.web;

import lombok.Value;

import java.time.LocalDateTime;

@Value
class RespostaErro {

    LocalDateTime dataOperacao;

    String mensagem;

}

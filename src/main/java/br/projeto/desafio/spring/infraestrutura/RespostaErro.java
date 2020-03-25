package br.projeto.desafio.spring.infraestrutura;

import lombok.Value;

import java.time.LocalDateTime;

@Value
class RespostaErro {

    LocalDateTime dataOperacao;

    String mensagem;

}

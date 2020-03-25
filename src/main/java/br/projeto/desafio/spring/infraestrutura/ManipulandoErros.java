package br.projeto.desafio.spring.infraestrutura;

import br.projeto.desafio.dominio.cliente.ClienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Optional;

@RestControllerAdvice
final class ManipulandoErros {

    @ExceptionHandler(ClienteException.class)
    ResponseEntity<RespostaErro> padraoErrors(final ClienteException e) {

        final Integer status = Optional.ofNullable(e.getStatusResposta()).orElse(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity
                .status(status)
                .body(new RespostaErro(LocalDateTime.now(), e.getMessage()));

    }

}

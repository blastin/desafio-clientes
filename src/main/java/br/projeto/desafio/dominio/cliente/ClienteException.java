package br.projeto.desafio.dominio.cliente;

import java.util.Optional;

public final class ClienteException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 5216128659568441590L;

    private transient Integer statusResposta = null;

    ClienteException(final Integer statusResposta, final String mensagem) {
        super(mensagem);
        this.statusResposta = statusResposta;
    }

    ClienteException(final String mensagem) {
        super(mensagem);
    }

    public Integer getStatusResposta() {
        return statusResposta;
    }

    @Override
    public String getMessage() {
        return Optional.ofNullable(super.getMessage()).orElse("");
    }

}

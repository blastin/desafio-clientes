package br.projeto.desafio.dominio.cliente;

import java.util.Objects;
import java.util.UUID;


final class EnderecoConstrutor {

    private final EnderecoAdaptador enderecoAdaptador;

    EnderecoConstrutor() {
        this.enderecoAdaptador = new EnderecoAdaptador();
    }

    EnderecoConstrutor comId(final UUID id) {
        enderecoAdaptador.id = id;
        return this;
    }

    EnderecoConstrutor comLogradouro(final String logradouro) {
        enderecoAdaptador.logradouro = logradouro;
        return this;
    }

    EnderecoConstrutor comComplemento(final String complemento) {
        enderecoAdaptador.complemento = complemento;
        return this;
    }

    EnderecoConstrutor comNumero(final Integer numero) {
        enderecoAdaptador.numero = numero;
        return this;
    }

    Endereco construir() {
        return enderecoAdaptador;
    }

    private static final class EnderecoAdaptador implements Endereco {

        private UUID id;

        private String logradouro;

        private String complemento;

        private Integer numero;

        private EnderecoAdaptador() {
        }

        @Override
        public String toString() {
            return "{" +
                   "id=" + id +
                   ", logradouro='" + logradouro + '\'' +
                   ", complemento='" + complemento + '\'' +
                   ", numero=" + numero +
                   '}';
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final EnderecoAdaptador that = (EnderecoAdaptador) o;
            return Objects.equals(id, that.id) &&
                   Objects.equals(logradouro, that.logradouro) &&
                   Objects.equals(complemento, that.complemento) &&
                   Objects.equals(numero, that.numero);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, logradouro, complemento, numero);
        }

        @Override
        public String getLogradouro() {
            return logradouro;
        }

        @Override
        public String getComplemento() {
            return complemento;
        }

        @Override
        public Integer getNumero() {
            return numero;
        }

        @Override
        public UUID getId() {
            return id;
        }
    }
}
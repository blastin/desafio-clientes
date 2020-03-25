package br.projeto.desafio.dominio.cliente;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

final class ClienteAdaptador implements Cliente {

    private final UUID id;

    private final String nome;

    private final LocalDate dataNascimento;

    private final String cpf;

    private final Endereco endereco;

    ClienteAdaptador(final Cliente cliente, final Cliente clienteEncontrado) {
        id = clienteEncontrado.getId();
        dataNascimento = cliente.getDataNascimento();
        cpf = cliente.getCpf();
        nome = cliente.getNome();
        endereco = new EnderecoAdaptador(cliente.getEndereco(), clienteEncontrado.getEndereco());
    }

    ClienteAdaptador(final Cliente cliente) {
        id = cliente.getId();
        dataNascimento = cliente.getDataNascimento();
        cpf = cliente.getCpf();
        nome = cliente.getNome();
        endereco = new EnderecoAdaptador(cliente.getEndereco());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ClienteAdaptador that = (ClienteAdaptador) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(nome, that.nome) &&
               Objects.equals(dataNascimento, that.dataNascimento) &&
               Objects.equals(cpf, that.cpf) &&
               Objects.equals(endereco, that.endereco);
    }

    @Override
    public String toString() {
        return "ClienteAdaptador{" +
               "nome='" + nome + '\'' +
               ", dataNascimento=" + dataNascimento +
               ", cpf='" + cpf + '\'' +
               ", endereco=" + endereco +
               '}';
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataNascimento, cpf, endereco);
    }

    final private static class EnderecoAdaptador implements Endereco {

        private final UUID id;

        private final String logradouro;

        private final String complemento;

        private final Integer numero;

        private EnderecoAdaptador(final Endereco endereco, final Endereco enderecoEncontrado) {
            id = enderecoEncontrado.getId();
            complemento = endereco.getComplemento();
            logradouro = endereco.getLogradouro();
            numero = endereco.getNumero();
        }

        private EnderecoAdaptador(final Endereco endereco) {
            id = endereco.getId();
            complemento = endereco.getComplemento();
            logradouro = endereco.getLogradouro();
            numero = endereco.getNumero();
        }

        @Override
        public String toString() {
            return "EnderecoAdaptador{" +
                   "logradouro='" + logradouro + '\'' +
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

    }
}

package br.projeto.desafio.dominio.cliente;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

final class ClienteConstrutor {

    private final ClienteAdaptador clienteAdaptador;

    ClienteConstrutor() {
        clienteAdaptador = new ClienteAdaptador();
    }

    ClienteConstrutor comID(final UUID id){
        clienteAdaptador.id = id;
        return this;
    }
    
    ClienteConstrutor comNome(final String nome) {
        clienteAdaptador.nome = nome;
        return this;
    }

    ClienteConstrutor comDataNascimento(final LocalDate dataNascimento) {
        clienteAdaptador.dataNascimento = dataNascimento;
        return this;
    }

    ClienteConstrutor comCpf(final String cpf) {
        clienteAdaptador.cpf = cpf;
        return this;
    }

    ClienteConstrutor paraEndereco(final Endereco endereco) {
        clienteAdaptador.endereco = endereco;
        return this;
    }

    Cliente construir() {
        return clienteAdaptador;
    }

    private static final class ClienteAdaptador implements Cliente {

        private UUID id;

        private String nome;

        private LocalDate dataNascimento;

        private String cpf;

        private Endereco endereco;

        private ClienteAdaptador() {
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
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final ClienteAdaptador that = (ClienteAdaptador) o;
            return Objects.equals(getId(), that.getId()) &&
                   Objects.equals(getNome(), that.getNome()) &&
                   Objects.equals(getDataNascimento(), that.getDataNascimento()) &&
                   Objects.equals(getCpf(), that.getCpf()) &&
                   Objects.equals(getEndereco(), that.getEndereco());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getNome(), getDataNascimento(), getCpf(), getEndereco());
        }

        @Override
        public String toString() {
            return "{" +
                   "id=" + id +
                   ", nome='" + nome + '\'' +
                   ", dataNascimento=" + dataNascimento +
                   ", cpf='" + cpf + '\'' +
                   ", endereco=" + endereco +
                   '}';
        }
    }

}


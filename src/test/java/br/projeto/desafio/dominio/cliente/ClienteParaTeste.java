package br.projeto.desafio.dominio.cliente;

import net.bytebuddy.utility.RandomString;

import java.time.LocalDate;
import java.util.SplittableRandom;
import java.util.UUID;

final class ClienteParaTeste implements Cliente {

    private final SplittableRandom random;

    ClienteParaTeste(SplittableRandom random) {
        this.random = random;
    }

    @Override
    public UUID getId() {
        return UUID.randomUUID();
    }

    @Override
    public String getNome() {
        return RandomString.make();
    }

    @Override
    public LocalDate getDataNascimento() {
        return LocalDate.now();
    }

    @Override
    public String getCpf() {
        return RandomString.make(12);
    }

    @Override
    public Endereco getEndereco() {
        return new EnderecoParaTeste(random);
    }

    private static class EnderecoParaTeste implements Endereco {

        private final SplittableRandom random;

        public EnderecoParaTeste(final SplittableRandom random) {
            this.random = random;
        }

        @Override
        public UUID getId() {
            return UUID.randomUUID();
        }

        @Override
        public String getLogradouro() {
            return RandomString.make(20);
        }

        @Override
        public String getComplemento() {
            return RandomString.make(20);
        }

        @Override
        public Integer getNumero() {
            return random.nextInt(1, 20000);
        }

    }
}

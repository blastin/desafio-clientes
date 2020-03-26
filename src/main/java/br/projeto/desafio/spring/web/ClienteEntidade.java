package br.projeto.desafio.spring.web;

import br.projeto.desafio.dominio.cliente.Cliente;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
final class ClienteEntidade implements Cliente {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @NotNull
    @CPF
    @Column(name = "cpf")
    @Length(min = 11, max = 12)
    private String cpf;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private StatusCliente status;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    private EnderecoEntidade endereco;

    ClienteEntidade(final Cliente cliente) {
        nome = cliente.getNome();
        dataNascimento = cliente.getDataNascimento();
        cpf = cliente.getCpf();
        endereco = new EnderecoEntidade(cliente.getEndereco());
        status = StatusCliente.ATIVO;
    }

    ClienteEntidade(final String cpf, final Cliente cliente) {
        this.cpf = cpf;
        nome = cliente.getNome();
        dataNascimento = cliente.getDataNascimento();
        endereco = new EnderecoEntidade(cliente.getEndereco());
        status = StatusCliente.ATIVO;
        id = cliente.getId();
    }
}

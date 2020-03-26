package br.projeto.desafio.spring.web;

import br.projeto.desafio.dominio.cliente.Endereco;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "endereco")
@Data
@NoArgsConstructor
final class EnderecoEntidade implements Endereco {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Column(name = "logradouro")
    @Length(max = 50)
    private String logradouro;

    @NotNull
    @Column(name = "complemento")
    @Length(max = 15)
    private String complemento;

    @Column(name = "numero")
    private Integer numero;

    EnderecoEntidade(final Endereco endereco) {
        logradouro = endereco.getLogradouro();
        complemento = endereco.getComplemento();
        numero = endereco.getNumero();
    }

    EnderecoEntidade(final UUID id, final Endereco endereco) {
        this.id = id;
        logradouro = endereco.getLogradouro();
        complemento = endereco.getComplemento();
        numero = endereco.getNumero();
    }

}

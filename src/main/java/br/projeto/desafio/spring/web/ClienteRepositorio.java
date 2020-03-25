package br.projeto.desafio.spring.web;

import br.projeto.desafio.dominio.cliente.StatusCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

@Repository
interface ClienteRepositorio extends JpaRepository<ClienteEntidade, UUID> {

    Collection<ClienteEntidade> findAllByStatusEquals(final StatusCliente statusCliente);

    ClienteEntidade getClienteByCpf(final String cpf);

    @Transactional
    void deleteByCpf(final String cpf);

}

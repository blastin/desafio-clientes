package br.projeto.desafio.spring.web;

import br.projeto.desafio.dominio.cliente.Cliente;
import br.projeto.desafio.dominio.cliente.ClienteException;
import br.projeto.desafio.dominio.cliente.ClientesGateway;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@RestController(value = "controlador")
@RequestMapping(value = "clientes")
final class ControladorCliente implements ClientesGateway {

    private final ClientesGateway gateway;

    ControladorCliente(final ClientesGateway gateway) {
        this.gateway = gateway;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Collection<? extends Cliente> clientes() {
        return gateway.clientes();
    }

    @GetMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Cliente obterClientePorCPF(@NotEmpty @PathVariable("cpf") final String cpf) throws ClienteException {
        return gateway.obterClientePorCPF(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente novoCliente(@Valid @RequestBody final ClienteDTO cliente) throws ClienteException {
        return gateway.novoCliente(cliente);
    }

    @DeleteMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Cliente removerClientePorCPF(@NotEmpty @PathVariable("cpf") final String cpf) throws ClienteException {
        return gateway.removerClientePorCPF(cpf);
    }

    @PutMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente atualizarCliente(@NotEmpty @PathVariable("cpf") final String cpf, @Valid @RequestBody final ClienteDTO cliente) throws ClienteException {
        return gateway.atualizarCliente(cpf, cliente);
    }

}

package br.projeto.desafio.spring.web;

import br.projeto.desafio.dominio.cliente.Cliente;
import br.projeto.desafio.dominio.cliente.ClienteException;
import br.projeto.desafio.dominio.cliente.ClientesGateway;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Retorna uma lista de clientes")
    @ApiResponse(code = 200, message = "Retorna lista de clientes")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Collection<? extends Cliente> clientes() {
        return gateway.clientes();
    }

    @ApiOperation(value = "Retorna um cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna cliente com cpf especifico"),
            @ApiResponse(code = 404, message = "Clientes com cpf não encontrado", response = RespostaErro.class)
    })
    @GetMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Cliente obterClientePorCPF(@NotEmpty @PathVariable("cpf") final String cpf) throws ClienteException {
        return gateway.obterClientePorCPF(cpf);
    }

    @ApiOperation(value = "Cadastra novo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente criado com sucesso"),
            @ApiResponse(code = 409, message = "Não foi possível cadastrar novo cliente", response = RespostaErro.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente novoCliente(@Valid @RequestBody final ClienteDTO cliente) throws ClienteException {
        return gateway.novoCliente(cliente);
    }

    @ApiOperation(value = "Remove um cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente removido com sucesso"),
            @ApiResponse(code = 204, message = "Não foi possível remover cliente com cpf específicado")
    })
    @DeleteMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Cliente removerClientePorCPF(@NotEmpty @PathVariable("cpf") final String cpf) throws ClienteException {
        return gateway.removerClientePorCPF(cpf);
    }

    @ApiOperation(value = "Atualiza um cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente atualizado com sucesso"),
            @ApiResponse(code = 204, message = "Não foi possível atualizado cliente com cpf específicado")
    })
    @PutMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente atualizarCliente(@NotEmpty @PathVariable("cpf") final String cpf, @Valid @RequestBody final ClienteDTO cliente) throws ClienteException {
        return gateway.atualizarCliente(cpf, cliente);
    }

}

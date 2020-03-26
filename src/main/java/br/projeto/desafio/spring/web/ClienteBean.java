package br.projeto.desafio.spring.web;

import br.projeto.desafio.dominio.cliente.ClientesFabrica;
import br.projeto.desafio.dominio.cliente.ClientesGateway;
import br.projeto.desafio.dominio.cliente.StatusResposta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
class ClienteBean {

    @Bean
    @Primary
    ClientesGateway clientesGateway(final ClienteRepositorio repositorio, final StatusResposta statusResposta) {
        final ClienteServico servico = new ClienteServico(repositorio);
        return ClientesFabrica.construir(new ClientesLog(servico), statusResposta);
    }

    @Bean
    StatusResposta statusResposta() {
        return new StatusRespostaHttp();
    }

}

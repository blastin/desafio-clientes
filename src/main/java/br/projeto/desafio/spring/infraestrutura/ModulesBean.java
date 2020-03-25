package br.projeto.desafio.spring.infraestrutura;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
class ModulesBean {

    @Bean
    SimpleModule module() {
        final SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerialize());
        return module;
    }

}

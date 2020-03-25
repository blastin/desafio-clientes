package br.projeto.desafio.spring.infraestrutura;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

final class LocalDateSerialize extends JsonSerializer<LocalDate> {

    private final static String PADRAO = "dd/MM/yyyy";

    @Override
    public void serialize(final LocalDate value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        if (value == null) {
            gen.writeNull();
        } else {
            gen.writeString(DateTimeFormatter.ofPattern(PADRAO).format(value));
        }

    }
}

FROM  adoptopenjdk/openjdk11-openj9:alpine-jre

LABEL "Autor" = "Jefferson Lisboa <lisboa.jeff@gmail.com>"

RUN adduser -D usuario

USER usuario

WORKDIR /home/usuario

#COPIAR JAR PARA CONTAINER
COPY target/*.jar servico.jar

#COMANDO DE INICIALIZAÇÃO
CMD [ "java", "-Dspring.profiles.active=container", "-jar", "servico.jar" ]


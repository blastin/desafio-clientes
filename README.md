# desafio-clientes
 
 
Proposta : Serviço básico de clientes utilizando arquitetura limpa

Tecnologias :

-   Java 11
-   Bibliotecas Spring 2.2.5.RELEASE
-   Maven 3.6.3
-   Postgresql 12.2
-   Swagger 2.9.2


Ferramentas:
-   Docker Compose
-   Docker
-   Postman


Variáveis de ambiente Postman :


    É recomendável construir dois ambientes.
    
        1   [localhost]
        2   [docker]
    
    Para cada um deles será criado uma variável de ambiente chamada API
            
        1 Para ambiente [localhost] , API terá valor {{LOCALHOST}}/api
        2 Para ambiente [docker]    , API terá valor {{CONTAINER}}/api


Ambientes :

Para comunicar com serviço podemos utilizar as seguintes url canônicas

    [localhost] = http://localhost:8081/api/clientes
    [docker]    = http://localhost:7080/api/clientes

Swagger :

A API pode ser visualizada com swagger-ui. Basta acessar as seguintes url

    [localhost] = http://localhost:8081/api/swagger-ui.html
    [docker] = http://localhost:7080/api/swagger-ui.html
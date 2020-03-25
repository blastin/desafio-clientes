-- Adminer 4.7.6 PostgreSQL dump

DROP TABLE IF EXISTS "endereco";
CREATE TABLE "public"."endereco"
(
    "logradouro"  character varying(50) NOT NULL,
    "numero"      integer               NOT NULL,
    "complemento" character varying(15) NOT NULL,
    "id"          uuid                  NOT NULL,
    CONSTRAINT "endereco_id" PRIMARY KEY ("id")
) WITH (oids = false);

DROP TABLE IF EXISTS "cliente";
CREATE TABLE "public"."cliente"
(
    "nome"            character varying(50) NOT NULL,
    "data_nascimento" date                  NOT NULL,
    "cpf"             character varying(12) NOT NULL,
    "id"              uuid                  NOT NULL,
    "endereco_id"     uuid                  NOT NULL,
    "status"          integer               NOT NULL,
    CONSTRAINT "cliente_id" PRIMARY KEY ("id"),
    CONSTRAINT "cliente_enderecoID_fkey" FOREIGN KEY (endereco_id) REFERENCES endereco (id) NOT DEFERRABLE
) WITH (oids = false);

COMMENT ON COLUMN "public"."cliente"."nome" IS 'Nome Cliente';

COMMENT ON COLUMN "public"."cliente"."data_nascimento" IS 'Data Nascimento formato Date';

-- 2020-03-24 20:29:07.851099+00
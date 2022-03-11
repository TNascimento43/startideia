-- #### APLICAÇÃO #### --

-- cria esquema
\connect startideia;
CREATE SCHEMA apistartideia;

-- cria role com privilégios para todas as operações
CREATE ROLE rapistartideia;
ALTER ROLE rapistartideia SET search_path TO apistartideia, public;
GRANT ALL PRIVILEGES ON DATABASE startideia TO rapistartideia;
GRANT ALL PRIVILEGES ON SCHEMA apistartideia TO rapistartideia;

-- cria usuário geral da aplicação (terá privilégios para todas as operações)
CREATE USER apistartideia WITH PASSWORD 'apistartideia' IN ROLE rapistartideia;




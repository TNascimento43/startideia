# Nome do Projeto

STARTIDEIA-API

# Sistema

O STARTIDEIA-API é um sistema de Teste de desenvolvedores. 

## Postgresql 

O banco de dados ORM da solução é o Postgresql.



## Serviços

Os serviços da solução são APIs REST utilizadas para consumo e geração de dados dentro dos modelos. Todas as regras negociais são controladas por eles.


# Ambiente de desenvolvimento

## Compose dos containers

Vá na pasta docker e execute:

```
docker-compose -f docker-compose.yml up -d
```

Os containers serão montados e estarão prontos.

## Serviços:

Os serviços são compilados com o maven:

```
clean install
```

Deve-se utilizar o profile de dev e os testes podem ser ignorados para termos de compilação.

A partir da compilação podem ser executados pela IDE, pela classe principal ou pelo comando mvnw disponível dentro da pasta de cada serviço.

Apos execuçao do sistema, estara disponivel os seguintes recursos:

	Local: http://localhost:3000/api
	Externo: http://127.0.1.1:3000/api
	Swagger Url: http://127.0.1.1:3000/api/swagger-ui.html
	Local Swagger Url: http://localhost:3000/api/swagger-ui.html

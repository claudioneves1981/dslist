<h2> DSlist baseado no curso Intensivão Java Spring Nélio Alves</h2>

Para clonar o projeto(com GitHub Cli)
```
gh repo clone claudioneves1981/dslist
```

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
docker build -t dslist
docker run -p 8080:8080 dslist
```

Após executar o comando acima, basta apenas abrir o seguinte endereço para visualizar o projeto pronto.

```
http://localhost:8080/lists
```

São necessários os seguintes pré-requisitos para a execução do projeto:

* Java 17
* Maven 3
* Spring 3
* Intellj IDEA Community Edition ou sua IDE favorita.
* Controle de versão GIT instalado na sua máquina.
* GitHub Cli instalado na sua maquina.
* Conta no GitHub para o armazenamento do seu projeto na nuvem.
* PostgreSQL para banco de dados.
* Bootstrap e Thymeleaf para fazer o front.
* Docker
* Render para Deploy


Abaixo, seguem links dos principais recursos usados no projeto.

* [Site oficial do Spring Initialzr, para setup do projeto](https://start.spring.io/)
* [Github Cli](https://cli.github.com/)
* [PostgreSQL](https://www.postgresql.org/)
* [Bootstrap 5.0.1](https://getbootstrap.com/docs/5.1/getting-started/introduction/)
* [Render](https://render.com/)
* [Thymeleaf](https://www.thymeleaf.org/)

Dslist Baseado no projeto do Nélio Alves (Devsuperior) com adaptações (https://github.com/devsuperior/dslist-backend)

OBS.: Classe WebConfig pode ser descomentada caso precisa usar cors no projeto. 
Variavel de ambiente para cors no application.properties, linha comentada como exemplo de como pode ser configurado.

Front End baseado no projeto (https://github.com/Milsondepaz/task-management) com adaptações.

Projeto postado no Render(https://dslist-9mh7.onrender.com/lists)
)

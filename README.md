Mentorr API

Mentorr é uma plataforma completa para gerenciamento de mentorias especializadas. Desenvolvida com Spring Boot 3.4.1, Java 17, e PostgreSQL, a API é voltada para permitir que mentores ofereçam serviços personalizados e para facilitar o acesso de clientes a mentorias individuais. Este projeto é mantido por @danielSramos.

Status: A API está em construção.

Funcionalidades

Gerenciamento de Usuários:

Cadastro de usuários com diferentes perfis: Cliente, Mentor, Admin e Suporte.

Listagem de mentores cadastrados.

Endpoints seguros para operações privadas.

Gerenciamento de Mentorias:

Cadastro de planos de mentoria com valores personalizados (em desenvolvimento).

Classificação por categorias, áreas de interesse, conhecimentos ou empresas (em desenvolvimento).

Segurança:

Autenticação com JWT.

Tecnologias Utilizadas

Backend: Spring Boot 3.4.1, Java 17

Banco de Dados: PostgreSQL

Mapeamento de Objetos: MapStruct

Utilitários: Lombok

Autenticação: JWT

Gerenciamento de Dependências: Maven

Endpoints Disponíveis

Módulo de Usuários

GET /users - Lista todos os usuários (rota privada).

GET /users/{id} - Busca um usuário pelo ID (rota privada).

GET /users/mentor - Lista todos os usuários com a role mentor (rota privada).

POST /users - Cadastro de usuários (rota pública).

Módulo de Autenticação

POST /auth/login - Realiza login e retorna o token JWT.

Como Executar o Projeto

Requisitos

Java 17+

Maven 3.9+

PostgreSQL 14+

Configuração do Banco de Dados

Crie um banco de dados PostgreSQL.

Configure as variáveis de ambiente no arquivo application.yml ou no seu ambiente:

spring:
datasource:
url: jdbc:postgresql://localhost:5432/mentorr
username: seu_usuario
password: sua_senha
jpa:
hibernate:
ddl-auto: update

Executando a API

Clone o repositório:

git clone https://github.com/danielSramos/mentorr.git

Acesse o diretório do projeto:

cd mentorr

Compile e execute o projeto:

mvn spring-boot:run

A API estará disponível em: http://localhost:8080

Contribuições

São bem-vindas contribuições para expandir as funcionalidades da plataforma. Sinta-se à vontade para abrir issues ou enviar pull requests no repositório oficial.

Roadmap

Implementar cadastro de planos de mentoria: Criar uma funcionalidade que permita aos mentores configurarem diferentes planos com valores, duração ou níveis de complexidade.

Criar endpoints para gerenciamento de mentorias: Desenvolver APIs para organizar as mentorias, como criar, editar e excluir sessões de mentoria.

Adicionar suporte a categorização de mentorias: Permitir que mentorias sejam classificadas em categorias como áreas de interesse, conhecimentos específicos ou empresas, facilitando a busca por parte dos clientes.

Melhorar a documentação da API: Expandir a documentação existente para incluir exemplos de uso dos endpoints, detalhes técnicos adicionais, e possivelmente a integração com ferramentas como Swagger.

Este projeto está licenciado sob a MIT License.


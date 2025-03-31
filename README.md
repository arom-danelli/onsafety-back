# OnSafety - Backend

## Introdução
O projeto **OnSafety - Backend** é uma API desenvolvida com Spring Boot para gerenciar dados de usuários.

## Configuração do Banco de Dados
Antes de rodar a aplicação, crie o banco de dados no MySQL:
```sql
CREATE DATABASE nomedobanco;
```
Em seguida, configure as credenciais no arquivo `application.properties`:
```
spring.datasource.url=jdbc:mysql://localhost:3306/nomedobanco?useSSL=false&serverTimezone=UTC
spring.datasource.username=usuario
spring.datasource.password=senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Instalação
1. Clone o repositório:
   ```bash
   git clone https://github.com/arom-danelli/onsafety-back.git
   ```

2. Acesse o diretório do projeto:
   ```bash
   cd onsafety-backend
   ```

3. Compile o projeto:
   ```bash
   mvn clean install
   ```

A API estará disponível em `http://localhost:8080/`.



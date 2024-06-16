# Sistema Seguro

Este é um sistema desenvolvido para autenticação e autorização utilizando Spring Boot e JWT para gerenciar usuários com diferentes tipos de contas (ADMIN, MODERADO, etc.).
<br/>É um projeto academico afim, de entregar a tarefa da matéria Arquitetura de Aplicações Web

## Funcionalidades

- **Cadastro de Usuário**: Apenas usuários com a role ADMIN podem cadastrar novos usuários.
- **Login**: Geração de token JWT ao efetuar login.
- **Listagem de Usuários**: Listagem de todos os usuários cadastrados.
- **Extração de Nome de Usuário**: Extração do nome de usuário a partir de um token JWT.
- **Acesso Baseado em Roles**: Endpoints protegidos baseados nas roles dos usuários.

## Estrutura do Projeto

### Configuração de Segurança (`SecurityConfig`)

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // Configurações de segurança
}
```
### Controlador de acessos (`acessController`)
```java
@RestController
public class AcessController {
    // Endpoints de cadastro, login, etc.
}
```
### Utilitario JWT (`JwtUtil`)
```java
public class JwtUtil {
    // Métodos para geração e extração de JWT
}
```

## Endpoints
![todos endpoints](https://github.com/GustavoJorgge/AutenticacaoAutorizacao/assets/99773984/8ab540b3-3541-4765-8710-d35553526c50)

### Listar Todos os Usuários

- **URL**: `/todosUsuarios`
- **Método**: GET
  
![image](https://github.com/GustavoJorgge/AutenticacaoAutorizacao/assets/99773984/1384632c-86b0-4732-8f1b-795117090e2f)

### Buscar nome de Usuario via Token

- **URL**: `/username/{token}`
- **Método**: GET

![image](https://github.com/GustavoJorgge/AutenticacaoAutorizacao/assets/99773984/0b8167ef-045c-4409-8909-c70a3a2a1bb8)


### Buscar Admin

- **URL**: `/admin`
- **Método**: GET
- **Segurança**: Somente ADMIN

![image](https://github.com/GustavoJorgge/AutenticacaoAutorizacao/assets/99773984/5f7bdcb8-c618-453f-9501-8e0300b28c7d)


### Cadastrar Usuario

- **URL**: `/cadastrar`
- **Método**: POST
- **Segurança**: Somente ADMIN

![image](https://github.com/GustavoJorgge/AutenticacaoAutorizacao/assets/99773984/a0803cc4-523f-4509-9992-f702339c7cb6)
![image](https://github.com/GustavoJorgge/AutenticacaoAutorizacao/assets/99773984/16864f57-ef9e-463f-88aa-bf2b69f64c8e)
#### Se não for ADMIN
![image](https://github.com/GustavoJorgge/AutenticacaoAutorizacao/assets/99773984/fd3c030f-93bf-4b52-b548-8b66cc512f99)



## Exemplos de retorno:
| Código | Descrição | Exemplo de Retorno |
|--------|------------|--------------------|
| 200    | Requisição com sucesso | LISTA DE USUARIOS CADASTRADOS |
| 403    | Usuário não possui acesso para esta requisição | `{ "timestamp": "2024-06-16T18:43:53.069+00:00", "status": 403, "error": "Forbidden", "message": "Forbidden", "path": "/cadastrar" }` |
| 400    | Bad Request - Já possui usuário cadastrado | N/A |

# Configuração e Execução

## Pré-requisitos

- Java 17
- Maven
- Banco de dados configurado (PostgreSQL)

## Passos para Execução

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/sistema-seguro.git
   cd sistema-seguro
   
## Configuração do Banco de Dados

Configure o arquivo `application.properties` com as informações do banco de dados. No caso deste projeto eu utilizei o PostgreSQL

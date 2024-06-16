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

### Listar Todos os Usuários

- **URL**: `/todosUsuarios`
- **Método**: GET

### Buscar nome de Usuario via Token

- **URL**: `/username/{token}`
- **Método**: GET

### Buscar Admin

- **URL**: `/admin`
- **Método**: GET
- **Segurança**: Somente ADMIN

### Buscar Moderado

- **URL**: `/moderado`
- **Método**: GET
- **Segurança**: Somente MODERADO


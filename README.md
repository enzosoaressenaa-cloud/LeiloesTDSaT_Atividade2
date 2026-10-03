# LeiloesTDSaT

Sistema Java para gerenciamento de uma casa de leilões.

## Funcionalidades desta atividade
- `cadastroVIEW` definida como tela principal.
- Cadastro de produtos pelo botão **Salvar**.
- Mensagem de sucesso ou erro no cadastro.
- Listagem dos produtos cadastrados em tabela.
- Persistência dos dados em MySQL usando JDBC.

## Tecnologias
Java, Swing/NetBeans, MySQL, JDBC, Git e GitHub.

## Banco de dados
O arquivo `database.sql` cria o banco `uc11` e a tabela `produtos`.

Configuração padrão:
- Banco: `uc11`
- Usuário: `root`
- Senha: vazia
- URL: `jdbc:mysql://localhost:3306/uc11`

Se o MySQL local utilizar outra senha, altere `SENHA` em `src/conectaDAO.java`.

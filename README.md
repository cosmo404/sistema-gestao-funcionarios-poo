# Sistema de Gestão de Funcionários (POO + JDBC)

Projeto acadêmico desenvolvido em Java aplicando os pilares de Programação Orientada a Objetos (Abstração, Encapsulamento, Herança e Polimorfismo) integrados a um banco de dados relacional SQLite via API nativa JDBC.

## Integrantes do Grupo
- Mayk Vilar do Bomfim Calmon
- Diogo Pereira Stein
- Miguel Augusto Ferreira Carvalho
- Higor Fontes Borges


## Estrutura do Projeto
- `src/model/`: Classes de domínio (`Funcionario`, `Gerente` e `Caixa`).
- `src/dao/`: Camada de persistência com JDBC (`ConexaoBD` e `FuncionarioDAO`).
- `src/main/`: Interface de console e fluxo principal (`Main`).
- `lib/`: Driver JDBC do SQLite (`sqlite-jdbc`).

## Funcionalidades
- Cadastro de Gerentes (bonificação de 20%) e Caixas (bonificação de 10%).
- Listagem polimórfica com cálculo automático de bonificação e salário final.
- Exclusão de funcionários por ID.
- Persistência automática em banco de dados relacional (`empresa.db`).

## Como Executar
1. Clone o repositório.
2. Abra a pasta no VS Code (com a extensão *Extension Pack for Java* instalada) ou adicione o `.jar` da pasta `lib/` ao *Classpath* da sua IDE.
3. Execute a classe `src/main/Main.java`.

package main;

import dao.ConexaoBD;
import dao.FuncionarioDAO;
import model.Caixa;
import model.Funcionario;
import model.Gerente;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ConexaoBD.criarTabela();

        FuncionarioDAO dao = new FuncionarioDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=========================================");
            System.out.println("   SISTEMA DE GESTAO DE FUNCIONARIOS     ");
            System.out.println("=========================================");
            System.out.println("1 - Cadastrar Gerente");
            System.out.println("2 - Cadastrar Caixa");
            System.out.println("3 - Listar Funcionarios");
            System.out.println("4 - Excluir Funcionario");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida! Digite apenas numeros.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro de Gerente ---");
                    System.out.print("Nome: ");
                    String nomeGerente = scanner.nextLine();

                    System.out.print("Salario base: ");
                    double salarioGerente = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    System.out.print("Departamento: ");
                    String departamento = scanner.nextLine();

                    Funcionario gerente = new Gerente(nomeGerente, salarioGerente, departamento);
                    dao.cadastrar(gerente);
                    break;

                case 2:
                    System.out.println("\n--- Cadastro de Caixa ---");
                    System.out.print("Nome: ");
                    String nomeCaixa = scanner.nextLine();

                    System.out.print("Salario base: ");
                    double salarioCaixa = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    System.out.print("Numero do caixa: ");
                    int numeroCaixa = Integer.parseInt(scanner.nextLine());

                    Funcionario caixa = new Caixa(nomeCaixa, salarioCaixa, numeroCaixa);
                    dao.cadastrar(caixa);
                    break;

                case 3:
                    System.out.println("\n--- Lista de Funcionarios Cadastrados ---");
                    List<Funcionario> lista = dao.listarTodos();

                    if (lista.isEmpty()) {
                        System.out.println("Nenhum funcionario cadastrado no banco.");
                    } else {
                        for (Funcionario f : lista) {
                            f.exibirInformacoes();
                            System.out.println("-----------------------------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- Excluir Funcionario ---");
                    System.out.print("Digite o ID do funcionario: ");
                    int idExcluir = Integer.parseInt(scanner.nextLine());

                    if (dao.excluir(idExcluir)) {
                        System.out.println("Funcionario removido com sucesso!");
                    } else {
                        System.out.println("Nenhum funcionario encontrado com o ID " + idExcluir + ".");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opcao inexistente. Tente novamente.");
            }
        }

        scanner.close();
    }
}

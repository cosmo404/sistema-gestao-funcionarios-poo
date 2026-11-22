package main;

import model.Caixa;
import model.Funcionario;
import model.Gerente;

public class Teste {

    public static void main(String[] args) {
        Funcionario f1 = new Gerente("Carlos", 5000, "Vendas");
        Funcionario f2 = new Caixa("Ana", 5000, 3);

        f1.exibirInformacoes();
        System.out.println();
        f2.exibirInformacoes();
    }
}

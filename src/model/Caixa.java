package model;

public class Caixa extends Funcionario {

    private int numeroCaixa;

    public Caixa() {
        super();
        this.numeroCaixa = 0;
    }

    public Caixa(String nome, double salario, int numeroCaixa) {
        super(nome, salario);
        this.numeroCaixa = numeroCaixa;
    }

    public int getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(int numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    @Override
    public double calcularBonificacao() {
        return getSalario() * 0.10;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Cargo: Caixa");
        System.out.println("Numero do caixa: " + numeroCaixa);
        System.out.println("Bonificacao: " + calcularBonificacao());
    }

    public Caixa(int id, String nome, double salario, int numeroCaixa) {
        super(id, nome, salario);
        this.numeroCaixa = numeroCaixa;
    }
}

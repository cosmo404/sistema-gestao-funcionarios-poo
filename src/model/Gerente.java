package model;

public class Gerente extends Funcionario {
    private String departamento;

    public Gerente() {
        super();
        this.departamento = "";
    }

    public Gerente(String nome, double salario, String departamento) {
        super(nome, salario);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public double calcularBonificacao() {
        return getSalario() * 0.20;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Cargo: Gerente");
        System.out.println("Departamento: " + departamento);
        System.out.println("Bonificacao: " + calcularBonificacao());
        System.out.println("Salario final: " + calcularSalarioFinal());
    }
    public Gerente(int id, String nome, double salario, String departamento) {
        super(id, nome, salario);
        this.departamento = departamento;
    }
}

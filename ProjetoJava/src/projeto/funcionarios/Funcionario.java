package projeto.funcionarios;

import projeto.IPessoa;
import projeto.Pessoa;

public class Funcionario extends Pessoa implements IPessoa {
    protected double salario;
    protected double comissao;
    protected int vendas;


    public Funcionario(String nome, int idade, double salario, double comissao, int vendas) {
        super(nome, idade);
        this.salario = salario;
        this.comissao = comissao;
        this.vendas = vendas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }




    @Override
    public void exibir() {

    }
}

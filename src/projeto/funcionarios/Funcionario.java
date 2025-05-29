package projeto.funcionarios;

import projeto.IPessoa;
import projeto.Main;
import projeto.Pessoa;

import static projeto.Main.kbd;

public class Funcionario extends Pessoa implements IPessoa {

    //Atrubutos
    protected double salario;
    protected double comissao;
    protected int vendas;

    // Construtor
    public Funcionario()
    {
        super("", 0);
        salario = 0;
        comissao = 0;
        vendas = 0;
    }

    public Funcionario(String nome, int idade, double salario, double comissao, int vendas) {
        super(nome, idade);
        this.salario = salario;
        this.comissao = comissao;
        this.vendas = vendas;
    }

    // Gets e sets
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

    //Métodos
    @Override
    public void exibir() {
        System.out.println("\n" + nome + ", " + idade + " anos, salário: " + salario + " N. de vendas: " + vendas + ", Comissão: " + comissao + "\n");
    }

    public static Funcionario cadastraFuncionario()
    {
        Funcionario novoFuncionario = new Funcionario();

        System.out.print("\nNome do funcionário> ");

        kbd.nextLine();
        novoFuncionario.setNome(kbd.nextLine());

        System.out.print("Idade do funcionário> ");
        novoFuncionario.setIdade(kbd.nextInt());
        kbd.nextLine(); // limpa buffer

        System.out.print("Salário do funcionário> ");
        novoFuncionario.setSalario(kbd.nextInt());
        kbd.nextLine(); // limpa buffer

        System.out.print("Comissão do funcionário> ");
        novoFuncionario.setComissao(kbd.nextInt());
        kbd.nextLine(); // limpa buffer
        novoFuncionario.exibir();

        return novoFuncionario;
    }
    public static void procuraFuncionarioInfo(String nome)
    {
        boolean token = false;
        for (Funcionario P : Main.funcionarios)
        {
            if(P.nome.contains(nome))
            {
                token = true;
                P.exibir();
            }
        }
        if (!token)
        {
            System.out.println("\nO funcionário não pôde ser localizado.");
        }
    }
}

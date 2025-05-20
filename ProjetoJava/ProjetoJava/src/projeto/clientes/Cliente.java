package projeto.clientes;

import projeto.IPessoa;
import projeto.Pessoa;

public class Cliente extends Pessoa implements IPessoa {
    //atributos
    protected int cpf;
    protected int compras;
    protected boolean idoso;

    public Cliente(){
        super("", 0);
        this.cpf = 0;
        this.compras = 0;
        this.idoso = false;
    }

    public Cliente(String nome, int idade, int cpf, int compras, boolean idoso) {
        super(nome, idade);
        this.cpf = cpf;
        this.compras = 0;
        this.idoso = idoso;
    }

    //gets e sets
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    public boolean isIdoso() {
        return idoso;
    }

    public void setIdoso(boolean idoso) {
        this.idoso = idoso;
    }

    //métodos
    @Override
    public void exibir() {
        System.out.println(nome + ", " + idade + " anos, CPF: " + cpf + " N. de compras: " + compras + " " + ((idoso)?"Idoso":"Jovem"));
    }
}

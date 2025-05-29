package projeto.clientes;

import projeto.IPessoa;
import projeto.Pessoa;
import projeto.Main;

import static projeto.Main.kbd;

public class Cliente extends Pessoa implements IPessoa {
    // Atributos
    protected String cpf;
    protected int compras;
    protected boolean idoso;

    // Construtor
    public Cliente(){
        super("", 0);
        this.cpf = "";
        this.compras = 0;
        this.idoso = false;
    }

    public Cliente(String nome, int idade, String cpf, int compras, boolean idoso) {
        super(nome, idade);
        this.cpf = cpf;
        this.compras = compras;
        this.idoso = idoso;
    }

    // Gets e sets
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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
        System.out.println(nome + ", " + idade + " anos, CPF: " + cpf + " N. de compras: " + compras + ", " + ((idoso)?"Idoso":"Jovem"));
    }

    public static Cliente cadastraCliente()
    {
        Cliente novoCliente = new Cliente();
        System.out.print("\nNome do cliente> ");
        Main.kbd.nextLine();
        novoCliente.nome = kbd.nextLine();

        System.out.print("Idade do cliente> ");

        novoCliente.idade = kbd.nextInt();
        kbd.nextLine(); // limpa buffer

        System.out.print("Cpf do cliente> ");
        novoCliente.setCpf(kbd.nextLine());

        novoCliente.setIdoso(novoCliente.idade > 60);

        novoCliente.exibir();

        return novoCliente;
    }

    public static void excluirCliente(String clienteExcluir)
    {
        int token = 0; // verifica se um cliente foi excluído
        for (Cliente P: Main.clientes)
        {
            if (P.nome.equals(clienteExcluir))
            {
                Main.clientesExcl.add(P);
                Main.clientes.remove(P);
                token = 1;
                break;
            }
        }
        if (token == 1) System.out.println("\nCliente excluído com sucesso.");
        else System.out.println("\nNão há nenhum cliente com esse nome na lista.");
    }

    public static void procuraClienteInfo(String buscarPor) // Informações sobre um cliente
    {
        boolean token = false; //verifica se o cliente foi encontrado
        for (Cliente P : Main.clientes)
        {
            if(P.nome.contains(buscarPor)) // Busca pelo nome do cliente
            {
                token = true;
                System.out.print("\nCliente encontrado com sucesso> ");
                P.exibir();
                break;
            }
        }
        if(!token) System.out.println("O cliente não foi encontrado.");
    }

    public static void procuraMaisvelho() // O cliente mais velho
    {
        Cliente maisVelho = Main.clientes.getFirst();
        int max = maisVelho.getIdade();
        for (Cliente P : Main.clientes) // Procura pelo cliente mais velho
        {
            if(P.getIdade() > max)
            {
                maisVelho = P;
                max = P.getIdade();
            }
        }
        System.out.print("\nO cliente mais velho é> ");
        maisVelho.exibir();
    }

    public static void procuraMaisJovem() // O cliente mais jovem
    {
        Cliente maisJovem = Main.clientes.getFirst();
        int min = maisJovem.getIdade();
        for (Cliente P : Main.clientes) // Procura pelo cliente mais jovem
        {
            if(P.getIdade() < min)
            {
                maisJovem = P;
                min = P.getIdade();
            }
        }
        System.out.print("\nO cliente mais jovem é> ");
        maisJovem.exibir();
    }

    public static void quantMaioresDe60() // Clientes maiores que 60 anos
    {
        int quantClientes = 0;
        for(Cliente P : Main.clientes) if(P.getIdade() > 60) quantClientes += 1; // Procura por clientes maiores de 60

        if(quantClientes != 0) System.out.println("\nA quantidade de clientes maiores de 60 anos é> " + quantClientes);
        else System.out.println("\nNão há clientes com mais de 60 anos cadastrados.");
    }

    public static void quantMenoresde18() // Clientes menores que 18 anos
    {
        int quantClientes = 0;
        for(Cliente P : Main.clientes) if(P.getIdade() < 18) quantClientes += 1; // Procura por clientes maiores de 60

        if (quantClientes != 0) System.out.println("\nA quantidade de clientes menores de 18 anos é> " + quantClientes);
        else System.out.println("\nNão há clientes com menos de 18 anos cadastrados.");
    }

    public static void quantMediaAnos()
    {
        int divide = 0, soma = 0;
        for(Cliente P : Main.clientes)
        {
            soma += P.getIdade();
            divide += 1;
        };
        System.out.println("\nA média das idades dos clientes é de> " + soma/divide);
    }

    public static void procuraExcluidos() {
        int aux = 1;
        for (Cliente P : Main.clientesExcl) {
            System.out.printf("Cleinte excluído número %d> ", aux);
            P.exibir();
            aux++;
        }
    }
}

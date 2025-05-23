package projeto;

import projeto.clientes.Cliente;
import projeto.funcionarios.Funcionario;
import projeto.produtos.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public static ArrayList<Produto> produtos = new ArrayList<>();



    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        char opcao = ' ';
        do {
            System.out.print("O que deseja realizar?\nC - Cadastro\nB - Busca\nS - Sair\n>");
            opcao = kbd.next().charAt(0);
            switch (opcao){
                case 'C':
                    System.out.print("O que deseja cadastrar?\nC - Cliente\nP - Produto\nF - Funcionário\n>");
                    opcao = kbd.next().charAt(0);
                    switch (opcao)
                    {
                        case 'C':
                            Cliente novoCliente = new Cliente();
                            System.out.println("Qual o nome do cliente?>\n");
                            novoCliente.nome = kbd.nextLine();
                            System.out.println("Qual a idade do cliente?>\n");
                            novoCliente.idade = kbd.nextInt();
                            System.out.println("Qual o cpf do cliente?>\n");
                            novoCliente.setCpf(kbd.nextInt());

                            if (novoCliente.idade > 60)
                            {
                                novoCliente.setIdoso(true);
                            }

                            clientes.add(novoCliente);
                    }


            }


        }while (opcao != 'S' && opcao != 's');
    }
}
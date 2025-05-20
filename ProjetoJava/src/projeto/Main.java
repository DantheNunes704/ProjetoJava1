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
            System.out.print("O que deseja realizar?\nC - Cadastro\nB - Busca\nS - Sair\nE - Excluir\n>");
            opcao = kbd.next().charAt(0);
            switch (opcao){
                case 'C':
                    System.out.print("O que deseja cadastrar?\nC - Cliente\nP - Produto\nF - Funcionário\n>");
                    opcao = kbd.next().charAt(0);
                    switch (opcao)
                    {
                        case 'C':
                            Cliente novoCliente = new Cliente();

                            System.out.printf("Nome do cliente>");
                            kbd.nextLine();
                            novoCliente.nome = kbd.nextLine();

                            System.out.printf("Idade do cliente>");

                            novoCliente.idade = kbd.nextInt();
                            kbd.nextLine();

                            System.out.printf("Cpf do cliente>");
                            novoCliente.setCpf(kbd.nextInt());

                            if (novoCliente.idade > 60) {
                                novoCliente.setIdoso(true);
                            } else {
                                novoCliente.setIdoso(false);
                            }

                            clientes.add(novoCliente);

                            for (Cliente p : clientes)
                            {
                                System.out.printf("\n" + p.nome);
                                System.out.printf("\n" + p.idade);
                                System.out.printf("\n" + p.getCpf());
                                System.out.printf("\n" + p.getCompras());
                                System.out.printf("\n" + p.isIdoso() + "\n");
                            }

                        case 'P':
                            {
                                Produto novoProduto = new Produto();

                                System.out.printf("Descrição do produto\n>"); //Descrição ****

                                kbd.next(); //consome a quebra de linha
                                novoProduto.setDescricao(kbd.nextLine()); // lê a descrição e atribui ao objeto

                                System.out.println("Modelo do produto\n>"); //Modelo ****

                                kbd.next(); //consome a quebra de linha
                                novoProduto.setModelo(kbd.nextLine()); // lê o modelo e atribui ao objeto

                                System.out.println("Preço do produto\n>"); //Preço ****

                                kbd.next(); //consome a quebra de linha
                                novoProduto.setPreco(kbd.nextInt()); //lê o preço e atribui ao objeto produto

                                System.out.println("Marca do produto\n>"); //Marca ****

                                kbd.next(); //consome a quebra de linha
                                novoProduto.setMarca(kbd.nextLine());

                                for(Produto p : produtos)
                                {
                                    System.out.println("\n" + p.getanolancamento());
                                    System.out.println("\n" + p.getPreco());
                                    System.out.println("\n" + p.getModelo());
                                    System.out.println("\n" + p.getMarca());
                                    System.out.println("\n" + p.getDescricao());
                                }

                            }
                    }


            }


        }while (opcao != 'S' && opcao != 's');
    }
}
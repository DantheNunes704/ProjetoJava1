package projeto;

import projeto.clientes.Cliente;
import projeto.funcionarios.Funcionario;
import projeto.produtos.Produto;

import java.util.ArrayList;
import java.util.Scanner;

// Classe main
public class Main {

    // Listas para cadastro *****
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    public static ArrayList<Produto> produtos = new ArrayList<>();
    // Fim listas para cadastro *****

    // Listas para exclusão *****
    public static ArrayList<Cliente> clientesExcl = new ArrayList<>(); // lista de clientes excluídos
    public static ArrayList<Produto> produtosExcl = new ArrayList<>(); // lista de prosutos excluídos
    public static ArrayList<Funcionario> funcionáriosExcl = new ArrayList<>(); // lista de funcionários excluídos
    // Fim listas para exclusão *****

    public static Scanner kbd = new Scanner(System.in); // Scanner

    // métodos (main)*****

    // Fim métodos main *****

    // Body main
    public static void main(String[] args) {
        char opcao = ' ';
        do {
            System.out.print("\nO que deseja realizar?\nC - Cadastro\nB - Busca\nS - Sair\nE - Excluir\n> ");
            opcao = kbd.next().charAt(0); // lê o comando do usuário
            switch (opcao) {

                case 'C': // Cadastro *****
                {
                    System.out.print("\nO que deseja cadastrar?\nC - Cliente\nP - Produto\nF - Funcionário\n> ");
                    opcao = kbd.next().charAt(0);
                    switch (opcao) {

                        case 'C': // Cadastro cliente *****
                        {
                            clientes.add(Cliente.cadastraCliente());
                            break;
                        } // Fim cadastro cliente *****


                        case 'P': //Cadastro produto *****
                        {
                            produtos.add(Produto.cadastraProduto());

                            break;
                        } // Fim cadastro produto *****

                        case 'F': // Cadastro funcionário *****
                        {
                            funcionarios.add(Funcionario.cadastraFuncionario());

                            break;
                        } // Fim cadastro funcionário *****

                    }
                    break;
                } // Fim cadastro *****

                case 'E': // Exclusão *****
                {
                    System.out.print("\nO que deseja excluir?\nC - Cliente\nP - Produto\nF - Funcionário\n> ");
                    opcao = kbd.next().charAt(0);
                    switch (opcao)
                    {
                        case 'C': // Exclusão cliente *****
                        {
                            System.out.print("\nQual o nome do cliente que deseja excluir?\n> ");

                            kbd.nextLine();
                            String clienteExcluir = kbd.nextLine();

                            System.out.print("\nCliente que escolheu excluir: " + clienteExcluir); // excluir depois
                            Cliente.excluirCliente(clienteExcluir); // Função

                            break;
                        } // Fim exclusão cliente *****

                        case 'P': // Exclusão produto *****
                        {
                            System.out.print("\nQual a descrição do produto que deseja excluir?\n> ");

                            kbd.nextLine();
                            String produtoExcluir = kbd.nextLine();

                            System.out.print("\nProduto que escolheu excluir: " + produtoExcluir); // excluir depois

                            boolean token = false; // verifica se um produto foi excluído
                            for (Produto P: produtos)
                            {
                                if (P.getDescricao().equals(produtoExcluir))
                                {
                                    produtosExcl.add(P);
                                    produtos.remove(P);
                                    token = true;
                                    break;
                                }
                            }
                            if (token) System.out.println("\nProduto excluído com sucesso.");
                            else System.out.println("\nNão há nenhum produto com essa descrição na lista.");

                            break;
                        } // Fim exclusão produto *****

                        case 'F': // Exclusão funcionário
                         {
                             System.out.print("\nQual o nome do funcionário que deseja excluir?\n> ");

                             kbd.nextLine();
                             String funcionarioExcluir = kbd.nextLine();

                             System.out.print("\nFuncionário que escolheu excluir: " + funcionarioExcluir); // excluir depois

                             boolean token = false; // verifica se um funcionário foi excluído
                             for (Funcionario P: funcionarios)
                             {
                                 if (P.getNome().equals(funcionarioExcluir))
                                 {
                                     funcionáriosExcl.add(P);
                                     funcionarios.remove(P);
                                     token = true;
                                     break;
                                 }
                             }
                             if (token) System.out.println("\nFuncionário excluído com sucesso.");
                             else System.out.println("\nNão há nenhum Funcionário com esse nome na lista.");

                             break;
                         } // Fim exclusão funcionário

                    }
                    break;
                } // Fim exclusão *****

                case 'B': // Buscar
                {
                    System.out.print("\nO que deseja buscar?\nC - Cliente\nP - Produto\nF - Funcionário\n> ");

                    kbd.nextLine();
                    opcao = kbd.next().charAt(0);

                    switch (opcao) {
                        case 'C': // Sobre clientes
                        {
                            if (!clientes.isEmpty()) // Verifica se a lista de clientes não está vazia
                            {
                                System.out.print("\nO que deseja saber sobre clientes?\nI - Informções gerais\nV - O mais velho\nJ - O mais jovem\nM - Média das idades\nE - Clientes excluídos\n> - Clientes maiores que 60\n< - Clientes menores que 18\n> ");
                                kbd.nextLine();
                                opcao = kbd.next().charAt(0);

                                switch (opcao) {
                                    case 'I': // Informações sobre um cliente
                                    {
                                        if (!clientes.isEmpty()) {
                                            System.out.print("\nQual o nome do cliente que deseja?\n> ");
                                            kbd.nextLine();
                                            String buscarPor = kbd.nextLine();
                                            Cliente.procuraClienteInfo(buscarPor);
                                        }
                                        break;
                                    }

                                    case 'V': // O mais velho
                                    {
                                        Cliente.procuraMaisvelho();
                                        break;
                                    }

                                    case 'J': // O mais jovem
                                    {
                                        Cliente.procuraMaisJovem();
                                        break;
                                    }

                                    case '>': // Maiores de 60
                                    {
                                        Cliente.quantMaioresDe60();
                                        break;
                                    }

                                    case '<': // Menores de 18
                                    {
                                        Cliente.quantMenoresde18();
                                        break;
                                    }

                                    case 'M': // Média das idades dos clientes
                                    {
                                        Cliente.quantMediaAnos();
                                        break;
                                    }

                                    case 'E': // CLientes excluídos
                                    {
                                        if(!clientesExcl.isEmpty())
                                        {
                                            Cliente.procuraExcluidos();
                                        }
                                        else System.out.println("Não há nenhum cliente excluído.");
                                        break;
                                    }

                                }
                            } else System.out.println("Você ainda não tem nenhum cliente cadastrado");
                            break;
                        }
//
                        case 'P': // Informações sobre um produto
                        {
                            System.out.print("\nO que deseja saber sobre produtos?\nI - Informções gerais\nC - O mais caro\nB - O mais barato\nM - A média do preço\nA - Preço acima da média> ");
                            kbd.nextLine();
                            opcao = kbd.next().charAt(0);
                            if (!produtos.isEmpty()) {
                                switch (opcao) {
                                    case 'I': // Procura informações sobre o produto
                                    {
                                        System.out.print("\nComo deseja pesquisar?\nA - Marca\nM - Modelo\nD - Descrição\n> ");
                                        kbd.nextLine();
                                        opcao = kbd.next().charAt(0);

                                        switch (opcao) {
                                            case 'A': {
                                                System.out.println();
                                                System.out.print("Qual a marca do produto?\n> ");
                                                kbd.nextLine();
                                                String marca = kbd.nextLine();
                                                Produto.procuraPMarca(marca);
                                                break;
                                            }
                                            case 'M': {
                                                System.out.println();
                                                System.out.print("Qual o modelo do produto?\n> ");
                                                kbd.nextLine();
                                                String modelo = kbd.nextLine();
                                                Produto.procuraPModelo(modelo);
                                                break;
                                            }
                                            case 'D': {
                                                System.out.println();
                                                System.out.print("Qual a descrição do produto?\n> ");
                                                kbd.nextLine();
                                                String descricao = kbd.nextLine();
                                                Produto.procuraPDescricao(descricao);
                                                break;
                                            }
                                        }
                                        break;
                                    }

                                    case 'B': // Procura o produto mais barato
                                    {
                                        Produto.procuraMenorPreco();
                                        break;
                                    }


                                    case 'C': // Procura o produto mais caro
                                    {
                                        Produto.procuraMaiorPreco();
                                        break;
                                    }

                                    case 'M': // Média de preço dos produtos
                                    {
                                        Produto.procuraMediaPreco();
                                    }

                                    case 'A': // Quantidade de produtos com preço acima da média
                                    {
                                        Produto.procuraAcimadaMedia();
                                    }
                                }
                            } else System.out.println("Você ainda não tem nenhum produto cadastrado");
                            break;
                        }
                        case 'F': // Informações sobre um funcionário
                        {
                            System.out.println("Qual o nome do funcionário que deseja procurar?");
                            kbd.nextLine();
                            String nome = kbd.nextLine();
                            Funcionario.procuraFuncionarioInfo(nome);
                            break;
                        }

                        case 'S': // Sair
                        {
                            System.exit(1);
                            break;
                        }
                        }

                }
                 }
            System.out.print("\nO que deseja fazer agora?\nS - Sair\nC - continuar\n> ");
            opcao = kbd.next().charAt(0);
        }while (opcao != 'S' && opcao != 's'); // Verifica a resposta do usuário
    } // Fim body main
}
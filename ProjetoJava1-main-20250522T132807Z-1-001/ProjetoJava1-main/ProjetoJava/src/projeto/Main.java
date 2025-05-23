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
            System.out.print("\nO que deseja realizar?\nC - Cadastro\nB - Busca\nS - Sair\nE - Excluir\n>");
            opcao = kbd.next().charAt(0); // lê o comando do usuário
            switch (opcao) {

                case 'C': //cadastro *****
                {
                    System.out.print("\nO que deseja cadastrar?\nC - Cliente\nP - Produto\nF - Funcionário\n>");
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
                    System.out.print("\nO que deseja excluir?\nC - Cliente\nP - Produto\nF - Funcionário\n>");
                    opcao = kbd.next().charAt(0);
                    switch (opcao)
                    {
                        case 'C': // Exclusão cliente *****
                        {
                            System.out.print("\nQual o nome do cliente que deseja excluir?>");

                            kbd.nextLine();
                            String clienteExcluir = kbd.nextLine();

                            System.out.print("\nCliente que escolheu excluir: " + clienteExcluir); // excluir depois
                            Cliente.excluirCliente(clienteExcluir); // Função

                            break;
                        } // Fim exclusão cliente *****

                        case 'P': // Exclusão produto *****
                        {
                            System.out.print("\nQual a descrição do produto que deseja excluir?>");

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
                             System.out.print("\nQual o nome do funcionário que deseja excluir?>");

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
                     System.out.print("\nO que deseja buscar?\nC - Cliente\nP - Produto\nF - Funcionário\n>");

                     kbd.nextLine();
                     opcao = kbd.next().charAt(0);

                     switch (opcao)
                     {
                             case 'C': // Sobre clientes
                             {
                                 if(!clientes.isEmpty())
                                 {
                                     System.out.print("\nO que deseja saber sobre clientes?\nI - Informções gerais\nV - O mais velho\nJ - O mais jovem\nM - Média das idades\nE - Clientes excluídos>");
                                     kbd.nextLine();
                                     opcao = kbd.next().charAt(0);

                                     switch (opcao)
                                     {
                                         case 'I': // Informações sobre um cliente
                                         {
                                             if(!clientes.isEmpty())
                                             {
                                                 System.out.print("\nQual o nome do cliente que deseja?>");
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
                                             Cliente.procuraExcluidos();
                                             break;
                                         }

                                     }



                                 }
                                 else System.out.println("Você ainda não tem nenhum cliente cadastrado");
                                 break;
                             }
//
                         case 'P':
                         {
                             System.out.print("\nO que deseja saber sobre produtos?\nI - Informções gerais\nC - O mais caro\nB - O mais barato\n>");
                             kbd.nextLine();
                             opcao = kbd.next().charAt(0);
                             if(!produtos.isEmpty())
                             {
                                 switch (opcao)
                                 {
                                     case 'I': // Procura informações sobre o produto
                                     {
                                         System.out.print("\nQual a descrição do produto que deseja?>");
                                         kbd.nextLine();
                                         String descricao = kbd.nextLine();

                                         System.out.print("\nQual a marca do produto que deseja?>");
                                         String marca = kbd.nextLine();

                                         System.out.print("\nQual o modelo do produto que deseja?>");
                                         String modelo = kbd.nextLine();

                                         Produto.procuraProdutoInfo(descricao, marca, modelo);
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
                                 }
                             }
                             else System.out.println("Você ainda não tem nenhum produto cadastrado");
                             break;
                         }
                     }
                     break;
                 }
            }
            System.out.print("\nO que deseja fazer agora?\nS - Sair\nC - continuar\n>");
            opcao = kbd.next().charAt(0);

        }while (opcao != 'S' && opcao != 's'); // Verifica a resposta do usuário
    }
}
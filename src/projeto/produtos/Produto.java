package projeto.produtos;

import projeto.Main;
import projeto.clientes.Cliente;
import projeto.funcionarios.Funcionario;

import static projeto.Main.kbd;

public class Produto  {

    // Atributos
    protected double preco;
    protected String descricao;
    protected String modelo;
    protected String marca;
    protected int anolancamento;

    // Construtor
    public Produto(double preco, String descricao, String modelo, String marca, int anolancamento) {
        this.preco = preco;
        this.descricao = descricao;
        this.modelo = modelo;
        this.marca = marca;
        this.anolancamento = anolancamento;
    }

    public Produto() {
        this.preco = 0;
        this.descricao = "";
        this.modelo = "";
        this.marca = "";
        this.anolancamento = 0;
    }

    // Gets e sets
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getanolancamento() {
        return anolancamento;
    }

    public void setanoLancamento(int anoLancamento) {
        this.anolancamento = anoLancamento;
    }

    // Métodos
    public void mostraInfo()
    {
        System.out.println("Modelo: " + modelo + ", Marca:" + marca + ", Preço: "+ preco + ", Lançado em: " + anolancamento + ", Descrição: " + descricao);
    }

    public static Produto cadastraProduto()
    {
        Produto novoProduto = new Produto();

        System.out.print("\nDescrição do produto> "); //Descrição ****

        kbd.nextLine(); // limpa buffer
        novoProduto.setDescricao(kbd.nextLine()); // lê a descrição e atribui ao objeto produto

        System.out.print("Modelo do produto> "); //Modelo ****
        novoProduto.setModelo(kbd.nextLine()); // lê o modelo e atribui ao objeto produto

        System.out.print("Preço do produto> "); //Preço ****

        novoProduto.setPreco(kbd.nextInt()); //lê o preço e atribui ao objeto produto
        kbd.nextLine(); // limpa buffer

        System.out.print("Ano de lançamento do produto> "); //Ano de lançamento ****
        novoProduto.setanoLancamento(kbd.nextInt());

        System.out.print("Marca do produto> "); //Marca ****

        kbd.nextLine(); // Limpa buffer
        novoProduto.setMarca(kbd.nextLine());

        System.out.println();
        novoProduto.mostraInfo();

        return novoProduto;
    }

    public static void procuraProdutoInfo(String decricao, String marca, String modelo)
    {
        boolean token = false; //verifica se o produto foi encontrado
        int n = 0;
        for (Produto P : Main.produtos)
        {
            if(P.getDescricao().startsWith(decricao) // Busca pela descrição do produto
                    || P.getMarca().startsWith(marca) // Busca pela marcan do produto
                    || P.getModelo().startsWith(modelo)) // Busca pelo modelo do produto
            {
                n += 1;
                token = true;
                System.out.printf("\nProduto encontrado (%d)> ", n);
                P.mostraInfo();
                System.out.println();
            }
        }
        if(!token) System.out.println("O produto não foi encontrado.");
    }

    public static void procuraMenorPreco() // Produto com menor preço
    {
        Produto obj = Main.produtos.getFirst();

        for (Produto P : Main.produtos) if (P.getPreco() < obj.getPreco()) obj = P;

        System.out.println("\nO produto com o menor preço é> ");
        obj.mostraInfo();
    }

    public static void procuraMaiorPreco()
    {
        Produto obj = Main.produtos.getFirst();

        for (Produto P : Main.produtos) if (P.getPreco() > obj.getPreco()) obj = P;

        System.out.println("\nO produto com o maior preço é> ");
        obj.mostraInfo();
    }

    public static void procuraMediaPreco()
    {
        int divide = 0, soma = 0;
        for(Produto P : Main.produtos)
        {
            soma += P.getPreco();
            divide += 1;
        };
        System.out.println("\nA média dos preços dos produtos é de> " + soma/divide);
    }

    public static void procuraAcimadaMedia()
    {
        int divide = 0, soma = 0, quantAcima = 0;

        for(Produto P : Main.produtos)
        {
            soma += P.getPreco();
            divide += 1;
        };

        for(Produto P : Main.produtos)
        {
            if (soma/divide < P.getPreco()) quantAcima++;
        }

        System.out.print("\nA quantidade de produtos com preço acima da média é de> " + quantAcima);
    }
}

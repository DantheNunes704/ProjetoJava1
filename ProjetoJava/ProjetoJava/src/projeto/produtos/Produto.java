package projeto.produtos;


public class Produto  {
    protected double preco;
    protected String descricao;
    protected String modelo;
    protected String marca;
    protected String dataLancamento;

    //construtor

    public Produto(double preco, String descricao, String modelo, String marca, String dataLancamento) {
        this.preco = preco;
        this.descricao = descricao;
        this.modelo = modelo;
        this.marca = marca;
        this.dataLancamento = dataLancamento;
    }

    //gets e sets


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

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    //métodos
    public void mostraInfo()
    {
        System.out.println("Modelo: " + modelo + "\nMarca:" + marca + "\nPreço:"+ preco + "Lançado em: " + dataLancamento + "\nDescrição: " + descricao);
    }
}

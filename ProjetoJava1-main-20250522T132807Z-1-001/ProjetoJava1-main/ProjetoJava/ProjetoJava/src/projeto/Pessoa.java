package projeto;

public abstract class Pessoa{
    //atributos
    protected String nome;
    protected int   idade;

    //gets e sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    //métodos
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

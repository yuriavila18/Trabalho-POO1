package Julho.Trabalho2507.modelo;

public abstract class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private String descricao;

    public Produto(String codigo, String nome, double preco, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public abstract double calcularFrete();
    public abstract double calcularImposto();

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", nome=" + nome + ", preco=" + preco + ", descricao=" + descricao + "]";
    }
}
package Julho.Trabalho2507.modelo;

public class ProdutoFisico extends Produto {
    private double peso;
    private int estoque;

    public ProdutoFisico(String codigo, String nome, double preco, String descricao, double peso, int estoque) {
        super(codigo, nome, preco, descricao);
        this.peso = peso;
        this.estoque = estoque;
    }

    @Override
    public double calcularFrete() {
        return peso * 0.5;
    }

    @Override
    public double calcularImposto() {
        return getPreco() * 0.1;
    }

    public double getPeso() {
        return peso;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return super.toString() + " [peso=" + peso + "kg, estoque=" + estoque + "]";
    }
}
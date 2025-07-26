package Julho.Trabalho2507.modelo;

public class ProdutoDigital extends Produto {
    private String formato;
    private double tamanho;

    public ProdutoDigital(String codigo, String nome, double preco, String descricao, String formato, double tamanho) {
        super(codigo, nome, preco, descricao);
        this.formato = formato;
        this.tamanho = tamanho;
    }

    @Override
    public double calcularFrete() {
        return 0;
    }

    @Override
    public double calcularImposto() {
        return getPreco() * 0.15;
    }

    public String getFormato() {
        return formato;
    }

    public double getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return super.toString() + " [formato=" + formato + ", tamanho=" + tamanho + "MB]";
    }
}

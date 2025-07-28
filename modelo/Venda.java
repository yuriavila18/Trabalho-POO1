package Julho.Trabalho2507.modelo;

import java.util.Date;
import java.util.List;

public class Venda {
    private String id;
    private Cliente cliente;
    private List<ItemCarrinho> itens;
    private Date data;
    private double valorTotal;

    public Venda(String id, Cliente cliente, List<ItemCarrinho> itens, Date data) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.data = data;
        this.valorTotal = calcularTotal();
    }
    private double calcularTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.calcularSubtotal();
        } return total;
    }
    public String getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public List<ItemCarrinho> getItens() {
        return itens;
    }
    public Date getData() {
        return data;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    @Override
    public String toString() {
        return "Venda [id=" + id + ", cliente=" + cliente.getNome() + ", " +
                "data=" + data + ", valorTotal=R$" + String.format("%.2f", valorTotal) + "]";
    }
}

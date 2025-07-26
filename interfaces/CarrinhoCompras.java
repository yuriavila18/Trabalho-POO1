package Julho.Trabalho2507.interfaces;

import java.util.ArrayList;
import java.util.List;

import Julho.Trabalho2507.interfaces.Interface;
import Julho.Trabalho2507.modelo.Produto;
import Julho.Trabalho2507.modelo.Cliente;
import Julho.Trabalho2507.modelo.ProdutoFisico;
import Julho.Trabalho2507.modelo.Cliente;
import Julho.Trabalho2507.modelo.ItemCarrinho;
import Julho.Trabalho2507.modelo.Venda;
import Julho.Trabalho2507.excecoes.EstoqueInsuficienteException;
import Julho.Trabalho2507.excecoes.ClienteNaoEncontradoException;

public class CarrinhoCompras implements Interface {
    private List<ItemCarrinho> itens;
    private Cliente cliente;

    public CarrinhoCompras() {
        this.itens = new ArrayList<>();
    }

    @Override
    public void adicionarAoCarrinho(Produto produto, int quantidade) throws EstoqueInsuficienteException {
        if (produto instanceof ProdutoFisico) {
            ProdutoFisico pf = (ProdutoFisico) produto;
            if (pf.getEstoque() < quantidade) {
                throw new EstoqueInsuficienteException(
                        "Estoque insuficiente para o produto: " + pf.getNome() +
                                ". Estoque disponível: " + pf.getEstoque() +
                                ", quantidade solicitada: " + quantidade);
            }
        }

        for (ItemCarrinho item : itens) {
            if (item.getProduto().getCodigo().equals(produto.getCodigo())) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }

        itens.add(new ItemCarrinho(produto, quantidade));
    }

    @Override
    public double calcularDesconto(Cliente cliente) {
        if (cliente.isPremium()) {
            double subtotal = calcularSubtotal();
            return subtotal * 0.1;
        }
        return 0;
    }

    @Override
    public void finalizarVenda(Cliente cliente) throws ClienteNaoEncontradoException {
        if (cliente == null) {
            throw new ClienteNaoEncontradoException("Cliente não informado para finalizar a venda");
        }

        this.cliente = cliente;

        for (ItemCarrinho item : itens) {
            if (item.getProduto() instanceof ProdutoFisico) {
                ProdutoFisico pf = (ProdutoFisico) item.getProduto();
                pf.setEstoque(pf.getEstoque() - item.getQuantidade());
            }
        }

        String idVenda = "VEN" + System.currentTimeMillis();
        Venda venda = new Venda(idVenda, cliente, new ArrayList<>(itens), new java.util.Date());

        System.out.println("Venda finalizada com sucesso:");
        System.out.println(venda);
        System.out.println("Itens:");
        for (ItemCarrinho item : itens) {
            System.out.println(" - " + item);
        }
        System.out.println("Desconto: R$" + String.format("%.2f", calcularDesconto(cliente)));
        System.out.println("Total: R$" + String.format("%.2f", (calcularSubtotal() - calcularDesconto(cliente))));

        itens.clear();
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemCarrinho item : itens) {
            subtotal += item.calcularSubtotal();
        }
        return subtotal;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrinho de Compras:\n");
        for (ItemCarrinho item : itens) {
            sb.append(" - ").append(item).append("\n");
        }
        sb.append("Subtotal: R$").append(String.format("%.2f", calcularSubtotal()));
        return sb.toString();
    }
}

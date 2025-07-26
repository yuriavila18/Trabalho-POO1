package Julho.Trabalho2507;

import Julho.Trabalho2507.modelo.*;
import Julho.Trabalho2507.interfaces.*;
import Julho.Trabalho2507.excecoes.*;

public class main {
    public static void main(String[] args) {
        try {
            ProdutoFisico livro = new ProdutoFisico("P001", "Livro POO", 50.0,
                    "Livro sobre Programação Orientada a Objetos", 0.5, 10);

            ProdutoDigital curso = new ProdutoDigital("P002", "Curso Java", 250.0,
                    "Curso completo de Java", "MP4", 1500);

            ProdutoFisico celular = new ProdutoFisico("P003", "Smartphone", 2000.0,
                    "Smartphone última geração", 0.3, 2);

            Cliente cliente1 = new Cliente("C001", "Yuri Avila", "yuriavila@email.com", false);
            Cliente cliente2 = new Cliente("C002", "Lukas Costa", "lukascosta@email.com", true);

            CarrinhoCompras carrinho = new CarrinhoCompras();

            carrinho.adicionarAoCarrinho(livro, 2);
            carrinho.adicionarAoCarrinho(curso, 1);

            System.out.println("Carrinho após adicionar itens:");
            System.out.println(carrinho);

            try {
                carrinho.adicionarAoCarrinho(celular, 3);
            } catch (EstoqueInsuficienteException e) {
                System.out.println("\nErro ao adicionar produto: " + e.getMessage());
            }

            carrinho.adicionarAoCarrinho(celular, 1);

            System.out.println("\nCarrinho atualizado:");
            System.out.println(carrinho);

            System.out.println("\nFinalizando venda para cliente premium:");
            carrinho.finalizarVenda(cliente2);

            CarrinhoCompras carrinho2 = new CarrinhoCompras();
            carrinho2.adicionarAoCarrinho(livro, 1);

            try {
                System.out.println("\nTentando finalizar venda sem cliente:");
                carrinho2.finalizarVenda(null);
            } catch (ClienteNaoEncontradoException e) {
                System.out.println("Erro ao finalizar venda: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

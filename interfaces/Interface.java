package Julho.Trabalho2507.interfaces;

import Julho.Trabalho2507.modelo.Produto;
import Julho.Trabalho2507.modelo.Cliente;
import Julho.Trabalho2507.excecoes.EstoqueInsuficienteException;
import Julho.Trabalho2507.excecoes.ClienteNaoEncontradoException;

public interface Interface {
    void adicionarAoCarrinho(Produto produto, int quantidade) throws EstoqueInsuficienteException;
    double calcularDesconto(Cliente cliente);
    void finalizarVenda(Cliente cliente) throws ClienteNaoEncontradoException;
}
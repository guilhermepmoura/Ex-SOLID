package service;

import model.Cliente;
import model.Livro;
import model.Pedido;

public class GerenciadorDePedidos {
    private GerenciadorDeEstoque gerenciadorDeEstoque;

    public GerenciadorDePedidos(GerenciadorDeEstoque gerenciadorDeEstoque) {
        this.gerenciadorDeEstoque = gerenciadorDeEstoque;
    }

    public Pedido criarPedido(Cliente cliente, String tituloLivro, int quantidade) {
        if (gerenciadorDeEstoque.verificarDisponibilidade(tituloLivro, quantidade)) {
            Livro livro = gerenciadorDeEstoque.buscarLivro(tituloLivro);
            Pedido pedido = new Pedido(cliente);
            for (int i = 0; i < quantidade; i++) {
                pedido.adicionarLivro(livro);
            }
            gerenciadorDeEstoque.reduzirEstoque(tituloLivro, quantidade);
            return pedido;
        } else {
            throw new IllegalArgumentException("Livro indisponível no estoque!");
        }
    }
}

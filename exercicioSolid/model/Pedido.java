package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Livro> livros = new ArrayList<>();
    private double valorTotal;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        valorTotal += livro.getPreco();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}

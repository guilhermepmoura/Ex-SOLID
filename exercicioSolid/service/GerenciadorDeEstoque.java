package service;

import model.Livro;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeEstoque {
    private Map<String, Livro> livros = new HashMap<>();

    public void adicionarLivro(Livro livro) {
        livros.put(livro.getTitulo(), livro);
    }

    public Livro buscarLivro(String titulo) {
        return livros.get(titulo);
    }

    public boolean verificarDisponibilidade(String titulo, int quantidade) {
        Livro livro = livros.get(titulo);
        return livro != null && livro.getQuantidadeEmEstoque() >= quantidade;
    }

    public void reduzirEstoque(String titulo, int quantidade) {
        Livro livro = livros.get(titulo);
        if (livro != null) {
            livro.reduzirEstoque(quantidade);
        }
    }
}

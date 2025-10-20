package model;

// Princípio da Responsabilidade Única (SRP): classe responsável apenas por representar dados de um livro.
public class Livro {
    private String titulo;
    private String autor;
    private double preco;
    private int quantidadeEmEstoque;

    public Livro(String titulo, String autor, double preco, int quantidadeEmEstoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void reduzirEstoque(int quantidade) {
        if (quantidadeEmEstoque >= quantidade) {
            quantidadeEmEstoque -= quantidade;
        } else {
            throw new IllegalArgumentException("Estoque insuficiente para o livro: " + titulo);
        }
    }
}

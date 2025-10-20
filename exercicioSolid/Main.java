import model.Cliente;
import model.Livro;
import model.Pedido;
import service.GerenciadorDeEstoque;
import service.GerenciadorDePedidos;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeEstoque estoque = new GerenciadorDeEstoque();
        estoque.adicionarLivro(new Livro("Clean Code", "Robert C. Martin", 120.0, 5));
        estoque.adicionarLivro(new Livro("Java Efetivo", "Joshua Bloch", 150.0, 3));

        Cliente cliente = new Cliente("Guilherme Moura", "guilherme@email");

        GerenciadorDePedidos pedidos = new GerenciadorDePedidos(estoque);

        Pedido pedido = pedidos.criarPedido(cliente, "Clean Code", 2);

        System.out.println("Pedido criado para: " + pedido.getCliente().getNome());
        System.out.println("Livros comprados: ");
        pedido.getLivros().forEach(l -> System.out.println("- " + l.getTitulo()));
        System.out.println("Valor total: R$ " + pedido.getValorTotal());
    }
}

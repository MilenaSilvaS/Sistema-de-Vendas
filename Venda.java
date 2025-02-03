import java.util.ArrayList;

public class Venda {
    private Cliente cliente; // Cliente associado à venda
    private ArrayList<Produto> produtos; // Lista de produtos vendidos

    // Construtor da classe Venda que recebe um cliente como parâmetro
    public Venda(Cliente cliente) {
        this.cliente = cliente; // Define o cliente da venda
        this.produtos = new ArrayList<>(); // Inicializa a lista de produtos
    }

    // Método para adicionar um produto à lista de produtos da venda
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Método para obter o cliente associado à venda
    public Cliente getCliente() {
        return cliente;
    }

    // Método para obter a lista de produtos vendidos
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    // Método sobrescrito para representar a venda como uma string
    @Override
    public String toString() {
        // Usa StringBuilder para construir uma string contendo os detalhes da venda
        StringBuilder detalhes = new StringBuilder("Venda para " + cliente.getNome() + ":\n");
        for (Produto p : produtos) {
            detalhes.append(p.toString()).append("\n"); // Adiciona os produtos vendidos à string
        }
        return detalhes.toString(); // Retorna a string formatada da venda
    }
}


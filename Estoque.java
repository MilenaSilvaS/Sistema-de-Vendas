import java.util.ArrayList; // Importação da classe ArrayList para armazenar produtos dinamicamente

// Classe Estoque gerencia uma lista de produtos disponíveis para venda
public class Estoque {
    private ArrayList<Produto> produtos; // Lista de produtos no estoque

    // Construtor inicializa a lista de produtos
    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    /**
     * Adiciona um novo produto ao estoque.
     * @param produto Produto a ser adicionado
     */
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado ao estoque com sucesso!");
    }

    /**
     * Lista todos os produtos disponíveis no estoque.
     * Caso o estoque esteja vazio, exibe uma mensagem correspondente.
     */
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println((i + 1) + " - " + produtos.get(i));
            }
        }
    }

    /**
     * Remove uma quantidade específica de um produto do estoque.
     * @param indice Índice do produto na lista
     * @param quantidadeVendida Quantidade a ser removida do estoque
     * @return Produto removido com a quantidade especificada, ou null caso não seja possível remover.
     */
    public Produto removerQuantidadeProduto(int indice, int quantidadeVendida) {
        if (indice >= 0 && indice < produtos.size()) {
            Produto produto = produtos.get(indice);
            if (produto.getQuantidade() >= quantidadeVendida) {
                produto.setQuantidade(produto.getQuantidade() - quantidadeVendida);
                // Retorna um novo objeto Produto apenas com a quantidade vendida
                return new Produto(produto.getCodigo(), produto.getNome(), produto.getMarca(), 
                                   produto.getDataFabricacao(), produto.getDataVencimento(), 
                                   produto.getDescricao(), produto.getPreco(), quantidadeVendida);
            } else {
                System.out.println("Quantidade insuficiente no estoque.");
                return null;
            }
        } else {
            System.out.println("Índice inválido.");
            return null;
        }
    }

    /**
     * Remove um produto completamente do estoque, baseado no índice.
     * @param indice Índice do produto na lista
     */
    public void removerProduto(int indice) {
        if (indice >= 0 && indice < produtos.size()) {
            Produto removido = produtos.remove(indice);
            System.out.println("Produto '" + removido.getNome() + "' removido com sucesso!");
        } else {
            System.out.println("Índice inválido. Nenhum produto foi removido.");
        }
    }

    /**
     * Retorna a lista de produtos no estoque.
     * @return Lista de produtos
     */
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}

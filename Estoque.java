import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado ao estoque com sucesso!");
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println((i + 1) + " - " + produtos.get(i));
            }
        }
    }

    public Produto removerQuantidadeProduto(int indice, int quantidadeVendida) {
        if (indice >= 0 && indice < produtos.size()) {
            Produto produto = produtos.get(indice);
            if (produto.getQuantidade() >= quantidadeVendida) {
                produto.setQuantidade(produto.getQuantidade() - quantidadeVendida);
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

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}


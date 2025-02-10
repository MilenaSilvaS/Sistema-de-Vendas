import java.util.ArrayList;
import java.time.LocalDate;
import java.util.UUID;

public class Venda {
    private String id;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<Produto> produtos;
    private LocalDate dataVenda;
    private MetodoPagamento metodoPagamento;
    private double valorTotal;
    private boolean finalizada;

    public Venda(Cliente cliente, Vendedor vendedor, MetodoPagamento metodoPagamento) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.produtos = new ArrayList<>();
        this.dataVenda = LocalDate.now();
        this.metodoPagamento = metodoPagamento;
        this.valorTotal = 0.0;
        this.finalizada = false;
    }

    public void adicionarProduto(Produto produto) {
        if (!finalizada) {
            produtos.add(produto);
            this.valorTotal += produto.getPreco();
        } else {
            System.out.println("Não é possível adicionar produtos a uma venda finalizada.");
        }
    }

    public void finalizarVenda() {
        if (!produtos.isEmpty()) {
            this.finalizada = true;
            System.out.println("Venda finalizada com sucesso!");
        } else {
            System.out.println("A venda não pode ser finalizada sem produtos.");
        }
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    @Override
    public String toString() {
        StringBuilder detalhes = new StringBuilder("Venda ID: " + id + "\n");
        detalhes.append("Data: " + dataVenda + "\n");
        detalhes.append("Cliente: " + cliente.getNome() + "\n");
        detalhes.append("Vendedor: " + vendedor.getNome() + "\n");
        detalhes.append("Método de Pagamento: " + metodoPagamento.toString() + "\n");
        detalhes.append("Status: " + (finalizada ? "Finalizada" : "Pendente") + "\n");
        detalhes.append("Produtos: \n");
        for (Produto p : produtos) {
            detalhes.append("  - " + p.toString() + "\n");
        }
        detalhes.append("Valor Total: R$" + valorTotal + "\n");
        return detalhes.toString();
    }
}

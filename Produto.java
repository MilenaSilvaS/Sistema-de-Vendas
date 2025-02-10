import java.time.LocalDate;

public class Produto {
    private String codigo;
    private String nome;
    private String marca;
    private LocalDate dataFabricacao;
    private LocalDate dataVencimento;
    private String descricao;
    private double preco;
    private int quantidade;
    private boolean ativo; // Indica se o produto ainda está disponível

    public Produto(String codigo, String nome, String marca, LocalDate dataFabricacao, LocalDate dataVencimento, String descricao, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
        this.dataFabricacao = dataFabricacao;
        this.dataVencimento = dataVencimento;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.ativo = true; // Produto começa ativo por padrão
    }

    // Métodos getters
    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getMarca() { return marca; }
    public LocalDate getDataFabricacao() { return dataFabricacao; }
    public LocalDate getDataVencimento() { return dataVencimento; }
    public String getDescricao() { return descricao; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }
    public boolean isAtivo() { return ativo; }

    // Métodos setters para edição
    public void setNome(String nome) { this.nome = nome; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setDataFabricacao(LocalDate dataFabricacao) { this.dataFabricacao = dataFabricacao; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    // Método para "excluir" o produto, desativando-o
    public void excluirProduto() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
               ", Nome: " + nome +
               ", Marca: " + marca +
               ", Fabricação: " + dataFabricacao +
               ", Vencimento: " + dataVencimento +
               ", Descrição: " + descricao +
               ", Preço: R$" + preco +
               ", Quantidade: " + quantidade +
               ", Status: " + (ativo ? "Disponível" : "Indisponível");
    }
}

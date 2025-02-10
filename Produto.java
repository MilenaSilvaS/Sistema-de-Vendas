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

    public Produto(String codigo, String nome, String marca, LocalDate dataFabricacao, LocalDate dataVencimento, String descricao, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
        this.dataFabricacao = dataFabricacao;
        this.dataVencimento = dataVencimento;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
               ", Quantidade: " + quantidade;
    }
}

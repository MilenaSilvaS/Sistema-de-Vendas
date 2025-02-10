public class MetodoPagamento {
    private String tipo;

    // Constantes para os métodos de pagamento permitidos
    public static final String CREDITO = "Crédito";
    public static final String DEBITO = "Débito";
    public static final String PIX = "Pix";

    // Construtor que valida se o método de pagamento é válido
    public MetodoPagamento(String tipo) {
        if (!tipo.equals(CREDITO) && !tipo.equals(DEBITO) && !tipo.equals(PIX)) {
            throw new IllegalArgumentException("Método de pagamento inválido!");
        }
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}


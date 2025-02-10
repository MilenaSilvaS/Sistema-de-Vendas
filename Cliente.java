public class Cliente {
    private String nome;
    private String endereco;
    private String cpf;
    private String laboratorio;

    public Cliente(String nome, String endereco, String cpf, String laboratorio) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.laboratorio = laboratorio;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getLaboratorio() { return laboratorio; }
    public void setLaboratorio(String laboratorio) { this.laboratorio = laboratorio; }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", Endereço: " + endereco + ", CPF: " + cpf + ", Laboratório: " + laboratorio;
    }
}

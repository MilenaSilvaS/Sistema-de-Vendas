import java.util.UUID;

public class Vendedor {
    private String id;
    private String nome;
    private String cpf;
    private String departamento;
    private String contato;

    public Vendedor(String nome, String cpf, String departamento, String contato) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.cpf = cpf;
        this.departamento = departamento;
        this.contato = contato;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getContato() {
        return contato;
    }

    @Override
    public String toString() {
        return "Vendedor ID: " + id + "\nNome: " + nome + "\nCPF: " + cpf + "\nDepartamento: " + departamento + "\nContato: " + contato;
    }
}
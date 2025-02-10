import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

public class SistemaDeVendas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        ArrayList<Venda> vendas = new ArrayList<>();

        // Produtos pré-cadastrados com quantidades
        estoque.adicionarProduto(new Produto("RQ001", "Ácido Sulfúrico", "Quimex", LocalDate.of(2024, 1, 10), LocalDate.of(2026, 1, 10), "Ácido forte usado em laboratório", 150.00, 10));
        estoque.adicionarProduto(new Produto("RQ002", "Hidróxido de Sódio", "LabQuim", LocalDate.of(2023, 12, 5), LocalDate.of(2025, 12, 5), "Base forte utilizada em experimentos químicos", 80.00, 15));
        estoque.adicionarProduto(new Produto("RQ003", "Ethanol", "BioQuim", LocalDate.of(2023, 5, 15), LocalDate.of(2024, 5, 15), "Álcool usado em análises químicas", 50.00, 20));

        // Clientes pré-cadastrados
        clientes.add(new Cliente("Leandro", "Rua A, 123", "123.456.789-00", "Laboratório Químico"));
        clientes.add(new Cliente("Kalebe", "Rua B, 456", "987.654.321-00", "Departamento de Biologia"));
        clientes.add(new Cliente("Joaninha", "Rua C, 789", "456.789.123-00", "Laboratório de Análises"));

        // Vendedores pré-cadastrados
        vendedores.add(new Vendedor("Ana Clara", "112.334.556-77", "Vendas", "ana.clara@empresa.com"));
        vendedores.add(new Vendedor("Pedro Henrique", "998.776.554-33", "Atendimento", "pedro.henrique@empresa.com"));

        int opcao = 0;
        do {
            System.out.println("\n====== Sistema de Vendas de Reagentes Químicos ======");
            System.out.println("1 - Registrar Produto no Estoque");
            System.out.println("2 - Registrar Cliente");
            System.out.println("3 - Registrar Vendedor");
            System.out.println("4 - Realizar Venda");
            System.out.println("5 - Relatório de Vendas");
            System.out.println("6 - Lista de Produtos no Estoque");
            System.out.println("7 - Relação de Clientes");
            System.out.println("8 - Relação de Vendedores");
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Código do Produto: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nome do Produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Data de Fabricação (YYYY-MM-DD): ");
                    LocalDate dataFabricacao = LocalDate.parse(scanner.nextLine());
                    System.out.print("Data de Vencimento (YYYY-MM-DD): ");
                    LocalDate dataVencimento = LocalDate.parse(scanner.nextLine());
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();
                    estoque.adicionarProduto(new Produto(codigo, nome, marca, dataFabricacao, dataVencimento, descricao, preco, quantidade));
                    break;
                case 2:
                    System.out.print("Nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Laboratório/Departamento: ");
                    String laboratorio = scanner.nextLine();
                    clientes.add(new Cliente(nomeCliente, endereco, cpf, laboratorio));
                    System.out.println("Cliente registrado com sucesso!");
                    break;
                case 3:
                    System.out.print("Nome do Vendedor: ");
                    String nomeVendedor = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfVendedor = scanner.nextLine();
                    System.out.print("Departamento: ");
                    String departamento = scanner.nextLine();
                    System.out.print("Contato: ");
                    String contato = scanner.nextLine();
                    vendedores.add(new Vendedor(nomeVendedor, cpfVendedor, departamento, contato));
                    System.out.println("Vendedor registrado com sucesso!");
                    break;
                case 4:
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado. Cadastre um cliente antes de realizar uma venda.");
                        break;
                    }
                    if (vendedores.isEmpty()) {
                        System.out.println("Nenhum vendedor cadastrado. Cadastre um vendedor antes de realizar uma venda.");
                        break;
                    }
                    if (estoque.getProdutos().isEmpty()) {
                        System.out.println("Nenhum produto disponível no estoque. Adicione produtos antes de realizar uma venda.");
                        break;
                    }

                    System.out.println("Selecione um cliente:");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println((i + 1) + " - " + clientes.get(i).getNome());
                    }
                    int indiceCliente = scanner.nextInt() - 1;
                    scanner.nextLine();
                    Cliente clienteEscolhido = clientes.get(indiceCliente);

                    System.out.println("Selecione um vendedor:");
                    for (int i = 0; i < vendedores.size(); i++) {
                        System.out.println((i + 1) + " - " + vendedores.get(i).getNome());
                    }
                    int indiceVendedor = scanner.nextInt() - 1;
                    scanner.nextLine();
                    Vendedor vendedorEscolhido = vendedores.get(indiceVendedor);

                    System.out.println("Selecione os produtos (0 para encerrar):");
                    estoque.listarProdutos();
                    ArrayList<Produto> produtosSelecionados = new ArrayList<>();
                    while (true) {
                        int indiceProduto = scanner.nextInt();
                        scanner.nextLine();
                        if (indiceProduto == 0) break;
                        if (indiceProduto > 0 && indiceProduto <= estoque.getProdutos().size()) {
                            System.out.print("Quantidade a vender: ");
                            int quantidadeVendida = scanner.nextInt();
                            scanner.nextLine();
                            Produto produtoEscolhido = estoque.removerQuantidadeProduto(indiceProduto - 1, quantidadeVendida);
                            if (produtoEscolhido != null) {
                                produtosSelecionados.add(produtoEscolhido);
                                System.out.println("Produto adicionado: " + produtoEscolhido.getNome() + " (Quantidade: " + quantidadeVendida + ")");
                            } else {
                                System.out.println("Quantidade insuficiente no estoque. Tente novamente.");
                            }
                        } else {
                            System.out.println("Índice inválido! Tente novamente.");
                        }
                    }
                    if (produtosSelecionados.isEmpty()) {
                        System.out.println("Nenhum produto foi selecionado. Venda cancelada.");
                        break;
                    }

                    System.out.print("Método de pagamento: ");
                    String metodoPagamento = scanner.nextLine();
                    Venda venda = new Venda(clienteEscolhido, vendedorEscolhido, metodoPagamento);
                    for (Produto produto : produtosSelecionados) {
                        venda.adicionarProduto(produto);
                    }
                    vendas.add(venda);
                    System.out.println("Venda realizada com sucesso!");
                    break;
                case 5:
                    if (vendas.isEmpty()) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        for (Venda v : vendas) {
                            System.out.println(v);
                        }
                    }
                    break;
                case 6:
                    System.out.println("\nProdutos no Estoque:");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-5s %-10s %-20s %-15s %-10s %-40s\n", "#", "Código", "Nome", "Marca", "Preço", "Qtd.", "Descrição");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    for (int i = 0; i < estoque.getProdutos().size(); i++) {
                        Produto p = estoque.getProdutos().get(i);
                        System.out.printf(
                        "%-5d %-10s %-20s %-15s %-10.2f %-10d %-40s\n", 
                        i + 1, 
                        p.getCodigo(), 
                        p.getNome(), 
                        p.getMarca(), 
                        p.getPreco(), 
                        p.getQuantidade(), 
                        p.getDescricao()
                    );
                }
                
                    break;
                case 7:
                    System.out.println("\nClientes Cadastrados:");
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.printf("%-5s %-20s %-20s %-15s %-30s\n", "#", "Nome", "Endereço", "CPF", "Laboratório/Departamento");
                    System.out.println("---------------------------------------------------------------------------------------");
                    for (int i = 0; i < clientes.size(); i++) {
                        Cliente c = clientes.get(i);
                        System.out.printf("%-5d %-20s %-20s %-15s %-30s\n", i + 1, c.getNome(), c.getEndereco(), c.getCpf(), c.getLaboratorio());
                    }
                    break;
                case 8:
                    System.out.println("\nVendedores Cadastrados:");
                    System.out.println("--------------------------------------------------------------------------------------");
                    System.out.printf("%-5s %-20s %-15s %-20s %-30s\n", "#", "Nome", "CPF", "Departamento", "Contato");
                    System.out.println("--------------------------------------------------------------------------------------");
                    for (int i = 0; i < vendedores.size(); i++) {
                        Vendedor v = vendedores.get(i);
                        System.out.printf("%-5d %-20s %-15s %-20s %-30s\n", i + 1, v.getNome(), v.getCpf(), v.getDepartamento(), v.getContato());
                    }
                    break;
                case 9:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 9);
        scanner.close();
    }
}

import java.util.ArrayList; // Biblioteca para manipulação de listas dinâmicas
import java.util.InputMismatchException; // Biblioteca para tratamento de erros de entrada do usuário
import java.util.Scanner; // Biblioteca para entrada de dados pelo teclado

public class SistemaDeVendas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Objeto Scanner para entrada de dados
        ArrayList<Produto> produtos = new ArrayList<>(); // Lista para armazenar produtos
        ArrayList<Cliente> clientes = new ArrayList<>(); // Lista para armazenar clientes
        ArrayList<Venda> vendas = new ArrayList<>(); // Lista para armazenar vendas realizadas
        int opcao = 0; // Variável para controle do menu

        do {
            // Exibe o menu principal
            System.out.println("\n------------------- Menu -------------------");
            System.out.println("1 - Registrar Produto");
            System.out.println("2 - Registrar Cliente");
            System.out.println("3 - Realizar Venda");
            System.out.println("4 - Listar Vendas");
            System.out.println("5 - Gerenciar Produtos");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt(); // Captura a opção escolhida pelo usuário
                scanner.nextLine(); // Consome a quebra de linha
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número válido.");
                scanner.nextLine(); // Limpa o buffer
                continue; // Volta ao início do loop
            }

            switch (opcao) {
                case 1: // Registrar um novo produto
                    System.out.print("Nome do Produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Preço do Produto: ");
                    try {
                        double precoProduto = scanner.nextDouble();
                        scanner.nextLine();
                        produtos.add(new Produto(nomeProduto, precoProduto)); // Adiciona o produto à lista
                        System.out.println("Produto registrado com sucesso!");
                    } catch (InputMismatchException e) {
                        System.out.println("Preço inválido! Tente novamente.");
                        scanner.nextLine();
                    }
                    break;

                case 2: // Registrar um novo cliente
                    System.out.print("Nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    clientes.add(new Cliente(nomeCliente)); // Adiciona o cliente à lista
                    System.out.println("Cliente registrado com sucesso!");
                    break;

                case 3: // Realizar  o processo de venda
                    if (clientes.isEmpty() || produtos.isEmpty()) {
                        System.out.println("É necessário pelo menos um cliente e um produto para realizar uma venda.");
                        break;
                    }
                    // Selecionar o cliente
                    System.out.println("Selecione um cliente:");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println((i + 1) + " - " + clientes.get(i).getNome());
                    }
                    System.out.print("Escolha: ");
                    int indiceCliente;
                    try {
                        indiceCliente = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (indiceCliente < 0 || indiceCliente >= clientes.size()) {
                            System.out.println("Cliente inválido!");
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida!");
                        scanner.nextLine();
                        break;
                    }

                    Cliente clienteEscolhido = clientes.get(indiceCliente);
                    Venda venda = new Venda(clienteEscolhido);

                    // Selecionar os produtos para a venda
                    System.out.println("Selecione os produtos (digite 0 para encerrar):");
                    for (int i = 0; i < produtos.size(); i++) {
                        System.out.println((i + 1) + " - " + produtos.get(i));
                    }

                    while (true) {
                        System.out.print("Escolha: ");
                        int indiceProduto;
                        try {
                            indiceProduto = scanner.nextInt();
                            scanner.nextLine();
                            if (indiceProduto == 0) break;
                            if (indiceProduto < 1 || indiceProduto > produtos.size()) {
                                System.out.println("Produto inválido!");
                                continue;
                            }
                            venda.adicionarProduto(produtos.get(indiceProduto - 1));
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida!");
                            scanner.nextLine();
                        }
                    }

                    vendas.add(venda);
                    System.out.println("Venda realizada com sucesso!");
                    break;

                case 4: // Listar vendas
                    if (vendas.isEmpty()) {
                        System.out.println("Nenhuma venda registrada.");
                    } else {
                        for (Venda v : vendas) {
                            System.out.println(v);
                        }
                    }
                    break;

                case 5: // Gerenciar produtos (listar, remover, limpar)
                    System.out.println("Lista de Produtos:");
                    for (int i = 0; i < produtos.size(); i++) {
                        System.out.println((i + 1) + " - " + produtos.get(i));
                    }
                    
                    System.out.print("Deseja remover um produto? (Digite o número ou 0 para voltar): ");
                    try {
                        int remover = scanner.nextInt();
                        scanner.nextLine();
                        if (remover > 0 && remover <= produtos.size()) {
                            produtos.remove(remover - 1);
                            System.out.println("Produto removido!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida!");
                        scanner.nextLine();
                    }
                    
                    System.out.print("Deseja limpar a lista de produtos? (sim ou não): ");
                    String limpar = scanner.nextLine();
                    if (limpar.equalsIgnoreCase("s")) {
                        produtos.clear();
                        System.out.println("Lista de produtos limpa!");
                    }
                    break;

                case 6: // Encerrar o sistema
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close(); // Fecha o scanner
    }
}

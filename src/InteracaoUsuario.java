import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InteracaoUsuario {
    // Cria uma lista para armazenar receitas
    private List<Receita> receitas = new ArrayList<>();
    // Cria um objeto para ler a entrada do usuário
    private Scanner scanner = new Scanner(System.in);

    // Método principal que executa a interação com o usuário
    public void executar() {
        boolean continuar = true;

        // Loop que continua até o usuário decidir parar
        while (continuar) {
            // Adiciona uma nova receita
            adicionarReceita();
            System.out.println("\nReceita cadastrada com sucesso!\n");

            // Pergunta ao usuário se deseja adicionar outra receita
            System.out.print("Deseja cadastrar outra receita? (S/N): ");
            String resposta = scanner.nextLine().trim().toUpperCase();

            // Verifica a resposta do usuário
            if (!resposta.equals("S")) {
                continuar = false;
            }
        }

        // Lista todas as receitas cadastradas
        System.out.println("\nListando receitas cadastradas:\n");
        listarReceitas();

        // Se houver receitas, permite ao usuário visualizar uma específica
        if (!receitas.isEmpty()) {
            System.out.print("\nEscolha o número da receita que deseja visualizar: ");
            int escolha = lerEscolhaReceita();

            // Exibe a receita escolhida pelo usuário
            if (escolha > 0 && escolha <= receitas.size()) {
                System.out.println("\nVisualizando receita selecionada:\n");
                System.out.println(receitas.get(escolha - 1));
            } else {
                System.out.println("\nOpção inválida. Nenhuma receita será visualizada.");
            }
        } else {
            System.out.println("\nNenhuma receita cadastrada para visualização.");
        }

        // Fim do programa
        System.out.println("\nFim do programa.");
    }

    // Método para adicionar uma nova receita
    public void adicionarReceita() {
        System.out.print("\nNome da receita: ");
        String nomeReceita = scanner.nextLine();

        // Adiciona itens à receita
        List<Item> itens = new ArrayList<>();
        System.out.print("Quantos itens na receita? ");
        double quantidadeItens = lerInteiro();

        for (int i = 0; i < quantidadeItens; i++) {
            System.out.print("Nome do item: ");
            String nomeItem = scanner.nextLine();
            System.out.print("Quantidade do item: ");
            double quantidadeItem = lerInteiro();
            System.out.print("Unidade (ex: xícaras, colheres de sopa): ");
            String unidadeItem = scanner.nextLine();
            itens.add(new Item(nomeItem, quantidadeItem, unidadeItem));
        }

        // Adiciona passos ao modo de preparo da receita
        List<String> passos = new ArrayList<>();
        System.out.print("Quantos passos no modo de preparo? ");
        double quantidadePassos = lerInteiro();

        for (int i = 0; i < quantidadePassos; i++) {
            System.out.print("Descreva o passo " + (i + 1) + ": ");
            passos.add(scanner.nextLine());
        }

        // Cria o objeto Receita e adiciona à lista de receitas
        ModoDePreparo modoDePreparo = new ModoDePreparo(passos);
        Receita receita = new Receita(nomeReceita, itens, modoDePreparo);
        receitas.add(receita);
    }

    // Método para ler um número inteiro da entrada do usuário
    private double lerInteiro() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, insira um número válido: ");
            }
        }
    }

    // Método para ler a escolha do usuário para visualizar uma receita
    private int lerEscolhaReceita() {
        while (true) {
            try {
                int escolha = Integer.parseInt(scanner.nextLine());
                if (escolha < 1 || escolha > receitas.size()) {
                    throw new IndexOutOfBoundsException();
                }
                return escolha;
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, insira um número: ");
            } catch (IndexOutOfBoundsException e) {
                System.out.print("Escolha inválida. Por favor, escolha um número válido: ");
            }
        }
    }

    // Método para listar todas as receitas cadastradas
    public void listarReceitas() {
        for (int i = 0; i < receitas.size(); i++) {
            System.out.println((i + 1) + ". " + receitas.get(i).getNome());
        }
    }
}

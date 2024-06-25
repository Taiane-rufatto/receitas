import java.util.List;

public class Receita {
    // Variáveis de instância que representam os atributos de uma receita
    private String nome; // Nome da receita
    private List<Item> itens; // Lista de itens necessários para a receita
    private ModoDePreparo modoDePreparo; // Modo de preparo da receita

    // Construtor da classe Receita que inicializa os atributos da receita
    public Receita(String nome, List<Item> itens, ModoDePreparo modoDePreparo) {
        this.nome = nome; // Inicializa o nome da receita com o valor passado como parâmetro
        this.itens = itens; // Inicializa a lista de itens com a lista passada como parâmetro
        this.modoDePreparo = modoDePreparo; // Inicializa o modo de preparo com o objeto passado como parâmetro
    }

    // Método toString que retorna uma representação em formato de texto da receita
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Receita: ").append(nome).append("\nItens:\n");
        // Itera sobre a lista de itens e adiciona cada item à representação da receita
        for (Item item : itens) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("Modo de Preparo:\n").append(modoDePreparo); // Adiciona o modo de preparo à representação da receita
        return sb.toString(); // Retorna a representação final da receita em formato de texto
    }
}

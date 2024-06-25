import java.util.List;

public class ModoDePreparo {
    // Lista que armazena os passos do modo de preparo da receita
    private List<String> passos;

    // Construtor da classe ModoDePreparo que inicializa a lista de passos
    public ModoDePreparo(List<String> passos) {
        this.passos = passos; // Inicializa a lista de passos com a lista passada como parâmetro
    }

    // Método para obter a lista de passos do modo de preparo
    public List<String> getPassos() {
        return passos; // Retorna a lista de passos
    }

    // Método toString que retorna uma representação em formato de texto dos passos do modo de preparo
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Itera sobre a lista de passos e constrói uma string com cada passo numerado
        for (int i = 0; i < passos.size(); i++) {
            sb.append((i + 1)).append(". ").append(passos.get(i)).append("\n");
        }
        return sb.toString(); // Retorna a string construída
    }
}

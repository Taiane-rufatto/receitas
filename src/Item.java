public class Item {
    // Declaração das variáveis que representam as propriedades de um item
    private String nome; // Nome do item
    private double quantidade; // Quantidade do item
    private String unidade; // Unidade de medida do item (ex: xícaras, colheres de sopa)

    // Construtor da classe Item, usado para criar um novo item com nome, quantidade e unidade
    public Item(String nome, double quantidade, String unidade) {
        this.nome = nome; // Define o nome do item
        this.quantidade = quantidade; // Define a quantidade do item
        this.unidade = unidade; // Define a unidade de medida do item
    }

    // Método que retorna uma representação em forma de texto do item
    @Override
    public String toString() {
        // Constrói uma string que descreve o item
        // Ex: "Farinha (2 xícaras)"
        return nome + " (" + quantidade + " " + unidade + ")";
    }
}

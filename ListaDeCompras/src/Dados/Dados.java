package Dados;

/**
 * Classe que armazena todos os dados usados no programa
 * A classe armazena itens pré-selecionados para a lista de compras
 * @author Yan Matheus
 * @since 2024
 * @version 1.1
 */
public class Dados {
    private static String[] itens = {"3 tomates", "caixa de leite", "ovos", "5 pães", "2 alhos", "ketchup", "biscoito", "farinha de trigo", "melancia"};
    
    /**
     * Retorna a lista de itens armazenados.
     * @return a lista de itens armazenados
     */
    public static String[] getItens() {
        return itens;
    }

    /**
     * Define uma nova lista de itens.
     * @param novosItens a nova lista de itens a ser definida
     */
    public static void setItens(String[] novosItens) {
        itens = novosItens;
    }
}


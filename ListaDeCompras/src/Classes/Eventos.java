package Classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JFrame;

/**
 * Classe que executa os comandos dos eventos dos botões e da lista da iterface
 * @author Yan Matheus
 * @Since 2024
 * @version 1.0
 */
public class Eventos implements ListSelectionListener, ActionListener {
	private JButton adicionar;
	private JButton excluir;
    private JButton editar;
    private String[] itens;
    private JList<String> lista;
    private JFrame janela;
	
    /**
     * Construtor da classe Eventos.
     * @param adicionar o botão de adicionar
     * @param excluir o botão de excluir
     * @param editar o botão de editar
     * @param itens a lista de itens
     * @param lista a lista gráfica de itens
     * @param janela a janela principal
     */
	public Eventos(JButton adicionar, JButton excluir, JButton editar, String[] itens, JList<String> lista, JFrame janela) {
        this.adicionar = adicionar;
		this.excluir = excluir;
        this.editar = editar;
        this.itens = itens;
        this.lista = lista;
        this.janela = janela;
    }

	/**
	 * Mostra os botões excluir e editar ao selecionar um item da lista TRUE se selecionado, FALSE se não
	 * @param list o evento de alteração de seleção na lista
	 */
	public void valueChanged(ListSelectionEvent list) {
		int idxSelecionado = lista.getSelectedIndex();
		
		if (idxSelecionado != -1) {
			excluir.setVisible(true);
			editar.setVisible(true);
		} else {
			excluir.setVisible(false);
			editar.setVisible(false);
		}
	}

	/**
	 * Eventos dos botões adiconar, excluir e editar, respectivamente.
	 * Adicionar (primeiro if): adiciona através de um input um novo item a lista
	 * Excluir (primeiro else if): exclui o item selecionado da lista
	 * Editar (segundo else if): altera através de um input o item da lista
	 * @param event o evento de ação
	 */
	public void actionPerformed(ActionEvent event) {
	    if (event.getSource() == adicionar) {
	        String novoItem = JOptionPane.showInputDialog(janela, "Digite o novo item:");
	        if (novoItem != null && !novoItem.isEmpty()) { 
	            String[] novoArray = new String[itens.length + 1];
	            System.arraycopy(itens, 0, novoArray, 0, itens.length);
	            novoArray[novoArray.length - 1] = novoItem;
	            itens = novoArray;
	            lista.setListData(itens);
	        }
	    } else if (event.getSource() == excluir) {
	        int idxSelecionado = lista.getSelectedIndex(); 
	        if (idxSelecionado != -1) { 
	            String[] novoArray = new String[itens.length - 1];
	            int novoIndice = 0;
	            for (int i=0; i < itens.length; i++) {
	            	if (i != idxSelecionado) {
	            		novoArray[novoIndice++] = itens[i]; 
	            	}
	            }
	            itens = novoArray;
	            lista.setListData(itens);
	        }
	    } else if (event.getSource() == editar) {
	    	int idxSelecionado = lista.getSelectedIndex();
	    	if (idxSelecionado != -1) {
	    		String novoItem = JOptionPane.showInputDialog(janela, "Digite o nome do item:");
		    	if (novoItem != null && !novoItem.isEmpty()) {
		    		itens[idxSelecionado] = novoItem;
		    		lista.setListData(itens);
		    	}
	    	}	    	
	    }
	}
}
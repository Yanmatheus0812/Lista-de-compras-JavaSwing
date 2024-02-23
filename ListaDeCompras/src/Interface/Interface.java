package Interface;

import javax.swing.*;
import Classes.Eventos;
import Dados.Dados;

/** 
 * Interface gráfica da lista de compras usando Swing, incluindo a classe Main ao final
 * @author Yan Matheus
 * @since 2024
 * @version 1.0
 */
public class Interface {
	/* DECLARANDO ITENS */
	private static JLabel jLabel1;
	private static JFrame janela;
	private static JList<String> lista;
	private static JScrollPane scroll;
	private static JButton adicionar, excluir, editar;		

	/** 
	 * Classe em que estancia, ajusta a janela, dimensões e declara eventos usados na interface grafica.
	 * apresenta uma janela, um label ao topo, uma lista com uma string contendo dados de itens, um scroll e três botões: adicionar, excluir e editar.
	 * os botões excluir e editar não ficam visíveis ao iniciar a interface, apenas quando algum item da lista é selecionado,
	 */
	public Interface() {
		/* ESTANCIANDO OS ITENS */
		janela = new JFrame("Lista de compras - Yan Matheus");
		jLabel1 = new JLabel("Lista de compras");
		String[] itens = Dados.getItens();
		lista = new JList<String>(itens);
		scroll = new JScrollPane(lista);
		adicionar = new JButton("+"); 
		excluir = new JButton("Excluir");
		editar = new JButton("Editar");
		
		/* AJUSTANDO JANELA */
		janela.setSize(500,550);
		janela.setVisible(true);
		janela.setLayout(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* AJUSTANDO DIMENSOES */
		jLabel1.setBounds(190,0,300,40);
		scroll.setBounds(50, 50, 400, 300);
		adicionar.setBounds(400,10,50,30);
		excluir.setBounds(100,450,300,40);
		editar.setBounds(100,400,300,40);
		
		/* EVENTOS */
        Eventos eventos = new Eventos(adicionar, excluir, editar, itens, lista, janela);
        lista.addListSelectionListener(eventos);
        adicionar.addActionListener(eventos);
        excluir.addActionListener(eventos);
        editar.addActionListener(eventos);
		
		/* TOOLTIPS */
		adicionar.setToolTipText("Adicionar novo item");
		excluir.setToolTipText("Remover item da lista");
		editar.setToolTipText("Editar item");
		
		/* ADICIONANDO ITENS NA JANELA */
		janela.add(jLabel1);
		janela.add(scroll);
		janela.add(adicionar);
		janela.add(excluir);
		janela.add(editar);
		
		/* VISIBILIDADE */
		excluir.setVisible(false);
		editar.setVisible(false);
	}

	/**
	 * Classe main que chama a interface gráfica
	 * @param args
	 */
	public static void main(String[] args) {
		new Interface();
	}
}
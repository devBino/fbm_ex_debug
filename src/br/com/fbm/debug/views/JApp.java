package br.com.fbm.debug.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class JApp extends JFrame {

	private static final long serialVersionUID = -3001459404702645035L;
	
	private JPanel contentPane, pnTop, pnBottom, pnCenter, pnRight, pnLeft;
	private JPanel pnTituloListagemTop, pnTituloListagemBottom, pnTituloListagemLeft;
	private JPanel pnListExerciciosTop, pnListExerciciosLeft, pnListExerciciosRight, pnListExerciciosBottom;
	private JPanel pnTituloListagemRight, pnHeaderRight, pnListExerciciosCenter;
	private JPanel pnRelatorioRight, pnRelatorioBottom;
	
	private JLabel lblAssunto, lblTipo, lbIntervaloInicial, lbIntervaloFinal;
	private JLabel lbTituloListage, lbTituloTela,lblAnotacao, lblTitulo, lbFlags;
	
	private JTextField txtAssunto, txtNumIni, txtNumFinal, txtTitulo, txtFlags;

	private JComboBox<String> cbxTipo, cbxAnotacao;
	
	private JButton btnLocalizar, btnReset, btnDebugar, btnRelatorio;
	private JScrollPane scExercicios;
	private JTable tbExercicios;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JApp frame = new JApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JApp() {
		
		
		/**
		 * Algumas propriedades desse JFrame JApp.
		 */
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.GRAY);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Interface para Selecionar Implementações de Exercícios");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(500, 500));
		setBounds(100, 100, 819, 543);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		/**
		 * Criação dos paineis para agrupar os elementos 
		 * na distribuição do layout
		 */
		
		//painel topo
		pnTop = new JPanel();
		pnTop.setPreferredSize(new Dimension(10, 30));
		pnTop.setForeground(Color.LIGHT_GRAY);
		pnTop.setBackground(Color.GRAY);
		contentPane.add(pnTop, BorderLayout.NORTH);
		pnTop.setLayout(new BorderLayout(0, 0));
		
		pnHeaderRight = new JPanel();
		pnHeaderRight.setBackground(Color.GRAY);
		pnHeaderRight.setLayout(new BorderLayout(0, 0));
		pnTop.add(pnHeaderRight, BorderLayout.EAST);
		
		lbTituloTela = new JLabel("Interface para Selecionar Implementações de Exercícios     ");
		lbTituloTela.setHorizontalAlignment(SwingConstants.LEFT);
		lbTituloTela.setHorizontalTextPosition(SwingConstants.LEFT);
		lbTituloTela.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 14));
		lbTituloTela.setForeground(Color.LIGHT_GRAY);
		pnHeaderRight.add(lbTituloTela, BorderLayout.CENTER);
		
		//painel da esquerda
		pnLeft = new JPanel();
		pnLeft.setMinimumSize(new Dimension(159, 200));
		pnLeft.setMaximumSize(new Dimension(150, 200));
		pnLeft.setSize(new Dimension(150, 200));
		pnLeft.setBackground(Color.GRAY);
		pnLeft.setPreferredSize(new Dimension(150, 200));
		contentPane.add(pnLeft, BorderLayout.WEST);
		
		//painel da direita
		pnRight = new JPanel();
		pnRight.setPreferredSize(new Dimension(15, 10));
		pnRight.setForeground(Color.LIGHT_GRAY);
		pnRight.setBackground(Color.GRAY);
		contentPane.add(pnRight, BorderLayout.EAST);
		
		//painel do centro
		pnCenter = new JPanel();
		pnCenter.setForeground(Color.DARK_GRAY);
		pnCenter.setLayout(new BorderLayout(0, 0));
		contentPane.add(pnCenter, BorderLayout.CENTER);
		
		//painel do rodape
		pnBottom = new JPanel();
		pnBottom.setPreferredSize(new Dimension(10, 30));
		pnBottom.setForeground(Color.LIGHT_GRAY);
		pnBottom.setBackground(Color.GRAY);
		contentPane.add(pnBottom, BorderLayout.SOUTH);
		
		/**
		 * Criação de componentes do painel da esquerda
		 */
		
		//label e text Assunto
		lblAssunto = new JLabel("Assunto");
		lblAssunto.setSize(new Dimension(140, 20));
		lblAssunto.setPreferredSize(new Dimension(140, 20));
		lblAssunto.setMinimumSize(new Dimension(140, 20));
		lblAssunto.setMaximumSize(new Dimension(140, 20));
		lblAssunto.setForeground(Color.LIGHT_GRAY);
		pnLeft.add(lblAssunto);
		
		txtAssunto = new JTextField();
		txtAssunto.setSize(new Dimension(140, 20));
		txtAssunto.setPreferredSize(new Dimension(140, 20));
		txtAssunto.setMinimumSize(new Dimension(140, 20));
		txtAssunto.setMaximumSize(new Dimension(14, 20));
		txtAssunto.setForeground(Color.DARK_GRAY);
		txtAssunto.setColumns(10);
		pnLeft.add(txtAssunto);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setSize(new Dimension(140, 20));
		lblTitulo.setPreferredSize(new Dimension(140, 20));
		lblTitulo.setMinimumSize(new Dimension(140, 20));
		lblTitulo.setMaximumSize(new Dimension(140, 20));
		lblTitulo.setForeground(Color.LIGHT_GRAY);
		pnLeft.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setSize(new Dimension(140, 20));
		txtTitulo.setPreferredSize(new Dimension(140, 20));
		txtTitulo.setMinimumSize(new Dimension(140, 20));
		txtTitulo.setMaximumSize(new Dimension(14, 20));
		txtTitulo.setForeground(Color.DARK_GRAY);
		txtTitulo.setColumns(10);
		pnLeft.add(txtTitulo);
		
		//label e combobox Tipo Exercicio
		lblTipo = new JLabel("Tipo Exercicio");
		lblTipo.setForeground(Color.LIGHT_GRAY);
		pnLeft.add(lblTipo);
		
		cbxTipo = new JComboBox<>();
		cbxTipo.setForeground(Color.DARK_GRAY);
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Lista Tipos"}));
		pnLeft.add(cbxTipo);
		
		lblAnotacao = new JLabel("Anotação");
		lblAnotacao.setForeground(Color.LIGHT_GRAY);
		pnLeft.add(lblAnotacao);
		
		cbxAnotacao = new JComboBox<String>();
		cbxAnotacao.setForeground(Color.DARK_GRAY);
		cbxAnotacao.setModel(new DefaultComboBoxModel(new String[] {"Anotacao1","Anotacao2"}));
		pnLeft.add(cbxAnotacao);
		
		//label e txt numero inicial
		lbIntervaloInicial = new JLabel("Numero Inicial");
		lbIntervaloInicial.setForeground(Color.LIGHT_GRAY);
		pnLeft.add(lbIntervaloInicial);
		
		txtNumIni = new JTextField();
		txtNumIni.setText("1");
		txtNumIni.setForeground(Color.DARK_GRAY);
		txtNumIni.setColumns(10);
		pnLeft.add(txtNumIni);
		
		//label e txt numero final
		lbIntervaloFinal = new JLabel("Numero Final");
		lbIntervaloFinal.setForeground(Color.LIGHT_GRAY);
		pnLeft.add(lbIntervaloFinal);
		
		txtNumFinal = new JTextField();
		txtNumFinal.setText("5");
		txtNumFinal.setForeground(Color.DARK_GRAY);
		txtNumFinal.setColumns(10);
		pnLeft.add(txtNumFinal);
		
		lbFlags = new JLabel("Flags");
		lbFlags.setForeground(Color.LIGHT_GRAY);
		pnLeft.add(lbFlags);
		
		txtFlags = new JTextField();
		txtFlags.setForeground(Color.DARK_GRAY);
		txtFlags.setColumns(10);
		pnLeft.add(txtFlags);
		
		//botão localizar
		btnLocalizar = new JButton("Localizar");
		pnLeft.setLayout(new GridLayout(0, 1, 0, 5));
		btnLocalizar.setBackground(Color.PINK);
		pnLeft.add(btnLocalizar);
		
		/**
		 * Criação de componentes no painel do centro
		 */
		
		//painel de titulo de listagem dos exercicios
		pnListExerciciosTop = new JPanel();
		pnListExerciciosTop.setLayout(new BorderLayout(0, 0));
		pnListExerciciosTop.setForeground(Color.DARK_GRAY);
		pnListExerciciosTop.setPreferredSize(new Dimension(10, 40));
		pnCenter.add(pnListExerciciosTop, BorderLayout.NORTH);
		
		//label titulo listagem
		lbTituloListage = new JLabel("3 Exercício(s) Encontrado(s)...");
		lbTituloListage.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		pnListExerciciosTop.add(lbTituloListage, BorderLayout.CENTER);
		
		//paineis para completar o border layout do painel central de listagem de exercícios
		pnTituloListagemTop = new JPanel();
		pnTituloListagemTop.setPreferredSize(new Dimension(10, 5));
		pnListExerciciosTop.add(pnTituloListagemTop, BorderLayout.NORTH);
		 
		pnTituloListagemBottom = new JPanel();
		pnTituloListagemBottom.setPreferredSize(new Dimension(10, 5));
		pnListExerciciosTop.add(pnTituloListagemBottom, BorderLayout.SOUTH);
		
		pnTituloListagemLeft = new JPanel();
		pnListExerciciosTop.add(pnTituloListagemLeft, BorderLayout.WEST);
		
		pnTituloListagemRight = new JPanel();
		pnListExerciciosTop.add(pnTituloListagemRight, BorderLayout.EAST);
		
		//botão Resetar
		btnReset = new JButton("Resetar");
		btnReset.setBackground(Color.PINK);
		pnTituloListagemRight.add(btnReset);
		
		//botão Debugar
		btnDebugar = new JButton("Debugar");
		btnDebugar.setBackground(Color.PINK);
		pnTituloListagemRight.add(btnDebugar);
		
		pnListExerciciosCenter = new JPanel();
		pnListExerciciosCenter.setLayout(new BorderLayout(0, 0));
		pnCenter.add(pnListExerciciosCenter, BorderLayout.CENTER);
		
		scExercicios = new JScrollPane();
		scExercicios.setBackground(Color.GRAY);
		pnListExerciciosCenter.add(scExercicios);
		
		tbExercicios = new JTable();
		tbExercicios.setBorder(new LineBorder(Color.GRAY, 1, true));
		tbExercicios.setShowHorizontalLines(false);
		tbExercicios.setOpaque(false);
		tbExercicios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tbExercicios.setSelectionForeground(Color.LIGHT_GRAY);
		tbExercicios.setSelectionBackground(Color.DARK_GRAY);
		tbExercicios.setRowHeight(20);
		tbExercicios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tbExercicios.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tbExercicios.setColumnSelectionAllowed(true);
		tbExercicios.setCellSelectionEnabled(true);
		tbExercicios.setIntercellSpacing(new Dimension(3, 3));
		tbExercicios.setGridColor(Color.GRAY);
		tbExercicios.setFont(new Font("Ubuntu", Font.PLAIN, 13));
		tbExercicios.setForeground(Color.DARK_GRAY);
		scExercicios.setViewportView(tbExercicios);
		tbExercicios.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "String", "Metodo equals String", "Exercicio"},
				{"2", "Cast", "Conceitos de UpCasting", "Exercicio"},
				{"3", "Cast", "Casting long to int", "Quiz"},
			},
			new String[] {
				"NUMERO", "ASSUNTO", "TITULO", "TIPO"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbExercicios.getColumnModel().getColumn(0).setPreferredWidth(60);
		
		pnListExerciciosLeft = new JPanel();
		pnListExerciciosLeft.setPreferredSize(new Dimension(15, 10));
		pnCenter.add(pnListExerciciosLeft, BorderLayout.EAST);
		
		pnListExerciciosRight = new JPanel();
		pnListExerciciosRight.setPreferredSize(new Dimension(15, 10));
		pnCenter.add(pnListExerciciosRight, BorderLayout.WEST);
		
		pnListExerciciosBottom = new JPanel();
		pnListExerciciosBottom.setPreferredSize(new Dimension(10, 40));
		pnListExerciciosBottom.setLayout(new BorderLayout(0, 0));
		pnCenter.add(pnListExerciciosBottom, BorderLayout.SOUTH);
		
		pnRelatorioRight = new JPanel();
		pnListExerciciosBottom.add(pnRelatorioRight, BorderLayout.EAST);
		
		btnRelatorio = new JButton("Relatório");
		btnRelatorio.setBackground(Color.PINK);
		pnRelatorioRight.add(btnRelatorio);
		
		pnRelatorioBottom = new JPanel();
		pnListExerciciosBottom.add(pnRelatorioBottom, BorderLayout.SOUTH);
		
		
	}
}

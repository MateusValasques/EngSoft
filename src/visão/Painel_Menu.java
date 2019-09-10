package visão;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Painel_Menu extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmCadastrarFuncionrio;
	private JMenuItem mntmCadastrarFornecedor;
	private JMenuItem mntmCadastrarCliente;
	private JMenuItem mntmCadastrarProduto;

	public Painel_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getMenuBar_1());
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			ImageIcon imagem = new ImageIcon(getClass().getResource("/Imagens/Foto_Menu.PNG")); 
			lblNewLabel = new JLabel(imagem);
			lblNewLabel.setBounds(106, 88, 509, 409);
		}
		return lblNewLabel;
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(new Color(153, 255, 204));
			menuBar.setBounds(0, 0, 134, 50);
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	public JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Op\u00E7\u00F5es de cadastro");
			mnNewMenu.add(getMntmCadastrarFuncionrio());
			mnNewMenu.add(getMntmCadastrarFornecedor());
			mnNewMenu.add(getMntmCadastrarCliente());
			mnNewMenu.add(getMntmCadastrarProduto());
		}
		return mnNewMenu;
	}
	public JMenuItem getMntmCadastrarFuncionrio() {
		if (mntmCadastrarFuncionrio == null) {
			mntmCadastrarFuncionrio = new JMenuItem("Cadastrar funcion\u00E1rio");
		}
		return mntmCadastrarFuncionrio;
	}
	public JMenuItem getMntmCadastrarFornecedor() {
		if (mntmCadastrarFornecedor == null) {
			mntmCadastrarFornecedor = new JMenuItem("Cadastrar fornecedor");
		}
		return mntmCadastrarFornecedor;
	}
	public JMenuItem getMntmCadastrarCliente() {
		if (mntmCadastrarCliente == null) {
			mntmCadastrarCliente = new JMenuItem("Cadastrar cliente");
		}
		return mntmCadastrarCliente;
	}
	public JMenuItem getMntmCadastrarProduto() {
		if (mntmCadastrarProduto == null) {
			mntmCadastrarProduto = new JMenuItem("Cadastrar produto");
		}
		return mntmCadastrarProduto;
	}
}

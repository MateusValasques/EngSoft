package visão;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JList;

public class PainelPagamentoConta extends JFrame {

	private JPanel contentPane;
	private JLabel lblPagamentoConta;
	private JButton btnNewButton;
	private JSeparator separator;
	private JLabel lblNome;
	private JTextField textField;
	private JLabel lblCpfcnpj;
	private JTextField textField_1;
	private JSeparator separator_1;
	private JLabel lblProdutosComprados;
	private JLabel lblProdutosAPagar;
	private JList listComprados;
	private JList listPagar;
	private JButton btnSelecionaPagar_1;
	private JButton btnSelecionaPagarTudo;
	private JButton btnTiraPagamentoTodos;
	private JButton btnTiraPagamento1;
	private JButton btnConfirmar;
	private JButton btnCancelar;

	
	public PainelPagamentoConta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setLayout(null);
		contentPane.add(getLblPagamentoConta());
		contentPane.add(getBtnNewButton());
		contentPane.add(getSeparator());
		contentPane.add(getLblNome());
		contentPane.add(getTextField());
		contentPane.add(getLblCpfcnpj());
		contentPane.add(getTextField_1());
		contentPane.add(getSeparator_1());
		contentPane.add(getLblProdutosComprados());
		contentPane.add(getLblProdutosAPagar());
		contentPane.add(getListComprados());
		contentPane.add(getListPagar());
		contentPane.add(getBtnSelecionaPagar_1());
		contentPane.add(getBtnSelecionaPagarTudo());
		contentPane.add(getBtnTiraPagamentoTodos());
		contentPane.add(getBtnTiraPagamento1());
		contentPane.add(getButton_4());
		contentPane.add(getButton_5());
	}
	public JLabel getLblPagamentoConta() {
		if (lblPagamentoConta == null) {
			lblPagamentoConta = new JLabel("Pagamento Conta");
			lblPagamentoConta.setFont(new Font("Tahoma", Font.ITALIC, 24));
			lblPagamentoConta.setBounds(0, 0, 225, 29);
		}
		return lblPagamentoConta;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Escolher Cliente");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton.setBounds(10, 55, 109, 45);
		}
		return btnNewButton;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(-14, 29, 215, 18);
		}
		return separator;
	}
	public JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome");
			lblNome.setBounds(10, 111, 46, 14);
		}
		return lblNome;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(10, 130, 258, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	public JLabel getLblCpfcnpj() {
		if (lblCpfcnpj == null) {
			lblCpfcnpj = new JLabel("CPF/CNPJ");
			lblCpfcnpj.setBounds(333, 111, 226, 14);
		}
		return lblCpfcnpj;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(333, 130, 120, 20);
		}
		return textField_1;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 157, 559, 2);
		}
		return separator_1;
	}
	public JLabel getLblProdutosComprados() {
		if (lblProdutosComprados == null) {
			lblProdutosComprados = new JLabel("Produtos comprados");
			lblProdutosComprados.setBounds(58, 161, 109, 14);
		}
		return lblProdutosComprados;
	}
	public JLabel getLblProdutosAPagar() {
		if (lblProdutosAPagar == null) {
			lblProdutosAPagar = new JLabel("Produtos a pagar");
			lblProdutosAPagar.setBounds(410, 161, 109, 14);
		}
		return lblProdutosAPagar;
	}
	public JList getListComprados() {
		if (listComprados == null) {
			listComprados = new JList();
			listComprados.setBounds(10, 186, 204, 328);
		}
		return listComprados;
	}
	public JList getListPagar() {
		if (listPagar == null) {
			listPagar = new JList();
			listPagar.setBounds(346, 186, 204, 328);
		}
		return listPagar;
	}
	public JButton getBtnSelecionaPagar_1() {
		if (btnSelecionaPagar_1 == null) {
			btnSelecionaPagar_1 = new JButton(">");
			btnSelecionaPagar_1.setBounds(236, 219, 89, 23);
		}
		return btnSelecionaPagar_1;
	}
	public JButton getBtnSelecionaPagarTudo() {
		if (btnSelecionaPagarTudo == null) {
			btnSelecionaPagarTudo = new JButton(">>>");
			btnSelecionaPagarTudo.setBounds(236, 250, 89, 23);
		}
		return btnSelecionaPagarTudo;
	}
	public JButton getBtnTiraPagamentoTodos() {
		if (btnTiraPagamentoTodos == null) {
			btnTiraPagamentoTodos = new JButton("<<<");
			btnTiraPagamentoTodos.setBounds(236, 453, 89, 23);
		}
		return btnTiraPagamentoTodos;
	}
	public JButton getBtnTiraPagamento1() {
		if (btnTiraPagamento1 == null) {
			btnTiraPagamento1 = new JButton("<");
			btnTiraPagamento1.setBounds(236, 422, 89, 23);
		}
		return btnTiraPagamento1;
	}
	public JButton getButton_4() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setBounds(461, 527, 89, 23);
		}
		return btnConfirmar;
	}
	public JButton getButton_5() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(364, 527, 89, 23);
		}
		return btnCancelar;
	}
}

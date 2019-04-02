package visão;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.List;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;

public class PainelSelecionaFornecedor extends JFrame {

	private JPanel contentPane;
	private JLabel lblBuscaCliente;
	private JFormattedTextField txtPesquisa;
	private JComboBox cbxTipoPesquisa;
	private List list;
	private JButton btnPesquisar;
	private Button btnConfirmar;
	private Button btnCancelar;
	private JSeparator separator;

	
	public PainelSelecionaFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(153, 255, 204));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblBuscaCliente());
		contentPane.add(getTxtPesquisa());
		contentPane.add(getCbxTipoPesquisa());
		contentPane.add(getList());
		contentPane.add(getBtnPesquisar());
		contentPane.add(getBtnConfirmar());
		contentPane.add(getBtnCancelar());
		contentPane.add(getSeparator());
	}

	public JLabel getLblBuscaCliente() {
		if (lblBuscaCliente == null) {
			lblBuscaCliente = new JLabel("Busca Fornecedor");
			lblBuscaCliente.setFont(new Font("Tahoma", Font.ITALIC, 24));
			lblBuscaCliente.setBounds(0, 0, 223, 29);
		}
		return lblBuscaCliente;
	}
	public JFormattedTextField getTxtPesquisa() {
		if (txtPesquisa == null) {
			txtPesquisa = new JFormattedTextField();
			txtPesquisa.setColumns(10);
			txtPesquisa.setBounds(115, 47, 310, 20);
		}
		return txtPesquisa;
	}
	public JComboBox getCbxTipoPesquisa() {
		if (cbxTipoPesquisa == null) {
			cbxTipoPesquisa = new JComboBox();
			cbxTipoPesquisa.addItem("-Selecione-");
			cbxTipoPesquisa.addItem("CPF");
			cbxTipoPesquisa.addItem("CNPJ");
			cbxTipoPesquisa.addItem("NOME");
			cbxTipoPesquisa.setBounds(10, 46, 98, 22);
		}
		return cbxTipoPesquisa;
	}
	public List getList() {
		if (list == null) {
			list = new List();
			list.setBounds(10, 77, 537, 134);
		}
		return list;
	}
	public JButton getBtnPesquisar() {
		if (btnPesquisar == null) {
			btnPesquisar = new JButton("Pesquisar");
			btnPesquisar.setBounds(435, 46, 112, 23);
		}
		return btnPesquisar;
	}
	public Button getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new Button("Confirmar");
			btnConfirmar.setBounds(340, 229, 70, 22);
		}
		return btnConfirmar;
	}
	public Button getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new Button("Cancelar");
			btnCancelar.setBounds(449, 229, 70, 22);
		}
		return btnCancelar;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(0, 27, 196, 2);
		}
		return separator;
	}
}

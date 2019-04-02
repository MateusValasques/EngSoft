package visão;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.List;
import javax.swing.JComboBox;
import java.awt.Button;
import javax.swing.JSeparator;

public class PainelBuscaProduto extends JFrame {

	private JPanel contentPane;
	private List list;
	private JComboBox cbxTipoPesquisa;
	private JFormattedTextField txtPesquisa;
	private Button btnCancelar;
	private Button btnConfirmar;
	private JLabel lblBuscaProduto;
	private JSeparator separator;
	private JFormattedTextField txtQuantidade;
	private JFormattedTextField txtValorCompra;
	private JLabel lblQuantidade;
	private JLabel lblValorDeCompra;


	public PainelBuscaProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getList());
		contentPane.add(getCbxTipoPesquisa());
		contentPane.add(getTxtPesquisa());
		contentPane.add(getBtnCancelar());
		contentPane.add(getBtnConfirmar());
		contentPane.add(getLblBuscaProduto());
		contentPane.add(getSeparator());
		contentPane.add(getTxtQuantidade());
		contentPane.add(getTxtValorCompra());
		contentPane.add(getLblQuantidade());
		contentPane.add(getLblValorDeCompra());
	}
	public List getList() {
		if (list == null) {
			list = new List();
			list.setBounds(10, 87, 597, 134);
		}
		return list;
	}
	public JComboBox getCbxTipoPesquisa() {
		if (cbxTipoPesquisa == null) {
			cbxTipoPesquisa = new JComboBox();
			cbxTipoPesquisa.addItem("-SELECIONE-");
			cbxTipoPesquisa.addItem("NOME");
			cbxTipoPesquisa.addItem("CÓDIGO");
			
		

			cbxTipoPesquisa.setBounds(10, 56, 98, 22);
		}
		return cbxTipoPesquisa;
	}
	public JFormattedTextField getTxtPesquisa() {
		if (txtPesquisa == null) {
			txtPesquisa = new JFormattedTextField();
			txtPesquisa.setColumns(10);
			txtPesquisa.setBounds(115, 57, 232, 20);
		}
		return txtPesquisa;
	}
	public Button getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new Button("Cancelar");
			btnCancelar.setBounds(537, 227, 70, 22);
		}
		return btnCancelar;
	}
	public Button getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new Button("Confirmar");
			btnConfirmar.setBounds(428, 227, 70, 22);
		}
		return btnConfirmar;
	}
	public JLabel getLblBuscaProduto() {
		if (lblBuscaProduto == null) {
			lblBuscaProduto = new JLabel("Busca Produto");
			lblBuscaProduto.setFont(new Font("Tahoma", Font.ITALIC, 24));
			lblBuscaProduto.setBounds(0, 0, 223, 29);
		}
		return lblBuscaProduto;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(0, 27, 163, 2);
		}
		return separator;
	}
	public JFormattedTextField getTxtQuantidade() {
		if (txtQuantidade == null) {
			txtQuantidade = new JFormattedTextField();
			txtQuantidade.setColumns(10);
			txtQuantidade.setBounds(357, 57, 120, 20);
		}
		return txtQuantidade;
	}
	public JFormattedTextField getTxtValorCompra() {
		if (txtValorCompra == null) {
			txtValorCompra = new JFormattedTextField();
			txtValorCompra.setColumns(10);
			txtValorCompra.setBounds(487, 57, 120, 20);
		}
		return txtValorCompra;
	}
	public JLabel getLblQuantidade() {
		if (lblQuantidade == null) {
			lblQuantidade = new JLabel("Quantidade");
			lblQuantidade.setBounds(357, 43, 70, 14);
		}
		return lblQuantidade;
	}
	public JLabel getLblValorDeCompra() {
		if (lblValorDeCompra == null) {
			lblValorDeCompra = new JLabel("Valor de Compra");
			lblValorDeCompra.setBounds(487, 43, 106, 14);
		}
		return lblValorDeCompra;
	}
}

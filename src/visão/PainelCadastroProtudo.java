package visão;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.FormataMascaras;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class PainelCadastroProtudo extends JFrame {

	private JPanel contentPane;
	private JLabel lblCadastroProduto;
	private JSeparator separator;
	private JFormattedTextField txtDescricao;
	private JLabel lblDescricao;
	private JLabel lblCdigo;
	private JFormattedTextField txtCodigo;
	private JFormattedTextField txtCodigoDeBarras;
	private JLabel lblCodigoDeBarras;
	private JFormattedTextField txtEstoqueMinimo;
	private JLabel lblEstoqueMinimo;
	private JFormattedTextField txtEstoqueMaximo;
	private JLabel lblEstoqueMximo;
	private JFormattedTextField txtQuantidade;
	private JLabel lblQuantidade;
	private JComboBox cbxUnidade;
	private JLabel lblUnidade;
	private JButton btnExcluirUnidade;
	private JButton btnInserirUnidade;
	private JButton btnAlterarUnidade;
	private JButton btnExcluirTipo;
	private JButton btnAlterarTipo;
	private JButton btnInserirTipo;
	private JComboBox cbxTipo;
	private JLabel lblTipo;
	private JFormattedTextField txtLucro;
	private JLabel lblLucro;
	private JFormattedTextField txtValorDeVenda;
	private JLabel lblValorDeVenda;
	private JFormattedTextField txtValorDeCompra;
	private JLabel lblValorDeCompra;
	private JSeparator separator_1;
	private JLabel lblPesquisar;
	
	private JTable tabela;
	private JScrollPane scrollPane;
	private DefaultTableModel defaultTableModel;
	private JButton btnCancelar;
	private JButton btnConfirmarAlteracao;
	private JButton btnAlterar;
	private JButton btnInserir;
	private JButton btnExcluir;
	private JButton btnConfirmarInclusao;
	private JButton btnConfirmarExclusao;
	
	private JButton btnPesquisaCodigoBarra;
	private JButton btnPesquisaCodigo;
	private JButton btnPesquisaNome;
	
	private JFormattedTextField txtPesquisaNome;
	private JFormattedTextField txtPesquisaCodigo;
	private JFormattedTextField txtPesquisaCodigoBarra;
	
	private JComboBox cbxTipoPesquisa;

	FormataMascaras fm = new FormataMascaras();
	
	public PainelCadastroProtudo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 564);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblCadastroProduto());
		contentPane.add(getSeparator());
		contentPane.add(getTxtDescricao());
		contentPane.add(getLblDescricao());
		contentPane.add(getLblCdigo());
		contentPane.add(getTxtCodigo());
		contentPane.add(getTxtCodigoDeBarras());
		contentPane.add(getLblCodigoDeBarras());
		contentPane.add(getTxtEstoqueMinimo());
		contentPane.add(getLblEstoqueMinimo());
		contentPane.add(getTxtEstoqueMaximo());
		contentPane.add(getLblEstoqueMximo());
		contentPane.add(getTxtQuantidade());
		contentPane.add(getLabel_1());
		contentPane.add(getCbxUnidade());
		contentPane.add(getLabel_2());
		contentPane.add(getBtnExcluirUnidade());
		contentPane.add(getBtnInserirUnidade());
		contentPane.add(getBtnAlterarUnidade());
		contentPane.add(getBtnExcluirTipo());
		contentPane.add(getBtnAlterarTipo());
		contentPane.add(getBtnInserirTipo());
		contentPane.add(getCbxTipo());
		contentPane.add(getLblTipo());
		contentPane.add(getTxtLucro());
		contentPane.add(getLabel_1_1());
		contentPane.add(getTxtValorDeVenda());
		contentPane.add(getLabel_2_1());
		contentPane.add(getTxtValorDeCompra());
		contentPane.add(getLblValorDeCompra());
		contentPane.add(getSeparator_1());
		contentPane.add(getLblPesquisar());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnCancelar());
		contentPane.add(getBtnConfirmarAlteracao());
		contentPane.add(getBtnAlterar());
		contentPane.add(getBtnInserir());
		contentPane.add(getBtnExcluir());
		contentPane.add(getBtnConfirmarInclusao());
		contentPane.add(getBtnConfirmarExclusao());
		
		
		contentPane.add(getTxtPesquisaCodigo());
		contentPane.add(getTxtPesquisaNome());
		contentPane.add(getCbxTipoPesquisa());
		contentPane.add(getTxtPesquisaCodigo());
		
		
		contentPane.add(getBtnPesquisaCodigoBarras());
		contentPane.add(getBtnPesquisaCodigo());
		contentPane.add(getBtnPesquisaNome());
		
	}
	public JLabel getLblCadastroProduto() {
		if (lblCadastroProduto == null) {
			lblCadastroProduto = new JLabel("Cadastro Produto");
			lblCadastroProduto.setBounds(0, 0, 210, 29);
			lblCadastroProduto.setFont(new Font("Tahoma", Font.ITALIC, 24));
		}
		return lblCadastroProduto;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(0, 27, 197, 2);
		}
		return separator;
	}
	public JFormattedTextField getTxtDescricao() {
		if (txtDescricao == null) {
			txtDescricao = new JFormattedTextField();
			txtDescricao.setEnabled(false);
			txtDescricao.setBounds(164, 60, 271, 20);
		}
		return txtDescricao;
	}
	public JLabel getLblDescricao() {
		if (lblDescricao == null) {
			lblDescricao = new JLabel("Descri\u00E7\u00E3o");
			lblDescricao.setBounds(164, 46, 79, 14);
		}
		return lblDescricao;
	}
	public JLabel getLblCdigo() {
		if (lblCdigo == null) {
			lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setBounds(10, 46, 46, 14);
		}
		return lblCdigo;
	}
	public JFormattedTextField getTxtCodigo() {
		if (txtCodigo == null) {
			txtCodigo = new JFormattedTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(10, 60, 123, 20);
		}
		return txtCodigo;
	}
	public JFormattedTextField getTxtCodigoDeBarras() {
		if (txtCodigoDeBarras == null) {
			txtCodigoDeBarras = new JFormattedTextField();
			txtCodigoDeBarras.setEnabled(false);
			txtCodigoDeBarras.setBounds(467, 60, 123, 20);
		}
		return txtCodigoDeBarras;
	}
	public JLabel getLblCodigoDeBarras() {
		if (lblCodigoDeBarras == null) {
			lblCodigoDeBarras = new JLabel("C\u00F3digo de Barras");
			lblCodigoDeBarras.setBounds(467, 46, 107, 14);
		}
		return lblCodigoDeBarras;
	}
	public JFormattedTextField getTxtEstoqueMinimo() {
		if (txtEstoqueMinimo == null) {
			txtEstoqueMinimo = new JFormattedTextField();
			txtEstoqueMinimo.setEnabled(false);
			txtEstoqueMinimo.setBounds(10, 128, 123, 20);
		}
		return txtEstoqueMinimo;
	}
	public JLabel getLblEstoqueMinimo() {
		if (lblEstoqueMinimo == null) {
			lblEstoqueMinimo = new JLabel("Estoque M\u00EDnimo");
			lblEstoqueMinimo.setBounds(10, 114, 101, 14);
		}
		return lblEstoqueMinimo;
	}
	public JFormattedTextField getTxtEstoqueMaximo() {
		if (txtEstoqueMaximo == null) {
			txtEstoqueMaximo = new JFormattedTextField();
			txtEstoqueMaximo.setEnabled(false);
			txtEstoqueMaximo.setBounds(164, 128, 123, 20);
		}
		return txtEstoqueMaximo;
	}
	public JLabel getLblEstoqueMximo() {
		if (lblEstoqueMximo == null) {
			lblEstoqueMximo = new JLabel("Estoque M\u00E1ximo");
			lblEstoqueMximo.setBounds(164, 114, 101, 14);
		}
		return lblEstoqueMximo;
	}
	public JFormattedTextField getTxtQuantidade() {
		if (txtQuantidade == null) {
			txtQuantidade = new JFormattedTextField();
			txtQuantidade.setEnabled(false);
			txtQuantidade.setBounds(314, 128, 121, 20);
		}
		return txtQuantidade;
	}
	public JLabel getLabel_1() {
		if (lblQuantidade == null) {
			lblQuantidade = new JLabel("Quantidade");
			lblQuantidade.setBounds(314, 114, 101, 14);
		}
		return lblQuantidade;
	}
	public JComboBox getCbxUnidade() {
		if (cbxUnidade == null) {
			cbxUnidade = new JComboBox();
			cbxUnidade.setEnabled(false);
			cbxUnidade.setModel(new DefaultComboBoxModel(new String[] {"-Selecione-"}));
			cbxUnidade.setBounds(467, 127, 123, 22);
		}
		return cbxUnidade;
	}
	public JLabel getLabel_2() {
		if (lblUnidade == null) {
			lblUnidade = new JLabel("Unidade");
			lblUnidade.setBounds(467, 114, 101, 14);
		}
		return lblUnidade;
	}
	public JButton getBtnExcluirUnidade() {
		if (btnExcluirUnidade == null) {
			btnExcluirUnidade = new JButton("X");
			btnExcluirUnidade.setEnabled(false);
			btnExcluirUnidade.setToolTipText("Excluir");
			btnExcluirUnidade.setBounds(689, 130, 42, 18);
		}
		return btnExcluirUnidade;
	}
	public JButton getBtnInserirUnidade() {
		if (btnInserirUnidade == null) {
			btnInserirUnidade = new JButton("I");
			btnInserirUnidade.setEnabled(false);
			btnInserirUnidade.setToolTipText("Inserir");
			btnInserirUnidade.setBounds(600, 130, 42, 18);
		}
		return btnInserirUnidade;
	}
	public JButton getBtnAlterarUnidade() {
		if (btnAlterarUnidade == null) {
			btnAlterarUnidade = new JButton("A");
			btnAlterarUnidade.setEnabled(false);
			btnAlterarUnidade.setToolTipText("Alterar");
			btnAlterarUnidade.setBounds(645, 130, 42, 18);
		}
		return btnAlterarUnidade;
	}
	public JButton getBtnExcluirTipo() {
		if (btnExcluirTipo == null) {
			btnExcluirTipo = new JButton("X");
			btnExcluirTipo.setEnabled(false);
			btnExcluirTipo.setToolTipText("Excluir");
			btnExcluirTipo.setBounds(689, 206, 42, 18);
		}
		return btnExcluirTipo;
	}
	public JButton getBtnAlterarTipo() {
		if (btnAlterarTipo == null) {
			btnAlterarTipo = new JButton("A");
			btnAlterarTipo.setEnabled(false);
			btnAlterarTipo.setToolTipText("Alterar");
			btnAlterarTipo.setBounds(645, 206, 42, 18);
		}
		return btnAlterarTipo;
	}
	public JButton getBtnInserirTipo() {
		if (btnInserirTipo == null) {
			btnInserirTipo = new JButton("I");
			btnInserirTipo.setEnabled(false);
			btnInserirTipo.setToolTipText("Inserir");
			btnInserirTipo.setBounds(600, 206, 42, 18);
		}
		return btnInserirTipo;
	}
	public JComboBox getCbxTipo() {
		if (cbxTipo == null) {
			cbxTipo = new JComboBox();
			cbxTipo.setEnabled(false);
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"-Selecione-"}));
			cbxTipo.setBounds(467, 203, 123, 22);
		}
		return cbxTipo;
	}
	public JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo");
			lblTipo.setBounds(467, 190, 101, 14);
		}
		return lblTipo;
	}
	public JFormattedTextField getTxtLucro() {
		if (txtLucro == null) {
			txtLucro = new JFormattedTextField();
			txtLucro.setEnabled(false);
			txtLucro.setBounds(314, 204, 121, 20);
		}
		return txtLucro;
	}
	public JLabel getLabel_1_1() {
		if (lblLucro == null) {
			lblLucro = new JLabel("Lucro (%)");
			lblLucro.setBounds(314, 190, 101, 14);
		}
		return lblLucro;
	}
	public JFormattedTextField getTxtValorDeVenda() {
		if (txtValorDeVenda == null) {
			txtValorDeVenda = new JFormattedTextField(fm.getDinheiro());
			txtValorDeVenda.setEnabled(false);
			txtValorDeVenda.setBounds(164, 204, 123, 20);
		}
		return txtValorDeVenda;
	}
	public JLabel getLabel_2_1() {
		if (lblValorDeVenda == null) {
			lblValorDeVenda = new JLabel("Valor de Venda");
			lblValorDeVenda.setBounds(164, 190, 101, 14);
		}
		return lblValorDeVenda;
	}
	public JFormattedTextField getTxtValorDeCompra() {
		if (txtValorDeCompra == null) {
			txtValorDeCompra = new JFormattedTextField(fm.getDinheiro());
			txtValorDeCompra.setEnabled(false);
			txtValorDeCompra.setBounds(10, 204, 123, 20);
		}
		return txtValorDeCompra;
	}
	public JLabel getLblValorDeCompra() {
		if (lblValorDeCompra == null) {
			lblValorDeCompra = new JLabel("Valor de Compra");
			lblValorDeCompra.setBounds(10, 190, 123, 14);
		}
		return lblValorDeCompra;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 250, 728, 2);
		}
		return separator_1;
	}
	public JLabel getLblPesquisar() {
		if (lblPesquisar == null) {
			lblPesquisar = new JLabel("Pesquisar");
			lblPesquisar.setBounds(1, 250, 98, 14);
		}
		return lblPesquisar;
	}
	public JTable getTabela() {
		if (tabela == null) {
			tabela = new JTable(getDefaultTableModel());
			tabela.getTableHeader().setReorderingAllowed(false);
			tabela.getColumnModel().getColumn(0).setPreferredWidth(110);
			tabela.getColumnModel().getColumn(1).setPreferredWidth(188);
			tabela.getColumnModel().getColumn(2).setPreferredWidth(82);
		}
		return tabela;
	}
	
	public DefaultTableModel getDefaultTableModel() {
		if (defaultTableModel == null) {
			defaultTableModel = new DefaultTableModel(new Object[][] {},
					new String[] { "ID", "Nome", "Codigo de Barras" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModel;
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(74, 316, 591, 137);
			scrollPane.setViewportView(getTabela());
		}
		return scrollPane;
	}
	public JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(600, 491, 89, 23);
		}
		return btnCancelar;
	}
	public JButton getBtnConfirmarAlteracao() {
		if (btnConfirmarAlteracao == null) {
			btnConfirmarAlteracao = new JButton("Confirmar");
			btnConfirmarAlteracao.setEnabled(false);
			btnConfirmarAlteracao.setBounds(490, 491, 100, 23);
		}
		return btnConfirmarAlteracao;
	}
	public JButton getBtnAlterar() {
		if (btnAlterar == null) {
			btnAlterar = new JButton("Alterar");
			btnAlterar.setBounds(154, 491, 89, 23);
		}
		return btnAlterar;
	}
	public JButton getBtnInserir() {
		if (btnInserir == null) {
			btnInserir = new JButton("Inserir");
			btnInserir.setBounds(37, 491, 89, 23);
		}
		return btnInserir;
	}
	public JButton getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new JButton("Excluir");
			btnExcluir.setBounds(267, 491, 89, 23);
		}
		return btnExcluir;
	}
	public JButton getBtnConfirmarInclusao() {
		if (btnConfirmarInclusao == null) {
			btnConfirmarInclusao = new JButton("Confirmar");
			btnConfirmarInclusao.setEnabled(false);
			btnConfirmarInclusao.setToolTipText("Confirmar inclus\u00E3o");
			btnConfirmarInclusao.setBounds(490, 491, 100, 23);
		}
		return btnConfirmarInclusao;
	}
	public JButton getBtnConfirmarExclusao() {
		if (btnConfirmarExclusao == null) {
			btnConfirmarExclusao = new JButton("Confirmar");
			btnConfirmarExclusao.setEnabled(false);
			btnConfirmarExclusao.setBounds(490, 491, 89, 23);
		}
		return btnConfirmarExclusao;
	}
	
	public JComboBox getCbxTipoPesquisa() {
		if (cbxTipoPesquisa == null) {
			cbxTipoPesquisa = new JComboBox();
			cbxTipoPesquisa.setModel(
					new DefaultComboBoxModel(new String[] { "-Tipo-", "Descrição", "Código" }));
			cbxTipoPesquisa.setBounds(74, 284, 98, 22);
		}
		return cbxTipoPesquisa;
	}
	
	public JButton getBtnPesquisaCodigoBarras() {
		if (btnPesquisaCodigoBarra == null) {
			btnPesquisaCodigoBarra = new JButton("Pesquisar");
			btnPesquisaCodigoBarra.setToolTipText("Pesquisa C\u00F3digo de barras");
			btnPesquisaCodigoBarra.setBounds(553, 282, 112, 23);
			btnPesquisaCodigoBarra.setVisible(false);
		}
		return btnPesquisaCodigoBarra;
	}

	public JButton getBtnPesquisaCodigo() {
		if (btnPesquisaCodigo == null) {
			btnPesquisaCodigo = new JButton("Pesquisar");
			btnPesquisaCodigo.setToolTipText("Pesquisa Codigo");
			btnPesquisaCodigo.setBounds(553, 282, 112, 23);
			btnPesquisaCodigo.setVisible(false);
		}
		return btnPesquisaCodigo;
	}

	public JButton getBtnPesquisaNome() {
		if (btnPesquisaNome == null) {
			btnPesquisaNome = new JButton("Pesquisar");
			btnPesquisaNome.setBounds(553, 282, 112, 23);
			btnPesquisaNome.setToolTipText("Pesquisa Nome");
			btnPesquisaNome.setVisible(false);
		}
		return btnPesquisaNome;
	}
	
	public JFormattedTextField getTxtPesquisaCodigoBarra() {
		if (txtPesquisaCodigoBarra == null) {
			txtPesquisaCodigoBarra = new JFormattedTextField(fm.getCnpj());
			txtPesquisaCodigoBarra.setEditable(false);
			txtPesquisaCodigoBarra.setColumns(10);
			txtPesquisaCodigoBarra.setBounds(115, 484, 310, 20);
			txtPesquisaCodigoBarra.setVisible(false);
			txtPesquisaCodigoBarra.setToolTipText("Pesquisa codigo de barras");

		}
		return txtPesquisaCodigoBarra;
	}

	public JFormattedTextField getTxtPesquisaCodigo() {
		if (txtPesquisaCodigo == null) {
			txtPesquisaCodigo = new JFormattedTextField();
			txtPesquisaCodigo.setToolTipText("Pesquisa C\u00F3digo");
			txtPesquisaCodigo.setColumns(10);
			txtPesquisaCodigo.setBounds(209, 285, 310, 20);
			txtPesquisaCodigo.setVisible(false);
		}
		return txtPesquisaCodigo;
	}
	
	public JFormattedTextField getTxtPesquisaNome() {
		if (txtPesquisaNome == null) {
			txtPesquisaNome = new JFormattedTextField(fm.getNome());
			txtPesquisaNome.setToolTipText("Pesquisa Nome");
			txtPesquisaNome.setColumns(10);
			txtPesquisaNome.setBounds(209, 285, 310, 20);
		}
		return txtPesquisaNome;
	}

}

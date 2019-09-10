package visão;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controle.FormataMascaras;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class PainelCadastroCliente extends JFrame {
	public static void main(String[] args) {
		PainelCadastroCliente painelCadastroCliente = new PainelCadastroCliente();
		painelCadastroCliente.setVisible(true);
	}
	private JPanel contentPane;
	private JLabel lblCadastroCliente;
	private JFormattedTextField txtCodigo;
	private JLabel lblCodigo;
	private JComboBox cbxTipo;
	private JLabel lblTipo;
	private JFormattedTextField txtCpf;
	private JLabel lblCpfcnpj;
	private JFormattedTextField txtNome;
	private JLabel lblNome;
	private JSeparator separator;
	private JFormattedTextField txtCep;
	private JLabel lblCep;
	private JLabel lblEndereo;
	private JLabel lblDadosPessoais;
	private JSeparator separator_1;
	private JFormattedTextField txtRua;
	private JLabel lblRua;
	private JFormattedTextField txtBairro;
	private JLabel lblBairro;
	private JFormattedTextField txtCidade;
	private JLabel lblCidade;
	private JLabel lblUf;
	private JFormattedTextField txtNumero;
	private JLabel Número;
	private JComboBox cbxUf;
	private JSeparator separator_2;
	private JLabel C;
	private JFormattedTextField txtTelefone;
	private JLabel lblTelefone;
	private JFormattedTextField txtCelular;
	private JLabel lblCelular;
	private JFormattedTextField txtEmail;
	private JLabel lblEmail;
	private JSeparator separator_3;
	private JFormattedTextField txtPesquisaNome;
	private JLabel Pesquisar;
	private JComboBox cbxTipoPesquisa;
	private Button btnInserir;
	private Button btnAlterar;
	private Button btnExcluir;
	private Button btnConfirmarInclusao;
	private Button btnCancelar;
	private JFormattedTextField txtComplemento;
	private JLabel lblComplemento;
	private JLabel lblCredito;
	private JFormattedTextField txtLimiteCredito;
	private JRadioButton rbtnAtivo;
	private JRadioButton rbtnNaoAtivo;
	
	private JFormattedTextField txtPesquisaCPF;
	private JFormattedTextField txtPesquisaCNPJ;
	private JFormattedTextField txtPesquisaCodigo;
	
	private JButton btnPesquisaCPF;
	private JButton btnPesquisaCNPJ ;
	private JButton btnPesquisaCodigo;
	private JButton btnPesquisaNome ;
	
	private JFormattedTextField txtCNPJ ;
	private JLabel lblCnpj ;
	private JTable tabela;
	private DefaultTableModel defaultTableModel;
	private JScrollPane scrollPane;
	FormataMascaras fm = new FormataMascaras();
	Validacao_Monetaria vm = new Validacao_Monetaria();
	private Button btnConfirmarAlteracao;
	private Button btnConfirmarExclusao;
	public PainelCadastroCliente(){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 575, 703);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		contentPane.add(getLblCadastroCliente());
		contentPane.add(getTxtCodigo());
		contentPane.add(getLblCodigo());
		contentPane.add(getCbxTipo());
		contentPane.add(getLblTipo());
		contentPane.add(getTxtCpf());
		contentPane.add(getLblCpfcnpj());
		contentPane.add(getTxtNome());
		contentPane.add(getLblNome());
		contentPane.add(getSeparator());
		contentPane.add(getTxtCep());
		contentPane.add(getLblCep());
		contentPane.add(getLblEndereo());
		contentPane.add(getLblDadosPessoais());
		contentPane.add(getSeparator_1());
		contentPane.add(getTxtRua());
		contentPane.add(getLabel_1());
		contentPane.add(getTxtBairro());
		contentPane.add(getLabel_1_1());
		contentPane.add(getTxtCidade());
		contentPane.add(getLblCidade());
		contentPane.add(getLblUf());
		contentPane.add(getTxtNumero());
		contentPane.add(getNúmero());
		contentPane.add(getCbxUf());
		contentPane.add(getSeparator_2());
		contentPane.add(getC());
		contentPane.add(getTxtTelefone());
		contentPane.add(getLblTelefone());
		contentPane.add(getTxtCelular());
		contentPane.add(getLabel_1_2());
		contentPane.add(getTxtEmail());
		contentPane.add(getLblEmail());
		contentPane.add(getSeparator_3());
		contentPane.add(getTxtPesquisaNome());
		contentPane.add(getCbxTipoPesquisa());
		contentPane.add(getBtnInserir());
		contentPane.add(getBtnAlterar());
		contentPane.add(getBtnExcluir());
		contentPane.add(getBtnConfirmarInclusao());
		contentPane.add(getBtnCancelar());
		contentPane.add(getTxtComplemento());
		contentPane.add(getLblComplemento());
		contentPane.add(getLblCredito());
		contentPane.add(getTxtLimiteCredito());
		contentPane.add(getRbtnAtivo());
		contentPane.add(getRbtnNaoAtivo());
		
		
		contentPane.add(getTxtPesquisaCNPJ());
		contentPane.add(getTxtPesquisaCPF());
		contentPane.add(getPesquisaNome());
		contentPane.add(getTxtPesquisaCodigo());
		
		contentPane.add(getBtnPesquisaCNPJ());
		contentPane.add(getBtnPesquisaCodigo());
		contentPane.add(getBtnPesquisaNome());
		contentPane.add(getBtnPesquisaCPF());
		
		contentPane.add(getTxtCNPJ());
		contentPane.add(getLblCnpj());
		
		contentPane.add(getScrollPane());
		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(getRbtnAtivo());
		bg.add(getRbtnNaoAtivo());
		contentPane.add(getBtnConfirmarAlteracao());
		contentPane.add(getBtnConfirmarExclusao());
		
	}
	public JLabel getLblCadastroCliente() {
		if (lblCadastroCliente == null) {
			lblCadastroCliente = new JLabel("Cadastro Cliente");
			lblCadastroCliente.setFont(new Font("Tahoma", Font.ITALIC, 24));
			lblCadastroCliente.setBounds(0, 0, 295, 40);
		}
		return lblCadastroCliente;
	}
	public JFormattedTextField getTxtCodigo() {
		if (txtCodigo == null) {
			txtCodigo = new JFormattedTextField();
			txtCodigo.setBounds(10, 89, 163, 20);
			txtCodigo.setColumns(10);
			txtCodigo.setEnabled(false);
		}
		return txtCodigo;
	}
	public JLabel getLblCodigo() {
		if (lblCodigo == null) {
			lblCodigo = new JLabel("C\u00F3digo");
			lblCodigo.setBounds(10, 72, 46, 14);
		}
		return lblCodigo;
	}
	public JComboBox getCbxTipo() {
		if (cbxTipo == null) {
			cbxTipo = new JComboBox();
			cbxTipo.setEnabled(false);
			cbxTipo.addItem("-Selecione-");
			cbxTipo.addItem("CPF");
			cbxTipo.addItem("CNPJ");
			cbxTipo.setBounds(200, 88, 85, 22);
		}
		return cbxTipo;
	}
	public JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo");
			lblTipo.setBounds(200, 72, 46, 14);
		}
		return lblTipo;
	}
	public JFormattedTextField getTxtCpf(){
		
		if (txtCpf == null) {
			txtCpf = new JFormattedTextField(fm.getCPF());
			txtCpf.setEnabled(false);
			txtCpf.setColumns(10);
			txtCpf.setBounds(336, 89, 163, 20);
		}
		return txtCpf;
	}
	public JLabel getLblCpfcnpj() {
		if (lblCpfcnpj == null) {
			lblCpfcnpj = new JLabel("CPF");
			lblCpfcnpj.setBounds(336, 72, 95, 14);
		}
		return lblCpfcnpj;
	}
	public JFormattedTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JFormattedTextField(fm.getNome());
			txtNome.setEnabled(false);
			txtNome.setColumns(10);
			txtNome.setBounds(10, 128, 335, 20);
		}
		return txtNome;
	}
	public JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome");
			lblNome.setBounds(10, 111, 46, 14);
		}
		return lblNome;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(2, 206, 559, 2);
		}
		return separator;
	}
	public JFormattedTextField getTxtCep() {
		if (txtCep == null) {
			txtCep = new JFormattedTextField(fm.getCep());
			txtCep.setEnabled(false);
			txtCep.setColumns(10);
			txtCep.setBounds(12, 248, 163, 20);
		}
		return txtCep;
	}
	public JLabel getLblCep() {
		if (lblCep == null) {
			lblCep = new JLabel("CEP");
			lblCep.setBounds(12, 231, 46, 14);
		}
		return lblCep;
	}
	public JLabel getLblEndereo() {
		if (lblEndereo == null) {
			lblEndereo = new JLabel("Endere\u00E7o");
			lblEndereo.setBounds(10, 211, 145, 14);
		}
		return lblEndereo;
	}
	public JLabel getLblDadosPessoais() {
		if (lblDadosPessoais == null) {
			lblDadosPessoais = new JLabel("Dados Pessoais");
			lblDadosPessoais.setBounds(10, 51, 145, 14);
		}
		return lblDadosPessoais;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 38, 173, 2);
		}
		return separator_1;
	}
	public JFormattedTextField getTxtRua() {
		if (txtRua == null) {
			txtRua = new JFormattedTextField(fm.getEndereco());
			txtRua.setEnabled(false);
			txtRua.setColumns(10);
			txtRua.setBounds(212, 248, 163, 20);
		}
		return txtRua;
	}
	public JLabel getLabel_1() {
		if (lblRua == null) {
			lblRua = new JLabel("Rua");
			lblRua.setBounds(212, 231, 46, 14);
		}
		return lblRua;
	}
	public JFormattedTextField getTxtBairro() {
		if (txtBairro == null) {
			txtBairro = new JFormattedTextField();
			txtBairro.setEnabled(false);
			txtBairro.setColumns(10);
			txtBairro.setBounds(10, 287, 163, 20);
		}
		return txtBairro;
	}
	public JLabel getLabel_1_1() {
		if (lblBairro == null) {
			lblBairro = new JLabel("Bairro");
			lblBairro.setBounds(12, 270, 46, 14);
		}
		return lblBairro;
	}
	public JFormattedTextField getTxtCidade() {
		if (txtCidade == null) {
			txtCidade = new JFormattedTextField(fm.getEndereco());
			txtCidade.setEnabled(false);
			txtCidade.setColumns(10);
			txtCidade.setBounds(212, 287, 163, 20);
		}
		return txtCidade;
	}
	public JLabel getLblCidade() {
		if (lblCidade == null) {
			lblCidade = new JLabel("Cidade");
			lblCidade.setBounds(212, 270, 46, 14);
		}
		return lblCidade;
	}
	public JLabel getLblUf() {
		if (lblUf == null) {
			lblUf = new JLabel("UF:");
			lblUf.setBounds(420, 270, 46, 14);
		}
		return lblUf;
	}
	public JFormattedTextField getTxtNumero() {
		if (txtNumero == null) {
			txtNumero = new JFormattedTextField(fm.getNumero());
			txtNumero.setEnabled(false);
			txtNumero.setText("00000");
			txtNumero.setColumns(10);
			txtNumero.setBounds(420, 248, 71, 20);
		}
		return txtNumero;
	}
	public JLabel getNúmero() {
		if (Número == null) {
			Número = new JLabel("N\u00FAmero");
			Número.setBounds(420, 231, 71, 14);
		}
		return Número;
	}
	public JComboBox getCbxUf() {
		if (cbxUf == null) {
			cbxUf = new JComboBox();
			cbxUf.setEnabled(false);
			
			cbxUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Selecione-", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO" }));
			
			cbxUf.setBounds(420, 286, 85, 22);
		}
		return cbxUf;
	}
	public JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBounds(-5, 349, 559, 2);
		}
		return separator_2;
	}
	public JLabel getC() {
		if (C == null) {
			C = new JLabel("Contato");
			C.setBounds(10, 360, 145, 14);
		}
		return C;
	}
	
	public JFormattedTextField getTxtTelefone() {
		if (txtTelefone == null) {
			txtTelefone = new JFormattedTextField(fm.gettelefone());
			txtTelefone.setEnabled(false);
			txtTelefone.setColumns(10);
			txtTelefone.setBounds(10, 395, 127, 20);
		}
		return txtTelefone;
	}
	public JLabel getLblTelefone() {
		if (lblTelefone == null) {
			lblTelefone = new JLabel("Telefone");
			lblTelefone.setBounds(10, 378, 46, 14);
		}
		return lblTelefone;
	}
	public JFormattedTextField getTxtCelular() {
		if (txtCelular == null) {
			txtCelular = new JFormattedTextField(fm.getCelular());
			txtCelular.setEnabled(false);
			txtCelular.setColumns(10);
			txtCelular.setBounds(168, 395, 127, 20);
		}
		return txtCelular;
	}
	public JLabel getLabel_1_2() {
		if (lblCelular == null) {
			lblCelular = new JLabel("Celular");
			lblCelular.setBounds(168, 378, 46, 14);
		}
		return lblCelular;
	}
	public JFormattedTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JFormattedTextField();
			txtEmail.setEnabled(false);
			txtEmail.setColumns(10);
			txtEmail.setBounds(315, 395, 204, 20);
		}
		return txtEmail;
	}
	public JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail");
			lblEmail.setBounds(315, 382, 46, 14);
		}
		return lblEmail;
	}
	public JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
			separator_3.setBounds(0, 426, 559, 2);
		}
		return separator_3;
	}
	public JFormattedTextField getTxtPesquisaNome() {
		if (txtPesquisaNome == null) {
			txtPesquisaNome = new JFormattedTextField(fm.getNome());
			txtPesquisaNome.setColumns(10);
			txtPesquisaNome.setBounds(121, 453, 310, 20);
		}
		return txtPesquisaNome;
	}
	public JLabel getPesquisaNome() {
		if (Pesquisar == null) {
			Pesquisar = new JLabel("Pesquisar");
			Pesquisar.setBounds(10, 435, 98, 14);
		}
		return Pesquisar;
	}
	public JComboBox getCbxTipoPesquisa() {
		if (cbxTipoPesquisa == null) {
			cbxTipoPesquisa = new JComboBox();
			cbxTipoPesquisa.setModel(new DefaultComboBoxModel(new String[] {"-Tipo-", "CPF", "CNPJ", "Nome", "C\u00F3digo"}));
			cbxTipoPesquisa.setBounds(10, 452, 98, 22);
		}
		return cbxTipoPesquisa;
	}
	public Button getBtnInserir() {
		if (btnInserir == null) {
			btnInserir = new Button("Inserir");
			btnInserir.setBounds(14, 635, 70, 22);
		}
		return btnInserir;
	}
	public Button getBtnAlterar() {
		if (btnAlterar == null) {
			btnAlterar = new Button("Alterar");
			btnAlterar.setEnabled(false);
			btnAlterar.setBounds(119, 635, 70, 22);
		}
		return btnAlterar;
	}
	public Button getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new Button("Excluir");
			btnExcluir.setEnabled(false);
			btnExcluir.setBounds(230, 635, 70, 22);
		}
		return btnExcluir;
	}
	public Button getBtnConfirmarInclusao() {
		if (btnConfirmarInclusao == null) {
			btnConfirmarInclusao = new Button("Confirmar");
			btnConfirmarInclusao.setEnabled(false);
			btnConfirmarInclusao.setBounds(361, 635, 70, 22);
		}
		return btnConfirmarInclusao;
	}
	public Button getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new Button("Cancelar");
			btnCancelar.setBounds(449, 635, 70, 22);
		}
		return btnCancelar;
	}
	public JFormattedTextField getTxtComplemento() {
		if (txtComplemento == null) {
			txtComplemento = new JFormattedTextField();
			txtComplemento.setEnabled(false);
			txtComplemento.setColumns(10);
			txtComplemento.setBounds(10, 325, 365, 20);
			
		}
		return txtComplemento;
	}
	public JLabel getLblComplemento() {
		if (lblComplemento == null) {
			lblComplemento = new JLabel("Complemento");
			lblComplemento.setBounds(10, 309, 142, 14);
		}
		return lblComplemento;
	}
	public JLabel getLblCredito() {
		if (lblCredito == null) {
			lblCredito = new JLabel("Limite de cr\u00E9dito");
			lblCredito.setBounds(10, 159, 163, 14);
		}
		return lblCredito;
	}
	public JFormattedTextField getTxtLimiteCredito() {
		if (txtLimiteCredito == null) {
			txtLimiteCredito = new JFormattedTextField(fm.getDinheiro());
			txtLimiteCredito.setEnabled(false);
			txtLimiteCredito.setColumns(10);
			txtLimiteCredito.setBounds(10, 175, 163, 20);
		}
		return txtLimiteCredito;
	}
	public JRadioButton getRbtnAtivo() {
		if (rbtnAtivo == null) {
			rbtnAtivo = new JRadioButton("Ativo");
			rbtnAtivo.setEnabled(false);
			rbtnAtivo.setBackground(new Color(153, 255, 204));
			rbtnAtivo.setBounds(420, 155, 109, 23);
		}
		return rbtnAtivo;
	}
	public JRadioButton getRbtnNaoAtivo() {
		if (rbtnNaoAtivo == null) {
			rbtnNaoAtivo = new JRadioButton("N\u00E3o Ativo");
			rbtnNaoAtivo.setEnabled(false);
			rbtnNaoAtivo.setBackground(new Color(153, 255, 204));
			rbtnNaoAtivo.setBounds(420, 176, 109, 23);
		}
		return rbtnNaoAtivo;
	}
	
	public JFormattedTextField getTxtPesquisaCPF() {
		if (txtPesquisaCPF  == null) {
			txtPesquisaCPF = new JFormattedTextField(fm.getCPF());
			txtPesquisaCPF.setEditable(false);
			txtPesquisaCPF.setColumns(10);
			txtPesquisaCPF.setBounds(121, 453, 310, 20);
			txtPesquisaCPF.setVisible(false);
		}
		return txtPesquisaCPF;
	}

	public JFormattedTextField getTxtPesquisaCNPJ() {
		if (txtPesquisaCNPJ  == null) {
			txtPesquisaCNPJ = new JFormattedTextField(fm.getCnpj());
			txtPesquisaCNPJ.setEnabled(false);
			txtPesquisaCNPJ.setColumns(10);
			txtPesquisaCNPJ.setBounds(121, 453, 310, 20);
			txtPesquisaCNPJ.setVisible(false);

		}
		return txtPesquisaCNPJ;
	}

	public JFormattedTextField getTxtPesquisaCodigo() {
		if (txtPesquisaCodigo  == null) {
			txtPesquisaCodigo = new JFormattedTextField();
			txtPesquisaCodigo.setColumns(10);
			txtPesquisaCodigo.setBounds(121, 453, 310, 20);
			txtPesquisaCodigo.setVisible(false);
		}
		return txtPesquisaCodigo;
	}

	public JButton getBtnPesquisaCPF() {
		if (btnPesquisaCPF  == null) {
			btnPesquisaCPF = new JButton("Pesquisar CP");
			btnPesquisaCPF.setBounds(435, 452, 112, 23);
			btnPesquisaCPF.setVisible(false);
		}
		return btnPesquisaCPF;
	}

	public JButton getBtnPesquisaCNPJ() {
		if (btnPesquisaCNPJ  == null) {
			btnPesquisaCNPJ = new JButton("Pesquisar CN");
			btnPesquisaCNPJ.setBounds(435, 452, 112, 23);
			btnPesquisaCNPJ.setVisible(false);
		}
		return btnPesquisaCNPJ;
	}

	public JButton getBtnPesquisaCodigo() {
		if (btnPesquisaCodigo == null) {
			btnPesquisaCodigo = new JButton("Pesquisar CO");
			btnPesquisaCodigo.setBounds(435, 452, 112, 23);
			btnPesquisaCodigo.setVisible(false);
		}
		return btnPesquisaCodigo;
	}

	public JButton getBtnPesquisaNome() {
		if (btnPesquisaNome  == null) {
			btnPesquisaNome = new JButton("Pesquisar N");
			btnPesquisaNome.setBounds(435, 452, 112, 23);
			btnPesquisaNome.setVisible(false);
		}
		return btnPesquisaNome;
	}

	public JFormattedTextField getTxtCNPJ() {
		if (txtCNPJ  == null) {
			txtCNPJ = new JFormattedTextField(fm.getCnpj());
			txtCNPJ.setColumns(10);
			txtCNPJ.setBounds(336, 89, 163, 20);
			txtCNPJ.setVisible(false);
		}
		return txtCNPJ;
	}

	public JLabel getLblCnpj() {
		if (lblCnpj  == null) {
			lblCnpj = new JLabel("CNPJ");
			lblCnpj.setBounds(336, 72, 95, 14);
			lblCnpj.setVisible(false);
		}
		return lblCnpj;
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
		if (defaultTableModel  == null) {
			defaultTableModel = new DefaultTableModel(new Object[][] {},
					new String[] { "ID", "Nome", "CPF/CNPJ" }) {
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
			scrollPane.setBounds(10, 484, 537, 137);
			scrollPane.setViewportView(getTabela());
		}
		return scrollPane;
	}

	public Button getBtnConfirmarAlteracao() {
		if (btnConfirmarAlteracao == null) {
			btnConfirmarAlteracao = new Button("Confirmar");
			btnConfirmarAlteracao.setEnabled(false);
			btnConfirmarAlteracao.setBounds(361, 635, 70, 22);
		}
		return btnConfirmarAlteracao;
	}
	public Button getBtnConfirmarExclusao() {
		if (btnConfirmarExclusao == null) {
			btnConfirmarExclusao = new Button("Confirmar");
			btnConfirmarExclusao.setEnabled(false);
			btnConfirmarExclusao.setBounds(361, 635, 70, 22);
		}
		return btnConfirmarExclusao;
	}
}

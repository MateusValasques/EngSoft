package visão;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controle.FormataMascaras;

import javax.swing.JRadioButton;

public class PainelCadastroCliente extends JFrame {
	private JPanel contentPane;
	private JLabel lblCadastroCliente;
	private JFormattedTextField txtCodigo;
	private JLabel lblCodigo;
	private JComboBox cbxTipo;
	private JLabel lblTipo;
	private JFormattedTextField txtCpfCnpj;
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
	private JFormattedTextField txtPesquisa;
	private JLabel Pesquisar;
	private JComboBox cbxTipoPesquisa;
	private List list;
	private Button btnInserir;
	private Button btnAlterar;
	private Button btnExcluir;
	private Button btnConfirmar;
	private Button btnCancelar;
	private JFormattedTextField txtComplemento;
	private JLabel lblComplemento;
	private JLabel lblCredito;
	private JFormattedTextField txtLimiteCredito;
	private JRadioButton rbtnAtivo;
	private JRadioButton rbtnNaoAtivo;
	FormataMascaras fm = new FormataMascaras();
	public PainelCadastroCliente(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		contentPane.add(getTxtCpfCnpj());
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
		contentPane.add(getTxtPesquisa());
		contentPane.add(getPesquisar());
		contentPane.add(getCbxTipoPesquisa());
		contentPane.add(getList());
		contentPane.add(getBtnInserir());
		contentPane.add(getBtnAlterar());
		contentPane.add(getBtnExcluir());
		contentPane.add(getBtnConfirmar());
		contentPane.add(getBtnCancelar());
		contentPane.add(getTxtComplemento());
		contentPane.add(getLblComplemento());
		contentPane.add(getLblCredito());
		contentPane.add(getTxtLimiteCredito());
		contentPane.add(getRbtnAtivo());
		contentPane.add(getRbtnNaoAtivo());
		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(getRbtnAtivo());
		bg.add(getRbtnNaoAtivo());
		
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
	public JFormattedTextField getTxtCpfCnpj(){
		
		if (txtCpfCnpj == null) {
			txtCpfCnpj = new JFormattedTextField(fm.getCPF());
			txtCpfCnpj.setColumns(10);
			txtCpfCnpj.setBounds(336, 89, 163, 20);
		}
		return txtCpfCnpj;
	}
	public JLabel getLblCpfcnpj() {
		if (lblCpfcnpj == null) {
			lblCpfcnpj = new JLabel("CPF/CNPJ");
			lblCpfcnpj.setBounds(336, 72, 95, 14);
		}
		return lblCpfcnpj;
	}
	public JFormattedTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JFormattedTextField(fm.getNome());
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
			txtCidade = new JFormattedTextField();
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
			txtNumero = new JFormattedTextField();
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
			txtTelefone = new JFormattedTextField();
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
			txtCelular = new JFormattedTextField();
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
	public JFormattedTextField getTxtPesquisa() {
		if (txtPesquisa == null) {
			txtPesquisa = new JFormattedTextField();
			txtPesquisa.setColumns(10);
			txtPesquisa.setBounds(115, 453, 432, 20);
		}
		return txtPesquisa;
	}
	public JLabel getPesquisar() {
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
	public List getList() {
		if (list == null) {
			list = new List();
			list.setBounds(10, 483, 537, 134);
		}
		return list;
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
			btnAlterar.setBounds(119, 635, 70, 22);
		}
		return btnAlterar;
	}
	public Button getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new Button("Excluir");
			btnExcluir.setBounds(230, 635, 70, 22);
		}
		return btnExcluir;
	}
	public Button getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new Button("Confirmar");
			btnConfirmar.setBounds(340, 635, 70, 22);
		}
		return btnConfirmar;
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
			lblCredito.setBounds(10, 159, 89, 14);
		}
		return lblCredito;
	}
	public JFormattedTextField getTxtLimiteCredito() {
		if (txtLimiteCredito == null) {
			txtLimiteCredito = new JFormattedTextField();
			txtLimiteCredito.setColumns(10);
			txtLimiteCredito.setBounds(10, 175, 163, 20);
		}
		return txtLimiteCredito;
	}
	public JRadioButton getRbtnAtivo() {
		if (rbtnAtivo == null) {
			rbtnAtivo = new JRadioButton("Ativo");
			rbtnAtivo.setBackground(new Color(153, 255, 204));
			rbtnAtivo.setBounds(356, 157, 109, 23);
		}
		return rbtnAtivo;
	}
	public JRadioButton getRbtnNaoAtivo() {
		if (rbtnNaoAtivo == null) {
			rbtnNaoAtivo = new JRadioButton("N\u00E3o Ativo");
			rbtnNaoAtivo.setBackground(new Color(153, 255, 204));
			rbtnNaoAtivo.setBounds(356, 178, 109, 23);
		}
		return rbtnNaoAtivo;
	}
}

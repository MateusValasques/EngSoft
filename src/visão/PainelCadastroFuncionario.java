package visão;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class PainelCadastroFuncionario extends JFrame {
	private JPanel contentPane;
	private JLabel lblCadastroFuncionario;
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
	private JLabel lblAgencia;
	private JFormattedTextField txtLimiteCredito;
	private JFormattedTextField txtConta;
	private JLabel lblConta;
	private JFormattedTextField txtLogin;
	private JLabel lblLoguin;
	private JLabel lblSenha;
	private JFormattedTextField txtSenha;
	private JFormattedTextField textField;
	private JLabel lblConfirmarsenha;
	private JRadioButton rdbtnCancelaCompra;
	private JRadioButton rdbtnNoCancelaCompra;

	public PainelCadastroFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 737);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		contentPane.add(getLblCadastroFuncionario());
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
		contentPane.add(getTextField_1_1());
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
		contentPane.add(getLblAgencia());
		contentPane.add(getTxtLimiteCredito());
		contentPane.add(getTxtConta());
		contentPane.add(getLblConta());
		contentPane.add(getTxtLogin());
		contentPane.add(getLblLoguin());
		contentPane.add(getLabel_1_3());
		contentPane.add(getTxtSenha());
		contentPane.add(getTextField());
		contentPane.add(getLblConfirmarsenha());
		contentPane.add(getRdbtnCancelaCompra());
		contentPane.add(getRdbtnNoCancelaCompra());
	}
	public JLabel getLblCadastroFuncionario() {
		if (lblCadastroFuncionario == null) {
			lblCadastroFuncionario = new JLabel("Cadastro Funcionario");
			lblCadastroFuncionario.setFont(new Font("Tahoma", Font.ITALIC, 24));
			lblCadastroFuncionario.setBounds(0, 0, 295, 40);
		}
		return lblCadastroFuncionario;
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
	public JFormattedTextField getTxtCpfCnpj() {
		if (txtCpfCnpj == null) {
			txtCpfCnpj = new JFormattedTextField();
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
			txtNome = new JFormattedTextField();
			txtNome.setColumns(10);
			
			txtNome.setBounds(10, 128, 336, 20);
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
			separator.setBounds(0, 242, 559, 2);
		}
		return separator;
	}
	public JFormattedTextField getTxtCep() {
		if (txtCep == null) {
			txtCep = new JFormattedTextField();
			txtCep.setColumns(10);
			txtCep.setBounds(12, 281, 163, 20);
		}
		return txtCep;
	}
	public JLabel getLblCep() {
		if (lblCep == null) {
			lblCep = new JLabel("CEP");
			lblCep.setBounds(12, 264, 46, 14);
		}
		return lblCep;
	}
	public JLabel getLblEndereo() {
		if (lblEndereo == null) {
			lblEndereo = new JLabel("Endere\u00E7o");
			lblEndereo.setBounds(10, 244, 145, 14);
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
	public JFormattedTextField getTextField_1_1() {
		if (txtRua == null) {
			txtRua = new JFormattedTextField();
			txtRua.setColumns(10);
			txtRua.setBounds(212, 281, 163, 20);
		}
		return txtRua;
	}
	public JLabel getLabel_1() {
		if (lblRua == null) {
			lblRua = new JLabel("Rua");
			lblRua.setBounds(212, 264, 46, 14);
		}
		return lblRua;
	}
	public JFormattedTextField getTxtBairro() {
		if (txtBairro == null) {
			txtBairro = new JFormattedTextField();
			txtBairro.setColumns(10);
			txtBairro.setBounds(10, 320, 163, 20);
		}
		return txtBairro;
	}
	public JLabel getLabel_1_1() {
		if (lblBairro == null) {
			lblBairro = new JLabel("Bairro");
			lblBairro.setBounds(12, 303, 46, 14);
		}
		return lblBairro;
	}
	public JFormattedTextField getTxtCidade() {
		if (txtCidade == null) {
			txtCidade = new JFormattedTextField();
			txtCidade.setColumns(10);
			txtCidade.setBounds(212, 320, 163, 20);
		}
		return txtCidade;
	}
	public JLabel getLblCidade() {
		if (lblCidade == null) {
			lblCidade = new JLabel("Cidade");
			lblCidade.setBounds(212, 303, 46, 14);
		}
		return lblCidade;
	}
	public JLabel getLblUf() {
		if (lblUf == null) {
			lblUf = new JLabel("UF:");
			lblUf.setBounds(420, 303, 46, 14);
		}
		return lblUf;
	}
	public JFormattedTextField getTxtNumero() {
		if (txtNumero == null) {
			txtNumero = new JFormattedTextField();
			txtNumero.setColumns(10);
			txtNumero.setBounds(420, 281, 71, 20);
		}
		return txtNumero;
	}
	public JLabel getNúmero() {
		if (Número == null) {
			Número = new JLabel("N\u00FAmero");
			Número.setBounds(420, 264, 71, 14);
		}
		return Número;
	}
	public JComboBox getCbxUf() {
		if (cbxUf == null) {
			cbxUf = new JComboBox();
			
			cbxUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Selecione-", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO" }));
			
			cbxUf.setBounds(420, 319, 85, 22);
		}
		return cbxUf;
	}
	public JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBounds(-1, 385, 559, 2);
		}
		return separator_2;
	}
	public JLabel getC() {
		if (C == null) {
			C = new JLabel("Contato");
			C.setBounds(10, 392, 145, 14);
		}
		return C;
	}
	public JFormattedTextField getTxtTelefone() {
		if (txtTelefone == null) {
			txtTelefone = new JFormattedTextField();
			txtTelefone.setColumns(10);
			txtTelefone.setBounds(10, 434, 127, 20);
		}
		return txtTelefone;
	}
	public JLabel getLblTelefone() {
		if (lblTelefone == null) {
			lblTelefone = new JLabel("Telefone");
			lblTelefone.setBounds(10, 417, 46, 14);
		}
		return lblTelefone;
	}
	public JFormattedTextField getTxtCelular() {
		if (txtCelular == null) {
			txtCelular = new JFormattedTextField();
			txtCelular.setColumns(10);
			txtCelular.setBounds(147, 434, 127, 20);
		}
		return txtCelular;
	}
	public JLabel getLabel_1_2() {
		if (lblCelular == null) {
			lblCelular = new JLabel("Celular");
			lblCelular.setBounds(147, 417, 46, 14);
		}
		return lblCelular;
	}
	public JFormattedTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JFormattedTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(284, 434, 204, 20);
		}
		return txtEmail;
	}
	public JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail");
			lblEmail.setBounds(284, 417, 46, 14);
		}
		return lblEmail;
	}
	public JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
			separator_3.setBounds(-4, 461, 559, 2);
		}
		return separator_3;
	}
	public JFormattedTextField getTxtPesquisa() {
		if (txtPesquisa == null) {
			txtPesquisa = new JFormattedTextField();
			txtPesquisa.setColumns(10);
			txtPesquisa.setBounds(115, 484, 432, 20);
		}
		return txtPesquisa;
	}
	public JLabel getPesquisar() {
		if (Pesquisar == null) {
			Pesquisar = new JLabel("Pesquisar");
			Pesquisar.setBounds(10, 466, 98, 14);
		}
		return Pesquisar;
	}
	public JComboBox getCbxTipoPesquisa() {
		if (cbxTipoPesquisa == null) {
			cbxTipoPesquisa = new JComboBox();
			cbxTipoPesquisa.setModel(new DefaultComboBoxModel(new String[] {"-Tipo-", "CPF", "CNPJ", "Nome", "C\u00F3digo"}));
			cbxTipoPesquisa.setBounds(10, 483, 98, 22);
		}
		return cbxTipoPesquisa;
	}
	public List getList() {
		if (list == null) {
			list = new List();
			list.setBounds(10, 514, 537, 134);
		}
		return list;
	}
	public Button getBtnInserir() {
		if (btnInserir == null) {
			btnInserir = new Button("Inserir");
			btnInserir.setBounds(14, 666, 70, 22);
		}
		return btnInserir;
	}
	public Button getBtnAlterar() {
		if (btnAlterar == null) {
			btnAlterar = new Button("Alterar");
			btnAlterar.setBounds(119, 666, 70, 22);
		}
		return btnAlterar;
	}
	public Button getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new Button("Excluir");
			btnExcluir.setBounds(230, 666, 70, 22);
		}
		return btnExcluir;
	}
	public Button getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new Button("Confirmar");
			btnConfirmar.setBounds(340, 666, 70, 22);
		}
		return btnConfirmar;
	}
	public Button getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new Button("Cancelar");
			btnCancelar.setBounds(449, 666, 70, 22);
		}
		return btnCancelar;
	}
	public JFormattedTextField getTxtComplemento() {
		if (txtComplemento == null) {
			txtComplemento = new JFormattedTextField();
			txtComplemento.setColumns(10);
			txtComplemento.setBounds(10, 358, 365, 20);
		}
		return txtComplemento;
	}
	public JLabel getLblComplemento() {
		if (lblComplemento == null) {
			lblComplemento = new JLabel("Complemento");
			lblComplemento.setBounds(10, 342, 142, 14);
		}
		return lblComplemento;
	}
	public JLabel getLblAgencia() {
		if (lblAgencia == null) {
			lblAgencia = new JLabel("Ag\u00EAncia");
			lblAgencia.setBounds(10, 159, 74, 14);
		}
		return lblAgencia;
	}
	public JFormattedTextField getTxtLimiteCredito() {
		if (txtLimiteCredito == null) {
			txtLimiteCredito = new JFormattedTextField();
			txtLimiteCredito.setColumns(10);
			txtLimiteCredito.setBounds(10, 175, 74, 20);
		}
		return txtLimiteCredito;
	}
	public JFormattedTextField getTxtConta() {
		if (txtConta == null) {
			txtConta = new JFormattedTextField();
			txtConta.setColumns(10);
			txtConta.setBounds(10, 216, 74, 20);
		}
		return txtConta;
	}
	public JLabel getLblConta() {
		if (lblConta == null) {
			lblConta = new JLabel("Conta");
			lblConta.setBounds(10, 200, 74, 14);
		}
		return lblConta;
	}
	public JFormattedTextField getTxtLogin() {
		if (txtLogin == null) {
			txtLogin = new JFormattedTextField();
			txtLogin.setColumns(10);
			txtLogin.setBounds(115, 175, 131, 20);
		}
		return txtLogin;
	}
	public JLabel getLblLoguin() {
		if (lblLoguin == null) {
			lblLoguin = new JLabel("Login");
			lblLoguin.setBounds(115, 159, 131, 14);
		}
		return lblLoguin;
	}
	public JLabel getLabel_1_3() {
		if (lblSenha == null) {
			lblSenha = new JLabel("Senha");
			lblSenha.setBounds(115, 200, 131, 14);
		}
		return lblSenha;
	}
	public JFormattedTextField getTxtSenha() {
		if (txtSenha == null) {
			txtSenha = new JFormattedTextField();
			txtSenha.setColumns(10);
			txtSenha.setBounds(115, 216, 131, 20);
		}
		return txtSenha;
	}
	public JFormattedTextField getTextField() {
		if (textField == null) {
			textField = new JFormattedTextField();
			textField.setColumns(10);
			textField.setBounds(256, 216, 131, 20);
		}
		return textField;
	}
	public JLabel getLblConfirmarsenha() {
		if (lblConfirmarsenha == null) {
			lblConfirmarsenha = new JLabel("Confirmar Senha");
			lblConfirmarsenha.setBounds(256, 200, 131, 14);
		}
		return lblConfirmarsenha;
	}
	public JRadioButton getRdbtnCancelaCompra() {
		if (rdbtnCancelaCompra == null) {
			rdbtnCancelaCompra = new JRadioButton("Cancela Compra");
			rdbtnCancelaCompra.setBackground(new Color(153, 255, 204));
			rdbtnCancelaCompra.setBounds(385, 150, 148, 23);
		}
		return rdbtnCancelaCompra;
	}
	public JRadioButton getRdbtnNoCancelaCompra() {
		if (rdbtnNoCancelaCompra == null) {
			rdbtnNoCancelaCompra = new JRadioButton("N\u00E3o Cancela Compra");
			rdbtnNoCancelaCompra.setBackground(new Color(153, 255, 204));
			rdbtnNoCancelaCompra.setBounds(385, 172, 148, 23);
		}
		return rdbtnNoCancelaCompra;
	}
}

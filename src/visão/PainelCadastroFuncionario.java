package visão;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.FormataMascaras;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;

public class PainelCadastroFuncionario extends JFrame {
	private JPanel contentPane;
	private JLabel lblCadastroFuncionario;
	private JFormattedTextField txtCodigo;
	private JLabel lblCodigo;
	private JComboBox cbxTipo;
	private JLabel lblTipo;
	private JFormattedTextField txtCpf;
	private JLabel lblCpf;
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
	private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnConfirmarInclusao;
	private JButton btnCancelar;
	private JFormattedTextField txtComplemento;
	private JLabel lblComplemento;
	private JLabel lblAgencia;
	private JFormattedTextField txtAgencia;
	private JFormattedTextField txtConta;
	private JLabel lblConta;
	private JFormattedTextField txtLogin;
	private JLabel lblLoguin;
	private JLabel lblSenha;
	private JLabel lblConfirmarsenha;
	private JRadioButton rdbtnCancelaCompra;
	private JRadioButton rdbtnNoCancelaCompra;
	private JFormattedTextField txtPesquisaCPF;
	private JFormattedTextField txtPesquisaCNPJ;
	private JFormattedTextField txtPesquisaCodigo;
	private JButton btnPesquisaCPF;
	private JButton btnPesquisaCNPJ;
	private JButton btnPesquisaCodigo;
	FormataMascaras fm = new FormataMascaras();
	private JFormattedTextField txtCNPJ;
	private JLabel lblCnpj;
	private JButton btnPesquisaNome;
	private JButton btnConfirmarAlteracao;
	private JButton btnConfirmarExclusao;
	private DefaultTableModel defaultTableModel;
	private JScrollPane scrollPane;
	private JTable tabela;
	private JPasswordField txtSenha;
	private JPasswordField txtConfirmaSenha;

	public PainelCadastroFuncionario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		contentPane.add(getTxtCpf());
		contentPane.add(getLblCpf());
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
		
		contentPane.add(getPesquisar());
		
		contentPane.add(getBtnInserir());
		contentPane.add(getBtnAlterar());
		contentPane.add(getBtnExcluir());
		contentPane.add(getBtnConfirmarInclusao());
		contentPane.add(getBtnCancelar());
		contentPane.add(getTxtComplemento());
		contentPane.add(getLblComplemento());
		contentPane.add(getLblAgencia());
		contentPane.add(getTxtAgencia());
		contentPane.add(getTxtConta());
		contentPane.add(getLblConta());
		contentPane.add(getTxtLogin());
		contentPane.add(getLblLoguin());
		contentPane.add(getLabel_1_3());
		contentPane.add(getLblConfirmarsenha());
		contentPane.add(getRdbtnCancelaCompra());
		contentPane.add(getRdbtnNoCancelaCompra());
		
		
		contentPane.add(getTxtPesquisaCodigo());
		contentPane.add(getTxtPesquisaNome());
		contentPane.add(getCbxTipoPesquisa());
		contentPane.add(getTxtPesquisaCNPJ());
		
		contentPane.add(getTxtPesquisaCPF());
		contentPane.add(getTxtCNPJ());
		contentPane.add(getLblCnpj());
		contentPane.add(getScrollPane());

		contentPane.add(getBtnPesquisaCPF());
		contentPane.add(getBtnPesquisaCNPJ());
		contentPane.add(getBtnPesquisaCodigo());
		contentPane.add(getBtnPesquisaNome());
		btnPesquisaCodigo.setVisible(false);
		btnPesquisaCNPJ.setVisible(false);
		btnPesquisaCPF.setVisible(false);
		btnPesquisaNome.setVisible(true);
		
		ButtonGroup grupinho = new ButtonGroup();
		grupinho.add(rdbtnCancelaCompra);
		grupinho.add(rdbtnNoCancelaCompra);
		contentPane.add(getBtnConfirmarAlteracao());
		contentPane.add(getBtnConfirmarExclusao());
		contentPane.add(getTxtSenha());
		contentPane.add(getTxtConfirmaSenha());
		
	}

	public JLabel getLblCadastroFuncionario() {
		if (lblCadastroFuncionario == null) {
			lblCadastroFuncionario = new JLabel("Cadastro Funcionario");
			lblCadastroFuncionario.setFont(new Font("Tahoma", Font.ITALIC, 24));
			lblCadastroFuncionario.setBounds(0, 0, 425, 38);
		}
		return lblCadastroFuncionario;
	}

	public JFormattedTextField getTxtCodigo() {
		if (txtCodigo == null) {
			txtCodigo = new JFormattedTextField();
			txtCodigo.setEnabled(false);
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

	public JFormattedTextField getTxtCpf() {
		if (txtCpf == null) {
			txtCpf = new JFormattedTextField(fm.getCPF());
			txtCpf.setColumns(10);
			txtCpf.setBounds(336, 89, 163, 20);
			txtCpf.setVisible(false);
		}
		return txtCpf;
	}

	public JLabel getLblCpf() {
		if (lblCpf == null) {
			lblCpf = new JLabel("CPF");
			lblCpf.setBounds(336, 72, 95, 14);
			lblCpf.setVisible(false);
		}
		return lblCpf;
	}

	public JFormattedTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JFormattedTextField(fm.getNome());
			txtNome.setEnabled(false);
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
			txtCep = new JFormattedTextField(fm.getCep());
			txtCep.setEnabled(false);
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
			separator_1.setBounds(0, 38, 246, 2);
		}
		return separator_1;
	}

	public JFormattedTextField getTxtRua() {
		if (txtRua == null) {
			txtRua = new JFormattedTextField();
			txtRua.setEnabled(false);
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
			txtBairro.setEnabled(false);
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
			txtCidade.setEnabled(false);
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
			txtNumero = new JFormattedTextField(fm.getNumero());
			txtNumero.setEnabled(false);
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
			cbxUf.setEnabled(false);

			cbxUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Selecione-", "AC", "AL", "AM", "AP",
					"BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN",
					"RO", "RS", "SC", "SE", "SP", "TO" }));

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
			txtTelefone = new JFormattedTextField(fm.gettelefone());
			txtTelefone.setEnabled(false);
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
			txtCelular = new JFormattedTextField(fm.getCelular());
			txtCelular.setEnabled(false);
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
			txtEmail.setEnabled(false);
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

	public JFormattedTextField getTxtPesquisaNome() {
		if (txtPesquisaNome == null) {
			txtPesquisaNome = new JFormattedTextField(fm.getNome());
			txtPesquisaNome.setColumns(10);
			txtPesquisaNome.setBounds(115, 484, 310, 20);
		}
		return txtPesquisaNome;
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
			cbxTipoPesquisa.setModel(
					new DefaultComboBoxModel(new String[] { "-Tipo-", "CPF", "CNPJ", "Nome", "C\u00F3digo" }));
			cbxTipoPesquisa.setBounds(10, 483, 98, 22);
		}
		return cbxTipoPesquisa;
	}

	public JButton getBtnInserir() {
		if (btnInserir == null) {
			btnInserir = new JButton("Inserir");
			btnInserir.setBounds(14, 666, 90, 22);
		}
		return btnInserir;
	}

	public JButton getBtnAlterar() {
		if (btnAlterar == null) {
			btnAlterar = new JButton("Alterar");
			btnAlterar.setEnabled(false);
			btnAlterar.setBounds(121, 666, 90, 22);
		}
		return btnAlterar;
	}

	public JButton getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new JButton("Excluir");
			btnExcluir.setEnabled(false);
			btnExcluir.setBounds(230, 666, 90, 22);
		}
		return btnExcluir;
	}

	public JButton getBtnConfirmarInclusao() {
		if (btnConfirmarInclusao == null) {
			btnConfirmarInclusao = new JButton("Confirmar ");
			btnConfirmarInclusao.setToolTipText("Confirmar inclus\u00E3o");
			btnConfirmarInclusao.setEnabled(false);
			btnConfirmarInclusao.setBounds(336, 666, 100, 22);
		}
		return btnConfirmarInclusao;
	}

	public JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(449, 666, 100, 22);
		}
		return btnCancelar;
	}

	public JFormattedTextField getTxtComplemento() {
		if (txtComplemento == null) {
			txtComplemento = new JFormattedTextField();
			txtComplemento.setEnabled(false);
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

	public JFormattedTextField getTxtAgencia() {
		if (txtAgencia == null) {
			txtAgencia = new JFormattedTextField();
			txtAgencia.setEnabled(false);
			txtAgencia.setColumns(10);
			txtAgencia.setBounds(10, 175, 74, 20);
		}
		return txtAgencia;
	}

	public JFormattedTextField getTxtConta() {
		if (txtConta == null) {
			txtConta = new JFormattedTextField(fm.getConta());
			txtConta.setEnabled(false);
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
			txtLogin.setEnabled(false);
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
			rdbtnCancelaCompra.setEnabled(false);
			rdbtnCancelaCompra.setBackground(new Color(153, 255, 204));
			rdbtnCancelaCompra.setBounds(385, 150, 148, 23);
		}
		return rdbtnCancelaCompra;
	}

	public JRadioButton getRdbtnNoCancelaCompra() {
		if (rdbtnNoCancelaCompra == null) {
			rdbtnNoCancelaCompra = new JRadioButton("N\u00E3o Cancela Compra");
			rdbtnNoCancelaCompra.setEnabled(false);
			rdbtnNoCancelaCompra.setBackground(new Color(153, 255, 204));
			rdbtnNoCancelaCompra.setBounds(385, 172, 148, 23);
		}
		return rdbtnNoCancelaCompra;
	}

	public JFormattedTextField getTxtPesquisaCPF() {
		if (txtPesquisaCPF == null) {
			txtPesquisaCPF = new JFormattedTextField(fm.getCPF());
			txtPesquisaCPF.setColumns(10);
			txtPesquisaCPF.setBounds(115, 484, 310, 20);
			txtPesquisaCPF.setVisible(false);
		}
		return txtPesquisaCPF;
	}

	public JFormattedTextField getTxtPesquisaCNPJ() {
		if (txtPesquisaCNPJ == null) {
			txtPesquisaCNPJ = new JFormattedTextField(fm.getCnpj());
			txtPesquisaCNPJ.setColumns(10);
			txtPesquisaCNPJ.setBounds(115, 484, 310, 20);
			txtPesquisaCNPJ.setVisible(false);

		}
		return txtPesquisaCNPJ;
	}

	public JFormattedTextField getTxtPesquisaCodigo() {
		if (txtPesquisaCodigo == null) {
			txtPesquisaCodigo = new JFormattedTextField();
			txtPesquisaCodigo.setColumns(10);
			txtPesquisaCodigo.setBounds(115, 484, 310, 20);
			txtPesquisaCodigo.setVisible(false);
		}
		return txtPesquisaCodigo;
	}

	public JButton getBtnPesquisaCPF() {
		if (btnPesquisaCPF == null) {
			btnPesquisaCPF = new JButton("Pesquisar");
			btnPesquisaCPF.setToolTipText("Pesquisar CPF");
			btnPesquisaCPF.setBounds(435, 483, 112, 23);
			btnPesquisaCPF.setVisible(false);
		}
		return btnPesquisaCPF;
	}

	public JButton getBtnPesquisaCNPJ() {
		if (btnPesquisaCNPJ == null) {
			btnPesquisaCNPJ = new JButton("Pesquisar");
			btnPesquisaCNPJ.setToolTipText("Pesquisar cnpj");
			btnPesquisaCNPJ.setBounds(435, 483, 112, 23);
			btnPesquisaCNPJ.setVisible(false);
		}
		return btnPesquisaCNPJ;
	}

	public JButton getBtnPesquisaCodigo() {
		if (btnPesquisaCodigo == null) {
			btnPesquisaCodigo = new JButton("Pesquisar");
			btnPesquisaCodigo.setToolTipText("Pesquisar  codigo");
			btnPesquisaCodigo.setBounds(435, 483, 112, 23);
			btnPesquisaCodigo.setVisible(false);
		}
		return btnPesquisaCodigo;
	}

	public JButton getBtnPesquisaNome() {
		if (btnPesquisaNome == null) {
			btnPesquisaNome = new JButton("Pesquisar");
			btnPesquisaNome.setToolTipText("Pesquisar Nome");
			btnPesquisaNome.setBounds(435, 483, 112, 23);
			btnPesquisaNome.setVisible(false);
		}
		return btnPesquisaNome;
	}

	public JFormattedTextField getTxtCNPJ() {
		if (txtCNPJ == null) {
			txtCNPJ = new JFormattedTextField(fm.getCnpj());
			txtCNPJ.setEnabled(false);
			txtCNPJ.setColumns(10);
			txtCNPJ.setBounds(336, 89, 163, 20);
			txtCNPJ.setVisible(false);
		}
		return txtCNPJ;
	}

	public JLabel getLblCnpj() {
		if (lblCnpj == null) {
			lblCnpj = new JLabel("CNPJ");
			lblCnpj.setBounds(336, 72, 95, 14);
			lblCnpj.setVisible(false);
		}
		return lblCnpj;
	}
	public JButton getBtnConfirmarAlteracao() {
		if (btnConfirmarAlteracao == null) {
			btnConfirmarAlteracao = new JButton("Confirmar");
			btnConfirmarAlteracao.setToolTipText("Confirmar altera\u00E7\u00E3o");
			btnConfirmarAlteracao.setEnabled(false);
			btnConfirmarAlteracao.setBounds(336, 666, 92, 22);
		}
		return btnConfirmarAlteracao;
	}
	public JButton getBtnConfirmarExclusao() {
		if (btnConfirmarExclusao == null) {
			btnConfirmarExclusao = new JButton("Confirmar");
			btnConfirmarExclusao.setToolTipText("Confirmar exclus\u00E3o");
			btnConfirmarExclusao.setEnabled(false);
			btnConfirmarExclusao.setBounds(336, 666, 92, 22);
		}
		return btnConfirmarExclusao;
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
			scrollPane.setBounds(10, 511, 538, 137);
			scrollPane.setViewportView(getTabela());
		}
		return scrollPane;
	}
	public JPasswordField getTxtSenha() {
		if (txtSenha == null) {
			txtSenha = new JPasswordField();
			txtSenha.setEnabled(false);
			txtSenha.setBounds(115, 216, 127, 20);
		}
		return txtSenha;
	}
	public JPasswordField getTxtConfirmaSenha() {
		if (txtConfirmaSenha == null) {
			txtConfirmaSenha = new JPasswordField();
			txtConfirmaSenha.setEnabled(false);
			txtConfirmaSenha.setBounds(256, 216, 127, 20);
		}
		return txtConfirmaSenha;
	}
}

package visão;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controle.FormataMascaras;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.List;
import java.text.ParseException;
import java.awt.Button;

public class painelCadastroForncedor extends JFrame {

	private JPanel contentPane;
	private JLabel lblCadastroForncedor;
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
	FormataMascaras fm = new FormataMascaras();
	private JFormattedTextField txtCnpj;
	private JLabel lblCnpj;

	public painelCadastroForncedor(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 703);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		contentPane.add(getLblCadastroForncedor());
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
		contentPane.add(getTxtCnpj());
		contentPane.add(getLblCnpj());
		getTxtCpf().setVisible(false);
		getTxtCnpj().setVisible(false);
	}
	public JLabel getLblCadastroForncedor() {
		if (lblCadastroForncedor == null) {
			lblCadastroForncedor = new JLabel("Cadastro Fornecedor");
			lblCadastroForncedor.setFont(new Font("Tahoma", Font.ITALIC, 24));
			lblCadastroForncedor.setBounds(0, 0, 237, 40);
		}
		return lblCadastroForncedor;
	}
	public JFormattedTextField getTxtCodigo() {
		if (txtCodigo == null) {
			txtCodigo = new JFormattedTextField();
			txtCodigo.setEditable(false);
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
	public JFormattedTextField getTxtCpf(){
		if (txtCpf == null) {
			txtCpf = new JFormattedTextField(fm.getCPF());
			txtCpf.setColumns(10);
			txtCpf.setBounds(336, 89, 163, 20);
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
	public JFormattedTextField getTxtNome(){
		if (txtNome == null) {
			
			txtNome = new JFormattedTextField(fm.getNome());
			txtNome.setColumns(10);			
			txtNome.setBounds(10, 134, 335, 20);
		}
		return txtNome;
	}
	public JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome");
			lblNome.setBounds(10, 117, 46, 14);
		}
		return lblNome;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(2, 164, 559, 2);
		}
		return separator;
	}
	public JFormattedTextField getTxtCep(){
		if (txtCep == null) {
			txtCep = new JFormattedTextField(fm.getCep());
			txtCep.setColumns(10);
			
			txtCep.setBounds(12, 207, 163, 20);
		}
		return txtCep;
	}
	public JLabel getLblCep() {
		if (lblCep == null) {
			lblCep = new JLabel("CEP");
			lblCep.setBounds(12, 190, 46, 14);
		}
		return lblCep;
	}
	public JLabel getLblEndereo() {
		if (lblEndereo == null) {
			lblEndereo = new JLabel("Endere\u00E7o");
			lblEndereo.setBounds(10, 168, 145, 14);
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
			separator_1.setBounds(0, 38, 225, 2);
		}
		return separator_1;
	}
	public JFormattedTextField getTxtRua() {
		if (txtRua == null) {
			txtRua = new JFormattedTextField();
			txtRua.setColumns(10);
			txtRua.setBounds(212, 207, 163, 20);
		}
		return txtRua;
	}
	public JLabel getLabel_1() {
		if (lblRua == null) {
			lblRua = new JLabel("Rua");
			lblRua.setBounds(212, 190, 46, 14);
		}
		return lblRua;
	}
	public JFormattedTextField getTxtBairro() {
		if (txtBairro == null) {
			txtBairro = new JFormattedTextField(fm.getEndereco());
			txtBairro.setColumns(10);
			txtBairro.setBounds(12, 246, 163, 20);
		}
		return txtBairro;
	}
	public JLabel getLabel_1_1() {
		if (lblBairro == null) {
			lblBairro = new JLabel("Bairro");
			lblBairro.setBounds(12, 229, 46, 14);
		}
		return lblBairro;
	}
	public JFormattedTextField getTxtCidade() {
		if (txtCidade == null) {
			txtCidade = new JFormattedTextField(fm.getEndereco());
			txtCidade.setColumns(10);
			txtCidade.setBounds(212, 246, 163, 20);
		}
		return txtCidade;
	}
	public JLabel getLblCidade() {
		if (lblCidade == null) {
			lblCidade = new JLabel("Cidade");
			lblCidade.setBounds(212, 229, 46, 14);
		}
		return lblCidade;
	}
	public JLabel getLblUf() {
		if (lblUf == null) {
			lblUf = new JLabel("UF:");
			lblUf.setBounds(420, 229, 46, 14);
		}
		return lblUf;
	}
	public JFormattedTextField getTxtNumero(){
		if (txtNumero == null) {
			txtNumero = new JFormattedTextField(fm.getNumero());
			txtNumero.setColumns(10);
			txtNumero.setBounds(420, 207, 71, 20);
		}
		return txtNumero;
	}
	public JLabel getNúmero() {
		if (Número == null) {
			Número = new JLabel("N\u00FAmero");
			Número.setBounds(420, 190, 71, 14);
		}
		return Número;
	}
	public JComboBox getCbxUf() {
		if (cbxUf == null) {
			cbxUf = new JComboBox();
			
			cbxUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Selecione-", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO" }));
			
			cbxUf.setBounds(420, 245, 85, 22);
		}
		return cbxUf;
	}
	public JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBounds(2, 315, 559, 2);
		}
		return separator_2;
	}
	public JLabel getC() {
		if (C == null) {
			C = new JLabel("Contato");
			C.setBounds(10, 321, 145, 14);
		}
		return C;
	}
	public JFormattedTextField getTxtTelefone(){
		if (txtTelefone == null) {
			txtTelefone = new JFormattedTextField(fm.gettelefone());
			txtTelefone.setColumns(10);
			
			txtTelefone.setBounds(10, 358, 127, 20);
		}
		return txtTelefone;
	}
	public JLabel getLblTelefone(){
		if (lblTelefone == null) {
			lblTelefone = new JLabel("Telefone");
			
			lblTelefone.setBounds(10, 341, 94, 14);
		}
		return lblTelefone;
	}
	public JFormattedTextField getTxtCelular(){
		if (txtCelular == null) {
			txtCelular = new JFormattedTextField(fm.getCelular());
			txtCelular.setColumns(10);
			txtCelular.setBounds(218, 358, 127, 20);
		}
		return txtCelular;
	}
	public JLabel getLabel_1_2() {
		if (lblCelular == null) {
			lblCelular = new JLabel("Celular");
			lblCelular.setBounds(218, 341, 46, 14);
		}
		return lblCelular;
	}
	public JFormattedTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JFormattedTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(11, 398, 247, 20);
		}
		return txtEmail;
	}
	public JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail");
			lblEmail.setBounds(11, 385, 46, 14);
		}
		return lblEmail;
	}
	public JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
			separator_3.setBounds(-4, 431, 559, 2);
		}
		return separator_3;
	}
	public JFormattedTextField getTxtPesquisa() {
		if (txtPesquisa == null) {
			txtPesquisa = new JFormattedTextField();
			txtPesquisa.setColumns(10);
			txtPesquisa.setBounds(111, 457, 432, 20);
		}
		return txtPesquisa;
	}
	public JLabel getPesquisar() {
		if (Pesquisar == null) {
			Pesquisar = new JLabel("Pesquisar");
			Pesquisar.setBounds(6, 439, 98, 14);
		}
		return Pesquisar;
	}
	public JComboBox getCbxTipoPesquisa() {
		if (cbxTipoPesquisa == null) {
			cbxTipoPesquisa = new JComboBox();
			cbxTipoPesquisa.setModel(new DefaultComboBoxModel(new String[] {"-Tipo-", "CPF", "CNPJ", "Nome", "C\u00F3digo"}));
			cbxTipoPesquisa.setBounds(6, 456, 98, 22);
		}
		return cbxTipoPesquisa;
	}
	public List getList() {
		if (list == null) {
			list = new List();
			list.setBounds(6, 487, 537, 134);
		}
		return list;
	}
	public Button getBtnInserir() {
		if (btnInserir == null) {
			btnInserir = new Button("Inserir");
			btnInserir.setBounds(10, 639, 70, 22);
		}
		return btnInserir;
	}
	public Button getBtnAlterar() {
		if (btnAlterar == null) {
			btnAlterar = new Button("Alterar");
			btnAlterar.setBounds(115, 639, 70, 22);
		}
		return btnAlterar;
	}
	public Button getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new Button("Excluir");
			btnExcluir.setBounds(226, 639, 70, 22);
		}
		return btnExcluir;
	}
	public Button getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new Button("Confirmar");
			btnConfirmar.setBounds(336, 639, 70, 22);
		}
		return btnConfirmar;
	}
	public Button getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new Button("Cancelar");
			btnCancelar.setBounds(445, 639, 70, 22);
		}
		return btnCancelar;
	}
	public JFormattedTextField getTxtComplemento() {
		if (txtComplemento == null) {
			txtComplemento = new JFormattedTextField();
			txtComplemento.setColumns(10);
			txtComplemento.setBounds(10, 284, 365, 20);
		}
		return txtComplemento;
	}
	public JLabel getLblComplemento() {
		if (lblComplemento == null) {
			lblComplemento = new JLabel("Complemento");
			lblComplemento.setBounds(10, 268, 142, 14);
		}
		return lblComplemento;
	}
	public JFormattedTextField getTxtCnpj() {
		if (txtCnpj == null) {
			txtCnpj = new JFormattedTextField(fm.getCnpj());
			txtCnpj.setColumns(10);
			txtCnpj.setBounds(336, 89, 163, 20);
			txtCnpj.setVisible(false);
		}
		return txtCnpj;
	}
	public JLabel getLblCnpj() {
		if (lblCnpj == null) {
			lblCnpj = new JLabel("CNPJ");
			lblCnpj.setBounds(336, 72, 95, 14);
			lblCnpj.setVisible(false);
		}
		return lblCnpj;
	}
}

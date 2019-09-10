package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import dao.Fornecedor_Dao;
import dao.Funcionario_Dao;
import modelo.Funcionario;
import visão.PainelCadastroFuncionario;

public class Controlador_Painel_Cadastro_Funcionario implements ActionListener, MouseListener {

	PainelCadastroFuncionario painelCadastroFuncionario;
	Funcionario_Dao funcionarioDao;

	public Controlador_Painel_Cadastro_Funcionario(PainelCadastroFuncionario painelCadastroFuncionario,
			Funcionario_Dao funcionarioDao) {

		this.painelCadastroFuncionario = painelCadastroFuncionario;
		this.funcionarioDao = funcionarioDao;
		addEventos();
	}

	private void addEventos() {
		painelCadastroFuncionario.getBtnAlterar().addActionListener(this);
		painelCadastroFuncionario.getBtnExcluir().addActionListener(this);
		painelCadastroFuncionario.getBtnInserir().addActionListener(this);
		painelCadastroFuncionario.getCbxTipo().addActionListener(this);

		painelCadastroFuncionario.getBtnConfirmarAlteracao().addActionListener(this);
		painelCadastroFuncionario.getBtnConfirmarExclusao().addActionListener(this);
		painelCadastroFuncionario.getBtnConfirmarInclusao().addActionListener(this);
		
		painelCadastroFuncionario.getBtnCancelar().addActionListener(this);

		painelCadastroFuncionario.getBtnPesquisaCNPJ().addActionListener(this);
		painelCadastroFuncionario.getBtnPesquisaCodigo().addActionListener(this);
		painelCadastroFuncionario.getBtnPesquisaCPF().addActionListener(this);
		painelCadastroFuncionario.getBtnPesquisaNome().addActionListener(this);
		painelCadastroFuncionario.getCbxTipoPesquisa().addActionListener(this);
		
		painelCadastroFuncionario.getTabela().addMouseListener(this);
		
	}	
	public void mouseClicked(MouseEvent e) {

		if (painelCadastroFuncionario.getTabela().getSelectedRow() > -1) {
			int x = (int) painelCadastroFuncionario.getTabela()
					.getValueAt(painelCadastroFuncionario.getTabela().getSelectedRow(), 0);
			Funcionario funcionario = new Funcionario(x, null, null, null, null, null, null, null, null, null, null, null, null, null, true, null, null, null, null);
			funcionario = Funcionario_Dao.busca_simples(x);
			String y ="" + funcionario.getCodigo();
			painelCadastroFuncionario.getTxtCodigo().setText(y);
			painelCadastroFuncionario.getCbxTipo().setSelectedItem(funcionario.getTipo());
			painelCadastroFuncionario.getBtnAlterar().setEnabled(true);
			painelCadastroFuncionario.getBtnExcluir().setEnabled(true);
			painelCadastroFuncionario.getBtnInserir().setEnabled(false);
			
			if(funcionario.getCancela_compra() == true)
				painelCadastroFuncionario.getRdbtnCancelaCompra().setSelected(true);
			else
				painelCadastroFuncionario.getRdbtnNoCancelaCompra().setSelected(true);
			
			if (painelCadastroFuncionario.getCbxTipo().getSelectedItem() == "CPF")
				painelCadastroFuncionario.getTxtCpf().setText(funcionario.getCpfcnpj());
			
			else if (painelCadastroFuncionario.getCbxTipo().getSelectedItem() == "CNPJ")
				painelCadastroFuncionario.getTxtCNPJ().setText(funcionario.getCpfcnpj());
			
			painelCadastroFuncionario.getTxtNome().setText(funcionario.getNome());
			painelCadastroFuncionario.getTxtCep().setText(funcionario.getCep());
			painelCadastroFuncionario.getTxtRua().setText(funcionario.getRua());
			painelCadastroFuncionario.getTxtNumero().setText(funcionario.getNumero());
			painelCadastroFuncionario.getTxtBairro().setText(funcionario.getBairro());
			painelCadastroFuncionario.getTxtCidade().setText(funcionario.getCidade());
			painelCadastroFuncionario.getCbxUf().setSelectedItem(funcionario.getUf());
			painelCadastroFuncionario.getTxtTelefone().setText(funcionario.getTelefone());
			painelCadastroFuncionario.getTxtCelular().setText(funcionario.getCelular());
			painelCadastroFuncionario.getTxtEmail().setText(funcionario.getEmail());
			painelCadastroFuncionario.getTxtComplemento().setText(funcionario.getComplemento());
			painelCadastroFuncionario.getTxtAgencia().setText(funcionario.getAgencia());
			painelCadastroFuncionario.getTxtConta().setText(funcionario.getConta());
			painelCadastroFuncionario.getTxtLogin().setText(funcionario.getConta());
			painelCadastroFuncionario.getTxtSenha().setText(funcionario.getSenha());
			painelCadastroFuncionario.getTxtConfirmaSenha().setText(funcionario.getSenha());

		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == painelCadastroFuncionario.getBtnConfirmarInclusao() == true) {
			System.out.println("oi");
			if (JOptionPane.showConfirmDialog(painelCadastroFuncionario,
					"Tem certeza que deseja inserir?") == JOptionPane.YES_OPTION) {
				try {
					Validate_Funcionario validacao = new Validate_Funcionario(painelCadastroFuncionario);
					if (validacao.validacao_Funcionario(painelCadastroFuncionario) == true) {
						Funcionario funcionario = new Funcionario(0, validacao.getTipo(), validacao.getCpfcnpj(),
								validacao.getNome(), validacao.getCep(), validacao.getRua(), validacao.getNumero(),
								validacao.getBairro(), validacao.getCidade(), validacao.getUf(),
								validacao.getTelefone(), validacao.getCelular(), validacao.getEmail(),
								validacao.getComplemento(), validacao.getCancela(), validacao.getLogin(),
								validacao.getSenha(), validacao.getConta(), validacao.getAgencia());

						Funcionario_Dao.create(funcionario);
					} else
						JOptionPane.showMessageDialog(null, "Falha validação");

				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			zera();
			trava();
			destrava_pesquisa();
		}

		if (e.getSource() == painelCadastroFuncionario.getBtnConfirmarAlteracao()) {
			if (JOptionPane.showConfirmDialog(painelCadastroFuncionario,
					"Tem certeza que deseja inserir?") == JOptionPane.YES_OPTION) {
				try {
					Validate_Funcionario validacao = new Validate_Funcionario(painelCadastroFuncionario);
					System.out.println("oi");
					if (validacao.validacao_Funcionario(painelCadastroFuncionario) == true) {
						Funcionario funcionario = new Funcionario(0, validacao.getTipo(), validacao.getCpfcnpj(),
								validacao.getNome(), validacao.getCep(), validacao.getRua(), validacao.getNumero(),
								validacao.getBairro(), validacao.getCidade(), validacao.getUf(),
								validacao.getTelefone(), validacao.getCelular(), validacao.getEmail(),
								validacao.getComplemento(), validacao.getCancela(), validacao.getLogin(),
								validacao.getSenha(), validacao.getConta(), validacao.getAgencia());

						Funcionario_Dao.update(funcionario);
					} else
						JOptionPane.showMessageDialog(null, "Falha validação");

				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			zera();
			trava();
			destrava_pesquisa();

		}

		if (e.getSource() == painelCadastroFuncionario.getBtnConfirmarExclusao()) {

			if (JOptionPane.showConfirmDialog(painelCadastroFuncionario,
					"Tem certeza que deseja excluir ?") == JOptionPane.YES_OPTION) {
				Funcionario_Dao.delete(Integer.parseInt(painelCadastroFuncionario.getTxtCodigo().getText()));
			}
			zera();
			trava();
			destrava_pesquisa();
		}
		
		if (e.getSource() == painelCadastroFuncionario.getCbxTipo()) {

			if (painelCadastroFuncionario.getCbxTipo().getSelectedItem() == "CPF") {
				painelCadastroFuncionario.getTxtCpf().setVisible(true);
				painelCadastroFuncionario.getTxtCNPJ().setVisible(false);
				painelCadastroFuncionario.getLblCpf().setVisible(true);
				painelCadastroFuncionario.getLblCnpj().setVisible(false);
			}

			else if (painelCadastroFuncionario.getCbxTipo().getSelectedItem() == "CNPJ") {
				painelCadastroFuncionario.getTxtCpf().setVisible(false);
				painelCadastroFuncionario.getTxtCNPJ().setVisible(true);
				painelCadastroFuncionario.getLblCpf().setVisible(false);
				painelCadastroFuncionario.getLblCnpj().setVisible(true);
			} else {
				painelCadastroFuncionario.getTxtCpf().setVisible(false);
				painelCadastroFuncionario.getTxtCNPJ().setVisible(false);
				painelCadastroFuncionario.getLblCpf().setVisible(false);
				painelCadastroFuncionario.getLblCnpj().setVisible(false);
			}

		}

		if (e.getSource() == painelCadastroFuncionario.getCbxTipoPesquisa()) {
			if (painelCadastroFuncionario.getCbxTipoPesquisa().getSelectedItem() == "CPF") {
				painelCadastroFuncionario.getTxtPesquisaCPF().setVisible(true);
				painelCadastroFuncionario.getTxtPesquisaCPF().setEnabled(true);
				painelCadastroFuncionario.getTxtPesquisaNome().setVisible(false);
				painelCadastroFuncionario.getTxtPesquisaCNPJ().setVisible(false);
				painelCadastroFuncionario.getTxtPesquisaCodigo().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaCPF().setVisible(true);
				painelCadastroFuncionario.getBtnPesquisaCPF().setEnabled(true);
				painelCadastroFuncionario.getBtnPesquisaNome().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaCNPJ().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaCodigo().setVisible(false);

			}
			if (painelCadastroFuncionario.getCbxTipoPesquisa().getSelectedItem() == "CNPJ") {

				painelCadastroFuncionario.getTxtPesquisaCNPJ().setEnabled(true);
				painelCadastroFuncionario.getTxtPesquisaCPF().setVisible(false);
				painelCadastroFuncionario.getTxtPesquisaNome().setVisible(false);
				painelCadastroFuncionario.getTxtPesquisaCNPJ().setVisible(true);
				painelCadastroFuncionario.getTxtPesquisaCodigo().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaCPF().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaNome().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaCNPJ().setVisible(true);
				painelCadastroFuncionario.getBtnPesquisaCodigo().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaCNPJ().setEnabled(true);

			}
			if (painelCadastroFuncionario.getCbxTipoPesquisa().getSelectedItem() == "Nome") {
				painelCadastroFuncionario.getTxtPesquisaNome().setEnabled(true);
				painelCadastroFuncionario.getTxtPesquisaCPF().setEnabled(false);
				painelCadastroFuncionario.getTxtPesquisaNome().setVisible(true);
				painelCadastroFuncionario.getTxtPesquisaCNPJ().setVisible(false);
				painelCadastroFuncionario.getTxtPesquisaCodigo().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaCPF().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaNome().setVisible(true);
				painelCadastroFuncionario.getBtnPesquisaCNPJ().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaCodigo().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaNome().setEnabled(true);

			}
			if (painelCadastroFuncionario.getCbxTipoPesquisa().getSelectedItem() == "Código") {

				painelCadastroFuncionario.getTxtPesquisaCodigo().setEnabled(true);
				painelCadastroFuncionario.getTxtPesquisaCPF().setVisible(false);
				painelCadastroFuncionario.getTxtPesquisaNome().setVisible(false);
				painelCadastroFuncionario.getTxtPesquisaCNPJ().setVisible(false);
				painelCadastroFuncionario.getTxtPesquisaCodigo().setVisible(true);
				painelCadastroFuncionario.getBtnPesquisaCPF().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaNome().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaCNPJ().setVisible(false);
				painelCadastroFuncionario.getBtnPesquisaCodigo().setVisible(true);
				painelCadastroFuncionario.getBtnPesquisaCodigo().setEnabled(true);

			}
			
			if (e.getSource() == painelCadastroFuncionario.getCbxTipo()) {

				if (painelCadastroFuncionario.getCbxTipo().getSelectedItem() == "CPF") {
					painelCadastroFuncionario.getTxtCpf().setVisible(true);
					painelCadastroFuncionario.getTxtCNPJ().setVisible(false);
					painelCadastroFuncionario.getLblCpf().setVisible(true);
					painelCadastroFuncionario.getLblCnpj().setVisible(false);
				}

				else if (painelCadastroFuncionario.getCbxTipo().getSelectedItem() == "CNPJ") {
					painelCadastroFuncionario.getTxtCpf().setVisible(false);
					painelCadastroFuncionario.getTxtCNPJ().setVisible(true);
					painelCadastroFuncionario.getLblCpf().setVisible(false);
					painelCadastroFuncionario.getLblCnpj().setVisible(true);
				} else {
					painelCadastroFuncionario.getTxtCpf().setVisible(false);
					painelCadastroFuncionario.getTxtCNPJ().setVisible(false);
					painelCadastroFuncionario.getLblCpf().setVisible(false);
					painelCadastroFuncionario.getLblCnpj().setVisible(false);
				}

			}
		}
		
		if (e.getSource() == painelCadastroFuncionario.getBtnInserir() == true) {

			destrava();
			zera();
			trava_pesquisa();
			
			painelCadastroFuncionario.getBtnAlterar().setEnabled(false);
			painelCadastroFuncionario.getBtnExcluir().setEnabled(false);
			painelCadastroFuncionario.getBtnInserir().setEnabled(false);
			
			painelCadastroFuncionario.getBtnConfirmarAlteracao().setVisible(false);
			painelCadastroFuncionario.getBtnConfirmarExclusao().setVisible(false);
			painelCadastroFuncionario.getBtnConfirmarInclusao().setEnabled(true);
			painelCadastroFuncionario.getBtnConfirmarInclusao().setVisible(true);

		}
		
		if(e.getSource() == painelCadastroFuncionario.getBtnCancelar()) {
			zera();
			trava();
			destrava_pesquisa();
		}
		if (e.getSource() == painelCadastroFuncionario.getBtnAlterar() == true) {
			destrava();
			destrava_pesquisa();
			
			painelCadastroFuncionario.getBtnAlterar().setEnabled(false);
			painelCadastroFuncionario.getBtnExcluir().setEnabled(false);
			painelCadastroFuncionario.getBtnInserir().setEnabled(false);
			
			painelCadastroFuncionario.getBtnConfirmarInclusao().setVisible(false);
			painelCadastroFuncionario.getBtnConfirmarAlteracao().setVisible(true);
			painelCadastroFuncionario.getBtnConfirmarExclusao().setVisible(false);
			painelCadastroFuncionario.getBtnConfirmarAlteracao().setEnabled(true);

		}
		if (e.getSource() == painelCadastroFuncionario.getBtnExcluir() == true) {
			trava();
			destrava_pesquisa();
			
			painelCadastroFuncionario.getBtnAlterar().setEnabled(false);
			painelCadastroFuncionario.getBtnExcluir().setEnabled(false);
			painelCadastroFuncionario.getBtnInserir().setEnabled(false);
			
			painelCadastroFuncionario.getBtnConfirmarInclusao().setVisible(false);
			painelCadastroFuncionario.getBtnConfirmarAlteracao().setVisible(false);
			painelCadastroFuncionario.getBtnConfirmarExclusao().setVisible(true);
			painelCadastroFuncionario.getBtnConfirmarExclusao().setEnabled(true);
			
		}
		if (e.getSource() == painelCadastroFuncionario.getBtnPesquisaCNPJ()) {
			System.out.println("cnpj");
			pesquisa_cnpj();
		}
		if (e.getSource() == painelCadastroFuncionario.getBtnPesquisaCPF()) {
			System.out.println("cpf");
			pesquisa_cpf();
		}
		if (e.getSource() == painelCadastroFuncionario.getBtnPesquisaCodigo()) {
			System.out.println("codigo");
			pesquisa_codigo();
		}
		if (e.getSource() == painelCadastroFuncionario.getBtnPesquisaNome()) {
			System.out.println("nome");
			pesquisa_nome();
		}
	}
	public void pesquisa_nome() {
		painelCadastroFuncionario.getDefaultTableModel().setNumRows(0);
		painelCadastroFuncionario.getTabela().setEditingRow(0);
		painelCadastroFuncionario.getTabela().setEditingColumn(0);
		painelCadastroFuncionario.getDefaultTableModel().isCellEditable(0, 0);
		Funcionario_Dao.pesquisa_nome(painelCadastroFuncionario.getTxtPesquisaNome().getText());
	}
	
	public void pesquisa_cpf() {

		painelCadastroFuncionario.getDefaultTableModel().setNumRows(0);
		painelCadastroFuncionario.getTabela().setEditingRow(0);
		painelCadastroFuncionario.getTabela().setEditingColumn(0);
		painelCadastroFuncionario.getDefaultTableModel().isCellEditable(0, 0);
		Funcionario_Dao.pesquisa_cpf_cnpj((painelCadastroFuncionario.getTxtPesquisaCPF().getText()).trim());

	}

	public void pesquisa_codigo() {
		painelCadastroFuncionario.getDefaultTableModel().setNumRows(0);
		painelCadastroFuncionario.getTabela().setEditingRow(0);
		painelCadastroFuncionario.getTabela().setEditingColumn(0);
		painelCadastroFuncionario.getDefaultTableModel().isCellEditable(0, 0);
		Funcionario_Dao.pesquisa_codigo(Integer.parseInt(painelCadastroFuncionario.getTxtPesquisaCodigo().getText()));
	}

	public void pesquisa_cnpj() {

		painelCadastroFuncionario.getDefaultTableModel().setNumRows(0);
		painelCadastroFuncionario.getTabela().setEditingRow(0);
		painelCadastroFuncionario.getTabela().setEditingColumn(0);
		painelCadastroFuncionario.getDefaultTableModel().isCellEditable(0, 0);
		Funcionario_Dao.pesquisa_cpf_cnpj((painelCadastroFuncionario.getTxtPesquisaCNPJ().getText()).trim());

	}
	
	public void trava_pesquisa() {

		painelCadastroFuncionario.getTxtPesquisaCNPJ().setEnabled(false);
		painelCadastroFuncionario.getTxtPesquisaCPF().setEnabled(false);
		painelCadastroFuncionario.getTxtPesquisaNome().setEnabled(false);
		painelCadastroFuncionario.getTxtPesquisaCodigo().setEnabled(false);

		painelCadastroFuncionario.getBtnPesquisaCPF().setEnabled(false);
		painelCadastroFuncionario.getBtnPesquisaNome().setEnabled(false);
		painelCadastroFuncionario.getBtnPesquisaCodigo().setEnabled(false);
		painelCadastroFuncionario.getBtnPesquisaCNPJ().setEnabled(false);

		painelCadastroFuncionario.getCbxTipoPesquisa().setEnabled(false);

	}

	public void destrava_pesquisa() {

		painelCadastroFuncionario.getTxtPesquisaCNPJ().setEnabled(true);
		painelCadastroFuncionario.getTxtPesquisaCPF().setEnabled(true);
		painelCadastroFuncionario.getTxtPesquisaNome().setEnabled(true);
		painelCadastroFuncionario.getTxtPesquisaCodigo().setEnabled(true);

		painelCadastroFuncionario.getBtnPesquisaCPF().setEnabled(true);
		painelCadastroFuncionario.getBtnPesquisaNome().setEnabled(true);
		painelCadastroFuncionario.getBtnPesquisaCodigo().setEnabled(true);
		painelCadastroFuncionario.getBtnPesquisaCNPJ().setEnabled(true);

		painelCadastroFuncionario.getCbxTipoPesquisa().setEnabled(true);

	}

	public void zera() {
		painelCadastroFuncionario.getTxtPesquisaNome().setText(null);
		painelCadastroFuncionario.getBtnPesquisaNome().setEnabled(true);
		painelCadastroFuncionario.getCbxTipoPesquisa().setSelectedItem("-Selecione-");
		painelCadastroFuncionario.getTxtCodigo().setText(null);
		painelCadastroFuncionario.getCbxTipo().setSelectedItem("-Selecione-");
		painelCadastroFuncionario.getTxtCpf().setText(null);
		painelCadastroFuncionario.getTxtCNPJ().setText(null);
		painelCadastroFuncionario.getTxtNome().setText(null);
		painelCadastroFuncionario.getTxtCep().setText(null);
		painelCadastroFuncionario.getTxtRua().setText(null);
		painelCadastroFuncionario.getTxtNumero().setText(null);
		painelCadastroFuncionario.getTxtBairro().setText(null);
		painelCadastroFuncionario.getTxtCidade().setText(null);
		painelCadastroFuncionario.getCbxUf().setSelectedItem("-Selecione-");
		painelCadastroFuncionario.getTxtTelefone().setText(null);
		painelCadastroFuncionario.getTxtCelular().setText(null);
		painelCadastroFuncionario.getTxtEmail().setText(null);
		painelCadastroFuncionario.getTxtComplemento().setText(null);
		painelCadastroFuncionario.getDefaultTableModel().setNumRows(0);
		painelCadastroFuncionario.getTabela().setEditingRow(0);
		painelCadastroFuncionario.getTabela().setEditingColumn(0);
		painelCadastroFuncionario.getDefaultTableModel().isCellEditable(0, 0);
		painelCadastroFuncionario.getTxtPesquisaNome().setCaretPosition(0);
		painelCadastroFuncionario.getBtnAlterar().setEnabled(false);
		painelCadastroFuncionario.getBtnExcluir().setEnabled(false);
		painelCadastroFuncionario.getBtnInserir().setEnabled(true);
		
		painelCadastroFuncionario.getRdbtnCancelaCompra().setEnabled(false);
		painelCadastroFuncionario.getRdbtnNoCancelaCompra().setEnabled(false);
		painelCadastroFuncionario.getRdbtnCancelaCompra().setSelected(false);
		painelCadastroFuncionario.getRdbtnNoCancelaCompra().setSelected(false);

		
		painelCadastroFuncionario.getTxtAgencia().setText(null);
		painelCadastroFuncionario.getTxtConta().setText(null);
		painelCadastroFuncionario.getTxtLogin().setText(null);
		painelCadastroFuncionario.getTxtSenha().setText(null);
		painelCadastroFuncionario.getTxtConfirmaSenha().setText(null);

	}

	public void trava() {

		painelCadastroFuncionario.getCbxTipo().setEnabled(false);
		painelCadastroFuncionario.getTxtCpf().setEnabled(false);
		painelCadastroFuncionario.getTxtCNPJ().setEnabled(false);
		painelCadastroFuncionario.getTxtNome().setEnabled(false);
		painelCadastroFuncionario.getTxtCep().setEnabled(false);
		painelCadastroFuncionario.getTxtRua().setEnabled(false);
		painelCadastroFuncionario.getTxtNumero().setEnabled(false);
		painelCadastroFuncionario.getTxtBairro().setEnabled(false);
		painelCadastroFuncionario.getTxtCidade().setEnabled(false);
		painelCadastroFuncionario.getCbxUf().setEnabled(false);
		painelCadastroFuncionario.getTxtTelefone().setEnabled(false);
		painelCadastroFuncionario.getTxtCelular().setEnabled(false);
		painelCadastroFuncionario.getTxtEmail().setEnabled(false);
		painelCadastroFuncionario.getTxtComplemento().setEnabled(false);
		
		painelCadastroFuncionario.getTxtAgencia().setEnabled(false);
		painelCadastroFuncionario.getTxtConta().setEnabled(false);
		painelCadastroFuncionario.getTxtLogin().setEnabled(false);
		painelCadastroFuncionario.getTxtSenha().setEnabled(false);
		painelCadastroFuncionario.getTxtConfirmaSenha().setEnabled(false);
		
		painelCadastroFuncionario.getRdbtnCancelaCompra().setEnabled(false);
		painelCadastroFuncionario.getRdbtnNoCancelaCompra().setEnabled(false);
		
		painelCadastroFuncionario.getBtnConfirmarAlteracao().setEnabled(false);
		painelCadastroFuncionario.getBtnConfirmarExclusao().setEnabled(false);
		painelCadastroFuncionario.getBtnConfirmarInclusao().setEnabled(false);


	}

	public void destrava() {

		painelCadastroFuncionario.getCbxTipo().setEnabled(true);
		painelCadastroFuncionario.getTxtCpf().setEnabled(true);
		painelCadastroFuncionario.getTxtCNPJ().setEnabled(true);
		painelCadastroFuncionario.getTxtNome().setEnabled(true);
		painelCadastroFuncionario.getTxtCep().setEnabled(true);
		painelCadastroFuncionario.getTxtRua().setEnabled(true);
		painelCadastroFuncionario.getTxtNumero().setEnabled(true);
		painelCadastroFuncionario.getTxtBairro().setEnabled(true);
		painelCadastroFuncionario.getTxtCidade().setEnabled(true);
		painelCadastroFuncionario.getCbxUf().setEnabled(true);
		painelCadastroFuncionario.getTxtTelefone().setEnabled(true);
		painelCadastroFuncionario.getTxtCelular().setEnabled(true);
		painelCadastroFuncionario.getTxtEmail().setEnabled(true);
		painelCadastroFuncionario.getTxtComplemento().setEnabled(true);
		
		painelCadastroFuncionario.getTxtAgencia().setEnabled(true);
		painelCadastroFuncionario.getTxtConta().setEnabled(true);
		painelCadastroFuncionario.getTxtLogin().setEnabled(true);
		painelCadastroFuncionario.getTxtSenha().setEnabled(true);
		painelCadastroFuncionario.getTxtConfirmaSenha().setEnabled(true);
		
		painelCadastroFuncionario.getRdbtnCancelaCompra().setEnabled(true);
		painelCadastroFuncionario.getRdbtnNoCancelaCompra().setEnabled(true);
		
		painelCadastroFuncionario.getBtnConfirmarAlteracao().setEnabled(true);
		painelCadastroFuncionario.getBtnConfirmarExclusao().setEnabled(true);
		painelCadastroFuncionario.getBtnConfirmarInclusao().setEnabled(true);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

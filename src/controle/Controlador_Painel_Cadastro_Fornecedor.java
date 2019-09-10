package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.Fornecedor_Dao;
import modelo.Fornecedor;
import visão.painelCadastroForncedor;

public class Controlador_Painel_Cadastro_Fornecedor implements ActionListener, MouseListener {

	painelCadastroForncedor painel_Cadastro_Fornecedor;
	ArrayList<Fornecedor> fornecedores;
	Fornecedor_Dao fornecedor_bd;

	public Controlador_Painel_Cadastro_Fornecedor(painelCadastroForncedor painel_Cadastro_Fornecedor,
			Fornecedor_Dao fornecedor_bd) {

		this.painel_Cadastro_Fornecedor = painel_Cadastro_Fornecedor;
		this.fornecedor_bd = fornecedor_bd;
		addEventos();

	}

	private void addEventos() {

		getPainel_Cadastro_Fornecedor().getBtnAlterar().addActionListener(this);
		getPainel_Cadastro_Fornecedor().getBtnConfirmar().addActionListener(this);
		getPainel_Cadastro_Fornecedor().getBtnConfirmar_Alteracao().addActionListener(this);
		getPainel_Cadastro_Fornecedor().getBtnConfirmar_Exclusao().addActionListener(this);
		getPainel_Cadastro_Fornecedor().getBtnCancelar().addActionListener(this);
		getPainel_Cadastro_Fornecedor().getBtnExcluir().addActionListener(this);
		getPainel_Cadastro_Fornecedor().getBtnInserir().addActionListener(this);
		getPainel_Cadastro_Fornecedor().getCbxTipo().addActionListener(this);

		getPainel_Cadastro_Fornecedor().getCbxTipoPesquisa().addActionListener(this);
		getPainel_Cadastro_Fornecedor().getTabela().addMouseListener(this);

		getPainel_Cadastro_Fornecedor().getBtnPesquisaCNPJ().addActionListener(this);
		getPainel_Cadastro_Fornecedor().getBtnPesquisaCPF().addActionListener(this);
		getPainel_Cadastro_Fornecedor().getBtnPesquisaCodigo().addActionListener(this);
		getPainel_Cadastro_Fornecedor().getBtnPesquisaNome().addActionListener(this);

	}

	public void mouseClicked(MouseEvent e) {

		if (getPainel_Cadastro_Fornecedor().getTabela().getSelectedRow() > -1) {

			getPainel_Cadastro_Fornecedor().getBtnAlterar().setEnabled(true);
			getPainel_Cadastro_Fornecedor().getBtnExcluir().setEnabled(true);
			getPainel_Cadastro_Fornecedor().getBtnInserir().setEnabled(false);
			int x = (int) getPainel_Cadastro_Fornecedor().getTabela()
					.getValueAt(getPainel_Cadastro_Fornecedor().getTabela().getSelectedRow(), 0);
			System.out.println(x);
			Fornecedor fornecedor = new Fornecedor();
			fornecedor = Fornecedor_Dao.busca_simples(x);
			String y = "" + fornecedor.getCodigo();
			getPainel_Cadastro_Fornecedor().getTxtCodigo().setText(y);
			getPainel_Cadastro_Fornecedor().getCbxTipo().setSelectedItem(fornecedor.getTipo());

			if (getPainel_Cadastro_Fornecedor().getCbxTipo().getSelectedItem() == "CPF")
				getPainel_Cadastro_Fornecedor().getTxtCpf().setText(fornecedor.getCpfcnpj());

			else if (getPainel_Cadastro_Fornecedor().getCbxTipo().getSelectedItem() == "CNPJ")
				getPainel_Cadastro_Fornecedor().getTxtCnpj().setText(fornecedor.getCpfcnpj());

			getPainel_Cadastro_Fornecedor().getTxtNome().setText(fornecedor.getNome());
			getPainel_Cadastro_Fornecedor().getTxtCep().setText(fornecedor.getCep());
			getPainel_Cadastro_Fornecedor().getTxtRua().setText(fornecedor.getRua());
			getPainel_Cadastro_Fornecedor().getTxtNumero().setText(fornecedor.getNumero());
			getPainel_Cadastro_Fornecedor().getTxtBairro().setText(fornecedor.getBairro());
			getPainel_Cadastro_Fornecedor().getTxtCidade().setText(fornecedor.getCidade());
			getPainel_Cadastro_Fornecedor().getCbxUf().setSelectedItem(fornecedor.getUf());
			getPainel_Cadastro_Fornecedor().getTxtTelefone().setText(fornecedor.getTelefone());
			getPainel_Cadastro_Fornecedor().getTxtCelular().setText(fornecedor.getCelular());
			getPainel_Cadastro_Fornecedor().getTxtEmail().setText(fornecedor.getEmail());
			getPainel_Cadastro_Fornecedor().getTxtComplemento().setText(fornecedor.getComplemento());

		}

	}

	// aqui vai pesquisar por nome
	public void pesquisa_nome() {
		getPainel_Cadastro_Fornecedor().getDefaultTableModel().setNumRows(0);
		getPainel_Cadastro_Fornecedor().getTabela().setEditingRow(0);
		getPainel_Cadastro_Fornecedor().getTabela().setEditingColumn(0);
		getPainel_Cadastro_Fornecedor().getDefaultTableModel().isCellEditable(0, 0);
		painel_Cadastro_Fornecedor.getTxtPesquisa().setCaretPosition(0);
		Fornecedor_Dao.pesquisa_nome(painel_Cadastro_Fornecedor.getTxtPesquisa().getText());
	}

	public void pesquisa_cpf() {

		getPainel_Cadastro_Fornecedor().getDefaultTableModel().setNumRows(0);
		getPainel_Cadastro_Fornecedor().getTabela().setEditingRow(0);
		getPainel_Cadastro_Fornecedor().getTabela().setEditingColumn(0);
		getPainel_Cadastro_Fornecedor().getDefaultTableModel().isCellEditable(0, 0);
		painel_Cadastro_Fornecedor.getTxtPesquisa().setCaretPosition(0);
		Fornecedor_Dao.pesquisa_cpf_cnpj((painel_Cadastro_Fornecedor.getTxtPesquisaCPF().getText()).trim());

	}

	public void pesquisa_codigo() {
		getPainel_Cadastro_Fornecedor().getDefaultTableModel().setNumRows(0);
		getPainel_Cadastro_Fornecedor().getTabela().setEditingRow(0);
		getPainel_Cadastro_Fornecedor().getTabela().setEditingColumn(0);
		getPainel_Cadastro_Fornecedor().getDefaultTableModel().isCellEditable(0, 0);
		Fornecedor_Dao.pesquisa_codigo(Integer.parseInt(painel_Cadastro_Fornecedor.getTxtPesquisaCodigo().getText()));
	}

	public void pesquisa_cnpj() {

		getPainel_Cadastro_Fornecedor().getDefaultTableModel().setNumRows(0);
		getPainel_Cadastro_Fornecedor().getTabela().setEditingRow(0);
		getPainel_Cadastro_Fornecedor().getTabela().setEditingColumn(0);
		getPainel_Cadastro_Fornecedor().getDefaultTableModel().isCellEditable(0, 0);
		painel_Cadastro_Fornecedor.getTxtPesquisa().setCaretPosition(0);
		Fornecedor_Dao.pesquisa_cpf_cnpj((painel_Cadastro_Fornecedor.getTxtPesquisaCNPJ().getText()).trim());

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == getPainel_Cadastro_Fornecedor().getCbxTipoPesquisa()) {
			if (getPainel_Cadastro_Fornecedor().getCbxTipoPesquisa().getSelectedItem() == "CPF") {
				painel_Cadastro_Fornecedor.getTxtPesquisaCPF().setVisible(true);
				painel_Cadastro_Fornecedor.getTxtPesquisaCPF().setEditable(true);
				painel_Cadastro_Fornecedor.getTxtPesquisa().setVisible(false);
				painel_Cadastro_Fornecedor.getTxtPesquisaCNPJ().setVisible(false);
				painel_Cadastro_Fornecedor.getTxtPesquisaCodigo().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaCPF().setVisible(true);
				painel_Cadastro_Fornecedor.getBtnPesquisaCPF().setEnabled(true);
				painel_Cadastro_Fornecedor.getBtnPesquisaNome().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaCNPJ().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaCodigo().setVisible(false);

			}
			if (getPainel_Cadastro_Fornecedor().getCbxTipoPesquisa().getSelectedItem() == "CNPJ") {

				painel_Cadastro_Fornecedor.getTxtPesquisaCNPJ().setEditable(true);
				painel_Cadastro_Fornecedor.getTxtPesquisaCPF().setVisible(false);
				painel_Cadastro_Fornecedor.getTxtPesquisa().setVisible(false);
				painel_Cadastro_Fornecedor.getTxtPesquisaCNPJ().setVisible(true);
				painel_Cadastro_Fornecedor.getTxtPesquisaCodigo().setVisible(false);

				painel_Cadastro_Fornecedor.getBtnPesquisaCPF().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaNome().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaCNPJ().setVisible(true);
				painel_Cadastro_Fornecedor.getBtnPesquisaCodigo().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaCNPJ().setEnabled(true);

			}
			if (getPainel_Cadastro_Fornecedor().getCbxTipoPesquisa().getSelectedItem() == "Nome") {
				painel_Cadastro_Fornecedor.getTxtPesquisa().setEditable(true);
				painel_Cadastro_Fornecedor.getTxtPesquisaCPF().setEditable(false);
				painel_Cadastro_Fornecedor.getTxtPesquisa().setVisible(true);
				painel_Cadastro_Fornecedor.getTxtPesquisaCNPJ().setVisible(false);
				painel_Cadastro_Fornecedor.getTxtPesquisaCodigo().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaCPF().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaNome().setVisible(true);
				painel_Cadastro_Fornecedor.getBtnPesquisaCNPJ().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaCodigo().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaNome().setEnabled(true);

			}
			if (getPainel_Cadastro_Fornecedor().getCbxTipoPesquisa().getSelectedItem() == "Código") {

				painel_Cadastro_Fornecedor.getTxtPesquisaCodigo().setEditable(true);
				painel_Cadastro_Fornecedor.getTxtPesquisaCPF().setVisible(false);
				painel_Cadastro_Fornecedor.getTxtPesquisa().setVisible(false);
				painel_Cadastro_Fornecedor.getTxtPesquisaCNPJ().setVisible(false);
				painel_Cadastro_Fornecedor.getTxtPesquisaCodigo().setVisible(true);
				painel_Cadastro_Fornecedor.getBtnPesquisaCPF().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaNome().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaCNPJ().setVisible(false);
				painel_Cadastro_Fornecedor.getBtnPesquisaCodigo().setVisible(true);
				painel_Cadastro_Fornecedor.getBtnPesquisaCodigo().setEnabled(true);

			}

		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnCancelar()) {

			int saida = JOptionPane.showConfirmDialog(getPainel_Cadastro_Fornecedor(), "Deseja realmente cancelar?",
					"Cancelar", JOptionPane.YES_NO_OPTION);
			if (saida == 0) {
				zera();
				trava();
				destrava_pesquisa();
			}

		}

		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnPesquisaCNPJ()) {
			System.out.println("cnpj");
			pesquisa_cnpj();
		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnPesquisaCPF()) {
			System.out.println("cpf");
			pesquisa_cpf();
		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnPesquisaCodigo()) {
			System.out.println("codigo");
			pesquisa_codigo();
		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnPesquisaNome()) {
			System.out.println("nome");
			pesquisa_nome();
		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnConfirmar_Alteracao()) {

			System.out.println("sndsand");
			int saida = JOptionPane.showConfirmDialog(getPainel_Cadastro_Fornecedor(), "Deseja realmente alterar?",
					"Confirmação de Alteração", JOptionPane.YES_NO_OPTION);
			if (saida == 0) {
				try {
					Validate_Fornecedor validacao = new Validate_Fornecedor(getPainel_Cadastro_Fornecedor());

					if (validacao.validacao_Fornecedor(getPainel_Cadastro_Fornecedor()) == true) {
						String codigo = painel_Cadastro_Fornecedor.getTxtCodigo().getText();
						int valor = Integer.parseInt(codigo);
						System.out.println("oi " + codigo);
						Fornecedor fornecedor = new Fornecedor(1, validacao.getTipo(), validacao.getCpfcnpj(),
								validacao.getNome(), validacao.getCep(), validacao.getRua(), validacao.getNumero(),
								validacao.getBairro(), validacao.getCidade(), validacao.getUf(),
								validacao.getTelefone(), validacao.getCelular(), validacao.getEmail(),
								validacao.getComplemento());
						fornecedor.setCodigo(valor);

						Fornecedor_Dao.update(fornecedor);
						zera();
						destrava_pesquisa();
						trava();
					}

				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			}

		}

		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnConfirmar_Exclusao()) {

			int saida = JOptionPane.showConfirmDialog(getPainel_Cadastro_Fornecedor(), "Deseja realmente excluir?",
					"Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
			if (saida == 0) {
				Fornecedor_Dao.delete(Integer.parseInt(getPainel_Cadastro_Fornecedor().getTxtCodigo().getText()));
				getPainel_Cadastro_Fornecedor().getBtnInserir().setEnabled(false);
				getPainel_Cadastro_Fornecedor().getBtnExcluir().setEnabled(false);
				getPainel_Cadastro_Fornecedor().getBtnAlterar().setEnabled(false);
				zera();
				trava();
			}

		}

		if (e.getSource() == getPainel_Cadastro_Fornecedor().getCbxTipo()) {

			if (getPainel_Cadastro_Fornecedor().getCbxTipo().getSelectedItem() == "CPF") {
				getPainel_Cadastro_Fornecedor().getTxtCpf().setVisible(true);
				getPainel_Cadastro_Fornecedor().getTxtCnpj().setVisible(false);
				getPainel_Cadastro_Fornecedor().getLblCpf().setVisible(true);
				getPainel_Cadastro_Fornecedor().getLblCnpj().setVisible(false);
			}

			else if (getPainel_Cadastro_Fornecedor().getCbxTipo().getSelectedItem() == "CNPJ") {
				getPainel_Cadastro_Fornecedor().getTxtCpf().setVisible(false);
				getPainel_Cadastro_Fornecedor().getTxtCnpj().setVisible(true);
				getPainel_Cadastro_Fornecedor().getLblCpf().setVisible(false);
				getPainel_Cadastro_Fornecedor().getLblCnpj().setVisible(true);
			} else {
				getPainel_Cadastro_Fornecedor().getTxtCpf().setVisible(false);
				getPainel_Cadastro_Fornecedor().getTxtCnpj().setVisible(false);
				getPainel_Cadastro_Fornecedor().getLblCpf().setVisible(false);
				getPainel_Cadastro_Fornecedor().getLblCnpj().setVisible(false);
			}

		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnInserir() == true) {
			posi_zero();
			zera();
			trava_pesquisa();
			destrava();

			getPainel_Cadastro_Fornecedor().getBtnAlterar().setEnabled(false);
			getPainel_Cadastro_Fornecedor().getBtnExcluir().setEnabled(false);
			getPainel_Cadastro_Fornecedor().getBtnInserir().setEnabled(false);

			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Alteracao().setVisible(false);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Exclusao().setVisible(false);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar().setEnabled(true);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar().setVisible(true);

		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnAlterar() == true) {
			destrava_pesquisa();
			destrava();

			getPainel_Cadastro_Fornecedor().getBtnAlterar().setEnabled(false);
			getPainel_Cadastro_Fornecedor().getBtnExcluir().setEnabled(false);
			getPainel_Cadastro_Fornecedor().getBtnInserir().setEnabled(false);

			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Alteracao().setVisible(true);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Alteracao().setEnabled(true);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Exclusao().setVisible(false);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar().setVisible(false);

		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnExcluir() == true) {
			destrava_pesquisa();
			trava();

			getPainel_Cadastro_Fornecedor().getBtnAlterar().setEnabled(false);
			getPainel_Cadastro_Fornecedor().getBtnExcluir().setEnabled(false);
			getPainel_Cadastro_Fornecedor().getBtnInserir().setEnabled(false);

			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Alteracao().setVisible(false);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar().setVisible(false);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Exclusao().setEnabled(true);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Exclusao().setVisible(true);
		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnConfirmar()) {

			int saida = JOptionPane.showConfirmDialog(getPainel_Cadastro_Fornecedor(), "Deseja realmente inserir?",
					"Confirmação de inserção", JOptionPane.YES_NO_OPTION);
			if (saida == 0) {
				try {

					Validate_Fornecedor validacao1 = new Validate_Fornecedor(getPainel_Cadastro_Fornecedor());
					if (validacao1.validacao_Fornecedor(getPainel_Cadastro_Fornecedor()) == true) {
						Fornecedor fornecedor = new Fornecedor(0, validacao1.getTipo(), validacao1.getCpfcnpj(),
								validacao1.getNome(), validacao1.getCep(), validacao1.getRua(), validacao1.getNumero(),
								validacao1.getBairro(), validacao1.getCidade(), validacao1.getUf(),
								validacao1.getTelefone(), validacao1.getCelular(), validacao1.getEmail(),
								validacao1.getComplemento());
						Fornecedor_Dao.create(fornecedor);
						getPainel_Cadastro_Fornecedor().getBtnInserir().setEnabled(true);
						getPainel_Cadastro_Fornecedor().getBtnExcluir().setEnabled(true);
						getPainel_Cadastro_Fornecedor().getBtnAlterar().setEnabled(true);

						zera();
						trava();
						destrava_pesquisa();
					}

				} catch (ParseException e1) {
					e1.printStackTrace();
				}
		}

	}

	}

	public painelCadastroForncedor getPainel_Cadastro_Fornecedor() {
		if (painel_Cadastro_Fornecedor == null) {
			painel_Cadastro_Fornecedor = new painelCadastroForncedor();
		}
		return painel_Cadastro_Fornecedor;
	}

	public ArrayList<Fornecedor> getFornecedores() {
		if (fornecedores == null) {
			fornecedores = new ArrayList<Fornecedor>();
		}
		return fornecedores;
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

	public void posi_zero() {
		getPainel_Cadastro_Fornecedor().getTxtBairro().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtCelular().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtCep().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtCidade().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtCnpj().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtCodigo().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtComplemento().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtCpf().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtEmail().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtNome().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtNumero().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtPesquisa().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtPesquisaCNPJ().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtPesquisaCodigo().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getTxtPesquisaCPF().setCaretPosition(0);

	}

	public void trava_pesquisa() {

		painel_Cadastro_Fornecedor.getTxtPesquisaCNPJ().setEnabled(false);
		painel_Cadastro_Fornecedor.getTxtPesquisaCPF().setEnabled(false);
		painel_Cadastro_Fornecedor.getTxtPesquisa().setEnabled(false);
		painel_Cadastro_Fornecedor.getTxtPesquisaCodigo().setEnabled(false);

		painel_Cadastro_Fornecedor.getBtnPesquisaCPF().setEnabled(false);
		painel_Cadastro_Fornecedor.getBtnPesquisaNome().setEnabled(false);
		painel_Cadastro_Fornecedor.getBtnPesquisaCodigo().setEnabled(false);
		painel_Cadastro_Fornecedor.getBtnPesquisaCNPJ().setEnabled(false);

		painel_Cadastro_Fornecedor.getCbxTipoPesquisa().setEnabled(false);

	}

	public void destrava_pesquisa() {

		painel_Cadastro_Fornecedor.getTxtPesquisaCNPJ().setEnabled(true);
		painel_Cadastro_Fornecedor.getTxtPesquisaCPF().setEnabled(true);
		painel_Cadastro_Fornecedor.getTxtPesquisa().setEnabled(true);
		painel_Cadastro_Fornecedor.getTxtPesquisaCodigo().setEnabled(true);

		painel_Cadastro_Fornecedor.getBtnPesquisaCPF().setEnabled(true);
		painel_Cadastro_Fornecedor.getBtnPesquisaNome().setEnabled(true);
		painel_Cadastro_Fornecedor.getBtnPesquisaCodigo().setEnabled(true);
		painel_Cadastro_Fornecedor.getBtnPesquisaCNPJ().setEnabled(true);

		painel_Cadastro_Fornecedor.getCbxTipoPesquisa().setEnabled(true);

	}

	public void zera() {
		getPainel_Cadastro_Fornecedor().getTxtPesquisa().setText(null);
		getPainel_Cadastro_Fornecedor().getBtnPesquisaNome().setEnabled(true);
		getPainel_Cadastro_Fornecedor().getCbxTipoPesquisa().setSelectedItem("-Selecione-");
		getPainel_Cadastro_Fornecedor().getTxtCodigo().setText(null);
		getPainel_Cadastro_Fornecedor().getCbxTipo().setSelectedItem("-Selecione-");
		getPainel_Cadastro_Fornecedor().getTxtCpf().setText(null);
		getPainel_Cadastro_Fornecedor().getTxtCnpj().setText(null);
		getPainel_Cadastro_Fornecedor().getTxtNome().setText(null);
		getPainel_Cadastro_Fornecedor().getTxtCep().setText(null);
		getPainel_Cadastro_Fornecedor().getTxtRua().setText(null);
		getPainel_Cadastro_Fornecedor().getTxtNumero().setText(null);
		getPainel_Cadastro_Fornecedor().getTxtBairro().setText(null);
		getPainel_Cadastro_Fornecedor().getTxtCidade().setText(null);
		getPainel_Cadastro_Fornecedor().getCbxUf().setSelectedItem("-Selecione-");
		getPainel_Cadastro_Fornecedor().getTxtTelefone().setText(null);
		getPainel_Cadastro_Fornecedor().getTxtCelular().setText(null);
		getPainel_Cadastro_Fornecedor().getTxtEmail().setText(null);
		getPainel_Cadastro_Fornecedor().getTxtComplemento().setText(null);
		getPainel_Cadastro_Fornecedor().getDefaultTableModel().setNumRows(0);
		getPainel_Cadastro_Fornecedor().getTabela().setEditingRow(0);
		getPainel_Cadastro_Fornecedor().getTabela().setEditingColumn(0);
		getPainel_Cadastro_Fornecedor().getDefaultTableModel().isCellEditable(0, 0);
		painel_Cadastro_Fornecedor.getTxtPesquisa().setCaretPosition(0);
		getPainel_Cadastro_Fornecedor().getBtnAlterar().setEnabled(false);
		getPainel_Cadastro_Fornecedor().getBtnExcluir().setEnabled(false);
		getPainel_Cadastro_Fornecedor().getBtnInserir().setEnabled(true);

	}

	public void trava() {

		getPainel_Cadastro_Fornecedor().getCbxTipo().setEnabled(false);
		getPainel_Cadastro_Fornecedor().getTxtCpf().setEditable(false);
		getPainel_Cadastro_Fornecedor().getTxtCnpj().setEditable(false);
		getPainel_Cadastro_Fornecedor().getTxtNome().setEditable(false);
		getPainel_Cadastro_Fornecedor().getTxtCep().setEditable(false);
		getPainel_Cadastro_Fornecedor().getTxtRua().setEditable(false);
		getPainel_Cadastro_Fornecedor().getTxtNumero().setEditable(false);
		getPainel_Cadastro_Fornecedor().getTxtBairro().setEditable(false);
		getPainel_Cadastro_Fornecedor().getTxtCidade().setEditable(false);
		getPainel_Cadastro_Fornecedor().getCbxUf().setEnabled(false);
		getPainel_Cadastro_Fornecedor().getTxtTelefone().setEditable(false);
		getPainel_Cadastro_Fornecedor().getTxtCelular().setEditable(false);
		getPainel_Cadastro_Fornecedor().getTxtEmail().setEditable(false);
		getPainel_Cadastro_Fornecedor().getTxtComplemento().setEditable(false);

		getPainel_Cadastro_Fornecedor().getBtnConfirmar().setEnabled(false);
		getPainel_Cadastro_Fornecedor().getBtnConfirmar_Alteracao().setEnabled(false);
		getPainel_Cadastro_Fornecedor().getBtnConfirmar_Exclusao().setEnabled(false);

	}

	public void destrava() {

		getPainel_Cadastro_Fornecedor().getCbxTipo().setEnabled(true);
		getPainel_Cadastro_Fornecedor().getTxtCpf().setEditable(true);
		getPainel_Cadastro_Fornecedor().getTxtCnpj().setEditable(true);
		getPainel_Cadastro_Fornecedor().getTxtNome().setEditable(true);
		getPainel_Cadastro_Fornecedor().getTxtCep().setEditable(true);
		getPainel_Cadastro_Fornecedor().getTxtRua().setEditable(true);
		getPainel_Cadastro_Fornecedor().getTxtNumero().setEditable(true);
		getPainel_Cadastro_Fornecedor().getTxtBairro().setEditable(true);
		getPainel_Cadastro_Fornecedor().getTxtCidade().setEditable(true);
		getPainel_Cadastro_Fornecedor().getCbxUf().setEnabled(true);
		getPainel_Cadastro_Fornecedor().getTxtTelefone().setEditable(true);
		getPainel_Cadastro_Fornecedor().getTxtCelular().setEditable(true);
		getPainel_Cadastro_Fornecedor().getTxtEmail().setEditable(true);
		getPainel_Cadastro_Fornecedor().getTxtComplemento().setEditable(true);

		getPainel_Cadastro_Fornecedor().getBtnConfirmar().setEnabled(true);
		getPainel_Cadastro_Fornecedor().getBtnConfirmar_Alteracao().setEnabled(true);
		getPainel_Cadastro_Fornecedor().getBtnConfirmar_Exclusao().setEnabled(true);

	}

}

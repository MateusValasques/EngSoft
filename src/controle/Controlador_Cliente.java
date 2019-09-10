package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import dao.Cliente_Dao;
import dao.Fornecedor_Dao;
import dao.Cliente_Dao;
import modelo.Cliente;
import modelo.Funcionario;
import visão.PainelCadastroCliente;

public class Controlador_Cliente implements ActionListener, MouseListener {

	PainelCadastroCliente painelCliente;
	Cliente_Dao clienteDao;

	public Controlador_Cliente(PainelCadastroCliente painelCliente, Cliente_Dao clienteDao) {

		this.painelCliente = painelCliente;
		this.clienteDao = clienteDao;
		addEventos();
	}

	private void addEventos() {
		painelCliente.getBtnAlterar().addActionListener(this);
		painelCliente.getBtnExcluir().addActionListener(this);
		painelCliente.getBtnInserir().addActionListener(this);
		painelCliente.getCbxTipo().addActionListener(this);
		
		painelCliente.getBtnCancelar().addActionListener(this);
		painelCliente.getBtnConfirmarAlteracao().addActionListener(this);
		painelCliente.getBtnConfirmarExclusao().addActionListener(this);
		painelCliente.getBtnConfirmarInclusao().addActionListener(this);

		painelCliente.getBtnPesquisaCNPJ().addActionListener(this);
		painelCliente.getBtnPesquisaCodigo().addActionListener(this);
		painelCliente.getBtnPesquisaCPF().addActionListener(this);
		painelCliente.getBtnPesquisaNome().addActionListener(this);
		painelCliente.getCbxTipoPesquisa().addActionListener(this);

		painelCliente.getTabela().addMouseListener(this);
		

	}

	public void mouseClicked(MouseEvent e) {

		if (painelCliente.getTabela().getSelectedRow() > -1) {
			int x = (int) painelCliente.getTabela().getValueAt(painelCliente.getTabela().getSelectedRow(), 0);
			Cliente cliente = new Cliente();
			cliente = Cliente_Dao.busca_simples(x);
			String y = "" + cliente.getCodigo();
			painelCliente.getTxtCodigo().setText(y);
			painelCliente.getCbxTipo().setSelectedItem(cliente.getTipo());
			painelCliente.getBtnAlterar().setEnabled(true);
			painelCliente.getBtnExcluir().setEnabled(true);
			painelCliente.getBtnInserir().setEnabled(false);
			if (cliente.isAtivo() == true)
				painelCliente.getRbtnAtivo().setSelected(true);
			else
				painelCliente.getRbtnNaoAtivo().setSelected(true);

			if (painelCliente.getCbxTipo().getSelectedItem() == "CPF")
				painelCliente.getTxtCpf().setText(cliente.getCpfcnpj());

			else if (painelCliente.getCbxTipo().getSelectedItem() == "CNPJ")
				painelCliente.getTxtCNPJ().setText(cliente.getCpfcnpj());

			painelCliente.getTxtLimiteCredito().setText(cliente.getLimite_credito());
			painelCliente.getTxtNome().setText(cliente.getNome());
			painelCliente.getTxtCep().setText(cliente.getCep());
			painelCliente.getTxtRua().setText(cliente.getRua());
			painelCliente.getTxtNumero().setText(cliente.getNumero());
			painelCliente.getTxtBairro().setText(cliente.getBairro());
			painelCliente.getTxtCidade().setText(cliente.getCidade());
			painelCliente.getCbxUf().setSelectedItem(cliente.getUf());
			painelCliente.getTxtTelefone().setText(cliente.getTelefone());
			painelCliente.getTxtCelular().setText(cliente.getCelular());
			painelCliente.getTxtEmail().setText(cliente.getEmail());
			painelCliente.getTxtComplemento().setText(cliente.getComplemento());

		}

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == painelCliente.getBtnCancelar()) {
			
			int saida = JOptionPane.showConfirmDialog(painelCliente, "Deseja realmente cancelar?",
					"Cancelar", JOptionPane.YES_NO_OPTION);
			if (saida == 0) {
				zera();
				trava();
				destrava_pesquisa();
			}
			
			
		}
		if (e.getSource() == painelCliente.getBtnConfirmarInclusao() == true) {
			System.out.println("oi");
			if (JOptionPane.showConfirmDialog(painelCliente,
					"Tem certeza que deseja inserir?") == JOptionPane.YES_OPTION) {
				try {
					Validate_Cliente validacao = new Validate_Cliente(painelCliente);
					System.out.println("oi");
					if (validacao.validacao_Cliente(painelCliente) == true) {
						Cliente cliente = new Cliente(0, validacao.getTipo(), validacao.getCpfcnpj(),
								validacao.getNome(), validacao.getCep(), validacao.getRua(), validacao.getNumero(),
								validacao.getBairro(), validacao.getCidade(), validacao.getUf(),
								validacao.getTelefone(), validacao.getCelular(), validacao.getEmail(),
								validacao.getLimiteCompra(), validacao.isAtivo(), validacao.getComplemento());

						Cliente_Dao.create(cliente);
					} else
						JOptionPane.showMessageDialog(null, "Falha validação");

				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			trava();
			destrava_pesquisa();
			zera();

		}

		if (e.getSource() == painelCliente.getBtnConfirmarAlteracao()) {
			if (JOptionPane.showConfirmDialog(painelCliente,
					"Tem certeza que deseja Alterar?") == JOptionPane.YES_OPTION) {
				try {
					Validate_Cliente validacao = new Validate_Cliente(painelCliente);
					String codigo = painelCliente.getTxtCodigo().getText();
					int valor = Integer.parseInt(codigo);
					if (validacao.validacao_Cliente(painelCliente) == true) {
						Cliente cliente = new Cliente(0, validacao.getTipo(), validacao.getCpfcnpj(),
								validacao.getNome(), validacao.getCep(), validacao.getRua(), validacao.getNumero(),
								validacao.getBairro(), validacao.getCidade(), validacao.getUf(),
								validacao.getTelefone(), validacao.getCelular(), validacao.getEmail(),
								validacao.getLimiteCompra(), validacao.isAtivo(), validacao.getComplemento());
						cliente.setCodigo(valor);
						System.out.println("dsadsa");
						Cliente_Dao.update(cliente);
					} else
						JOptionPane.showMessageDialog(null, "Falha validação");

				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			trava();
			destrava_pesquisa();
			zera();
		}

		if (e.getSource() == painelCliente.getBtnConfirmarExclusao()) {

			if (JOptionPane.showConfirmDialog(painelCliente,
					"Tem certeza que deseja excluir ?") == JOptionPane.YES_OPTION) {
				Cliente_Dao.delete(Integer.parseInt(painelCliente.getTxtCodigo().getText()));
			}
			trava();
			destrava_pesquisa();
			zera();
		}

		if (e.getSource() == painelCliente.getCbxTipo()) {

			if (painelCliente.getCbxTipo().getSelectedItem() == "CPF") {
				painelCliente.getTxtCpf().setVisible(true);
				painelCliente.getTxtCNPJ().setVisible(false);
				painelCliente.getLblCpfcnpj().setVisible(true);
				painelCliente.getLblCnpj().setVisible(false);
			}

			else if (painelCliente.getCbxTipo().getSelectedItem() == "CNPJ") {
				painelCliente.getTxtCpf().setVisible(false);
				painelCliente.getTxtCNPJ().setVisible(true);
				painelCliente.getLblCpfcnpj().setVisible(false);
				painelCliente.getLblCnpj().setVisible(true);
			} else {
				painelCliente.getTxtCpf().setVisible(false);
				painelCliente.getTxtCNPJ().setVisible(false);
				painelCliente.getLblCpfcnpj().setVisible(false);
				painelCliente.getLblCnpj().setVisible(false);
			}

		}

		if (e.getSource() == painelCliente.getCbxTipoPesquisa()) {
			if (painelCliente.getCbxTipoPesquisa().getSelectedItem() == "CPF") {
				painelCliente.getTxtPesquisaCPF().setVisible(true);
				painelCliente.getTxtPesquisaCPF().setEditable(true);
				painelCliente.getTxtPesquisaNome().setVisible(false);
				painelCliente.getTxtPesquisaCNPJ().setVisible(false);
				painelCliente.getTxtPesquisaCodigo().setVisible(false);
				painelCliente.getBtnPesquisaCPF().setVisible(true);
				painelCliente.getBtnPesquisaCPF().setEnabled(true);
				painelCliente.getBtnPesquisaNome().setVisible(false);
				painelCliente.getBtnPesquisaCNPJ().setVisible(false);
				painelCliente.getBtnPesquisaCodigo().setVisible(false);

			}
			if (painelCliente.getCbxTipoPesquisa().getSelectedItem() == "CNPJ") {

				painelCliente.getTxtPesquisaCNPJ().setEditable(true);
				painelCliente.getTxtPesquisaCPF().setVisible(false);
				painelCliente.getTxtPesquisaNome().setVisible(false);
				painelCliente.getTxtPesquisaCNPJ().setVisible(true);
				painelCliente.getTxtPesquisaCodigo().setVisible(false);

				painelCliente.getBtnPesquisaCPF().setVisible(false);
				painelCliente.getBtnPesquisaNome().setVisible(false);
				painelCliente.getBtnPesquisaCNPJ().setVisible(true);
				painelCliente.getBtnPesquisaCodigo().setVisible(false);
				painelCliente.getBtnPesquisaCNPJ().setEnabled(true);

			}
			if (painelCliente.getCbxTipoPesquisa().getSelectedItem() == "Nome") {
				painelCliente.getTxtPesquisaNome().setEditable(true);
				painelCliente.getTxtPesquisaCPF().setEditable(false);
				painelCliente.getTxtPesquisaNome().setVisible(true);
				painelCliente.getTxtPesquisaCNPJ().setVisible(false);
				painelCliente.getTxtPesquisaCodigo().setVisible(false);
				painelCliente.getBtnPesquisaCPF().setVisible(false);
				painelCliente.getBtnPesquisaNome().setVisible(true);
				painelCliente.getBtnPesquisaCNPJ().setVisible(false);
				painelCliente.getBtnPesquisaCodigo().setVisible(false);
				painelCliente.getBtnPesquisaNome().setEnabled(true);

			}
			if (painelCliente.getCbxTipoPesquisa().getSelectedItem() == "Código") {

				painelCliente.getTxtPesquisaCodigo().setEditable(true);
				painelCliente.getTxtPesquisaCPF().setVisible(false);
				painelCliente.getTxtPesquisaNome().setVisible(false);
				painelCliente.getTxtPesquisaCNPJ().setVisible(false);
				painelCliente.getTxtPesquisaCodigo().setVisible(true);
				painelCliente.getBtnPesquisaCPF().setVisible(false);
				painelCliente.getBtnPesquisaNome().setVisible(false);
				painelCliente.getBtnPesquisaCNPJ().setVisible(false);
				painelCliente.getBtnPesquisaCodigo().setVisible(true);
				painelCliente.getBtnPesquisaCodigo().setEnabled(true);

			}

			if (e.getSource() == painelCliente.getCbxTipo()) {

				if (painelCliente.getCbxTipo().getSelectedItem() == "CPF") {
					painelCliente.getTxtCpf().setVisible(true);
					painelCliente.getTxtCNPJ().setVisible(false);
					painelCliente.getLblCpfcnpj().setVisible(true);
					painelCliente.getLblCnpj().setVisible(false);
				}

				else if (painelCliente.getCbxTipo().getSelectedItem() == "CNPJ") {
					painelCliente.getTxtCpf().setVisible(false);
					painelCliente.getTxtCNPJ().setVisible(true);
					painelCliente.getLblCpfcnpj().setVisible(false);
					painelCliente.getLblCnpj().setVisible(true);
				} else {
					painelCliente.getTxtCpf().setVisible(false);
					painelCliente.getTxtCNPJ().setVisible(false);
					painelCliente.getLblCpfcnpj().setVisible(false);
					painelCliente.getLblCnpj().setVisible(false);
				}

			}
		}

		if (e.getSource() == painelCliente.getBtnInserir() == true) {
			
			destrava();
			zera();
			trava_pesquisa();
			
			painelCliente.getBtnConfirmarInclusao().setEnabled(true);
			painelCliente.getBtnConfirmarInclusao().setVisible(true);
			painelCliente.getBtnConfirmarAlteracao().setVisible(false);
			painelCliente.getBtnConfirmarExclusao().setVisible(false);
			
			painelCliente.getBtnInserir().setEnabled(false);
			painelCliente.getBtnExcluir().setEnabled(false);
			painelCliente.getBtnAlterar().setEnabled(false);
			

		}
		if (e.getSource() == painelCliente.getBtnAlterar() == true) {
			destrava();
			destrava_pesquisa();
			painelCliente.getBtnConfirmarInclusao().setVisible(false);
			painelCliente.getBtnConfirmarAlteracao().setVisible(true);
			painelCliente.getBtnConfirmarExclusao().setVisible(false);
			painelCliente.getBtnConfirmarAlteracao().setEnabled(true);
			
			painelCliente.getBtnInserir().setEnabled(false);
			painelCliente.getBtnExcluir().setEnabled(false);
			painelCliente.getBtnAlterar().setEnabled(false);
		}
		if (e.getSource() == painelCliente.getBtnExcluir() == true) {
			trava();
			destrava_pesquisa();
			painelCliente.getBtnConfirmarInclusao().setVisible(false);
			painelCliente.getBtnConfirmarAlteracao().setVisible(false);
			painelCliente.getBtnConfirmarExclusao().setVisible(true);
			painelCliente.getBtnConfirmarExclusao().setEnabled(true);
			
			painelCliente.getBtnInserir().setEnabled(false);
			painelCliente.getBtnExcluir().setEnabled(false);
			painelCliente.getBtnAlterar().setEnabled(false);

		}
		if (e.getSource() == painelCliente.getBtnPesquisaCNPJ()) {
			System.out.println("cnpj");
			pesquisa_cnpj();
		}
		if (e.getSource() == painelCliente.getBtnPesquisaCPF()) {
			System.out.println("cpf");
			pesquisa_cpf();
		}
		if (e.getSource() == painelCliente.getBtnPesquisaCodigo()) {
			System.out.println("codigo");
			pesquisa_codigo();
		}
		if (e.getSource() == painelCliente.getBtnPesquisaNome()) {
			System.out.println("nome");
			pesquisa_nome();
		}
	}

	public void pesquisa_nome() {
		painelCliente.getDefaultTableModel().setNumRows(0);
		painelCliente.getTabela().setEditingRow(0);
		painelCliente.getTabela().setEditingColumn(0);
		painelCliente.getDefaultTableModel().isCellEditable(0, 0);
		System.out.println(painelCliente.getTxtNome().getText());
		Cliente_Dao.pesquisa_nome(painelCliente.getTxtPesquisaNome().getText());
	}

	public void pesquisa_cpf() {

		painelCliente.getDefaultTableModel().setNumRows(0);
		painelCliente.getTabela().setEditingRow(0);
		painelCliente.getTabela().setEditingColumn(0);
		painelCliente.getDefaultTableModel().isCellEditable(0, 0);
		Cliente_Dao.pesquisa_cpf_cnpj((painelCliente.getTxtPesquisaCPF().getText()).trim());

	}

	public void pesquisa_codigo() {
		painelCliente.getDefaultTableModel().setNumRows(0);
		painelCliente.getTabela().setEditingRow(0);
		painelCliente.getTabela().setEditingColumn(0);
		painelCliente.getDefaultTableModel().isCellEditable(0, 0);
		Cliente_Dao.pesquisa_codigo(Integer.parseInt(painelCliente.getTxtPesquisaCodigo().getText()));
	}

	public void pesquisa_cnpj() {

		painelCliente.getDefaultTableModel().setNumRows(0);
		painelCliente.getTabela().setEditingRow(0);
		painelCliente.getTabela().setEditingColumn(0);
		painelCliente.getDefaultTableModel().isCellEditable(0, 0);
		Cliente_Dao.pesquisa_cpf_cnpj((painelCliente.getTxtPesquisaCNPJ().getText()).trim());

	}

	public void trava_pesquisa() {

		painelCliente.getTxtPesquisaCNPJ().setEnabled(false);
		painelCliente.getTxtPesquisaCPF().setEnabled(false);
		painelCliente.getTxtPesquisaNome().setEnabled(false);
		painelCliente.getTxtPesquisaCodigo().setEnabled(false);

		painelCliente.getBtnPesquisaCPF().setEnabled(false);
		painelCliente.getBtnPesquisaNome().setEnabled(false);
		painelCliente.getBtnPesquisaCodigo().setEnabled(false);
		painelCliente.getBtnPesquisaCNPJ().setEnabled(false);

		painelCliente.getCbxTipoPesquisa().setEnabled(false);

	}

	public void destrava_pesquisa() {

		painelCliente.getTxtPesquisaCNPJ().setEnabled(true);
		painelCliente.getTxtPesquisaCPF().setEnabled(true);
		painelCliente.getTxtPesquisaNome().setEnabled(true);
		painelCliente.getTxtPesquisaCodigo().setEnabled(true);

		painelCliente.getBtnPesquisaCPF().setEnabled(true);
		painelCliente.getBtnPesquisaNome().setEnabled(true);
		painelCliente.getBtnPesquisaCodigo().setEnabled(true);
		painelCliente.getBtnPesquisaCNPJ().setEnabled(true);

		painelCliente.getCbxTipoPesquisa().setEnabled(true);

	}

	public void zera() {

		painelCliente.getTxtLimiteCredito().setText(null);
		painelCliente.getTxtPesquisaNome().setText(null);
		painelCliente.getBtnPesquisaNome().setEnabled(true);
		painelCliente.getCbxTipoPesquisa().setSelectedItem("-Selecione-");
		painelCliente.getTxtCodigo().setText(null);
		painelCliente.getCbxTipo().setSelectedItem("-Selecione-");
		painelCliente.getTxtCpf().setText(null);
		painelCliente.getTxtCNPJ().setText(null);
		painelCliente.getTxtNome().setText(null);
		painelCliente.getTxtCep().setText(null);
		painelCliente.getTxtRua().setText(null);
		painelCliente.getTxtNumero().setText(null);
		painelCliente.getTxtBairro().setText(null);
		painelCliente.getTxtCidade().setText(null);
		painelCliente.getCbxUf().setSelectedItem("-Selecione-");
		painelCliente.getTxtTelefone().setText(null);
		painelCliente.getTxtCelular().setText(null);
		painelCliente.getTxtEmail().setText(null);
		painelCliente.getTxtComplemento().setText(null);
		painelCliente.getDefaultTableModel().setNumRows(0);
		painelCliente.getTabela().setEditingRow(0);
		painelCliente.getTabela().setEditingColumn(0);
		painelCliente.getDefaultTableModel().isCellEditable(0, 0);
		painelCliente.getTxtPesquisaNome().setCaretPosition(0);
		painelCliente.getBtnAlterar().setEnabled(false);
		painelCliente.getBtnExcluir().setEnabled(false);
		painelCliente.getBtnInserir().setEnabled(true);

	}

	public void trava() {

		painelCliente.getTxtLimiteCredito().setEnabled(false);
		painelCliente.getCbxTipo().setEnabled(false);
		painelCliente.getTxtCpf().setEnabled(false);
		painelCliente.getTxtCNPJ().setEnabled(false);
		painelCliente.getTxtNome().setEnabled(false);
		painelCliente.getTxtCep().setEnabled(false);
		painelCliente.getTxtRua().setEnabled(false);
		painelCliente.getTxtNumero().setEnabled(false);
		painelCliente.getTxtBairro().setEnabled(false);
		painelCliente.getTxtCidade().setEnabled(false);
		painelCliente.getCbxUf().setEnabled(false);
		painelCliente.getTxtTelefone().setEnabled(false);
		painelCliente.getTxtCelular().setEnabled(false);
		painelCliente.getTxtEmail().setEnabled(false);
		painelCliente.getTxtComplemento().setEnabled(false);

		painelCliente.getRbtnAtivo().setEnabled(false);
		painelCliente.getRbtnNaoAtivo().setEnabled(false);

		painelCliente.getBtnConfirmarAlteracao().setEnabled(false);
		painelCliente.getBtnConfirmarExclusao().setEnabled(false);
		painelCliente.getBtnConfirmarInclusao().setEnabled(false);

	}

	public void destrava() {

		painelCliente.getTxtLimiteCredito().setEnabled(true);
		painelCliente.getCbxTipo().setEnabled(true);
		painelCliente.getTxtCpf().setEnabled(true);
		painelCliente.getTxtCNPJ().setEnabled(true);
		painelCliente.getTxtNome().setEnabled(true);
		painelCliente.getTxtCep().setEnabled(true);
		painelCliente.getTxtRua().setEnabled(true);
		painelCliente.getTxtNumero().setEnabled(true);
		painelCliente.getTxtBairro().setEnabled(true);
		painelCliente.getTxtCidade().setEnabled(true);
		painelCliente.getCbxUf().setEnabled(true);
		painelCliente.getTxtTelefone().setEnabled(true);
		painelCliente.getTxtCelular().setEnabled(true);
		painelCliente.getTxtEmail().setEnabled(true);
		painelCliente.getTxtComplemento().setEnabled(true);

		painelCliente.getRbtnAtivo().setEnabled(true);
		painelCliente.getRbtnNaoAtivo().setEnabled(true);

		painelCliente.getBtnConfirmarAlteracao().setEnabled(true);
		painelCliente.getBtnConfirmarExclusao().setEnabled(true);
		painelCliente.getBtnConfirmarInclusao().setEnabled(true);

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

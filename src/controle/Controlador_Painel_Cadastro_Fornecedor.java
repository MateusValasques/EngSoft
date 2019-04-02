package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import dao.Fornecedor_Dao;
import modelo.Fornecedor;
import visão.painelCadastroForncedor;

public class Controlador_Painel_Cadastro_Fornecedor implements ActionListener {

	painelCadastroForncedor painel_Cadastro_Fornecedor;
	ArrayList<Fornecedor> fornecedores;

	public Controlador_Painel_Cadastro_Fornecedor(painelCadastroForncedor painel_Cadastro_Fornecedor) {

		this.painel_Cadastro_Fornecedor = painel_Cadastro_Fornecedor;

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
		getPainel_Cadastro_Fornecedor().getBtnPesquisar().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnPesquisar()) {
			Fornecedor fornecedor = new Fornecedor();
//			fornecedores = fornece
			fornecedor = Pesquisar.nome(getPainel_Cadastro_Fornecedor());
			String y = Integer.toString(fornecedor.getCodigo());
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

			getPainel_Cadastro_Fornecedor().getTxtPesquisa().setEditable(true);
			getPainel_Cadastro_Fornecedor().getBtnPesquisar().setEnabled(true);
			getPainel_Cadastro_Fornecedor().getCbxTipoPesquisa().setEnabled(true);
//			getPainel_Cadastro_Fornecedor().getList().setEnabled(true);

			getPainel_Cadastro_Fornecedor().getCbxTipo().setEnabled(false);
			getPainel_Cadastro_Fornecedor().getTxtCpf().setEditable(false);
			getPainel_Cadastro_Fornecedor().getTxtCnpj().setEditable(false);
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
			// System.out.println(fornecedor.getNome());
		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnConfirmar_Alteracao()) {

			try {
				Validate_Fornecedor validacao = new Validate_Fornecedor(getPainel_Cadastro_Fornecedor());
 
				if (validacao.validacao_Fornecedor(getPainel_Cadastro_Fornecedor()) == true) {
					String codigo = painel_Cadastro_Fornecedor.getTxtCodigo().getText();
					int valor = Integer.parseInt(codigo);
					System.out.println("oi " + codigo);
					Fornecedor fornecedor = new Fornecedor(1, validacao.getTipo(), validacao.getCpfcnpj(),
							validacao.getNome(), validacao.getCep(), validacao.getRua(), validacao.getNumero(),
							validacao.getBairro(), validacao.getCidade(), validacao.getUf(), validacao.getTelefone(),
							validacao.getCelular(), validacao.getEmail(), validacao.getComplemento());
					fornecedor.setCodigo(valor);

					Fornecedor_Dao.update(fornecedor);
				}

			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnConfirmar_Exclusao()) {

			try {
				Validate_Fornecedor validacao = new Validate_Fornecedor(getPainel_Cadastro_Fornecedor());
 
				if (validacao.validacao_Fornecedor(getPainel_Cadastro_Fornecedor()) == true) {
					String codigo = painel_Cadastro_Fornecedor.getTxtCodigo().getText();
					int valor = Integer.parseInt(codigo);
					Fornecedor fornecedor = new Fornecedor(1, validacao.getTipo(), validacao.getCpfcnpj(),
							validacao.getNome(), validacao.getCep(), validacao.getRua(), validacao.getNumero(),
							validacao.getBairro(), validacao.getCidade(), validacao.getUf(), validacao.getTelefone(),
							validacao.getCelular(), validacao.getEmail(), validacao.getComplemento());
					fornecedor.setCodigo(valor);

					Fornecedor_Dao.delete(fornecedor);
				}

			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
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

			zera();
			getPainel_Cadastro_Fornecedor().getBtnConfirmar().setVisible(true);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Alteracao().setVisible(false);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Exclusao().setVisible(false);

			getPainel_Cadastro_Fornecedor().getTxtPesquisa().setEditable(false);
			getPainel_Cadastro_Fornecedor().getBtnPesquisar().setEnabled(false);
			getPainel_Cadastro_Fornecedor().getCbxTipoPesquisa().setEnabled(false);
//			getPainel_Cadastro_Fornecedor().getList().setEnabled(false);

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

		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnAlterar() == true) {

			zera();
			getPainel_Cadastro_Fornecedor().getBtnConfirmar().setVisible(false);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Alteracao().setVisible(true);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Exclusao().setVisible(false);

			getPainel_Cadastro_Fornecedor().getTxtPesquisa().setEditable(true);
			getPainel_Cadastro_Fornecedor().getBtnPesquisar().setEnabled(true);
			getPainel_Cadastro_Fornecedor().getCbxTipoPesquisa().setEnabled(true);
//			getPainel_Cadastro_Fornecedor().getList().setEnabled(true);

			getPainel_Cadastro_Fornecedor().getCbxTipo().setEnabled(false);
			getPainel_Cadastro_Fornecedor().getTxtCpf().setEditable(false);
			;
			;
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

		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnExcluir() == true) {

			getPainel_Cadastro_Fornecedor().getBtnConfirmar().setVisible(false);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Alteracao().setVisible(false);
			getPainel_Cadastro_Fornecedor().getBtnConfirmar_Exclusao().setVisible(true);

			getPainel_Cadastro_Fornecedor().getTxtPesquisa().setEditable(true);
			getPainel_Cadastro_Fornecedor().getBtnPesquisar().setEnabled(true);
			getPainel_Cadastro_Fornecedor().getCbxTipoPesquisa().setEnabled(true);
//			getPainel_Cadastro_Fornecedor().getList().setEnabled(true);

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

		}
		if (e.getSource() == getPainel_Cadastro_Fornecedor().getBtnConfirmar()) {

			try {

				Validate_Fornecedor validacao1 = new Validate_Fornecedor(getPainel_Cadastro_Fornecedor());
				if (validacao1.validacao_Fornecedor(getPainel_Cadastro_Fornecedor()) == true) {
					// falta colocar o código q é gerado
					Fornecedor fornecedor = new Fornecedor(0, validacao1.getTipo(), validacao1.getCpfcnpj(),
							validacao1.getNome(), validacao1.getCep(), validacao1.getRua(), validacao1.getNumero(),
							validacao1.getBairro(), validacao1.getCidade(), validacao1.getUf(),
							validacao1.getTelefone(), validacao1.getCelular(), validacao1.getEmail(),
							validacao1.getComplemento());

//					System.out.println(validacao.getNome());
//					System.out.println(validacao.getTipo()); 
//					System.out.println(validacao.getCpfcnpj());
					Fornecedor_Dao.create(fornecedor);
//					for (int i = 0; i < getFornecedores().size(); i++) {
//						
//						System.out.println(getFornecedores().get(i).getCpfcnpj());
//						
//					}

				}
			} catch (ParseException e1) {
				e1.printStackTrace();
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

	public void zera() {

		getPainel_Cadastro_Fornecedor().getTxtPesquisa().setText(null);
		;
		getPainel_Cadastro_Fornecedor().getBtnPesquisar().setEnabled(true);
		getPainel_Cadastro_Fornecedor().getCbxTipoPesquisa().setSelectedItem("-Selecione-");
//		getPainel_Cadastro_Fornecedor().getList().setEnabled(true);

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

	}
	
	

}

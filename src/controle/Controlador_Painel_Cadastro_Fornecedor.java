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
	Fornecedor fornecedor = new Fornecedor(0, null, null, null, null, null, null, null, null, null, null, null, null,
			null);
	ArrayList<Fornecedor> fornecedores = new ArrayList<>();

	public Controlador_Painel_Cadastro_Fornecedor(painelCadastroForncedor painel_Cadastro_Fornecedor,
			ArrayList<Fornecedor> fornecedores) {

		this.painel_Cadastro_Fornecedor = painel_Cadastro_Fornecedor;
		this.fornecedores = fornecedores;

		addEventos();
	}

	private void addEventos() {

		painel_Cadastro_Fornecedor.getBtnAlterar().addActionListener(this);
		painel_Cadastro_Fornecedor.getBtnConfirmar().addActionListener(this);
		painel_Cadastro_Fornecedor.getBtnCancelar().addActionListener(this);
		painel_Cadastro_Fornecedor.getBtnExcluir().addActionListener(this);
		painel_Cadastro_Fornecedor.getBtnInserir().addActionListener(this);
		painel_Cadastro_Fornecedor.getCbxTipo().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == painel_Cadastro_Fornecedor.getBtnAlterar()) {
			
			
			Fornecedor_Dao.update(fornecedores.get(6));
			
		}
		if (e.getSource() == painel_Cadastro_Fornecedor.getCbxTipo()) {

			if (painel_Cadastro_Fornecedor.getCbxTipo().getSelectedItem() == "CPF") {
				painel_Cadastro_Fornecedor.getTxtCpf().setVisible(true);
				painel_Cadastro_Fornecedor.getTxtCnpj().setVisible(false);
				painel_Cadastro_Fornecedor.getLblCpf().setVisible(true);
				painel_Cadastro_Fornecedor.getLblCnpj().setVisible(false);
			}

			else if (painel_Cadastro_Fornecedor.getCbxTipo().getSelectedItem() == "CNPJ") {
				painel_Cadastro_Fornecedor.getTxtCpf().setVisible(false);
				painel_Cadastro_Fornecedor.getTxtCnpj().setVisible(true);
				painel_Cadastro_Fornecedor.getLblCpf().setVisible(false);
				painel_Cadastro_Fornecedor.getLblCnpj().setVisible(true);
			} else {
				painel_Cadastro_Fornecedor.getTxtCpf().setVisible(false);
				painel_Cadastro_Fornecedor.getTxtCnpj().setVisible(false);
				painel_Cadastro_Fornecedor.getLblCpf().setVisible(false);
				painel_Cadastro_Fornecedor.getLblCnpj().setVisible(false);
			}

		}
		if (e.getSource() == painel_Cadastro_Fornecedor.getBtnConfirmar()) {

			try {
				Validate_Fornecedor validacao = new Validate_Fornecedor(painel_Cadastro_Fornecedor);
				if (validacao.validacao_Fornecedor(painel_Cadastro_Fornecedor) == true) {
					// falta colocar o código q é gerado
					fornecedor = new Fornecedor(0, validacao.getTipo(), validacao.getCpfcnpj(), validacao.getNome(),
							validacao.getCep(), validacao.getRua(), validacao.getNumero(), validacao.getBairro(),
							validacao.getCidade(), validacao.getUf(), validacao.getTelefone(), validacao.getCelular(),
							validacao.getEmail(), validacao.getComplemento());

//					System.out.println(validacao.getNome());
//					System.out.println(validacao.getTipo()); 
//					System.out.println(validacao.getCpfcnpj());
					Fornecedor_Dao.create(fornecedor);
					fornecedores = Fornecedor_Dao.read();
//					for (int i = 0; i < fornecedores.size(); i++) {
//						
//						System.out.println(fornecedores.get(i).getCpfcnpj());
//						
//					}

				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

		}

	}

}

package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import modelo.Fornecedor;
import visão.painelCadastroForncedor;

public class Controlador_Painel_Cadastro_Fornecedor implements ActionListener {

	painelCadastroForncedor painel_Cadastro_Fornecedor;
	Fornecedor fornecedor = new Fornecedor();

	public Controlador_Painel_Cadastro_Fornecedor(painelCadastroForncedor painel_Cadastro_Fornecedor, ArrayList<Fornecedor> fornecedores) {

		this.painel_Cadastro_Fornecedor = painel_Cadastro_Fornecedor;
	

		addEventos();
	}

	private void addEventos() {

		painel_Cadastro_Fornecedor.getBtnAlterar().addActionListener(this);
		painel_Cadastro_Fornecedor.getBtnConfirmar().addActionListener(this);
		painel_Cadastro_Fornecedor.getBtnCancelar().addActionListener(this);
		painel_Cadastro_Fornecedor.getBtnExcluir().addActionListener(this);
		painel_Cadastro_Fornecedor.getBtnInserir().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == painel_Cadastro_Fornecedor.getBtnConfirmar()) {

			try {
				Validate_Fornecedor validacao = new Validate_Fornecedor(painel_Cadastro_Fornecedor);
				if (validacao.validacao_Fornecedor(painel_Cadastro_Fornecedor) == true) {
					//falta colocar o código q é gerado
					fornecedor = new Fornecedor(0, validacao.getBairro(), validacao.getCelular(), validacao.getCep(), validacao.getCidade(),
							validacao.getComplemento(), validacao.getCpfcnpj(), validacao.getEmail(), validacao.getNome(), 
							validacao.getNumero(), validacao.getRua(), validacao.getTelefone(), validacao.getTipo(), validacao.getUf());
							
					
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

		}

	}

}

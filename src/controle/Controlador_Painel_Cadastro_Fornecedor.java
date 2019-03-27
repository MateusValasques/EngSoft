package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Fornecedor;
import visão.painelCadastroFornecedor;

public class Controlador_Painel_Cadastro_Fornecedor implements ActionListener {

	painelCadastroFornecedor painel_Cadastro_Fornecedor;
	Fornecedor fornecedor;
	static ArrayList<Fornecedor> fornecedores;

	public Controlador_Painel_Cadastro_Fornecedor(painelCadastroFornecedor painel_Cadastro_Fornecedor, ArrayList<Fornecedor> fornecedores) {

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

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == painel_Cadastro_Fornecedor.getBtnConfirmar()) {

			
				Validate_Fornecedor validacao = new Validate_Fornecedor(painel_Cadastro_Fornecedor);
				if (validacao.validacao_Fornecedor(painel_Cadastro_Fornecedor) == true) {
					//falta colocar o código q é gerado
					fornecedor = new Fornecedor(fornecedores.size(), validacao.getBairro(), validacao.getCelular(), validacao.getCep(), validacao.getCidade(),
							validacao.getComplemento(), validacao.getCpfcnpj(), validacao.getEmail(), validacao.getNome(), 
							validacao.getNumero(), validacao.getRua(), validacao.getTelefone(), validacao.getTipo(), validacao.getUf());
					fornecedores.add(fornecedor);	
					System.out.print(fornecedores.size());
					
					painel_Cadastro_Fornecedor.getCbxTipo().setSelectedIndex(0);
					painel_Cadastro_Fornecedor.getCbxUf().setSelectedIndex(0);
					
					painel_Cadastro_Fornecedor.getTxtBairro().setText("");
					painel_Cadastro_Fornecedor.getTxtCelular().setText("");
					painel_Cadastro_Fornecedor.getTxtCep().setText("");
					painel_Cadastro_Fornecedor.getTxtCidade().setText("");
					painel_Cadastro_Fornecedor.getTxtComplemento().setText("");
					painel_Cadastro_Fornecedor.getTxtCpfCnpj().setText("");
					painel_Cadastro_Fornecedor.getTxtEmail().setText("");
					painel_Cadastro_Fornecedor.getTxtNome().setText("");
					painel_Cadastro_Fornecedor.getTxtNumero().setText("");
					painel_Cadastro_Fornecedor.getTxtRua().setText("");
					painel_Cadastro_Fornecedor.getTxtTelefone().setText("");
				}
				else {
					JOptionPane.showMessageDialog(painel_Cadastro_Fornecedor,"Existem campos que não foram preechidos");
				}
			

		}

	}

}

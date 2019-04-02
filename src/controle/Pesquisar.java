package controle;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.swing.JPanel;

import dao.Fornecedor_Dao;
import modelo.Fornecedor;
import visão.painelCadastroForncedor;

public class Pesquisar {
	Fornecedor_Dao fornecedor_Dao;
	public static Fornecedor nome(painelCadastroForncedor painel) {
		ArrayList<Fornecedor> fornecedores = Fornecedor_Dao.read();
		
		for (int i = 0; i < fornecedores.size(); i++) {
			System.out.println(fornecedores.get(i).getNome());
			if(painel.getTxtPesquisa().getText().equals(fornecedores.get(i).getNome())){
				
				System.out.println(fornecedores.get(i).getCpfcnpj());
				System.out.println("oi");
				return fornecedores.get(i);
				
			}
			
			
		}
		
		return null;
	}
	
	public Fornecedor_Dao getFornecedor_Dao() {
		if(fornecedor_Dao == null) {
			fornecedor_Dao = new Fornecedor_Dao();
		}
		return fornecedor_Dao;
	}

}

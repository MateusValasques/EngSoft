package controle;

import java.util.ArrayList;

import dao.Fornecedor_Dao;
import dao.Produto_Dao;
import modelo.Fornecedor;
import visão.Modelo_Tabela;
import visão.PainelCadastroCliente;
import visão.PainelCadastroFuncionario;
import visão.painelCadastroForncedor;

public class Main {
	
	
	static painelCadastroForncedor painel_Cadastro_Forncedor = new painelCadastroForncedor();
	static PainelCadastroCliente painel_Cadastro_Cliente = new PainelCadastroCliente();
	static PainelCadastroFuncionario painel_Cadastro_Funcionario = new PainelCadastroFuncionario();
	
	static Controlador_Painel_Cadastro_Fornecedor controladorPainelCadastroFornecedor;
	static Controlador_Opcoes controladorOpcoes;
	
	
	
		
	
	public static void main(String[] args) {
		
		painel_Cadastro_Forncedor.setVisible(true);
		painel_Cadastro_Forncedor.setLocation(300,0);
		Fornecedor_Dao fornecedorDao = new Fornecedor_Dao();
		fornecedorDao.preencher_Tabela();
		controladorPainelCadastroFornecedor = new Controlador_Painel_Cadastro_Fornecedor(painel_Cadastro_Forncedor);
		
		
		
	}
	

}

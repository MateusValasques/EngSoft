package controle;

import java.util.ArrayList;

import modelo.Fornecedor;
import visão.PainelCadastroCliente;
import visão.PainelCadastroFuncionario;
import visão.painelCadastroForncedor;

public class Main {
	
	
	static painelCadastroForncedor painel_Cadastro_Forncedor = new painelCadastroForncedor();
	static PainelCadastroCliente painel_Cadastro_Cliente = new PainelCadastroCliente();
	static PainelCadastroFuncionario painel_Cadastro_Funcionario = new PainelCadastroFuncionario();
	
	static Controlador_Painel_Cadastro_Fornecedor controladorPainelCadastroFornecedor;
	static Controlador_Opcoes controladorOpcoes;
	
	static ArrayList<Fornecedor> Fornecedores = new ArrayList();
	
	public static void main(String[] args) {
		
		painel_Cadastro_Forncedor.setVisible(true);
		controladorPainelCadastroFornecedor = new Controlador_Painel_Cadastro_Fornecedor(painel_Cadastro_Forncedor, Fornecedores);
	
	}
	

}

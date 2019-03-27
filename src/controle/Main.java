package controle;

import java.util.ArrayList;

import modelo.Fornecedor;
import vis�o.PainelCadastroCliente;
import vis�o.PainelCadastroFuncionario;
import vis�o.painelCadastroFornecedor;

public class Main {
	
	
	static painelCadastroFornecedor painel_Cadastro_Fornecedor = new painelCadastroFornecedor();
	static PainelCadastroCliente painel_Cadastro_Cliente = new PainelCadastroCliente();
	static PainelCadastroFuncionario painel_Cadastro_Funcionario = new PainelCadastroFuncionario();
	
	static Controlador_Painel_Cadastro_Fornecedor controladorPainelCadastroFornecedor;
	static Controlador_Opcoes controladorOpcoes;
	
	static ArrayList<Fornecedor> Fornecedores = new ArrayList();
	
	public static void main(String[] args) {
		
		painel_Cadastro_Fornecedor.setVisible(true);
		controladorPainelCadastroFornecedor = new Controlador_Painel_Cadastro_Fornecedor(painel_Cadastro_Fornecedor, Fornecedores);
	
	}
	

}

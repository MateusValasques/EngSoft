package controle;

import java.util.ArrayList;

import dao.Cliente_Dao;
import dao.Fornecedor_Dao;
import dao.Funcionario_Dao;
import dao.Produto_Dao;
import modelo.Fornecedor;
import visão.Cadastro_Tipo;
import visão.Cadastro_Unidade;
//import visão.Modelo_Tabela;
import visão.PainelCadastroCliente;
import visão.PainelCadastroFuncionario;
import visão.PainelCadastroProtudo;
import visão.Painel_Menu;
import visão.painelCadastroForncedor;

public class Mercadinho {

	static painelCadastroForncedor painel_Cadastro_Forncedor = new painelCadastroForncedor();
	static PainelCadastroCliente painel_Cadastro_Cliente = new PainelCadastroCliente();
	static PainelCadastroFuncionario painel_Cadastro_Funcionario = new PainelCadastroFuncionario();
	static PainelCadastroProtudo painel_Cadastro_Produto = new PainelCadastroProtudo();
	static Cadastro_Tipo cadastroTipo = new Cadastro_Tipo();
	static Cadastro_Unidade cadastroUnidade = new Cadastro_Unidade();
	static Painel_Menu painelMenu = new Painel_Menu();

	static Controlador_Painel_Cadastro_Fornecedor controladorPainelCadastroFornecedor;
	static Controlador_Opcoes controladorOpcoes;
	static Controlador_Painel_Cadastro_Funcionario controladorPainelCadastroFuncionario;
	static Controlador_Cliente controladorCliente;
	static Controlador_Painel_Cadastro_Produto controladorPainelCadastroProduto;
	static Controlador_Menu controladorMenu;

	static Funcionario_Dao funcionarioDao;
	static Fornecedor_Dao fornecedorDao;
	static Cliente_Dao clienteDao;
	static Produto_Dao produtoDao;

	public static void main(String[] args) {
		// painel_Cadastro_Forncedor.setVisible(true);
		// painel_Cadastro_Funcionario.setVisible(true);
		// painel_Cadastro_Forncedor.setLocation(300,0);
//		painel_Cadastro_Cliente.setVisible(true);
//		painel_Cadastro_Cliente.setLocation(300, 0);
//		painel_Cadastro_Produto.setVisible(true);
//		painel_Cadastro_Produto.setLocation(300, 0);
		painelMenu.setVisible(true);
		painelMenu.setLocation(300, 0);
		

		produtoDao = new Produto_Dao(painel_Cadastro_Produto);

		fornecedorDao = new Fornecedor_Dao(painel_Cadastro_Forncedor);

		funcionarioDao = new Funcionario_Dao(painel_Cadastro_Funcionario);

		clienteDao = new Cliente_Dao(painel_Cadastro_Cliente);

		controladorPainelCadastroProduto = new Controlador_Painel_Cadastro_Produto(painel_Cadastro_Produto, produtoDao,
				cadastroTipo, cadastroUnidade);
		controladorPainelCadastroFornecedor = new Controlador_Painel_Cadastro_Fornecedor(painel_Cadastro_Forncedor,
				fornecedorDao);
		controladorPainelCadastroFuncionario = new Controlador_Painel_Cadastro_Funcionario(painel_Cadastro_Funcionario,
				funcionarioDao);
		controladorCliente = new Controlador_Cliente(painel_Cadastro_Cliente, clienteDao);
		
		controladorMenu = new Controlador_Menu(painel_Cadastro_Forncedor, painel_Cadastro_Cliente, 
				painel_Cadastro_Funcionario, painel_Cadastro_Produto, painelMenu);
		
	}

}

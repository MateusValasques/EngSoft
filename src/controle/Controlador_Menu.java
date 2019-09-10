package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visão.PainelCadastroCliente;
import visão.PainelCadastroFuncionario;
import visão.PainelCadastroProtudo;
import visão.Painel_Menu;
import visão.painelCadastroForncedor;

public class Controlador_Menu implements ActionListener{
	
	painelCadastroForncedor PainelCadastroFornecedor;
	PainelCadastroCliente painelCadastroCliente;
	PainelCadastroFuncionario painelCadastroFuncionario;
	PainelCadastroProtudo painelCadastroProduto;
	Painel_Menu painelMenu;
	
	public Controlador_Menu(painelCadastroForncedor PainelCadastroFornecedor, PainelCadastroCliente painelCadastroCliente,
			PainelCadastroFuncionario painelCadastroFuncionario, PainelCadastroProtudo painelCadastroProduto, Painel_Menu painelMenu) {
		
		this.painelCadastroCliente = painelCadastroCliente;
		this.PainelCadastroFornecedor = PainelCadastroFornecedor;
		this.painelCadastroFuncionario = painelCadastroFuncionario;
		this.painelCadastroProduto = painelCadastroProduto;
		this.painelMenu = painelMenu;
		addEventos();
	}

	private void addEventos() {
		
		painelMenu.getMntmCadastrarCliente().addActionListener(this);
		painelMenu.getMntmCadastrarFuncionrio().addActionListener(this);
		painelMenu.getMntmCadastrarFornecedor().addActionListener(this);
		painelMenu.getMntmCadastrarProduto().addActionListener(this);

		
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == painelMenu.getMntmCadastrarCliente()) {
			painelCadastroCliente.setLocation(350,0);
			painelCadastroCliente.setVisible(true);
		}
		if(e.getSource() == painelMenu.getMntmCadastrarFornecedor()) {
			PainelCadastroFornecedor.setLocation(350,0);
			PainelCadastroFornecedor.setVisible(true);
		}
		if(e.getSource() == painelMenu.getMntmCadastrarFuncionrio()) {
			painelCadastroFuncionario.setLocation(350,0);
			painelCadastroFuncionario.setVisible(true);
			
		}
		if(e.getSource() == painelMenu.getMntmCadastrarProduto()) {
			painelCadastroProduto.setLocation(350,0);
			painelCadastroProduto.setVisible(true);
		}
		
	}

}

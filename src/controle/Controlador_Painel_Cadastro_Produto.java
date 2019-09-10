package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.JOptionPane;

import dao.Produto_Dao;
import modelo.Produto;
import visão.Cadastro_Tipo;
import visão.Cadastro_Unidade;
import visão.PainelCadastroProtudo;

public class Controlador_Painel_Cadastro_Produto implements ActionListener, MouseListener {

	PainelCadastroProtudo painelCadastroProtudo;
	Produto_Dao produtoDao;
	Cadastro_Tipo cadastroTipo;
	public int contador = 0;
	String nome = new String();
	Cadastro_Unidade cadastroUnidade;

	public Controlador_Painel_Cadastro_Produto(PainelCadastroProtudo painelCadastroProtudo, Produto_Dao produtoDao,
			Cadastro_Tipo cadastroTipo, Cadastro_Unidade cadastroUnidade) {

		this.painelCadastroProtudo = painelCadastroProtudo;
		this.produtoDao = produtoDao;
		this.cadastroTipo = cadastroTipo;
		this.cadastroUnidade = cadastroUnidade;

		produtoDao.preencheCbxTipo();
		produtoDao.preencheCbxUnidade();
		addeventos();
	}

	private void addeventos() {

		painelCadastroProtudo.getCbxTipoPesquisa().addActionListener(this);
		painelCadastroProtudo.getBtnCancelar().addActionListener(this);

		painelCadastroProtudo.getBtnAlterar().addActionListener(this);
		painelCadastroProtudo.getBtnInserir().addActionListener(this);
		painelCadastroProtudo.getBtnExcluir().addActionListener(this);

		painelCadastroProtudo.getBtnConfirmarAlteracao().addActionListener(this);
		painelCadastroProtudo.getBtnConfirmarExclusao().addActionListener(this);
		painelCadastroProtudo.getBtnConfirmarInclusao().addActionListener(this);

		painelCadastroProtudo.getBtnPesquisaCodigo().addActionListener(this);
		painelCadastroProtudo.getBtnPesquisaCodigoBarras().addActionListener(this);
		painelCadastroProtudo.getBtnPesquisaNome().addActionListener(this);

		painelCadastroProtudo.getTabela().addMouseListener(this);

		// daqui pra baixo tá pronto
		painelCadastroProtudo.getBtnInserirTipo().addActionListener(this);
		painelCadastroProtudo.getBtnAlterarTipo().addActionListener(this);
		painelCadastroProtudo.getBtnExcluirTipo().addActionListener(this);

		painelCadastroProtudo.getBtnAlterarUnidade().addActionListener(this);
		painelCadastroProtudo.getBtnInserirUnidade().addActionListener(this);
		painelCadastroProtudo.getBtnExcluirUnidade().addActionListener(this);

		cadastroTipo.getBtnConfirmar().addActionListener(this);
		cadastroTipo.getBtnCancelar().addActionListener(this);

		cadastroUnidade.getBtnConfirmar().addActionListener(this);
		cadastroUnidade.getBtnCancelar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == painelCadastroProtudo.getBtnInserir()) {

			destrava_cima();
			trava_pesquisa();

			painelCadastroProtudo.getBtnAlterar().setEnabled(false);
			painelCadastroProtudo.getBtnExcluir().setEnabled(false);
			painelCadastroProtudo.getBtnInserir().setEnabled(false);

			painelCadastroProtudo.getBtnConfirmarAlteracao().setVisible(false);
			painelCadastroProtudo.getBtnConfirmarExclusao().setVisible(false);
			painelCadastroProtudo.getBtnConfirmarInclusao().setVisible(true);
			painelCadastroProtudo.getBtnConfirmarInclusao().setEnabled(true);

		}

		if (e.getSource() == painelCadastroProtudo.getBtnAlterar()) {

			destrava_cima();
			destrava_pesquisa();

			painelCadastroProtudo.getBtnInserir().setEnabled(false);
			painelCadastroProtudo.getBtnExcluir().setEnabled(false);
			painelCadastroProtudo.getBtnAlterar().setEnabled(false);

			painelCadastroProtudo.getBtnConfirmarAlteracao().setVisible(true);
			painelCadastroProtudo.getBtnConfirmarExclusao().setVisible(false);
			painelCadastroProtudo.getBtnConfirmarInclusao().setVisible(false);
			painelCadastroProtudo.getBtnConfirmarAlteracao().setEnabled(true);

		}

		if (e.getSource() == painelCadastroProtudo.getBtnExcluir()) {

			trava_cima();
			destrava_pesquisa();

			painelCadastroProtudo.getBtnAlterar().setEnabled(false);
			painelCadastroProtudo.getBtnInserir().setEnabled(false);

			painelCadastroProtudo.getBtnConfirmarAlteracao().setVisible(false);
			painelCadastroProtudo.getBtnConfirmarExclusao().setVisible(true);
			painelCadastroProtudo.getBtnConfirmarInclusao().setVisible(false);
			painelCadastroProtudo.getBtnConfirmarExclusao().setEnabled(true);

		}
		if (e.getSource() == painelCadastroProtudo.getBtnConfirmarExclusao()) {
			int saida = JOptionPane.showConfirmDialog(painelCadastroProtudo, "Deseja realmente excluir?",
					"Confirmação de Exclusao", JOptionPane.YES_NO_OPTION);
			if (saida == 0) {

				produtoDao.delete(Integer.parseInt(painelCadastroProtudo.getTxtCodigo().getText()));
				painelCadastroProtudo.getBtnAlterar().setVisible(true);
				painelCadastroProtudo.getBtnInserir().setVisible(true);
				painelCadastroProtudo.getBtnExcluir().setVisible(true);
				trava_cima();
				destrava_pesquisa();
				zera_campos();
			}

		}
		if (e.getSource() == painelCadastroProtudo.getBtnConfirmarAlteracao()) {
			int saida = JOptionPane.showConfirmDialog(painelCadastroProtudo, "Deseja realmente alterar?",
					"Confirmação de Alteração", JOptionPane.YES_NO_OPTION);
			if (saida == 0) {
				try {
					Validate_Produto validacao = new Validate_Produto(painelCadastroProtudo);
					if (validacao.validacao_produto(painelCadastroProtudo) == true) {
						System.out.println("passou");
						String codigo = painelCadastroProtudo.getTxtCodigo().getText();
						int valor = Integer.parseInt(codigo);
						Produto produto = new Produto(0, validacao.getDescricao(), validacao.getCodigo_barras(),
								validacao.getEstoque_min(), validacao.getEstoque_max(), validacao.getQuantidade(),
								validacao.getUnidade(), validacao.getValor_compra(), validacao.getValor_venda(),
								validacao.getLucro(), validacao.getTipo());
						produto.setCodigo(valor);

						produtoDao.update(produto);
					}
				} catch (ParseException e1) {

					e1.printStackTrace();
				}
			}
			trava_cima();
			destrava_pesquisa();
			zera_campos();
		}

		if (e.getSource() == painelCadastroProtudo.getCbxTipoPesquisa()) {

			if (painelCadastroProtudo.getCbxTipoPesquisa().getSelectedItem() == "Descrição") {

				painelCadastroProtudo.getTxtPesquisaNome().setEditable(true);

				painelCadastroProtudo.getTxtPesquisaNome().setVisible(true);
				painelCadastroProtudo.getTxtPesquisaCodigo().setVisible(false);
				painelCadastroProtudo.getTxtPesquisaCodigoBarra().setVisible(false);

				painelCadastroProtudo.getBtnPesquisaNome().setVisible(true);
				painelCadastroProtudo.getBtnPesquisaCodigoBarras().setVisible(false);
				painelCadastroProtudo.getBtnPesquisaCodigo().setVisible(false);
			}
			if (painelCadastroProtudo.getCbxTipoPesquisa().getSelectedItem() == "Código") {

				painelCadastroProtudo.getTxtPesquisaCodigo().setEditable(true);

				painelCadastroProtudo.getTxtPesquisaNome().setVisible(false);
				painelCadastroProtudo.getTxtPesquisaCodigo().setVisible(true);
				painelCadastroProtudo.getTxtPesquisaCodigoBarra().setVisible(false);

				painelCadastroProtudo.getBtnPesquisaNome().setVisible(true);
				painelCadastroProtudo.getBtnPesquisaCodigoBarras().setVisible(false);
				painelCadastroProtudo.getBtnPesquisaCodigo().setVisible(true);

			}

		}
		if (e.getSource() == painelCadastroProtudo.getBtnPesquisaNome()) {
			System.out.println("Pesquisa nome");
			String desc = new String();
			desc = painelCadastroProtudo.getTxtPesquisaNome().getText();
			produtoDao.busca_descricao(desc);
		}

		if (e.getSource() == painelCadastroProtudo.getBtnPesquisaCodigo()) {

			produtoDao.busca_codigo(Integer.parseInt(painelCadastroProtudo.getTxtPesquisaCodigo().getText()));

		}

		// aqui começa o cadastro de tipo
		if (e.getSource() == painelCadastroProtudo.getBtnInserirUnidade()) {

			// criar painel pra inserir unidade e Unidade
			contador = 1;
			cadastroUnidade.setVisible(true);
			cadastroUnidade.setLocation(500, 100);

		}
		if (e.getSource() == painelCadastroProtudo.getBtnAlterarUnidade()) {

			contador = 2;
			cadastroUnidade.setVisible(true);
			cadastroUnidade.setLocation(500, 100);

		}
		if (e.getSource() == cadastroUnidade.getBtnConfirmar()) {
			if (contador == 1) {

				nome = cadastroUnidade.getTxtNome().getText();
				if (produtoDao.create_Unidade(nome) == true)
					painelCadastroProtudo.getCbxUnidade().addItem(nome);

			} else if (contador == 2) {
				if (!painelCadastroProtudo.getCbxUnidade().getSelectedItem().equals("-Selecione-")) {
					nome = cadastroUnidade.getTxtNome().getText();
					String aux = (String) painelCadastroProtudo.getCbxUnidade().getSelectedItem();
					if (produtoDao.update_Unidade(aux, nome) == true) {
						painelCadastroProtudo.getCbxUnidade().removeItem(aux);

						painelCadastroProtudo.getCbxUnidade().addItem(nome);
					}

				}

			}

		}
		if (e.getSource() == painelCadastroProtudo.getBtnExcluirUnidade()) {
			if (!painelCadastroProtudo.getCbxUnidade().getSelectedItem().equals("-Selecione-")) {

				String aux = (String) painelCadastroProtudo.getCbxUnidade().getSelectedItem();
				painelCadastroProtudo.getCbxUnidade()
						.removeItem(painelCadastroProtudo.getCbxUnidade().getSelectedItem());
				produtoDao.delete_Unidade(aux);

			}
		}
		if (e.getSource() == cadastroUnidade.getBtnCancelar())

		{
			cadastroUnidade.dispose();
			cadastroUnidade.getTxtNome().setText(null);
		}
		// aqui acaba o cadastro de Unidade

		// aqui começa o cadastro de tipo
		if (e.getSource() == painelCadastroProtudo.getBtnInserirTipo()) {

			// criar painel pra inserir unidade e tipo
			contador = 1;
			cadastroTipo.setVisible(true);
			cadastroTipo.setLocation(500, 100);

		}
		if (e.getSource() == painelCadastroProtudo.getBtnAlterarTipo()) {

			contador = 2;
			cadastroTipo.setVisible(true);
			cadastroTipo.setLocation(500, 100);

		}
		if (e.getSource() == cadastroTipo.getBtnConfirmar()) {

			if (contador == 1) {
				nome = cadastroTipo.getTxtNome().getText();

				if (produtoDao.create_Tipo(nome) == true)
					painelCadastroProtudo.getCbxTipo().addItem(nome);

			} else if (contador == 2) {
				if (!painelCadastroProtudo.getCbxTipo().getSelectedItem().equals("-Selecione-")) {
					nome = cadastroTipo.getTxtNome().getText();
					String aux = (String) painelCadastroProtudo.getCbxTipo().getSelectedItem();
					if (produtoDao.update_Unidade(aux, nome) == true) {
						painelCadastroProtudo.getCbxTipo().removeItem(aux);

						painelCadastroProtudo.getCbxTipo().addItem(nome);
					}
				}

			}

		}
		if (e.getSource() == painelCadastroProtudo.getBtnExcluirTipo()) {
			if (!painelCadastroProtudo.getCbxTipo().getSelectedItem().equals("-Selecione-")) {

				String aux = (String) painelCadastroProtudo.getCbxTipo().getSelectedItem();
				painelCadastroProtudo.getCbxTipo().removeItem(painelCadastroProtudo.getCbxTipo().getSelectedItem());
				produtoDao.delete_Tipo(aux);

			}
		}
		if (e.getSource() == cadastroTipo.getBtnCancelar())

		{
			cadastroTipo.dispose();
			cadastroTipo.getTxtNome().setText(null);
		}
		// aqui acaba o cadastro de tipo
		if (e.getSource() == painelCadastroProtudo.getBtnConfirmarInclusao()) {
			System.out.println("foi");
			try {
				Validate_Produto validacao = new Validate_Produto(painelCadastroProtudo);
				if (validacao.validacao_produto(painelCadastroProtudo) == true) {
					System.out.println("passou");
					Produto produto = new Produto(0, validacao.getDescricao(), validacao.getCodigo_barras(),
							validacao.getEstoque_min(), validacao.getEstoque_max(), validacao.getQuantidade(),
							validacao.getUnidade(), validacao.getValor_compra(), validacao.getValor_venda(),
							validacao.getLucro(), validacao.getTipo());

					produtoDao.create(produto);
				}
			} catch (ParseException e1) {

				e1.printStackTrace();
			}
			trava_cima();
			destrava_pesquisa();
			zera_campos();
		}
		if (e.getSource() == painelCadastroProtudo.getBtnCancelar()) {

			painelCadastroProtudo.dispose();
			zera_campos();
			trava_cima();
			destrava_pesquisa();
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		if (painelCadastroProtudo.getTabela().getSelectedRow() > -1) {
			int x = (int) painelCadastroProtudo.getTabela()
					.getValueAt(painelCadastroProtudo.getTabela().getSelectedRow(), 0);
			Produto produto = new Produto();
			produto = produtoDao.busca_Simples(x);
			painelCadastroProtudo.getTxtCodigo().setText(Integer.toString(produto.getCodigo()));
			painelCadastroProtudo.getTxtCodigoDeBarras().setText(produto.getCodigo_barras());
			painelCadastroProtudo.getTxtDescricao().setText(produto.getDescricao());
			painelCadastroProtudo.getTxtValorDeCompra().setText(Double.toString(produto.getValor_compra()));
			painelCadastroProtudo.getTxtValorDeVenda().setText(Double.toString(produto.getValor_venda()));
			painelCadastroProtudo.getTxtEstoqueMaximo().setText(Integer.toString(produto.getEstoque_max()));
			painelCadastroProtudo.getTxtEstoqueMinimo().setText(Integer.toString(produto.getEstoque_min()));
			painelCadastroProtudo.getTxtLucro().setText(Double.toString(produto.getLucro() * 100));
			painelCadastroProtudo.getCbxTipo().setSelectedItem(produto.getTipo());
			painelCadastroProtudo.getCbxUnidade().setSelectedItem(produto.getUnidade());
			painelCadastroProtudo.getTxtQuantidade().setText(Integer.toString(produto.getQuantidade()));

		}

	}

	// quando a pessoa clcicar em inserir
	public void destrava_cima() {
		painelCadastroProtudo.getTxtCodigoDeBarras().setEnabled(true);
		painelCadastroProtudo.getTxtDescricao().setEnabled(true);
		painelCadastroProtudo.getTxtEstoqueMaximo().setEnabled(true);
		painelCadastroProtudo.getTxtEstoqueMinimo().setEnabled(true);
		painelCadastroProtudo.getTxtQuantidade().setEnabled(true);
		painelCadastroProtudo.getCbxTipo().setEnabled(true);
		painelCadastroProtudo.getCbxUnidade().setEnabled(true);
		painelCadastroProtudo.getTxtValorDeCompra().setEnabled(true);
		painelCadastroProtudo.getTxtValorDeVenda().setEnabled(true);

		painelCadastroProtudo.getBtnInserirTipo().setEnabled(true);
		painelCadastroProtudo.getBtnAlterarTipo().setEnabled(true);
		painelCadastroProtudo.getBtnExcluirTipo().setEnabled(true);
		painelCadastroProtudo.getBtnAlterarUnidade().setEnabled(true);
		painelCadastroProtudo.getBtnInserirUnidade().setEnabled(true);
		painelCadastroProtudo.getBtnExcluirUnidade().setEnabled(true);

		painelCadastroProtudo.getBtnConfirmarAlteracao().setEnabled(true);
		painelCadastroProtudo.getBtnConfirmarInclusao().setEnabled(true);
		painelCadastroProtudo.getBtnConfirmarAlteracao().setEnabled(true);
	}

	// quando for excluir
	public void trava_cima() {
		painelCadastroProtudo.getTxtCodigoDeBarras().setEnabled(false);
		painelCadastroProtudo.getTxtDescricao().setEnabled(false);
		painelCadastroProtudo.getTxtEstoqueMaximo().setEnabled(false);
		painelCadastroProtudo.getTxtEstoqueMinimo().setEnabled(false);
		painelCadastroProtudo.getTxtLucro().setEnabled(false);
		painelCadastroProtudo.getTxtQuantidade().setEnabled(false);
		painelCadastroProtudo.getCbxTipo().setEnabled(false);
		painelCadastroProtudo.getCbxUnidade().setEnabled(false);
		painelCadastroProtudo.getTxtValorDeCompra().setEnabled(false);
		painelCadastroProtudo.getTxtValorDeVenda().setEnabled(false);

		painelCadastroProtudo.getBtnInserirTipo().setEnabled(false);
		painelCadastroProtudo.getBtnAlterarTipo().setEnabled(false);
		painelCadastroProtudo.getBtnExcluirTipo().setEnabled(false);

		painelCadastroProtudo.getBtnAlterarUnidade().setEnabled(false);
		painelCadastroProtudo.getBtnInserirUnidade().setEnabled(false);
		painelCadastroProtudo.getBtnExcluirUnidade().setEnabled(false);

		painelCadastroProtudo.getBtnConfirmarAlteracao().setEnabled(false);
		painelCadastroProtudo.getBtnConfirmarInclusao().setEnabled(false);
		painelCadastroProtudo.getBtnConfirmarExclusao().setEnabled(false);
	}

	// quando a pessoa clicar em inserir
	public void trava_pesquisa() {

		painelCadastroProtudo.getCbxTipoPesquisa().setEnabled(false);

		painelCadastroProtudo.getTxtPesquisaCodigo().setEnabled(false);
		painelCadastroProtudo.getTxtPesquisaCodigoBarra().setEnabled(false);
		painelCadastroProtudo.getTxtPesquisaNome().setEnabled(false);

		painelCadastroProtudo.getBtnPesquisaCodigo().setEnabled(false);
		painelCadastroProtudo.getBtnPesquisaCodigoBarras().setEnabled(false);
		painelCadastroProtudo.getBtnPesquisaNome().setEnabled(false);

		painelCadastroProtudo.getTabela().setEnabled(false);
	}

	// quando confirmar inserção
	public void destrava_pesquisa() {

		painelCadastroProtudo.getCbxTipoPesquisa().setEnabled(true);

		painelCadastroProtudo.getTxtPesquisaCodigo().setEnabled(true);
		painelCadastroProtudo.getTxtPesquisaCodigoBarra().setEnabled(true);
		painelCadastroProtudo.getTxtPesquisaNome().setEnabled(true);

		painelCadastroProtudo.getBtnPesquisaCodigo().setEnabled(true);
		painelCadastroProtudo.getBtnPesquisaCodigoBarras().setEnabled(true);
		painelCadastroProtudo.getBtnPesquisaNome().setEnabled(true);

		painelCadastroProtudo.getTabela().setEnabled(true);
	}

	public void zera_campos() {

		painelCadastroProtudo.getTxtCodigo().setText(null);
		painelCadastroProtudo.getTxtCodigoDeBarras().setText(null);
		painelCadastroProtudo.getTxtDescricao().setText(null);
		painelCadastroProtudo.getTxtEstoqueMaximo().setText(null);
		painelCadastroProtudo.getTxtEstoqueMinimo().setText(null);
		painelCadastroProtudo.getTxtLucro().setText(null);
		painelCadastroProtudo.getTxtQuantidade().setText(null);
		painelCadastroProtudo.getCbxTipo().setSelectedItem("-Selecione-");
		painelCadastroProtudo.getCbxUnidade().setSelectedItem("-Selecione-");
		painelCadastroProtudo.getTxtValorDeCompra().setText(null);
		painelCadastroProtudo.getTxtValorDeVenda().setText(null);
		painelCadastroProtudo.getTxtPesquisaCodigo().setText(null);
		painelCadastroProtudo.getTxtPesquisaCodigoBarra().setText(null);
		painelCadastroProtudo.getTxtPesquisaNome().setText(null);
		;
		painelCadastroProtudo.getDefaultTableModel().setNumRows(0);
		painelCadastroProtudo.getTabela().setEditingRow(0);
		painelCadastroProtudo.getTabela().setEditingColumn(0);
		painelCadastroProtudo.getDefaultTableModel().isCellEditable(0, 0);

		painelCadastroProtudo.getBtnAlterar().setEnabled(true);
		painelCadastroProtudo.getBtnExcluir().setEnabled(true);
		painelCadastroProtudo.getBtnInserir().setEnabled(true);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import controle.Controlador_Painel_Cadastro_Produto;
import modelo.Fornecedor;
import modelo.Produto;
import visão.PainelCadastroProtudo;
import visão.painelCadastroForncedor;

public class Produto_Dao {

	static PainelCadastroProtudo painelCadastroProtudo;
	Controlador_Painel_Cadastro_Produto controladorProduto;

	public Produto_Dao(PainelCadastroProtudo painelCadastroProtudo) {

		Produto_Dao.painelCadastroProtudo = painelCadastroProtudo;
		this.controladorProduto = controladorProduto;

	}

	public void create(Produto produto) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {

			stat = con
					.prepareStatement("INSERT INTO produtos (idProdutos,descricao,codigodebarra,estoquemin,estoquemax,"
							+ "quantidade,unidade,valorcompra,valorvenda,lucro,tipo)values(?,?,?,?,?,?,?,?,?,?,?)");
			stat.setInt(1, produto.getCodigo());
			stat.setString(2, produto.getDescricao());
			stat.setString(3, produto.getCodigo_barras());
			stat.setInt(4, produto.getEstoque_min());
			stat.setInt(5, produto.getEstoque_max());
			stat.setInt(6, produto.getQuantidade());
			stat.setString(7, produto.getUnidade());
			stat.setDouble(8, produto.getValor_compra());
			stat.setDouble(9, produto.getValor_venda());
			stat.setDouble(10, produto.getLucro());
			stat.setString(11, produto.getTipo());
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update(Produto produto) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement(
					"UPDATE produtos SET idProdutos = ?,descricao = ?,codigodebarra = ?,estoquemin = ?,estoquemax = ?,"
							+ "quantidade = ?,unidade = ?,valorcompra = ?,valorvenda = ?,lucro = ?,tipo = ? WHERE idProdutos = ?");

			stat.setInt(1, produto.getCodigo());
			stat.setString(2, produto.getDescricao());
			stat.setString(3, produto.getCodigo_barras());
			stat.setInt(4, produto.getEstoque_min());
			stat.setInt(5, produto.getEstoque_max());
			stat.setInt(6, produto.getQuantidade());
			stat.setString(7, produto.getUnidade());
			stat.setDouble(8, produto.getValor_compra());
			stat.setDouble(9, produto.getValor_venda());
			stat.setDouble(10, produto.getLucro());
			stat.setString(11, produto.getTipo());
			stat.setInt(12, produto.getCodigo());
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// aqui começa a ligação do banco de tipo
	public boolean create_Tipo(String nome) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement("INSERT INTO tipo (nome)values(?)");
			stat.setString(1, nome);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update_Tipo(String aux, String nome) {

		System.out.println(aux);
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement("UPDATE tipo SET nome = ? WHERE nome = ?");
			stat.setString(1, nome);
			stat.setString(2, aux);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso");
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Atualizar " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void delete_Tipo(String nome) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement("Delete FROM tipo WHERE nome = ?");
			stat.setString(1, nome);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Excluído com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Atualizar " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void preencheCbxTipo() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = con.prepareStatement("select * from tipo");
			rs = stat.executeQuery();

			while (rs.next()) {
				painelCadastroProtudo.getCbxTipo().addItem(rs.getString("nome"));
				System.out.println("oi");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// aqui termina a de tipo

	// aqui começa a ligação do banco de Unidade
	public boolean create_Unidade(String nome) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement("INSERT INTO unidade (nome)values(?)");
			stat.setString(1, nome);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update_Unidade(String aux, String nome) {

		System.out.println(aux);
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement("UPDATE unidade SET nome = ? WHERE nome = ?");
			stat.setString(1, nome);
			stat.setString(2, aux);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso");
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Atualizar " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void delete_Unidade(String nome) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement("Delete FROM unidade WHERE nome = ?");
			stat.setString(1, nome);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Excluído com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Atualizar " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void preencheCbxUnidade() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = con.prepareStatement("select * from unidade");
			rs = stat.executeQuery();

			while (rs.next()) {
				painelCadastroProtudo.getCbxUnidade().addItem(rs.getString("nome"));
				System.out.println("oi");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void busca_descricao(String descricao) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = con.prepareStatement("select * from produtos WHERE descricao LIKE ?");// função para procurar no
																							// banco de dados
			System.out.println(descricao);
			descricao = descricao.trim();
			if(descricao == null) {
				descricao = " ";
				System.out.println("vsf");
			}
				
			
			stat.setString(1, "%" + descricao + "%");// coloca pra procurar o q tem com o q foi enviado da barra
			rs = stat.executeQuery();

			while (rs.next()) {
				System.out.println("oi");
				painelCadastroProtudo.getDefaultTableModel().addRow(
						new Object[] { rs.getInt("idProdutos"), rs.getString("descricao"), rs.getInt("codigodebarra") });
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat, rs);
		}
	}
	
	public void busca_codigo(int codigo) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = con.prepareStatement("select * from produtos WHERE idProdutos LIKE ?");// função para procurar no
																							// banco de dados
				
			
			stat.setString(1, "%" + codigo + "%");// coloca pra procurar o q tem com o q foi enviado da barra
			rs = stat.executeQuery();

			while (rs.next()) {
				System.out.println("oi");
				painelCadastroProtudo.getDefaultTableModel().addRow(
						new Object[] { rs.getInt("idProdutos"), rs.getString("descricao"), rs.getInt("codigodebarra") });
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat, rs);
		}
	}
	
	public void busca_codigo_Barra(String codigo) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		codigo = codigo.trim();
		try {
			stat = con.prepareStatement("select * from produtos WHERE codigodebarra LIKE ?");// função para procurar no
																							// banco de dados
				
			
			stat.setString(1, "%" + codigo + "%");// coloca pra procurar o q tem com o q foi enviado da barra
			rs = stat.executeQuery();

			while (rs.next()) {
				System.out.println("oi");
				painelCadastroProtudo.getDefaultTableModel().addRow(
						new Object[] { rs.getInt("idProdutos"), rs.getString("descricao"), rs.getInt("codigodebarra") });
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat, rs);
		}
	}

	public Produto busca_Simples(int id) {
		
		Produto produto = new Produto();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		
		try {
			stat = con.prepareStatement("SELECT * FROM produtos WHERE idProdutos = ?");
			stat.setInt(1, id);
			ResultSet rs = null;
			rs = stat.executeQuery();
			while (rs.next()) {
				
				produto.setCodigo(rs.getInt("idProdutos"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setCodigo_barras(rs.getString("codigodebarra"));
				produto.setEstoque_max(rs.getInt("estoquemax"));
				produto.setEstoque_min(rs.getInt("estoquemin"));
				produto.setLucro(rs.getDouble("lucro"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValor_compra(rs.getDouble("valorcompra"));
				produto.setValor_venda(rs.getDouble("valorvenda"));
				produto.setTipo(rs.getString("tipo"));
				produto.setUnidade(rs.getString("unidade"));
				
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  buscar " + e);

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat);
		}
		
		return produto;
	}

	public void delete(int id) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		
		try {
			stat = con.prepareStatement("DELETE FROM produtos WHERE idProdutos = ?");
			stat.setInt(1, id);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Excluido com sucesso");
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

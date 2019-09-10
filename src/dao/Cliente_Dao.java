package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import modelo.Cliente;
import modelo.Funcionario;
import visão.PainelCadastroCliente;

public class Cliente_Dao {

	private static int valor;
	static PainelCadastroCliente painelCadastroCliente;

	public Cliente_Dao(PainelCadastroCliente painelCadastroCliente) {

		Cliente_Dao.painelCadastroCliente = painelCadastroCliente;

	}

	public static void create(Cliente cliente) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement(

					"INSERT INTO clientes (idclientes,nome,tipo,cpfcnpj,limitecredito,ativo,cep,rua,numero,bairro,cidade,uf,complemento,telefone,celular,email)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stat.setInt(1, cliente.getCodigo());
			stat.setString(2, cliente.getNome());
			stat.setString(3, cliente.getTipo());
			stat.setString(4, cliente.getCpfcnpj());
			stat.setString(5, cliente.getLimite_credito());
			stat.setBoolean(6, cliente.isAtivo());
			stat.setString(7, cliente.getCep());
			stat.setString(8, cliente.getRua());
			stat.setString(9, cliente.getNumero());
			stat.setString(10, cliente.getBairro());
			stat.setString(11, cliente.getCidade());
			stat.setString(12, cliente.getUf());
			stat.setString(13, cliente.getComplemento());
			stat.setString(14, cliente.getTelefone());
			stat.setString(15, cliente.getCelular());
			stat.setString(16, cliente.getEmail());
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat);
		}

	}
	
	public static void update(Cliente cliente) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			System.out.println(cliente.getCodigo());
			stat = con.prepareStatement(
					"UPDATE clientes SET idclientes = ?, nome = ?,tipo = ?,cpfcnpj = ?,limitecredito = ?,ativo = ?,"
					+ "cep = ?,rua = ?,numero = ?,"
					+ "bairro = ?,cidade = ?,uf = ?,complemento = ?,telefone = ?,celular = ?,email = ? WHERE idclientes = ?");
			
			stat.setInt(1, cliente.getCodigo());
			stat.setString(2, cliente.getNome());
			stat.setString(3, cliente.getTipo());
			stat.setString(4, cliente.getCpfcnpj());
			stat.setString(5, cliente.getLimite_credito());
			stat.setBoolean(6, cliente.isAtivo());
			stat.setString(7, cliente.getCep());
			stat.setString(8, cliente.getRua());
			stat.setString(9, cliente.getNumero());
			stat.setString(10, cliente.getBairro());
			stat.setString(11, cliente.getCidade());
			stat.setString(12, cliente.getUf());
			stat.setString(13, cliente.getComplemento());
			stat.setString(14, cliente.getTelefone());
			stat.setString(15, cliente.getCelular());
			stat.setString(16, cliente.getEmail());
			stat.setInt(17, cliente.getCodigo());
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso");
			stat.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat);
		}

	}
	
	public static void delete(int codigo) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		try {
			stat = con.prepareStatement("DELETE FROM clientes WHERE idclientes = ?");
			stat.setInt(1, codigo);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Excluido com sucesso");
			stat.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  excluir " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat);
		}

	}

	// busca todos os funcionario por nome
	public static void pesquisa_nome(String nome) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			// System.out.println("oi");
			stat = con.prepareStatement("select * from clientes WHERE nome LIKE ?");// função para procurar no banco
																						// de dados
			nome = nome.trim();// tira os espaços em branco da string
			stat.setString(1, "%" + nome + "%");// coloca pra procurar o q tem com o q foi enviado da barra
			rs = stat.executeQuery();
			while (rs.next()) {
				// preenche a tabela
				painelCadastroCliente.getDefaultTableModel().addRow(
						new Object[] { rs.getInt("idclientes"), rs.getString("nome"), rs.getString("cpfcnpj") });
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat, rs);
		}

	}

	// busca todos os funcionario por cpf ou cnpj
	public static void pesquisa_cpf_cnpj(String cpfcnpj) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = con.prepareStatement("select * from clientes WHERE cpfcnpj LIKE ?");// função para procurar no
																							// banco de dados

			stat.setString(1, "%" + cpfcnpj + "%");// coloca pra procurar o q tem com o q foi enviado da barra
			rs = stat.executeQuery();
			System.out.println(cpfcnpj);
			while (rs.next()) {

				painelCadastroCliente.getDefaultTableModel().addRow(
						new Object[] { rs.getInt("idclientes"), rs.getString("nome"), rs.getString("cpfcnpj") });
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat, rs);
		}
	}

	// pesquisa por código
	public static void pesquisa_codigo(int id) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {

			stat = con.prepareStatement("select * from clientes WHERE idclientes LIKE ?");// função para
																								// procurar no
			// banco de dados

			stat.setString(1, "%" + id + "%");// coloca pra procurar o q tem com o q foi enviado da barra
			rs = stat.executeQuery();

			while (rs.next()) {

				painelCadastroCliente.getDefaultTableModel().addRow(
						new Object[] { rs.getInt("idclientes"), rs.getString("nome"), rs.getString("cpfcnpj") });

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat, rs);
		}

	}

	public static Cliente busca_simples(int x) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		Cliente cliente;
		cliente = new Cliente();
		try {
			stat = con.prepareStatement("SELECT * FROM clientes WHERE idclientes = ?");
			stat.setInt(1, x);
			ResultSet rs = null;
			rs = stat.executeQuery();
			while (rs.next()) {

				cliente.setCodigo(rs.getInt("idclientes"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTipo(rs.getString("tipo"));
				cliente.setCpfcnpj(rs.getString("cpfcnpj"));
				cliente.setAtivo(rs.getBoolean("ativo"));
				cliente.setLimite_credito(rs.getString("limitecredito"));
				cliente.setCep(rs.getString("cep"));
				cliente.setRua(rs.getString("rua"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setUf(rs.getString("uf"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCelular(rs.getString("celular"));
				cliente.setEmail(rs.getString("email"));
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  buscar " + e);

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat);
		}
		return cliente;

	}

}

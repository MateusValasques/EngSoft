package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import modelo.Fornecedor;
import modelo.Funcionario;
import visão.PainelCadastroFuncionario;
import visão.painelCadastroForncedor;

public class Funcionario_Dao {

	static PainelCadastroFuncionario painelCadastroFuncionario;

	public Funcionario_Dao(PainelCadastroFuncionario painelCadastroFuncionario) {

		Funcionario_Dao.painelCadastroFuncionario = painelCadastroFuncionario;

	}

	public static void create(Funcionario funcionario) {
		System.out.println("create");
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement(

					"INSERT INTO funcionario (idFuncionario,nome,tipo,cpfcnpj,agencia,conta,login,senha,cancelacompra,cep,rua,numero,bairro,cidade,uf,complemento,telefone,celular,email)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			stat.setInt(1, funcionario.getCodigo());
			stat.setString(2, funcionario.getNome());
			stat.setString(3, funcionario.getTipo());
			stat.setString(4, funcionario.getCpfcnpj());
			stat.setString(5, funcionario.getAgencia());
			stat.setString(6, funcionario.getConta());
			stat.setString(7, funcionario.getLogin());
			stat.setString(8, funcionario.getSenha());
			stat.setBoolean(9, funcionario.getCancela_compra());
			stat.setString(10, funcionario.getCep());
			stat.setString(11, funcionario.getRua());
			stat.setString(12, funcionario.getNumero());
			stat.setString(13, funcionario.getBairro());
			stat.setString(14, funcionario.getCidade());
			stat.setString(15, funcionario.getUf());
			stat.setString(16, funcionario.getComplemento());
			stat.setString(17, funcionario.getTelefone());
			stat.setString(18, funcionario.getCelular());
			stat.setString(19, funcionario.getEmail());
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

	public static void update(Funcionario funcionario) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement(
					"UPDATE funcionario SET idFuncionario = ?, nome = ?,tipo = ?,cpfcnpj = ?,agencia = ?,conta = ?,login = ?,senha = ?,"
							+ "cancelacompra = ?,cep = ?,rua = ?,numero = ?,"
							+ "bairro = ?,cidade = ?,uf = ?,complemento = ?,telefone = ?,celular = ?,email = ? WHERE idFuncionario = ?");
			stat.setInt(1, funcionario.getCodigo());
			stat.setString(2, funcionario.getNome());
			stat.setString(3, funcionario.getTipo());
			stat.setString(4, funcionario.getCpfcnpj());
			stat.setString(5, funcionario.getAgencia());
			stat.setString(6, funcionario.getConta());
			stat.setString(7, funcionario.getLogin());
			stat.setString(8, funcionario.getSenha());
			stat.setBoolean(9, funcionario.getCancela_compra());
			stat.setString(10, funcionario.getCep());
			stat.setString(11, funcionario.getRua());
			stat.setString(12, funcionario.getNumero());
			stat.setString(13, funcionario.getBairro());
			stat.setString(14, funcionario.getCidade());
			stat.setString(15, funcionario.getUf());
			stat.setString(16, funcionario.getComplemento());
			stat.setString(17, funcionario.getTelefone());
			stat.setString(18, funcionario.getCelular());
			stat.setString(19, funcionario.getEmail());
			stat.setInt(20, funcionario.getCodigo());
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
			stat.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Atualizar " + e);
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
			stat = con.prepareStatement("DELETE FROM funcionario WHERE idFuncionario = ?");
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
			stat = con.prepareStatement("select * from funcionario WHERE nome LIKE ?");// função para procurar no banco
																						// de dados
			nome = nome.trim();// tira os espaços em branco da string
			stat.setString(1, "%" + nome + "%");// coloca pra procurar o q tem com o q foi enviado da barra
			rs = stat.executeQuery();
			while (rs.next()) {
				// preenche a tabela
				painelCadastroFuncionario.getDefaultTableModel().addRow(
						new Object[] { rs.getInt("idFuncionario"), rs.getString("nome"), rs.getString("cpfcnpj") });
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
			stat = con.prepareStatement("select * from funcionario WHERE cpfcnpj LIKE ?");// função para procurar no
																							// banco de dados

			stat.setString(1, "%" + cpfcnpj + "%");// coloca pra procurar o q tem com o q foi enviado da barra
			rs = stat.executeQuery();

			while (rs.next()) {

				painelCadastroFuncionario.getDefaultTableModel().addRow(
						new Object[] { rs.getInt("idFuncionario"), rs.getString("nome"), rs.getString("cpfcnpj") });
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

			stat = con.prepareStatement("select * from funcionario WHERE idFuncionario LIKE ?");// função para
																								// procurar no
			// banco de dados

			stat.setString(1, "%" + id + "%");// coloca pra procurar o q tem com o q foi enviado da barra
			rs = stat.executeQuery();

			while (rs.next()) {

				painelCadastroFuncionario.getDefaultTableModel().addRow(
						new Object[] { rs.getInt("idFuncionario"), rs.getString("nome"), rs.getString("cpfcnpj") });

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat, rs);
		}

	}

	public static Funcionario busca_simples(int x) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		Funcionario funcionario;
		funcionario = new Funcionario(x, null, null, null, null, null, null, null, null, null, null, null, null, null,
				false, null, null, null, null);
		try {
			stat = con.prepareStatement("SELECT * FROM funcionario WHERE idFuncionario = ?");
			stat.setInt(1, x);
			ResultSet rs = null;
			rs = stat.executeQuery();
			while (rs.next()) {

				funcionario.setCodigo(rs.getInt("idFuncionario"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setTipo(rs.getString("tipo"));
				funcionario.setCpfcnpj(rs.getString("cpfcnpj"));
				funcionario.setAgencia(rs.getString("agencia"));
				funcionario.setConta(rs.getString("conta"));
				funcionario.setLogin(rs.getString("login"));
				funcionario.setSenha(rs.getString("senha"));
				funcionario.setCancela_compra(rs.getBoolean("cancelacompra"));
				funcionario.setCep(rs.getString("cep"));
				funcionario.setRua(rs.getString("rua"));
				funcionario.setNumero(rs.getString("numero"));
				funcionario.setBairro(rs.getString("bairro"));
				funcionario.setCidade(rs.getString("cidade"));
				funcionario.setUf(rs.getString("uf"));
				funcionario.setComplemento(rs.getString("complemento"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setCelular(rs.getString("celular"));
				funcionario.setEmail(rs.getString("email"));
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  buscar " + e);

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat);
		}
		return funcionario;

	}

}

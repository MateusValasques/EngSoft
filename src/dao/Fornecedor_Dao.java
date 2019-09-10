package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

//import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import modelo.Fornecedor;
//import visão.Modelo_Tabela;
import visão.painelCadastroForncedor;

public class Fornecedor_Dao {

	private static int valor;
	static painelCadastroForncedor painel_Cadastro_Forncedor;

	public Fornecedor_Dao(painelCadastroForncedor painel_Cadastro_Forncedor) {

		Fornecedor_Dao.painel_Cadastro_Forncedor = painel_Cadastro_Forncedor;

	}

	public static void create(Fornecedor fornecedor) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement(

					"INSERT INTO fornecedores (nome,tipo,cpfcnpj,cep,bairro,rua,numero,cidade,complemento,telefone,celular,uf,email,idFornecedores)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			// System.out.println(fornecedor.getNome());
			stat.setString(1, fornecedor.getNome());
			stat.setString(2, fornecedor.getTipo());
			// System.out.println(fornecedor.getTipo());
			stat.setString(3, fornecedor.getCpfcnpj());
			// System.out.println(fornecedor.getCpfcnpj());
			stat.setString(4, fornecedor.getCep());
			stat.setString(5, fornecedor.getBairro());
			stat.setString(6, fornecedor.getRua());
			stat.setString(7, fornecedor.getNumero());
			stat.setString(8, fornecedor.getCidade());
			stat.setString(9, fornecedor.getComplemento());
			stat.setString(10, fornecedor.getTelefone());
			stat.setString(11, fornecedor.getCelular());
			stat.setString(12, fornecedor.getEmail());
			stat.setString(13, fornecedor.getUf());
			stat.setInt(14, fornecedor.getCodigo());
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

	public static void update(Fornecedor fornecedor) {
		painelCadastroForncedor painel = new painelCadastroForncedor();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement(
					"UPDATE fornecedores SET nome = ?,tipo = ?,cpfcnpj = ?,cep = ?,bairro = ?,rua = ?,numero = ?"
							+ ",cidade = ?,complemento = ?,telefone = ?,celular = ?,email = ?,uf = ? WHERE idFornecedores = ?");
			stat.setString(1, fornecedor.getNome());
			stat.setString(2, fornecedor.getTipo());
			stat.setString(3, fornecedor.getCpfcnpj());
			stat.setString(4, fornecedor.getCep());
			stat.setString(5, fornecedor.getBairro());
			stat.setString(6, fornecedor.getRua());
			stat.setString(7, fornecedor.getNumero());
			stat.setString(8, fornecedor.getCidade());
			stat.setString(9, fornecedor.getComplemento());
			stat.setString(10, fornecedor.getTelefone());
			stat.setString(11, fornecedor.getCelular());
			stat.setString(12, fornecedor.getEmail());
			stat.setString(13, fornecedor.getUf());
			stat.setInt(14, fornecedor.getCodigo());

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
	//usado para deletar o fornecedor
	public static void delete(int codigo) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement("DELETE FROM fornecedores WHERE idFornecedores = ?");
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

	
	public static ArrayList<Fornecedor> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		ArrayList<Fornecedor> fornecedores = new ArrayList<>();
		try {
			stat = con.prepareStatement("select * from fornecedores");
			rs = stat.executeQuery();

			while (rs.next()) {
				Fornecedor fornecedor = new Fornecedor(0, null, null, null, null, null, null, null, null, null, null,
						null, null, null);

				fornecedor.setCodigo(rs.getInt("idFornecedores"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setTipo(rs.getString("tipo"));
				fornecedor.setCpfcnpj(rs.getString("cpfcnpj"));
				fornecedor.setCep(rs.getString("cep"));
				fornecedor.setBairro(rs.getString("bairro"));
				fornecedor.setRua(rs.getString("rua"));
				fornecedor.setNumero(rs.getString("numero"));
				fornecedor.setCidade(rs.getString("cidade"));
				fornecedor.setComplemento(rs.getString("complemento"));
				fornecedor.setTelefone(rs.getString("telefone"));
				fornecedor.setCelular(rs.getString("celular"));
				fornecedor.setEmail(rs.getString("email"));

//				System.out.println(fornecedor.getNome());

				fornecedores.add(fornecedor);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat, rs);
		}

		return fornecedores;

	}

	// busca todos os fornecedores por nome
	public static void pesquisa_nome(String nome) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			// System.out.println("oi");
			stat = con.prepareStatement("select * from fornecedores WHERE nome LIKE ?");// função para procurar no banco
																						// de dados
			nome = nome.trim();// tira os espaços em branco da string
			stat.setString(1, "%" + nome + "%");// coloca pra procurar o q tem com o q foi enviado da barra
			rs = stat.executeQuery();
			while (rs.next()) {
				//preenche a tabela
				painel_Cadastro_Forncedor.getDefaultTableModel().addRow(
						new Object[] { rs.getInt("idFornecedores"), rs.getString("nome"), rs.getString("cpfcnpj") });
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat, rs);
		}

	}

	
	// busca todos os fornecedores por cpf ou cnpj
	public static void pesquisa_cpf_cnpj(String cpfcnpj) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = con.prepareStatement("select * from fornecedores WHERE cpfcnpj LIKE ?");// função para procurar no
																							// banco de dados

			stat.setString(1, "%" + cpfcnpj + "%");// coloca pra procurar o q tem com o q foi enviado da barra
			rs = stat.executeQuery();
			
			while (rs.next()) {
				

				painel_Cadastro_Forncedor.getDefaultTableModel().addRow(
						new Object[] { rs.getInt("idFornecedores"), rs.getString("nome"), rs.getString("cpfcnpj") });
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat, rs);
		}
	}
	
	//pesquisa por código
	public static void pesquisa_codigo(int id) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			stat = con.prepareStatement("select * from fornecedores WHERE idFornecedores LIKE ?");// função para procurar no
																							// banco de dados

			stat.setString(1, "%" + id + "%");// coloca pra procurar o q tem com o q foi enviado da barra
			rs = stat.executeQuery();
			
			while (rs.next()) {

				painel_Cadastro_Forncedor.getDefaultTableModel().addRow(
						new Object[] { rs.getInt("idFornecedores"), rs.getString("nome"), rs.getString("cpfcnpj") });

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat, rs);
		}

	}

	// busca um único fornecedor pelo ID, aqui busca para enviar pra tela
	public static Fornecedor busca_simples(int x) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		Fornecedor fornecedor;
		fornecedor = new Fornecedor();
		try {
			stat = con.prepareStatement("SELECT * FROM fornecedores WHERE idFornecedores = ?");
			stat.setInt(1, x);
			ResultSet rs = null;
			rs = stat.executeQuery();
			while (rs.next()) {

				fornecedor.setCodigo(rs.getInt("idFornecedores"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setTipo(rs.getString("tipo"));
				fornecedor.setCpfcnpj(rs.getString("cpfcnpj"));
				fornecedor.setCep(rs.getString("cep"));
				fornecedor.setBairro(rs.getString("bairro"));
				fornecedor.setRua(rs.getString("rua"));
				fornecedor.setNumero(rs.getString("numero"));
				fornecedor.setCidade(rs.getString("cidade"));
				fornecedor.setComplemento(rs.getString("complemento"));
				fornecedor.setTelefone(rs.getString("telefone"));
				fornecedor.setCelular(rs.getString("celular"));
				fornecedor.setEmail(rs.getString("email"));

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  buscar " + e);

			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat);
		}
		return fornecedor;

	}

}

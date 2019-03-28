package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import modelo.Fornecedor;

public class Fornecedor_Dao {

	public static void create(Fornecedor fornecedor) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement(

					"INSERT INTO fornecedores (nome,tipo,cpfcnpj,cep,bairro,rua,numero,cidade,complemento,telefone,celular,email,idFornecedores)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

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
			stat.setInt(13, fornecedor.getCodigo());
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

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;

		try {
			stat = con.prepareStatement("UPDATE fornecedores SET nome = ?,tipo = ?,cpfcnpj = ?,cep = ?,"
					+ "bairro = ?,rua = ?,numero = ?,cidade = ?,complemento = ?,telefone = ?,celular = ?,email = ? WHERE idFornecedores = ?");
//			System.out.println(fornecedor.getCodigo());
			System.out.println(fornecedor.getNome());
//			System.out.println(fornecedor.getTipo());
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
			stat.setInt(13, fornecedor.getCodigo());

			stat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Atualizar " + e);
			// TODO Auto-generated catch block
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

				System.out.println(fornecedor.getNome());

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

}

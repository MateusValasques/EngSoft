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
import visão.Modelo_Tabela;
import visão.painelCadastroForncedor;

public class Fornecedor_Dao {

	private static int valor;

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
//			stat = con.prepareStatement(
//					"UPDATE fornecedores SET (nome ,tipo ,cpfcnpj ,cep ,bairro ,rua ,numero"
//					+ ",cidade ,complemento ,telefone ,celular,email,uf  WHERE idFornecedores)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			stat = con.prepareStatement(
					"UPDATE fornecedores SET nome = ?,tipo = ?,cpfcnpj = ?,cep = ?,bairro = ?,rua = ?,numero = ?"
					+ ",cidade = ?,complemento = ?,telefone = ?,celular = ?,email = ?,uf = ? WHERE idFornecedores = ?");
			System.out.println(stat);
//			
			System.out.println(fornecedor.getCodigo());

			System.out.println(fornecedor.getNome());
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

		//	stat.execute();


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
	
	public static void delete(Fornecedor fornecedor) {
		painelCadastroForncedor painel = new painelCadastroForncedor();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		
		try {
			stat = con.prepareStatement(
					"DELETE FROM fornecedores WHERE idFornecedores = ?");
			stat.setInt(1, fornecedor.getCodigo());
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
	public static void read2() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = con.prepareStatement("select * from fornecedores");
			rs = stat.executeQuery();

			
			painelCadastroForncedor painel_Cadastro_Forncedor = new painelCadastroForncedor();
			DefaultTableModel modelo = new DefaultTableModel();
			painel_Cadastro_Forncedor.getTabela().setModel(modelo); // tableActivities é o nome da minha jTable
			modelo.addColumn("Coluna 1");
			modelo.addColumn("Coluna 2");
			modelo.addColumn("Coluna 3");
			painel_Cadastro_Forncedor.getTabela().getColumnModel().getColumn(0).setPreferredWidth(100); // Tamanho da Coluna 1
			painel_Cadastro_Forncedor.getTabela().getColumnModel().getColumn(1).setPreferredWidth(80); // Tamnaho da Coluna 2
			painel_Cadastro_Forncedor.getTabela().getColumnModel().getColumn(2).setPreferredWidth(190); // Tamanho da Coluna 3
			System.out.println("oi");
			while (rs.next()) {

				System.out.println("oi");

				int campoBD1 = rs.getInt("idFornecedores");
				String campoBD2 =rs.getString("nome");
				String campoBD3 =rs.getString("cpfcnpj");

				modelo.addRow(new Object[] {campoBD1, campoBD2, campoBD3});

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha em  Cadastrar " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stat, rs);
		}


	}
	

	
	public void preencher_Tabela() {
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] {"id_fornecedor, nome, cpfcnpj"};
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = con.prepareStatement("select * from fornecedores");
			rs = stat.executeQuery();
			while(rs.next()) {
				dados.add(new Object[] {rs.getInt("idFornecedores"), rs.getString("nome"),rs.getString("cpfcnpj")});
				System.out.println(rs.getInt("idFornecedores") + rs.getString("nome") + rs.getString("cpfcnpj"));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha em preencher o arrayList " + e);
		}
		
		Modelo_Tabela modelo = new Modelo_Tabela(dados, colunas);
		painelCadastroForncedor painel_Cadastro_Forncedor = new painelCadastroForncedor();
		painel_Cadastro_Forncedor.getTabela().setModel(modelo);
		
		painel_Cadastro_Forncedor.getTabela().getColumnModel().getColumn(0).setPreferredWidth(80);//tamanho da primeira coluna
		painel_Cadastro_Forncedor.getTabela().getColumnModel().getColumn(0).setResizable(false);
		
		painel_Cadastro_Forncedor.getTabela().getColumnModel().getColumn(1).setPreferredWidth(180);//tamanho da primeira coluna
		painel_Cadastro_Forncedor.getTabela().getColumnModel().getColumn(1).setResizable(false);
		
		painel_Cadastro_Forncedor.getTabela().getColumnModel().getColumn(2).setPreferredWidth(130);//tamanho da primeira coluna
		painel_Cadastro_Forncedor.getTabela().getColumnModel().getColumn(2).setResizable(false);
	
		painel_Cadastro_Forncedor.getTabela().getTableHeader().setReorderingAllowed(false);
		
		painel_Cadastro_Forncedor.getTabela().setAutoResizeMode(painel_Cadastro_Forncedor.getTabela().AUTO_RESIZE_OFF);
		
		painel_Cadastro_Forncedor.getTabela().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//pode selecionar apenas 1 elemento da tabela
		
	
	}

}

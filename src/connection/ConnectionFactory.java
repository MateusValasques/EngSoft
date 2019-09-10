package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.jdbc.PreparedStatement;


public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/loja_fornecedor?autoReconnect=true&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "Gui@12345";

	public static Connection getConnection() {

		
		try {
			Class.forName(DRIVER);

			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			throw new RuntimeException("Erro na conexão: ", e);

		}
		return null;

	}

	public static void closeConnection(Connection con) {

		try {
		if (con != null) {
			
				con.close();
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public static void closeConnection(Connection con, PreparedStatement stat) {
		
		closeConnection(con);
		
		
		try {
		if (stat != null) {
			
				stat.close();
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	public static void closeConnection(Connection con, PreparedStatement stat, ResultSet rs) {
		
		closeConnection(con, stat);
		
		
		try {
		if (rs != null) {
			
				rs.close();
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


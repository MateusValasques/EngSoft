package dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;

public class Produto_Dao {
	
	public void create() {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stat = null;
		
		try {
			stat = (PreparedStatement) con.prepareStatement("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	

}

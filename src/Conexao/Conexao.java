package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public Connection obterConexao() throws SQLException {
		Connection conn = null;
		
		//conn = DriverManager.getConnection("jdbc:mysql://localhost/aforamento", "root", "root");
		return conn;
	}
	
	public void fecharConexao(Connection conn) throws SQLException {
		conn.close();
	}
	
}
	
	
	


package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public Connection obterConexao() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/aforamento", "root", "root");
			
		}catch ( SQLException ex) {
			System.out.println("Não conseguiu se conectar com o banco");
		}
		return conn;
	}
	
	public void fecharConexao(Connection conn) throws SQLException {
		conn.close();
	}
	
}
	
	
	


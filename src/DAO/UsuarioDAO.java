package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;
import Model.Usuario;

public class UsuarioDAO {
	
	private Connection conn;
	private Conexao conexao = new Conexao();
	private PreparedStatement stmt;
	private ResultSet rs;
	private String sql;
	
	public void save(Usuario usuario) throws SQLException {
		
		sql = "INSERT INTO usuario(nome, senha) VALUES(?,?)";
		conn = conexao.obterConexao();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getSenha());
		stmt.executeUpdate();
		
		//JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir o usuário: " + e);
		
		fechaConexoes(conn, stmt, rs);
		
	}
	
	public void excluir(Usuario usuario) throws SQLException {
		
			sql = "DELETE FROM usuario WHERE codigo_usuario = ?";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodigoUsuario());
			stmt.executeUpdate();
			
		//JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o registro: " + e);
		
			fechaConexoes(conn, stmt, rs);
		
	}
	
	public Boolean verificaNoBanco(Usuario usuario) throws SQLException {
		
		sql = "SELECT * FROM usuario WHERE nome=? AND senha=?";
		conn = conexao.obterConexao();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getSenha());
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			return true;
		}
		//JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e);
		
		fechaConexoes(conn, stmt, rs);
		
		return false;
	}
	private void fechaConexoes(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conexao.fecharConexao(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}

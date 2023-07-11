package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Conexao.Conexao;
import Model.Usuario;

public class UsuarioDAO {
	
	private Connection conn;
	private Conexao conexao = new Conexao();
	private PreparedStatement stmt;
	private ResultSet rs;
	private String sql;
	
	public void save(Usuario usuario) {
		try {
		sql = "INSERT INTO usuario(nome, senha) VALUES(?,?)";
		conn = conexao.obterConexao();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getSenha());
		stmt.executeQuery();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir o usuário: " + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (Exception e2) {
				// Escrever log no arquivo de log
			}
		}
	}
	
	public void excluir(Usuario usuario) {
		try {
			sql = "DELETE FROM usuario WHERE codigo_usuario = ?";
			conn = conexao.obterConexao();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodigoUsuario());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o registro: " + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				// Escrever log no arquivo de log
			}
		}
	}
	
	public Boolean verificaNoBanco(Usuario usuario) {
		try {
		sql = "SELECT * FROM usuario WHERE nome=? AND senha=?";
		conn = conexao.obterConexao();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getSenha());
		rs = stmt.executeQuery();
		
		if (rs.next()) {
			return true;
		}
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e);
		}finally {
			try {
				conexao.fecharConexao(conn);
			} catch (SQLException e2) {
				// Escrever log no arquivo de log
			}
		}
		return false;
	}
}
